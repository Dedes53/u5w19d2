package federicolepore.u5w19d2.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatarUrl;

    public Author(String nome, String cognome, String email, LocalDate dataDiNascita) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatarUrl = "http://ui-avatars.com/api/?name=" + this.nome + '+' + this.cognome;
    }


}
