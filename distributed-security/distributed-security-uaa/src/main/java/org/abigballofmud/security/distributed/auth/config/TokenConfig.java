package org.abigballofmud.security.distributed.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * <p>
 * TokenConfig
 * </p>
 *
 * @author isacc 2020/5/18 1:10
 * @since 1.0
 */
@Configuration
public class TokenConfig {

    @Bean
    public TokenStore tokenStore() {
        // 使用内存来存储令牌（普通令牌）
        return new InMemoryTokenStore();
    }
}
