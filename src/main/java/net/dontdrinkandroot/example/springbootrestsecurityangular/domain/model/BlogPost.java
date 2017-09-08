package net.dontdrinkandroot.example.springbootrestsecurityangular.domain.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
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

    @LastModifiedDate
    @Column(nullable = false)
    private Instant lastModified;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "blogPost")
    private List<Comment> comments;

    public BlogPost()
    {
        /* Default Constructor */
    }

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

    public Instant getLastModified()
    {
        return this.lastModified;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public List<Comment> getComments()
    {
        return this.comments;
    }
}
