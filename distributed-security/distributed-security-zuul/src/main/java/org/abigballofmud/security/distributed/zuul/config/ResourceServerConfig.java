// package org.abigballofmud.security.distributed.zuul.config;
//
// import javax.annotation.Resource;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
// import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
// import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
// import org.springframework.security.oauth2.provider.token.TokenStore;
//
// /**
//  * <p>
//  * ResourceServerConfig
//  * </p>
//  *
//  * @author isacc 2020/5/18 2:34
//  * @since 1.0
//  */
// @Configuration
// public class ResourceServerConfig {
//
//     public static final String RESOURCE_ID = "res1";
//
//     @Configuration
//     @EnableResourceServer
//     public static class OauthServiceConfig extends ResourceServerConfigurerAdapter {
//
//         @Resource
//         private TokenStore tokenStore;
//
//         @Override
//         public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//             resources
//                     // resourceId与授权服务的resourceIds匹配
//                     .resourceId(RESOURCE_ID)
//                     // 验证令牌的服务
//                     // .tokenServices(tokenServices())
//                     // 自定检验token
//                     .tokenStore(tokenStore)
//                     .stateless(true);
//         }
//
//         @Override
//         public void configure(HttpSecurity http) throws Exception {
//             http
//                     .authorizeRequests()
//                     .antMatchers("/oauth/**").permitAll();
//         }
//
//     }
//
//     @Configuration
//     @EnableResourceServer
//     public static class OrderServiceConfig extends ResourceServerConfigurerAdapter {
//
//         @Resource
//         private TokenStore tokenStore;
//
//         @Override
//         public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//             resources
//                     // resourceId与授权服务的resourceIds匹配
//                     .resourceId(RESOURCE_ID)
//                     // 验证令牌的服务
//                     // .tokenServices(tokenServices())
//                     // 自定检验token
//                     .tokenStore(tokenStore)
//                     .stateless(true);
//         }
//
//         @Override
//         public void configure(HttpSecurity http) throws Exception {
//             http
//                     .authorizeRequests()
//                     .antMatchers("/order/**").access("#oauth2.hasScope('ROLE_API')");
//         }
//
//     }
//
// }
