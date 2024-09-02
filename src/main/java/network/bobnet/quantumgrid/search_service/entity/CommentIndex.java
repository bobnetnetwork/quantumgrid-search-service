package network.bobnet.quantumgrid.search_service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "comments")
public class CommentIndex {

    @Id
    private String id;

    private String postId;
    private String content;
    private String author;
    private String createdAt;
    private String updatedAt;
}
