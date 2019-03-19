public class LoadException extends Exception {
    public LoadException(String msg) throws Exception {
        throw new Exception(msg);
    }
}
