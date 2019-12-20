# Spring Security 5 with Spring Boot Demo App

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
Getting users from database. Obviously you need users for that. So that means domain model, repository and service. For 
demo purposes a database seeder has been added to generate users. There is one more task though: user passwords need to be
encrypted. We use BCryptPasswordEncoder which is defined as a Bean in the SpringSecurityConfig. Users with encrypted passwords should get stored in h2
database during startup which can be accessed at http://localhost:8080/h2-console/

### Build a UserDetailsService 
Now for the connection of domain users and Spring security. The latter expects an implementation of UserDetailsService with the method loadUserByUsername.
So that should look like

````
@Service
public class SecUserDetailsServiceImpl implements UserDetailsService {
     @Override
        public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {}
}
````

This is it. The next step is to map the domain users to UserDetails, which is an interface. This can be done like this
````
public class SecUserDetailsImpl implements UserDetails 
````
The methods of the interface need to be implemented and mapped to the own user details. So our workflow would look like:
loadUserByUsername in our implementation of UserDetailsService get called. Fetch domain user via service and repository. 
Map user to UserDetails Object. 

This is basically it. The default values from application.properties are no longer working as we are supplying Spring Security
with our domain users now.

## Does this work with Email instead of names? 
Yes it does. In a very simple implementation in loadUserByUsername you could simply call
````
User user = userService.findByEmail(name);
````
Then all the input fields should be changed to avoid confusion
## Read more
To get the big picture you can start here https://spring.io/guides/topicals/spring-security-architecture/