package curse.myfirstwebapi.handler;

public class BusinessException extends RuntimeException {
    public BusinessException(String mensagem) {
        super(mensagem);
    }

    // Estrutura de conteúdo dinâmico, através do varargs
    public BusinessException(String mensagem, Object ... params) {
        super(String.format(mensagem, params));
    }
}
