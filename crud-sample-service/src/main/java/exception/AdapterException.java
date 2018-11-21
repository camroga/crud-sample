package exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class AdapterException extends RuntimeException {

    public AdapterException() {
    }

    public AdapterException(String message) {
        super(message);
    }

    public AdapterException(Throwable cause) {
        super(cause);
    }

    public AdapterException(String message, Throwable cause) {
        super(message, cause);
    }
}
