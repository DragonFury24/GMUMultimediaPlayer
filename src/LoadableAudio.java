public class LoadableAudio implements Loadable, AudioStream {
    int frequency;
    int size;
    int positionIndex;
    int[] data;

    public LoadableAudio() {}

    public LoadableAudio(int freq, int size, int[] data) {
        frequency = freq;
        this.size = size;
        this.data = data;

        if (size > 4)
            positionIndex = 4;
    }

    @Override
    public int freq() {
        return frequency;
    }

    @Override
    public int next() {
        positionIndex++;
        return data[positionIndex - 1];
    }

    @Override
    public boolean hasNext() {
        return positionIndex < data.length;
    }

    @Override
    public boolean matches(int[] data) {
        if (data.length < 3)
            return false;

        return data[0] == 3 && data[1] == 2 && data[2] == 1;
    }

    @Override
    public LoadableAudio load(int[] data) throws LoadException {
        if (!checkData(data))
            throw new LoadException("Improperly formatted data.");

        return new LoadableAudio(data[3], data.length - 4, data);
    }

    private boolean checkData(int[] data) {
        if (!matches(data))
            return false;

        if (data.length < 4)
            return false;

        for (int i = 4; i < data.length; i++) {
            if (data[i] < -999 || data[i] > 999)
                return false;
        }

        return true;
    }
}
