/**
 * 
 */
package com.resturant.project;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.crypto.password.NoOpPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.context.annotation.Bean; 

/**
 * 
 */
@EnableWebSecurity
public class config extends WebSecurityConfiguration {
	
	// Adding the roles 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
        auth.inMemoryAuthentication() 
                .withUser("Zack") 
                .password("aayush") 
                .roles("admin_role") 
                .and() 
                .withUser("GFG") 
                .password("Helloword") 
                .roles("student"); 
    } 
  
    // Configuring the api 
    // according to the roles. 
    protected void configure(HttpSecurity http) throws Exception { 
        http. 
                httpBasic() 
                .and() 
                .authorizeRequests() 
                .requestMatchers("/delete").hasRole("admin_role") 
                .requestMatchers("/details").hasAnyRole("admin_role","student") 
                .and() 
                .formLogin(); 
    } 
  
    // Function to encode the password 
    // assign to the particular roles. 
    @Bean
    public PasswordEncoder getPasswordEncoder(){ 
        return NoOpPasswordEncoder.getInstance(); 
    } 

}
