package ex3;

public class NomeInvalidoException extends Exception {
    public NomeInvalidoException(String message) {
        super(message);
    }
    public NomeInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
    public NomeInvalidoException(Throwable cause) {
        super(cause);
    }
    
}
