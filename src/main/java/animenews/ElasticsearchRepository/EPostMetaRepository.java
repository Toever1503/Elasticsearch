package animenews.ElasticsearchRepository;

import animenews.entity.PostMeta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EPostMetaRepository extends ElasticsearchRepository<PostMeta, Long> {

}