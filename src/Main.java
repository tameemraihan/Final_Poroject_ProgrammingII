public class Main {

    public static void main(String[] args) {

        String file = "matrix.txt";

        //COO Matrix
        System.out.println("=== Coordinate List (COO) Matrix ===");
        SparseMatrix coo = MatrixReader.read(file, "coo");

        if (coo == null) {
            System.out.println("Error: could not read matrix.txt");
            return;
        }

        double cooDet = Determinant.compute(coo, coo.getDimension());
        System.out.println("Determinant: " + cooDet);

        Transpose.transpose(coo);
        double cooTransposeDet = Determinant.compute(coo, coo.getDimension());
        System.out.println("Transpose Determinant: " + cooTransposeDet);
        System.out.println("Equal: " + (cooDet == cooTransposeDet));

        // Row-Wise Matrix
        System.out.println("\n=== Row-Wise Matrix ===");
        SparseMatrix rowwise = MatrixReader.read(file, "rowwise");

        double rowwiseDet = Determinant.compute(rowwise, rowwise.getDimension());
        System.out.println("Determinant: " + rowwiseDet);

        Transpose.transpose(rowwise);
        double rowwiseTransposeDet = Determinant.compute(rowwise, rowwise.getDimension());
        System.out.println("Transpose Determinant: " + rowwiseTransposeDet);
        System.out.println("Equal: " + (rowwiseDet == rowwiseTransposeDet));
    }
}
