public class TextAudioPlayer extends AudioPlayer {
    public TextAudioPlayer() {}

    @Override
    public void playback(AudioStream aud) {
        while (aud.hasNext()) {
            System.out.println(getPosition(aud.next()));
        }
    }

    private int getPosition(int value) {
        return (value + 1000) * 7 / 200;
    }
}
