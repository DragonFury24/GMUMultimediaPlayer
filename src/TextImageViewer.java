public class TextImageViewer extends ImageViewer {
    private final char[] vals = {' ', '.', 'o', 'O', '@'};

    public TextImageViewer() {
    }

    private char getChar(int i) {
        return vals[(int)(i * (vals.length / 1000.0))];
    }

    @Override
    public void view(StillImage img) {
        for (int j = 0; j < img.height(); j++) {
            for (int i = 0; i < img.width(); i++) {
                System.out.print(getChar(img.getPixel(i, j)));
            }

            System.out.println();
        }
    }
}
