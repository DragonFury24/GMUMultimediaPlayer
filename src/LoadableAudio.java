public class LoadableAudio implements Loadable, AudioStream {
    int frequency;
    int size;

    public LoadableAudio() {}

    public LoadableAudio(int freq, int size) {
        frequency = freq;
        this.size = size;
    }

    @Override
    public int freq() {
        return frequency;
    }

    @Override
    public int next() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean matches(int[] data) {
        if (data.length < 3)
            return false;

        return data[0] == 3 && data[1] == 2 && data[2] == 1;
    }

    @Override
    public LoadableAudio load(int[] data) throws LoadException {
        return null;
    }
}
