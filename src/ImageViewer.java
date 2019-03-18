public abstract class ImageViewer implements Player{

    public ImageViewer() {

    }

    public abstract  void view(StillImage img);

    public boolean canPlay(Loadable l) {
        return false;
    }

    public void play(Loadable l) {

    }
}
