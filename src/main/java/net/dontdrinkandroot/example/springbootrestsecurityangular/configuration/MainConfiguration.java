package net.dontdrinkandroot.example.springbootrestsecurityangular.configuration;

import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.model.User;
import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.service.security.SecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Configuration
@EnableJpaAuditing
public class MainConfiguration
{
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuditorAware<User> auditorAware(SecurityService securityService)
    {
        return securityService::getCurrentUser;
    }
}
