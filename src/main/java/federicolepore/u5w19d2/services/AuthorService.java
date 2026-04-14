package federicolepore.u5w19d2.services;


import federicolepore.u5w19d2.entities.Author;
import federicolepore.u5w19d2.exceptions.NotFoundException;
import federicolepore.u5w19d2.payloads.AuthorPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    private List<Author> authorsDB = new ArrayList<>();

    // 1
    public List<Author> findAll() {
        return this.authorsDB;
    }

    //2
    public Author save(AuthorPayload body) {
        Author a = new Author(body.getNome(), body.getCognome(), body.getEmail(), body.getDataDiNascita());
        authorsDB.add(a);
        return a;
    }

    //3
    public Author findById(String id) {
        UUID uuid = UUID.fromString(id);
        Author found = null;
        for (Author a : authorsDB) {
            if (a.getId().equals(uuid)) {
                found = a;
            }
        }
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    //4
    public Author findByIdAndUpdate(String id, AuthorPayload body) {
        UUID uuid = UUID.fromString(id);
        Author found = null;
        for (Author a : authorsDB) {
            if (a.getId().equals(uuid)) {
                found = a;
                found.setNome(body.getNome());
                found.setCognome(body.getCognome());
                found.setEmail(body.getEmail());
                found.setDataDiNascita(body.getDataDiNascita());
            }
        }
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    //5
    public void findByIdAndDelete(String id) {
        UUID uuid = UUID.fromString(id);
        Author found = null;
        for (Author a : authorsDB) {
            if (a.getId().equals(uuid)) {
                found = a;
            }
        }
        if (found == null) throw new NotFoundException(id);
        authorsDB.remove(found);
    }
}
