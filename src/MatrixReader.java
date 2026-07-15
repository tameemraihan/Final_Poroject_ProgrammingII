// I/O utility, which reads matrix.txt
import java.io.BufferedReader;
import java.io.FileReader;

public class MatrixReader {

    public static int readDimension(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            reader.close();
            if (line == null) return -1;
            String[] parts = line.split(" +");
            return Integer.parseInt(parts[0]);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return -1;
        }
    }

    public static void read(String filename, SparseMatrix matrix) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            reader.readLine(); // skip first line (dimension already used)

            // Read remaining lines for non-zero elements
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(" +");
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                double value = Double.parseDouble(parts[2]);

                // Convert from 1-indexed (file) to 0-indexed (internal)
                matrix.set(row - 1, col - 1, value);
                line = reader.readLine();
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
