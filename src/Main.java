import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Loader.Loader("res/numbers1.txt", 1, 99);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                Loader.Loader("res/numbers2.txt", 100, 199);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
