public class Transpose {

    public static void transpose(SparseMatrix m) {
        int n = m.getDimension();

        // Iterate over upper triangle only (i < j)
        // Swap element at (i, j) with element at (j, i)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double upper = m.get(i, j);
                double lower = m.get(j, i);

                // Only act if at least one of them is non-zero
                // If both becomes zero, then call delete() method
                if (upper != 0.0 || lower != 0.0) {
                    if (upper == 0.0) {
                        m.delete(j, i);
                        m.set(i, j, lower);
                    } else if (lower == 0.0) {
                        m.delete(i, j);
                        m.set(j, i, upper);
                    } else {
                        m.set(i, j, lower);
                        m.set(j, i, upper);
                    }
                }
            }
        }
    }
}
