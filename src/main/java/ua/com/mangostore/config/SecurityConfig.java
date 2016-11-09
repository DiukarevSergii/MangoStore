package ua.com.mangostore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ua.com.mangostore.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan("ua.com.mangostore")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * Регистрируем нашу реализацию UserDetailsService,
     * а также PasswordEncoder для приведения пароля в формат SHA1
     */
    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getShaPasswordEncoder());
    }

    /**
     * Настройка правил доступа пользователей к страницам сайта. Указываем адреса ресурсов с
     * ограниченным доступом, ограничение задано по ролям. К страницам, URL которых начинается
     * на "{@value }", имеют доступ только пользователи с ролью - администратор.
     * К страницам, URL которых начинается на "{@value }", имеют доступ
     * администраторы и менеджера. Чтобы попасть на эти страницы, нужно пройти этам авторизации.
     *
     * @param httpSecurity Объект класса HttpSecurity для настройки прав доступа к страницам.
     * @throws Exception Исключение методов класса HttpSecurity.
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /**
         * Включаем защиту от CSRF атак,
         * указываем правила запросов по которым будет определятся доступ к ресурсам и остальным данным
         */
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/employee/admin/**").hasRole("ADMIN")
                .antMatchers("/employee/manager/**").hasRole("MANAGER")
                .antMatchers("/employee/courier/**").hasRole("COURIER")
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error")
                .usernameParameter("j_login")
                .passwordParameter("j_password")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);

//        httpSecurity.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/resources/**", "/**").permitAll()
//                .anyRequest().permitAll()
//                .and();

        /**
         * Указываем страницу с формой логина,
         * указываем action с формы логина,
         * указываем URL при неудачном логине,
         * указываем параметры логина и пароля с формы логина,
         * а также даем доступ к форме логина всем
         */
//        httpSecurity.formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/j_spring_security_check")
//                .failureUrl("/login?error")
//                .usernameParameter("j_username")
//                .passwordParameter("j_password")
//                .permitAll();

        /**
         * Разрешаем делать логаут всем,
         * указываем URL логаута,
         * указываем URL при удачном логауте,
         * делаем не валидной текущую сессию.
         */
//        httpSecurity.logout()
//                .permitAll()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout")
//                .invalidateHttpSession(true);
//
//        httpSecurity.
//                exceptionHandling().accessDeniedPage("/forbidden_exception")
//                .and()
//                .csrf().disable();
    }

    /**
     * Указываем Spring контейнеру, что надо инициализировать ShaPasswordEncoder
     */
    @Bean
    public ShaPasswordEncoder getShaPasswordEncoder() {
        return new ShaPasswordEncoder();
    }
}