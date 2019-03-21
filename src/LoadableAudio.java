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
        if (data.length < 4)
            return false;

        return data[0] == 3 && data[1] == 2 && data[2] == 1;
    }

    @Override
    public LoadableAudio load(int[] data) throws LoadException {
        if (!checkData(data))
            throw new LoadException("Improperly formatted data.");

        return new LoadableAudio(data[4], data.length - 4);
    }

    private boolean checkData(int[] data) {
        if (!matches(data))
            return false;

        for (int value : data) {
            if (value > 999 || value < -999)
                return false;
        }

        return true;
    }
}
