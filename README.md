# Spring Security with Spring Boot Demo App

Spring Security for Spring Boot can be integrated via Maven package spring-boot-starter-security. Per default all routes
are protected. A default user named "user" and his/her random password gets generated and displayed in the console output. The docs state what is happening via
auto configuration
https://docs.spring.io/spring-security/site/docs/5.2.2.BUILD-SNAPSHOT/reference/htmlsingle/#servlet-hello-auto-configuration

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

## Configuration
Add a Configuration class that extends WebSecurityConfigurerAdapter. Method configure(HttpSecurity http) is the place
to restrict or enable access to routes. E.g. http.authorizeRequests().antMatchers("/").permitAll()
A custom login route can be set up here as well with .formLogin().loginPage("/login")

In the given example the Index page should be accessible for all users. The protected routes is only visible for
authenticated users. Therefore users that are not logged in get redirected to the login form.

# Database JPA Users
Getting users from database. Obviously you need users for that. So that means domain model, repository and service.

## Read more
To get the big picture you can start here https://spring.io/guides/topicals/spring-security-architecture/