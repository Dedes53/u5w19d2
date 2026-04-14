package federicolepore.u5w19d2.entities;


import federicolepore.u5w19d2.enumerators.Categoria;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class BlogPost {

    @Id
    @GeneratedValue
    private UUID id;
    private Categoria categoria;
    private String titolo;
    private String coverUrl;
    private String contenuto;
    private int tempoDiLettura;

    public BlogPost(Categoria categoria, String titolo, String contenuto, int tempoDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempoDiLettura = tempoDiLettura;
        this.coverUrl = "https://picsum.photos/200/300";
    }

    
}
