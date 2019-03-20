public class TextImageViewer extends ImageViewer {
    private final char[] vals = {' ', '.', 'o', 'O', '@'};

    public TextImageViewer() {
    }

    public char getChar(int i ) {
        return vals[(int)(i * (vals.length / 1000.0))];
    }

    @Override
    public void view(StillImage img) {
        for (int x = 0; x < img.width(); x++) {
            for (int y = 0; y < img.height(); y++) {
                System.out.print(getChar(img.getPixel(x, y)));
            }

            System.out.println();
        }
    }
}
