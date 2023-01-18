import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Loader {
    public static void Loader(String location, int numberFrom, int numberTo) throws FileNotFoundException {
        long start = System.currentTimeMillis();

        PrintWriter writer = new PrintWriter(location);

        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

        for (int regionCode = numberFrom; regionCode < numberTo; regionCode++){
            StringBuilder builder = new StringBuilder();
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {

                            builder.append(firstLetter)
                                    .append(padNumber(number, 3))
                                    .append(secondLetter)
                                    .append(thirdLetter)
                                    .append(padNumber(regionCode, 2))
                                    .append("\n");
                        }
                    }
                }
            }
            writer.write(builder.toString());
        }


        writer.flush();
        writer.close();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static StringBuilder padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        StringBuilder builder = new StringBuilder();
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            builder.append('0').append(numberStr);
        }

        return builder;
    }
}