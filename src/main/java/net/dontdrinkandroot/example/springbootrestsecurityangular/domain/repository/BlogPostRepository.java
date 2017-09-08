package net.dontdrinkandroot.example.springbootrestsecurityangular.domain.repository;

import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Repository
@RepositoryRestResource(path = "posts")
public interface BlogPostRepository extends JpaRepository<BlogPost, Long>
{
}
