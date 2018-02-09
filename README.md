### Run

    gradle test

Change `springBootVersion` in the build.gradle file to '2.0.0.M7' to see the tests pass.    

Tests are failing under 2.0.0.RC1 on MacOS 10.12.6 with JVM 1.8.0_144.

This is to support Spring Boot issue #11937 https://github.com/spring-projects/spring-boot/issues/11937
