public class LoadableImage implements Loadable, StillImage {

    int width;
    int height;

    int[] data;
    int[][] grid;
    public LoadableImage() {

    }

    public LoadableImage(int w, int h, int[] data) {
        width = w;
        height = h;
        this.data = data;
        grid = initGrid(data);
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

        return new LoadableImage(data[1], data[2], data);
    }

    @Override
    public int width() {
        try {
            if (width == 0)
                throw new Exception("No data loaded.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return width;
    }

    @Override
    public int height() {
        try {
            if (height == 0)
                throw new Exception("No data loaded.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return height;
    }

    @Override
    public int getPixel(int x, int y) {
        try {
            if (data == null)
                throw new Exception("No data loaded.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //SparseMatrix keyValue implementation
        return data[((x * width()) + y) + 3];
    }

    private boolean checkData(int[] data) {
        if (!matches(data))
            return false;

        //Check if proper width/height values are given
        if (data[1] == 0 || data[2] == 0)
            return false;

        //number of supplied values are greater than width * height
        return data.length - 3 > data[1] * data[2];
    }

    private int[][] initGrid(int[] data) {
        int[][] to2D = new int[data[1]][data[2]];

        for (int row = 0; row < data[1]; row++) {
            for (int col = 0; col < data[2]; col++) {
                to2D[row][col] = data[row * data[1] + col];
            }
        }

        return to2D;
    }
}
