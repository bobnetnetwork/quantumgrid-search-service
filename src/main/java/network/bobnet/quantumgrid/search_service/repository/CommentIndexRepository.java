package network.bobnet.quantumgrid.search_service.repository;

import network.bobnet.quantumgrid.search_service.entity.CommentIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentIndexRepository extends ElasticsearchRepository<CommentIndex, String> {

    // Custom query method to find comments by content containing a specific keyword
    List<CommentIndex> findByContentContaining(String keyword);
}
