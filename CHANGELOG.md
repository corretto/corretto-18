# Change Log for Amazon Corretto 18

The following sections describe the changes for each release of Amazon Corretto 18.

## Corretto version: 18.0.2.9.1
Release Date: July 19, 2022

**Target Platforms**

+ RPM-based Linux using glibc 2.12 or later, x86_64
+ Debian-based Linux using glibc 2.12 or later, x86_64
+ RPM-based Linux using glibc 2.17 or later, aarch64
+ Debian-based Linux using glibc 2.17 or later, aarch64
+ Alpine-based Linux, x86_64
+ Windows 7 or later, x86_64
+ macos 10.15 and later, x86_64
+ macos 11.0 and later, aarch64

 The following issues are addressed in 18.0.2.9.1

| Issue Name                                 | Platform | Description                                                                          | Link                                                                          |
|--------------------------------------------|----------|--------------------------------------------------------------------------------------|-------------------------------------------------------------------------------|
| Import jdk-18.0.2+9                        | All      | Updates Corretto baseline to OpenJDK 18.0.2+9                                        | [jdk-18.0.2+9](https://github.com/openjdk/jdk18u/releases/tag/jdk-18.0.2%2B9) |
| Fix src.rpm name that some tools depend on | Linux    | Updates src.rpm name                                                                 | [#27](https://github.com/corretto/corretto-18/pull/27)                        |
| Only require log4j-cve-mitigations on AL2  | AL2      | Updates log4j-cve-mitigations to AL2 only                                            | [#30](https://github.com/corretto/corretto-18/pull/30)                        |
| The documentation update                   | All      | Updates to code of conduct and contributing documentation                            | [#31](https://github.com/corretto/corretto-18/pull/31)                        |
| Revert and reapply macos packaging updates | macOS    | Updates to macos packaging                                                           | [#32](https://github.com/corretto/corretto-18/pull/32)                        |
| Enable bundled zlib library via Gradle     | macOS    | Updates to use bundled (not the system) version of the zlib library on macOS aarch64 | [#36](https://github.com/corretto/corretto-18/pull/36)                        |
| Update amazon cacerts                      | All      | Update amazon cacerts file from amazonlinux                                          | [#35](https://github.com/corretto/corretto-18/pull/35)                        |

 The following CVEs are addressed in 18.0.2.9.1

| CVE | CVSS | Component           |
 | --- |---------------------| --- |
| CVE-2022-34169 | 7.5 | xml/jaxp            |
| CVE-2022-21541 | 5.9 | hotspot/runtime     |
| CVE-2022-21549 | 5.3 | core-libs/java.util |
| CVE-2022-21540 | 5.3 | hotspot/compiler    |


## Corretto version: 18.0.1.10.1

Release Date: April 19, 2022

 **Target Platforms**

+ RPM-based Linux using glibc 2.12 or later, x86_64
+ Debian-based Linux using glibc 2.12 or later, x86_64
+ RPM-based Linux using glibc 2.17 or later, aarch64
+ Debian-based Linux using glibc 2.17 or later, aarch64
+ Alpine-based Linux, x86_64
+ Windows 7 or later, x86_64
+ macos 10.13 and later, x86_64
+ macos 11.0 and later, aarch64

The following issues are addressed in 18.0.1.10.1

| Issue Name       | Platform | Description                                | Link |
|------------------| --- |--------------------------------------------| --- |
| Import jdk-18.0.1+10 | All | Updates Corretto baseline to OpenJDK 18.0.1+10 | [jdk-18.0.1+10](https://github.com/openjdk/jdk18u/releases/tag/jdk-18.0.1%2B10)
| Update zlib | All | CVE-2018-25032: based upon our analysis, OpenJDK/Corretto is not affected by CVE-2018-25032, because the zlib “memLevel” parameter is not settable and is fixed at 8, and the usage of the Z_FIXED strategy is prevented. With these settings there is no way to invoke the issue described in the CVE and we only include this fix out of an abundance of caution. | |

 The following CVEs are addressed in 18.0.1.10.1

 | CVE | CVSS | Component |
 | --- | --- | --- |
 | CVE-2022-21449 | 7.5 | security-libs/java.security |
 | CVE-2022-21496 | 5.3 | core-libs/javax.naming |
 | CVE-2022-21434 | 5.3 | core-libs/java.lang |
 | CVE-2022-21426 | 5.3 | xml/jaxp |
 | CVE-2022-21443 | 3.7 | security-libs/java.security |


## Corretto version: 18.0.0.37.1

Release Date: March 22, 2022

 **Target Platforms**

+ RPM-based Linux using glibc 2.12 or later, x86_64
+ Debian-based Linux using glibc 2.12 or later, x86_64
+ RPM-based Linux using glibc 2.17 or later, aarch64
+ Debian-based Linux using glibc 2.17 or later, aarch64
+ Alpine-based Linux, x86_64
+ Windows 7 or later, x86_64
+ macos 10.13 and later, x86_64
+ macos 11.0 and later, aarch64

The following issues are addressed in 18.0.0.37.1.

| Issue Name       | Platform | Description                                | Link |
|------------------| --- |--------------------------------------------| --- |
| Import jdk-18+37 | All | Updates Corretto baseline to OpenJDK 18+37 | [jdk-18+37](https://github.com/openjdk/jdk18/releases/tag/jdk-18%2B37)
