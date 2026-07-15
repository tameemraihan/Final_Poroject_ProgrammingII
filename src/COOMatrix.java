public class COOMatrix {
   private class COONode { 
        int row;
        int col;
        double value;
        COONode next;

        COONode(int row, int col, double value) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.next = null;
        }
    }

    private COONode head;
    private int dimension; // 50

    public COOMatrix(int dimension) {
        this.dimension = dimension;
        this.head = null;
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
