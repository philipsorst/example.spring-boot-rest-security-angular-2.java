package net.dontdrinkandroot.example.springbootrestsecurityangular.configuration.rest;

import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.model.BlogPost;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Configuration
public class RepositoryRestConfiguration extends RepositoryRestConfigurerAdapter
{
    @Override
    public void configureRepositoryRestConfiguration(org.springframework.data.rest.core.config.RepositoryRestConfiguration config)
    {
        config.exposeIdsFor(BlogPost.class);
    }
}
