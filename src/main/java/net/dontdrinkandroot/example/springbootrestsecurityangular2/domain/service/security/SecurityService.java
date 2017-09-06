package net.dontdrinkandroot.example.springbootrestsecurityangular2.domain.service.security;

import net.dontdrinkandroot.example.springbootrestsecurityangular2.domain.model.User;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public interface SecurityService
{
    /**
     * Returns the currently logged in user or null if no user is logged in.
     */
    User getCurrentUser();

    /**
     * Logs in the given user.
     */
    void setCurrentUser(User user);
}
