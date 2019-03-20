public abstract class AudioPlayer implements Player {
    public AudioPlayer() {}

    public abstract void playback (AudioStream aud);

    public boolean canPlay(Loadable l) {
        return l instanceof AudioStream;
    }

    public void play (Loadable l) {}
}
