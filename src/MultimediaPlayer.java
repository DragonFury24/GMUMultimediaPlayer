import java.io.IOException;

public class MultimediaPlayer implements Player, Loadable {
    public MultimediaPlayer () {}

    public int[] read(String filename) throws LoadException, IOException {
        return new int[1];
    }

    @Override
    public boolean matches(int[] data) {
        return false;
    }

    @Override
    public Loadable load(int[] data) throws LoadException {
        return null;
    }

    @Override
    public boolean canPlay(Loadable l) {
        return false;
    }

    @Override
    public void play(Loadable l) {

    }

    public void play(String filename) throws LoadException, IOException {

    }
}
