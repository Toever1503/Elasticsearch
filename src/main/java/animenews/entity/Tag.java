package animenews.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tags")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(indexName = "tags")
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;
    @org.springframework.data.annotation.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tag_name", nullable = false)
    private String name;

    @Column(name = "tag_slug", nullable = false)
    private String slug;

}