package animenews.entity;

import animenews.entity.relationship.post.TagRelationship;
import animenews.entity.relationship.post.TermRelationship;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(indexName = "posts")
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @org.springframework.data.annotation.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_excerpt")
    private String postExcerpt;

    @Lob
    @Column(name = "post_content", nullable = false)
    private String postContent;

    @Column(name = "post_status", nullable = false)
    private String postStatus;

    @Column(name = "post_name", nullable = false)
    private String postName;

    @Column(name = "is_pinged")
    private Boolean isPinged;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "post_date")
    private Date postDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "post_modified")
    private Date postModified;

    @Column(name = "comment_count")
    private Long commentCount;

    @Column(name = "post_featured_image")
    private String postFeaturedImage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_author", nullable = false)
    private User author;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private List<PostMeta> postMeta_save;

    //        @OneToMany
//    @JoinColumn(name = "object_id", updatable = false)
//    @Where(clause = "term_by='post'")
//    private List<TermRelationship> postTermFilter;
    @ManyToMany
    @JoinTable(name = "term_relationships",
            joinColumns = @JoinColumn(name = "object_id"),
            inverseJoinColumns = @JoinColumn(name = "term_id"))
    @WhereJoinTable(clause = "term_by = 'post'")
    private Set<Term> terms = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tag_relationships",
            joinColumns = @JoinColumn(name = "object_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @WhereJoinTable(clause = "tag_by = 'post'")
    private Set<Tag> tags = new HashSet<>();
//    @OneToMany
//    @JoinColumn(name = "object_id", updatable = false)
//    @Where(clause = "tag_by='post'")
//    private List<TagRelationship> postTagFilter;

}