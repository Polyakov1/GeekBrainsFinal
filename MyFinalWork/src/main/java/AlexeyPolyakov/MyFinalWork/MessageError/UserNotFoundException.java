package AlexeyPolyakov.MyFinalWork.MessageError;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}