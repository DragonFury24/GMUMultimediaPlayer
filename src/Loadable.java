public interface Loadable {
    boolean matches(int[] data);

    Loadable load(int[] data) throws LoadException;
}