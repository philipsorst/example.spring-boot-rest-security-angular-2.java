package net.dontdrinkandroot.example.springbootrestsecurityangular2.domain.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Entity
public class BlogPost
{
    @GeneratedValue
    @Id
    private Long id;

    @CreatedBy
    @ManyToOne(optional = false)
    private User author;

    @CreatedDate
    @Column(nullable = false)
    private Instant created;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "blogPost")
    private List<Comment> comments;

    public Long getId()
    {
        return this.id;
    }

    public User getAuthor()
    {
        return this.author;
    }

    public Instant getCreated()
    {
        return this.created;
    }

    public String getContent()
    {
        return this.content;
    }

    public List<Comment> getComments()
    {
        return this.comments;
    }
}
