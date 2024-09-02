package network.bobnet.quantumgrid.search_service.repository;

import network.bobnet.quantumgrid.search_service.entity.PostIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostIndexRepository extends ElasticsearchRepository<PostIndex, String> {

    List<PostIndex> findByTitleContaining(String keyword);
}
