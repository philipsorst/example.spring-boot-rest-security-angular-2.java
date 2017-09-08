package net.dontdrinkandroot.example.springbootrestsecurityangular.domain.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comment
{
    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne(optional = false)
    private BlogPost blogPost;

    @CreatedBy
    @ManyToOne(optional = false)
    private User author;

    @CreatedDate
    @Column(nullable = false)
    private Instant created;

    @Column(nullable = false)
    private String content;

    public Comment()
    {
        /* Default Constructor */
    }

    public Comment(BlogPost blogPost, String content)
    {
        this.blogPost = blogPost;
        this.content = content;
    }

    public Long getId()
    {
        return this.id;
    }

    public BlogPost getBlogPost()
    {
        return this.blogPost;
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
}
