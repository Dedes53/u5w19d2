package federicolepore.u5w19d2.controllers;


import federicolepore.u5w19d2.entities.BlogPost;
import federicolepore.u5w19d2.payloads.BlogPostPayload;
import federicolepore.u5w19d2.services.BlogPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
1- GET http://localhost:port/blogPosts -> ritorna array di blogPosts
2- POST http://localhost:port/blogPosts (+payload) -> salva un nuovo blogPost
3- GET http://localhost:port/blogPosts/{blogPostID} -> ritorna uno specifico blogPost
4- PUT http://localhost:port/blogPosts/{blogPostID} (+payload) -> aggiorna il blogPost
5- DELETE http://localhost:port/blogPosts/{blogPostID} -> elimina il blogPost
*/


@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    // prima gli passo il service e poi creo il costruttore

    private BlogPostService blogPostService;

    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }


    // 1
    @GetMapping
    public List<BlogPost> findAll() {
        return blogPostService.findALl();
    }

    // 2
    @PostMapping
    public BlogPost save(@RequestParam BlogPostPayload body) {
        return this.blogPostService.save(body);
    }

    // 3
    @GetMapping("{blodPostId}")
    public BlogPost findById(@PathVariable String id) {
        return this.blogPostService.findById(id);
    }

    // 4
    @PostMapping("{blodPostId}")
    public BlogPost findByIdAndUpdate(@PathVariable String id, @RequestParam BlogPostPayload body) {
        return this.blogPostService.findByIdAndUpdate(id, body);
    }

    // 5
    @DeleteMapping("{blodPostId}")
    public void findByIdAndDelete(@PathVariable String id) {
        this.blogPostService.findByIdAndDelete(id);
    }


}
