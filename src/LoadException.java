public class LoadException extends Exception {
    public LoadException(String msg) {
        try {
            throw new Exception(msg);
        } catch (Exception e) {
        }
    }
}
