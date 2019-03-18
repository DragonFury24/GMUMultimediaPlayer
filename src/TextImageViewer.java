public class TextImageViewer extends ImageViewer {
    private final char[] vals = {' ', '.', 'o', 'O', '@'};

    public TextImageViewer() {
    }

    public char getChar(int i ) {
        return vals[(int)(i * (vals.length / 1000.0))];
    }
    @Override
    public void view(StillImage img) {
        
    }
}
