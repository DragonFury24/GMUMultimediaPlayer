public abstract class ImageViewer implements Player{

    public ImageViewer() {

    }

    public abstract  void view(StillImage img);

    public boolean canPlay(Loadable l) {
        return l instanceof StillImage;
    }

    public void play(Loadable l) {
        if (canPlay(l))
            view((StillImage) l);
    }
}
