package net.dontdrinkandroot.example.springbootrestsecurityangular2.domain.repository;

import net.dontdrinkandroot.example.springbootrestsecurityangular2.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}
