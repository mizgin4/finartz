//package com.example.finartz_project.configuration;
//
//import com.example.finartz_project.repository.MemberRepository;
//import com.example.finartz_project.service.Security.UserDetailService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableJpaRepositories(basePackageClasses = MemberRepository.class)
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserDetailService userDetailService;
//
//    public WebSecurityConfig(UserDetailService userDetailService) {
//        this.userDetailService = userDetailService;
//    }
//
//    //Member set ederken password cryption yapmayi unutma
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/auth/**").hasRole("ADMIN")
//                .antMatchers("/memberdemands/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/update/**").hasRole("USER")
//                .antMatchers("/signin/**").permitAll()
//                .and().formLogin();
//    }
//}
