package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Shli on 07/08/2017.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Unexisted student.")
public class UnexistedStudentException extends Exception {
}
