package federicolepore.u5w19d2.controllers;


import federicolepore.u5w19d2.entities.Author;
import federicolepore.u5w19d2.payloads.AuthorPayload;
import federicolepore.u5w19d2.services.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @PostMapping
    public void save(@RequestParam AuthorPayload body) {
        this.authorService.save(body);
    }

    @GetMapping("{authorId}")
    public Author findById(@PathVariable String id) {
        return authorService.findById(id);
    }

    @PostMapping({"authorId"})
    public Author findByIdAndUpdate(@PathVariable String id, @RequestParam AuthorPayload body) {
        return this.authorService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping({"authorId"})
    public void findByIdAndDelete(@PathVariable String id) {
        this.authorService.findByIdAndDelete(id);
    }


}
