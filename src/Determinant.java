public class Determinant {

    public static double compute(SparseMatrix m, int size) {
        // Base case: 1x1
        if (size == 1) {
            return m.get(0, 0);
        }

        // Base case: 2x2: (det = ad - bc)
        if (size == 2) {
            return m.get(0, 0) * m.get(1, 1) - m.get(0, 1) * m.get(1, 0);
        }

        // Laplace algo
        double det = 0.0;
        for (int j = 0; j < size; j++) {
            double val = m.get(0, j);
            if (val != 0.0) {
                SparseMatrix minor = m.reducedMatrix(0, j);
                double sign = ((j % 2) == 0) ? 1.0 : -1.0;
                det += sign * val * compute(minor, size - 1);
            }
        }
        return det;
    }
}
