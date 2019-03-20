public class TextImageViewer extends ImageViewer {
    private final char[] vals = {' ', '.', 'o', 'O', '@'};

    public TextImageViewer() {
    }

    public char getChar(int i) {
        return vals[(int)(i * (vals.length / 1000.0))];
    }

    @Override
    public void view(StillImage img) {
        for (int i = 0; i < img.height(); i++) {
            for (int j = 0; j < img.width(); j++) {
                System.out.print(getChar(img.getPixel(j, i)));
            }

            System.out.println();
        }
    }
}
