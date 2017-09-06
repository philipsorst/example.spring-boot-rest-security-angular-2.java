package net.dontdrinkandroot.example.springbootrestsecurityangular2.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Entity
public class User implements UserDetails
{
    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private LocalDate expirationDate;

    @Column
    private LocalDate credentialExpirationDate;

    @Column(nullable = false)
    private boolean locked = false;

    @Column(nullable = false)
    private boolean enabled = true;

    @Column(nullable = false)
    private boolean admin = false;

    public User()
    {
        /* Default Constructor */
    }

    public User(String username)
    {
        this.username = username;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (this.admin) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return authorities;
    }

    @Override
    public String getPassword()
    {
        return this.password;
    }

    @Override
    public String getUsername()
    {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return null == this.expirationDate || !LocalDate.now().isAfter(this.expirationDate);
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return null == this.credentialExpirationDate || !LocalDate.now().isAfter(this.credentialExpirationDate);
    }

    @Override
    public boolean isEnabled()
    {
        return this.enabled;
    }

    public void setLocked(boolean locked)
    {
        this.locked = locked;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isAdmin()
    {
        return this.admin;
    }

    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    }
}
