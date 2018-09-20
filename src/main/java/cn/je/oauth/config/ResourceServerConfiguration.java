package cn.je.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/*
 * 2.0.6
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	private static final String DEMO_RESOURCE_ID = "order";

	@Bean
	@Primary
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
         http
                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                 .and()
                 .requestMatchers().anyRequest()
                 .and()
                 .anonymous()
                 .and()
                 .authorizeRequests()
//                 .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
                 .antMatchers("/order/**","/").authenticated();//配置order访问控制，必须认证过后才可以访问
         // @formatter:on
	}
}
