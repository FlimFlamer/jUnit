package pro.sky.exception;

public class SameLoginAndEmailException extends RuntimeException{
    public SameLoginAndEmailException(String message) {
        super(message);
    }
}
