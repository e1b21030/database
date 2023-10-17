package oit.is.lec04.team6.database.security;

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
public class Sample3AuthConfiguration {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.formLogin(login -> login
        .permitAll())
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")) // ログアウト後に / にリダイレクト
        .authorizeHttpRequests(authz -> authz
            .requestMatchers(AntPathRequestMatcher.antMatcher("/sample4/**"))
            .authenticated() // /sample4/以下は認証済みであること
            .requestMatchers(AntPathRequestMatcher.antMatcher("/**"))
            .permitAll())// 上記以外は全員アクセス可能
        /*
         * .csrf(csrf -> csrf
         * .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/*")))
         */
        .headers(headers -> headers
         .frameOptions(frameOptions -> frameOptions
         .sameOrigin())
        );
    return http.build();
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User.withUsername("shinohara")
        .password("{bcrypt}$2y$10$OLzoRc0uwcA8i0NLr4GEvOJpi.t3gCaBtlNiau7nG2C7FqTyFXHlq").roles("USER").build();

    UserDetails admin = User.withUsername("kazuki")
        .password("{bcrypt}$2y$10$YLswQKiwk2RUBO3NS/uRmuKJoXygqXrDYtAg/C7C1fgsRCcoGrs2e").roles("ADMIN").build();
    return new InMemoryUserDetailsManager(user, admin);
  }
}
