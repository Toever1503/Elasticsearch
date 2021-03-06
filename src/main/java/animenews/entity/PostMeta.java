package animenews.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "postmeta")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(indexName = "postmeta")
public class PostMeta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meta_id")
    @org.springframework.data.annotation.Id
    private Long metaId;

    @Column(name = "meta_key", nullable = false)
    private String metaKey;

    @Lob
    @Column(name = "meta_value", nullable = false)
    private String metaValue;

    @Column(name = "post_id")
    private Long postId;

    public PostMeta postId(Long id) {
        this.postId = id;
        return this;
    }
}