package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Shli on 07/08/2017.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid student ids format")
public class InvalidStudentIdsFormatException extends Exception {
}
