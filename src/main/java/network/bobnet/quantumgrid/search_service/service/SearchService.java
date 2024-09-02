package network.bobnet.quantumgrid.search_service.service;

import lombok.AllArgsConstructor;
import network.bobnet.quantumgrid.search_service.entity.CommentIndex;
import network.bobnet.quantumgrid.search_service.entity.PageIndex;
import network.bobnet.quantumgrid.search_service.entity.PostIndex;
import network.bobnet.quantumgrid.search_service.repository.CommentIndexRepository;
import network.bobnet.quantumgrid.search_service.repository.PageIndexRepository;
import network.bobnet.quantumgrid.search_service.repository.PostIndexRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SearchService {

    private final PostIndexRepository postIndexRepository;
    private final PageIndexRepository pageIndexRepository;
    private final CommentIndexRepository commentIndexRepository;

    public PostIndex indexPost(PostIndex postIndex) {
        return postIndexRepository.save(postIndex);
    }

    public void deletePostById(String id) {
        postIndexRepository.deleteById(id);
    }

    public List<PostIndex> searchPostsByTitle(String keyword) {
        return postIndexRepository.findByTitleContaining(keyword);
    }

    public Optional<PostIndex> findPostById(String id) {
        return postIndexRepository.findById(id);
    }

    public PageIndex indexPage(PageIndex pageIndex) {
        return pageIndexRepository.save(pageIndex);
    }

    public void deletePageById(String id) {
        pageIndexRepository.deleteById(id);
    }

    public List<PageIndex> searchPageByTitle(String keyword) {
        return pageIndexRepository.findByTitleContaining(keyword);
    }

    public Optional<PageIndex> findPageById(String id) {
        return pageIndexRepository.findById(id);
    }

    public CommentIndex indexComment(CommentIndex commentIndex) {
        return commentIndexRepository.save(commentIndex);
    }

    public void deleteCommentById(String id) {
        commentIndexRepository.deleteById(id);
    }

    public List<CommentIndex> searchCommentsByContent(String keyword) {
        return commentIndexRepository.findByContentContaining(keyword);
    }

    public Optional<CommentIndex> findCommentById(String id) {
        return commentIndexRepository.findById(id);
    }
}
