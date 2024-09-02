package network.bobnet.quantumgrid.search_service.repository;

import network.bobnet.quantumgrid.search_service.entity.PageIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageIndexRepository extends ElasticsearchRepository<PageIndex, String> {

    List<PageIndex> findByTitleContaining(String keyword);
}
