package net.dontdrinkandroot.example.springbootrestsecurityangular.domain.service;

import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.model.User;
import net.dontdrinkandroot.example.springbootrestsecurityangular.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Service
public class RepositoryUserService implements UserDetailsService
{
    private UserRepository userRepository;

    public RepositoryUserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = this.userRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        return user;
    }
}
