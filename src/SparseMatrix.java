public interface SparseMatrix {

    double get(int row, int col);

    void set(int row, int col, double value);

    void delete(int row, int col);

    int getDimension();
}
