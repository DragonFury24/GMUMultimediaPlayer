public class LoadException extends Exception {
    private String msg;

    public LoadException(String msg) {
        this.msg = msg;
    }
}
