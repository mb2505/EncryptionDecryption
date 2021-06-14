import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    private static String data = "";
    private static String mode  = "enc";
    private static String key = "0";
    private static String out = "";
    private static String in = "";
    private static String alg = "shift";
    private static int keyNum;
    private static Algorithm algorithm;

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            data = "-data".equals(args[i]) ? args[i + 1] : data;
            mode = "-mode".equals(args[i]) ? args[i + 1] : mode;
            key = "-key".equals(args[i]) ? args[i + 1] : key;
            out = "-out".equals(args[i]) ? args[i + 1] : out;
            in = "-in".equals(args[i]) ? args[i + 1] : in;
            alg = "-alg".equals(args[i]) ? args[i + 1] : alg;
        }
        keyNum = Integer.parseInt(key);
        checkAlgorithm();
        checkOperation();
    }

    private static void checkAlgorithm() {
        if ("shift".equals(alg)) {
            algorithm = new ShiftAlgorithm();
        } else {
            algorithm = new UnicodeAlgorithm();
        }
    }

    private static void checkOperation() {
        if (!data.isEmpty() && out.isEmpty()) {
            System.out.println(algorithm.cipher(mode, data, keyNum));
        } else if (!data.isEmpty()) {
            outputFile(algorithm.cipher(mode, data, keyNum));
        }  else if (!in.isEmpty() && out.isEmpty()) {
            inputFile();
            System.out.println(algorithm.cipher(mode, in, keyNum));
        } else if (!in.isEmpty()) {
            inputFile();
            outputFile(algorithm.cipher(mode, in, keyNum));
        }
    }

    private static void inputFile() {
        try {
            in = Files.readString(Path.of(in));
        } catch (Exception e) {
            System.out.println("Error!" + e);
            System.exit(0);
        }
    }

    private static void outputFile(String txt) {
        try {
            File file = new File(out);
            FileWriter writer = new FileWriter(file);
            writer.write(txt);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error!" + e);
            System.exit(0);
        }
    }
}