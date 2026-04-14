package federicolepore.u5w19d2.exceptions;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super("Non è stato possibile trovare una corrispondenza con l'id: " + id);
    }
}
