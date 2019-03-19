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
        return data[0] == 55;
    }

    @Override
    public Loadable load(int[] data) throws LoadException {
        try {
            if (!checkData(data))
                throw new LoadException("Improperly formatted data");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new LoadableImage(data[1], data[2]);
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
        //


    }

    private boolean checkData(int[] data) {
        if (!matches(data))
            return false;

        if (data[1] == 0 || data[2] == 0)
            return false;

        return data.length - 3 > data[1] * data[2];
    }

    private
}
