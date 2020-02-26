package app.meli.mutant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class MutantException extends Exception {

    public MutantException (String message){
        super(message);
    }
}
