package oit.is.lec04.team6.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Sample4AuthConfiguration {
  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user1 = User.withUsername("shinohara")
        .password("{bcrypt}$2y$10$VBdPD4WvjgK2T9vicZSbOes5kySlj/e9HJa/iuZ9RGJ8T5h0o").roles("USER").build();

    UserDetails admin = User.withUsername("kazuki")
        .password("{bcrypt}$2y$10$fDth4o5F0nfUrPhNynPGk.JkGwVNOYJRpVn.ozsGkxAKZSSrtMrO").roles("ADMIN").build();

    return new InMemoryUserDetailsManager(user1, admin);
  }
}
