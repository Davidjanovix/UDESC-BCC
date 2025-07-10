package ex2;

public class PilhaCheiaException extends Exception {
    
    public PilhaCheiaException() {
        super("Pilha cheia");
    }
    
    public PilhaCheiaException(String message) {
        super(message);
    }
    
    public PilhaCheiaException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public PilhaCheiaException(Throwable cause) {
        super(cause);
    }
    
}
