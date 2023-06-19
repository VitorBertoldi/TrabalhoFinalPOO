class ExceptionPRO extends  RuntimeException {

    private static final long serialVersionUID = 1149241039409861914L;

    public ExceptionPRO(String msg){
        super(msg);
    }

    // contrói um objeto NumeroNegativoException com mensagem e a causa dessa exceção, utilizado para encadear exceptions
    public ExceptionPRO(String msg, Throwable cause){
        super(msg, cause);
    }
}
