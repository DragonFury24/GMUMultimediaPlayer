public class LoadableAudio implements Loadable, AudioStream {
    @Override
    public int freq() {
        return 0;
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
        return false;
    }

    @Override
    public LoadableAudio load(int[] data) throws LoadException {
        return null;
    }
}
