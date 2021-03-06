package org.abigballofmud.security.spring.config;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2019/12/13 1:22
 * @since 1.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 定义UserDetailsService，查询用户信息
     */
    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
        // HashMap<String, PasswordEncoder> idToPasswordEncoder = new HashMap<>(4);
        // idToPasswordEncoder.put("1", new BCryptPasswordEncoder());
        // return new DelegatingPasswordEncoder("1", idToPasswordEncoder);
    }

    /**
     * 安全拦截机制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/test1").hasAuthority("p1")
                .antMatchers("/test2").hasAuthority("p2")
                // test开头的必须认证通过
                .antMatchers("/test*").authenticated()
                // 其他请求放过
                .anyRequest().permitAll()
                .and()
                // 允许表单登录
                .formLogin()
                // 自定义登陆成功后的页面地址
                .successForwardUrl("/login-success");
    }
}
