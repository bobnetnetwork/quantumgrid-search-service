package network.bobnet.quantumgrid.search_service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "pages")
public class PageIndex {

    @Id
    private String id;

    private String title;
    private String content;
    private String author;
    private String createdAt;
    private String updatedAt;
}
