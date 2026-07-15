public class RowWiseMatrix {
    private class RowNode {
        int col;
        double value;
        RowNode next;

        RowNode(int col, double value) {
            this.col = col;
            this.value = value;
            this.next = null;
        }
    }

    private RowNode[] rows;
    private int dimension;

    public RowWiseMatrix(int dimension) {
        this.dimension = dimension;
        this.rows = new RowNode[dimension];
        for (int i = 0; i < dimension; i++) {
            rows[i] = null;
        }
    }

    public int getDimension() {
        return dimension;
    }
    public double get(int row, int col) {
        return 0.0;
    }
    public double set(int row, int col, double value) {
       return 0.0;
    }
    public void delete(int row, int col) {
        
    }
} 
    
