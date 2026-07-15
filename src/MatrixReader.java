// I/O utility, which reads matrix.txt
import java.io.BufferedReader;
import java.io.FileReader;

public class MatrixReader {

    public static SparseMatrix read(String filename, String type) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            // first line: get dimension
            int dimension = Integer.parseInt(reader.readLine().split(" +")[0]);

            // create the right matrix type
            SparseMatrix matrix;
            if (type.equals("rowwise")) {
                matrix = new RowWiseMatrix(dimension);
            } else {
                matrix = new COOMatrix(dimension);
            }

            // read remaining lines for non-zero elements
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(" +");
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                double value = Double.parseDouble(parts[2]);

                // convert from 1-indexed (file) to 0-indexed (internal)
                matrix.set(row - 1, col - 1, value);
                line = reader.readLine();
            }

            reader.close();
            return matrix;

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
}
