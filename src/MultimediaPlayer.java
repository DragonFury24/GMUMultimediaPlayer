import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultimediaPlayer implements Player, Loadable {
    private TextImageViewer textImageViewer;
    private TextAudioPlayer textAudioPlayer;
    private Player[]        players;
    private Loadable[]      loaders;
    private Loadable[]      media;
    private int             numMedia;

    public MultimediaPlayer() {
        players = new Player[2];
        players[0] = new TextAudioPlayer();
        players[1] = new TextImageViewer();

        loaders = new Loadable[2];
        loaders[0] = new LoadableAudio();
        loaders[1] = new LoadableImage();

        media = new Loadable[0];
    }

    public int[] read(String filename) throws LoadException, IOException {
        Scanner scanner = new Scanner(new File("src/" + filename));
        int     data[]  = new int[fileLength(filename)];


        for (int i = 0; i < data.length; i++) {
            try {
                data[i] = scanner.nextInt();
            } catch (InputMismatchException in) {
                throw new LoadException("Improperly formatted data.");
            }
        }

        scanner.close();

        return data;
    }

    private int fileLength(String filename) throws IOException {
        Scanner scanner = new Scanner(new File("src/" + filename));
        int     count   = 0;

        while (scanner.hasNext()) {
            scanner.next();
            count++;
        }

        scanner.close();

        return count;
    }

    public void add(Loadable l) {

    }

    @Override
    public boolean matches(int[] data) {
        for (Loadable m : loaders)
            if (m.matches(data))
                return true;

        return false;
    }

    @Override
    public Loadable load(int[] data) throws LoadException {
        for (Loadable m : loaders)
            if (m.matches(data)) {
                switch (m.getClass().toGenericString().split(" ")[2]) {
                    case "LoadableAudio":
                        return new LoadableAudio().load(data);
                    case "LoadableImage":
                        return new LoadableImage().load(data);
                }
            }

        throw new LoadException("Improperly formatted data.");
    }

    @Override
    public boolean canPlay(Loadable l) {
        for (Player p : players)
            if (p.canPlay(l))
                return true;

        return false;
    }

    @Override
    public void play(Loadable l) {
        for (Player p : players)
            if (p.canPlay(l))
                p.play(l);
    }

    public void play(String filename) throws LoadException, IOException {
        int[] data = read(filename);
        Loadable loader = load(data);

        if (canPlay(loader))
            play(loader);
    }
}
