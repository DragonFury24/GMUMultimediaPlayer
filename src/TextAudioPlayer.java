public class TextAudioPlayer extends AudioPlayer {
    public TextAudioPlayer() {}

    @Override
    public void playback(AudioStream aud) {
        while (aud.hasNext()) {
            int position = getPosition(aud.next());

            for (int i = 0; i < position; i++)
                System.out.print(" ");

            System.out.println("*");
        }
    }

    private int getPosition(int value) {
        return (value + 1000) * 7 / 200;
    }
}
