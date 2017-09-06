package net.dontdrinkandroot.example.springbootrestsecurityangular2.domain.repository;

import net.dontdrinkandroot.example.springbootrestsecurityangular2.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Repository
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>
{
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Page<User> findAll(Pageable pageable);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<User> findAll();

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<User> findAll(Sort sort);

    @RestResource(exported = false)
    User findByUsername(@Param("username") String username);
}
