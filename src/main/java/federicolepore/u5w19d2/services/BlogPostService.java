package federicolepore.u5w19d2.services;

import federicolepore.u5w19d2.entities.BlogPost;
import federicolepore.u5w19d2.exceptions.NotFoundException;
import federicolepore.u5w19d2.payloads.BlogPostPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class BlogPostService {

    private List<BlogPost> blogPostsDB = new ArrayList<>();


    // METODI DA RICHIAMARE NEL CONTROLLER PER CRUD
    //1
    public List<BlogPost> findALl() {
        return this.blogPostsDB;
    }

    //2
    public BlogPost save(BlogPostPayload body) {
        // istanzio un BlogPost con il payload che gli passo prendendo da lui gli attributi per generarlo
        BlogPost b = new BlogPost(body.getCategoria(), body.getTitolo(), body.getContenuto(), body.getTempoDiLettura());
        // lo salvo nella lista dei BlodPost
        blogPostsDB.add(b);
        return b;
    }

    //3
    public BlogPost findById(String id) {
        UUID uuid = UUID.fromString(id);
        BlogPost found = null;
        for (BlogPost b : blogPostsDB) {
            if (b.getId().equals(uuid)) {
                found = b;
            }
        }
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    // 4
    public BlogPost findByIdAndUpdate(String id, BlogPostPayload body) {
        UUID uuid = UUID.fromString(id);
        BlogPost found = null;
        for (BlogPost b : blogPostsDB) {
            if (b.getId().equals(uuid)) {
                found = b;
                found.setCategoria(body.getCategoria());
                found.setTitolo(body.getTitolo());
                found.setContenuto(body.getContenuto());
                found.setTempoDiLettura(body.getTempoDiLettura());
            }
        }
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    // 5
    public void findByIdAndDelete(String id) {
        UUID uuid = UUID.fromString(id);
        BlogPost found = null;
        for (BlogPost b : blogPostsDB) {
            if (b.getId().equals(uuid)) {
                found = b;
            }
        }
        blogPostsDB.remove(found);
        if (found == null) throw new NotFoundException(id);

    }

}
