package pl.java.recruitauthor.exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException() {
        super();
    }

    public AuthorNotFoundException(String message) {
        super(message);
    }
}
