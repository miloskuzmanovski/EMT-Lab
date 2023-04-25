package mk.ukim.finki.emt.labbookstore.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long author) {
        super("Author not found exception!");
    }
}
