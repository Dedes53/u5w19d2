package federicolepore.u5w19d2.payloads;


import federicolepore.u5w19d2.enumerators.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class BlogPostPayload {

    private Categoria categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
}


// Questa non è la entity. Serve per la creazione delle payload per i metodi CRUD, e deve contenere solo gli attributi che mi potranno essere passati dal client
//N.B. se un attributo, come l'id, viene generato automaticamente dal DB, non lo dovrò passare dal client e quindi non lo devo dichiarare in questa classe