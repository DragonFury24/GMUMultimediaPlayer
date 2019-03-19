public class LoadableImage implements Loadable, StillImage {

    int width;
    int height;

    int[]   data;
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
        if (width == 0)
            NoDataLoadedException();
        
        return width;
    }

    @Override
    public int height() {
        if (height == 0)
            NoDataLoadedException();

        return height;
    }

    @Override
    public int getPixel(int x, int y) {
        if (data == null)
            NoDataLoadedException();

        //SparseMatrix keyValue implementation
        return grid[x][y];
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

    public void NoDataLoadedException() {
        try {
            throw new Exception("No data loaded.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int[][] initGrid(int[] data) {
        int[][] to2D = new int[data[1]][data[2]];

        //SparseMatrix expansion
        for (int row = 0; row < data[1]; row++) {
            for (int col = 0; col < data[2]; col++) {
                to2D[row][col] = data[(row * data[1] + col) + 3];
            }
        }

        return to2D;
    }
}
