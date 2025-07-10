package ex2;

public class ProcessoSemJuizException extends Exception {

    public ProcessoSemJuizException() {
        super("Processo sem juiz");
    }

    public ProcessoSemJuizException(String message) {
        super(message);
    }

    public ProcessoSemJuizException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProcessoSemJuizException(Throwable cause) {
        super(cause);
    }
    
}
