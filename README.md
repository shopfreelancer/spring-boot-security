# Spring Security with Spring Boot Demo App

Spring Security for Spring Boot can be integrated via Maven package spring-boot-starter-security. Per default all routes
are protected. A random password gets generated and displayed in the console output. 
You can also specify a demo user in application.properties
````
spring.security.user.name=admin
spring.security.user.password=test
```` 
A default Login page from Spring Security is getting displayed.

Spring Security can be disabled globally in application.properties 
````
spring.autoconfigure.exclude[0]=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
````