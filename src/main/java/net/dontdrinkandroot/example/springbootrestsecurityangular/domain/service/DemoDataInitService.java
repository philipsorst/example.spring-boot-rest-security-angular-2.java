package net.dontdrinkandroot.example.springbootrestsecurityangular.domain.service;

import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.model.BlogPost;
import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.model.Comment;
import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.model.User;
import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.service.security.SecurityService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * When in profile "demodata" this service will populate the database with some demo data.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Service
@Profile("demodata")
public class DemoDataInitService implements ApplicationListener<ContextRefreshedEvent>
{
    @PersistenceContext
    private EntityManager entityManager;

    private PasswordEncoder passwordEncoder;

    private SecurityService securityService;

    public DemoDataInitService(PasswordEncoder passwordEncoder, SecurityService securityService)
    {
        this.passwordEncoder = passwordEncoder;
        this.securityService = securityService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        User admin = new User("admin");
        admin.setAdmin(true);
        admin.setPassword(this.passwordEncoder.encode("admin"));
        this.entityManager.persist(admin);

        User user1 = new User("user1");
        user1.setPassword(this.passwordEncoder.encode("user1"));
        this.entityManager.persist(user1);

        User user2 = new User("user2");
        user2.setPassword(this.passwordEncoder.encode("user2"));
        this.entityManager.persist(user2);

        this.securityService.setCurrentUser(user1);
        BlogPost blogPost1 = new BlogPost();
        blogPost1.setContent("Blog Post 1");
        this.entityManager.persist(blogPost1);

        this.securityService.setCurrentUser(user2);
        Comment comment1 = new Comment(blogPost1, "Blog Post 1, Comment 1");
        this.entityManager.persist(comment1);

        this.securityService.setCurrentUser(user1);
        Comment comment2 = new Comment(blogPost1, "Blog Post 1, Comment 2");
        this.entityManager.persist(comment2);

        this.securityService.setCurrentUser(user2);
        BlogPost blogPost2 = new BlogPost();
        blogPost2.setContent("Blog Post 2");
        this.entityManager.persist(blogPost2);

        this.securityService.setCurrentUser(null);
    }
}
