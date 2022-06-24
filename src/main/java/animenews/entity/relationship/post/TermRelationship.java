package animenews.entity.relationship.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

@Entity
@Table(name = "term_relationships")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "term_relationships")
public class TermRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @org.springframework.data.annotation.Id
    private Long id;

    @Column(name = "object_id", nullable = false)
    private Long objectId;

    @Column(name = "term_id", nullable = false)
    private Long termId;

    @Column(name = "term_by", nullable = false, length = 50)
    private String termBy;
}