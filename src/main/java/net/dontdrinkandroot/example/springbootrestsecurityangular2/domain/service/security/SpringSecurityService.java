package net.dontdrinkandroot.example.springbootrestsecurityangular2.domain.service.security;

import net.dontdrinkandroot.example.springbootrestsecurityangular2.domain.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Service
public class SpringSecurityService implements SecurityService
{
    @Override
    public User getCurrentUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null == authentication) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        if (null != principal && principal instanceof User) {
            return (User) principal;
        }

        return null;
    }

    @Override
    public void setCurrentUser(User user)
    {
        if (null == user) {
            SecurityContextHolder.getContext().setAuthentication(null);
            return;
        }

        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()));
    }
}
