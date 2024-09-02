package network.bobnet.quantumgrid.search_service.controller;

import lombok.AllArgsConstructor;
import network.bobnet.quantumgrid.search_service.entity.CommentIndex;
import network.bobnet.quantumgrid.search_service.entity.PageIndex;
import network.bobnet.quantumgrid.search_service.entity.PostIndex;
import network.bobnet.quantumgrid.search_service.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/posts/index")
    public ResponseEntity<PostIndex> indexPost(@RequestBody PostIndex postIndex) {
        PostIndex indexedPost = searchService.indexPost(postIndex);
        return ResponseEntity.ok(indexedPost);
    }

    @DeleteMapping("/posts/delete/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id) {
        searchService.deletePostById(id);
        return ResponseEntity.ok("Post deleted successfully from index.");
    }

    @GetMapping("/posts/posts")
    public ResponseEntity<List<PostIndex>> searchPostsByTitle(@RequestParam String title) {
        List<PostIndex> posts = searchService.searchPostsByTitle(title);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostIndex> findPostById(@PathVariable String id) {
        Optional<PostIndex> post = searchService.findPostById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/pages/index")
    public ResponseEntity<PageIndex> indexPage(@RequestBody PageIndex pageIndex) {
        PageIndex indexedPage = searchService.indexPage(pageIndex);
        return ResponseEntity.ok(indexedPage);
    }

    @DeleteMapping("/pages/delete/{id}")
    public ResponseEntity<String> deletePage(@PathVariable String id) {
        searchService.deletePageById(id);
        return ResponseEntity.ok("Page deleted successfully from index.");
    }

    @GetMapping("/pages/posts")
    public ResponseEntity<List<PageIndex>> searchPageByTitle(@RequestParam String title) {
        List<PageIndex> pages = searchService.searchPageByTitle(title);
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/pages/{id}")
    public ResponseEntity<PageIndex> findPageById(@PathVariable String id) {
        Optional<PageIndex> page = searchService.findPageById(id);
        return page.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/comments/index")
    public ResponseEntity<CommentIndex> indexComment(@RequestBody CommentIndex commentIndex) {
        CommentIndex indexedPage = searchService.indexComment(commentIndex);
        return ResponseEntity.ok(indexedPage);
    }

    @DeleteMapping("/comments/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable String id) {
        searchService.deleteCommentById(id);
        return ResponseEntity.ok("Comment deleted successfully from index.");
    }

    @GetMapping("/comments/posts")
    public ResponseEntity<List<CommentIndex>> searchCommentByTitle(@RequestParam String title) {
        List<CommentIndex> comments = searchService.searchCommentsByContent(title);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentIndex> findCommentById(@PathVariable String id) {
        Optional<CommentIndex> comment = searchService.findCommentById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
