public class LoadableImage implements Loadable, StillImage {

    int width;
    int height;

    public LoadableImage() {

    }

    public LoadableImage(int w, int h) {
        width = w;
        height = h;
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
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public int getPixel(int x, int y) {
        return 0;
    }
}
