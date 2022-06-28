/*
 * Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/**
 * @test
 * @summary Corretto-specific tests for additionally bundled zlib versions.
 * @run main/othervm CorrettoZipTests
 * @run main/othervm -XX:ZlibImplementation=bundled CorrettoZipTests
 * @run main/othervm -XX:ZlibImplementation=system CorrettoZipTests
 * @run main/othervm -XX:ZlibImplementation=cloudflare CorrettoZipTests
 * @run main/othervm -XX:ZlibImplementation=chromium CorrettoZipTests
 */

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class CorrettoZipTests {

    private static boolean error = false;

    private static void printError(String error, ZipEntry e, byte[] buf, int index, byte expected) {
        String file = e.getName();
        int tail = file.lastIndexOf('/');
        file = file.substring(tail == -1 ? 0 : tail + 1);
        System.out.print(
            String.format("%s (name=%s, clen=%d, len=%d) : %s",
                          error, file, e.getCompressedSize(), e.getSize(),
                          ("buf[" + index + "] == " + buf[index] + " expected " + expected)));
        if ("ERROR 1".equals(error)) {
            System.out.print(" ");
            while (index < buf.length && buf[index] != 0) {
                System.out.print((char)buf[index++]);
            }
        }
        System.out.println();
        if ("ERROR 2".equals(error)) {
            // We currently only fail if the buffer gets overwritten by calls
            // to InflaterInputStream.read() which return '-1' (i.e. "ERROR 2").
            CorrettoZipTests.error = true;
        }
    }

    public static void main(String[] args) throws Exception {
        String separator = System.getProperty("path.separator");
        String classpath = System.getProperty("java.class.path");
        String jtreg = Arrays.stream(classpath.split(separator)).filter(cpe -> cpe.endsWith("jtreg.jar")).findFirst().orElse(null);
        if (jtreg == null) {
            System.out.println("Couldn't find \"jtreg.jar\" in class path - test skipped");
            return;
        }
        ZipFile zip = new ZipFile(jtreg);
        ArrayList<? extends ZipEntry> entries = Collections.list(zip.entries());
        byte[] buf = new byte[16*1024];
        for (ZipEntry e : entries) {
            if (!e.isDirectory()) {
                InputStream is = zip.getInputStream(e);
                int len = 0;
                byte first = 0;
                int round = 0;
                Arrays.fill(buf, (byte)0);
                while ((len = is.read(buf, 0, buf.length)) != -1) {
                    if (round++ == 0 && len < buf.length && buf[len] != 0) {
                        printError("ERROR 1", e, buf, len, (byte)0);
                    }
                    first = buf[0];
                }
                if (first != buf[0]) {
                    printError("ERROR 2", e, buf, 0, first);
                }
            }
            if (error) throw new Exception("Illegal buffer overwrite by InflaterInputStream.read()");
        }
    }
}
