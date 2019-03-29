public class LoadableImage implements Loadable, StillImage {

    int width;
    int height;
    int[][] grid;

    public LoadableImage() {

    }

    public LoadableImage(int w, int h, int[][] gridData) {
        width = w;
        height = h;
        grid = gridData;
    }

    @Override
    public boolean matches(int[] data) {
        return data[0] == 55;
    }

    @Override
    public LoadableImage load(int[] data) throws LoadException {
        if (!checkData(data))
            throw new LoadException("Improperly formatted data");

        return new LoadableImage(data[1], data[2], initGrid(data));
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
        if (grid == null)
            return -1;

        //SparseMatrix keyValue implementation
        return grid[x][y];
    }

    private boolean checkData(int[] data) {
        if (!matches(data))
            return false;

        //Check that width and height values exist
        if (data.length < 3)
            return false;

        //Check if proper width/height values are given
        if (data[1] == 0 || data[2] == 0)
            return false;

        //number of supplied values are equal to width * height
        if (data.length - 3 != data[1] * data[2])
            return false;

        //check that all elements are between the interval 0 < x <= 999
        for (int value : data) {
            if (value > 999 || value < 0)
                return false;
        }

        return true;
    }

    private int[][] initGrid(int[] data) {
        int[][] to2D = new int[data[1]][data[2]];

        //SparseMatrix expansion
        for (int col = 0; col < data[1]; col++) {
            for (int row = 0; row < data[2]; row++) {
                to2D[col][row] = data[(row * data[1] + col) + 3];
            }
        }

        return to2D;
    }
}
