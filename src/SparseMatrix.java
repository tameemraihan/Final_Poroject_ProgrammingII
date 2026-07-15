public interface SparseMatrix {

    // Returns the value at (row, col), 0.0 if not stored (zero element)
    double get(int row, int col);

    // Inserts or updates the value at (row, col)
    void set(int row, int col, double value);

    // Removes the element at (row, col), treating it as zero
    void delete(int row, int col);

    // Returns the dimension n of the n x n matrix
    int getDimension();

    // Returns a new (n-1) x (n-1) matrix with the given row and column removed
    SparseMatrix reducedMatrix(int skipRow, int skipCol);
}
