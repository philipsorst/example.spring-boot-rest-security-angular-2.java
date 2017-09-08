package net.dontdrinkandroot.example.springbootrestsecurityangular.domain.model;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class PasswordCreationTest
{
    @Test
    public void testCreatePasswords()
    {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("admin: " + passwordEncoder.encode("admin"));
        System.out.println("user1: " + passwordEncoder.encode("user1"));
        System.out.println("user2: " + passwordEncoder.encode("user2"));
    }
}
