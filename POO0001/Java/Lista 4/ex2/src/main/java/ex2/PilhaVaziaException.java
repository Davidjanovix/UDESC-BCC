package ex2;

public class PilhaVaziaException extends Exception {
    
    public PilhaVaziaException() {
        super("Pilha vazia");
    }
    
    public PilhaVaziaException(String message) {
        super(message);
    }
    
    public PilhaVaziaException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public PilhaVaziaException(Throwable cause) {
        super(cause);
    }
    
}
