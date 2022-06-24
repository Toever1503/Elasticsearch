package animenews.entity.relationship.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

@Entity
@Table(name = "tag_relationships")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "tag_relationships")
public class TagRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @org.springframework.data.annotation.Id
    private Long id;

    @Column(name = "object_id", nullable = false)
    private Long objectId;

    @Column(name = "tag_id", nullable = false)
    private Long tagId;

    @Column(name = "tag_by", nullable = false)
    private String tagBy;

}