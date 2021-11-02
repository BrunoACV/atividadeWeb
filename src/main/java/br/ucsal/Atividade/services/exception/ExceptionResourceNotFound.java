package br.ucsal.Atividade.services.exception;

public class ExceptionResourceNotFound extends RuntimeException {
    private static final long serialVersionUID = 1l;

    public ExceptionResourceNotFound(Object id) {
        super("Resource not found. Id:" + id);
    }

}
