package com.teaminternational;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    JdbcTemplate jdbcTemplate;

    @Resource
    private Environment env;

    @Override
    public void configure(WebSecurity web) throws Exception {

        web
                .ignoring()

                .antMatchers("/style.css");
        web
                .ignoring()

                .antMatchers("/style2.css");
        web
                .ignoring()

                .antMatchers("/key.js");
        web
                .ignoring()

                .antMatchers("/keyForLesson.jpg");
        web
                .ignoring()

                .antMatchers("/jquery.js");
        web
                .ignoring()

                .antMatchers("/banner.jpg");
    }

    @Autowired
    CustomSuccessHandler customSuccessHandler;

   @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()

                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/finish").hasRole("USER")
                .antMatchers("/profile").hasRole("USER")
                .antMatchers("/tryagain").hasRole("USER")
                .antMatchers("/panel").hasRole("ADMIN")
                .antMatchers("/create").hasRole("ADMIN")
                .antMatchers("/exchange").hasRole("ADMIN")
                .antMatchers("/rename").hasRole("ADMIN")
                .antMatchers("/moderator").hasRole("MODERATOR")
                .anyRequest().authenticated()
                .and()

                .formLogin()
                .loginPage("/login")
                .successHandler(customSuccessHandler)
                .permitAll()
                .and()

                .logout()
                .logoutSuccessUrl("/")
                .permitAll();

    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                        //.withDefaultSchema()
                /*.withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");*/
                .usersByUsernameQuery("select login, password, 'true' FROM User where login=?")
                .authoritiesByUsernameQuery("select u.login, r.name FROM User u INNER JOIN Role r ON u.role_id = r.role_id where login=?");

    }


    @Bean
    public DataSource getDataSource() {


        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getRequiredProperty("spring.datasource.url"));
        dataSource.setUsername(env.getRequiredProperty("spring.datasource.username"));
        dataSource.setPassword(env.getRequiredProperty("spring.datasource.password"));

        return dataSource;
    }

}
