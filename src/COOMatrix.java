public class COOMatrix implements SparseMatrix { // get() set() delete() reduceMatrix()

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
        if (row < 0 || col < 0 || row >= dimension || col >= dimension) return 0.0;
        COONode current = head;
        while (current != null) {
            if (current.row == row && current.col == col) {
                return current.value;
            }
            current = current.next;
        }
        return 0.0;
    }

    public void set(int row, int col, double value) {
        if (row < 0 || col < 0 || row >= dimension || col >= dimension) return;
        COONode current = head;
        while (current != null) {
            if (current.row == row && current.col == col) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        // Node not found, insert at head
        COONode newNode = new COONode(row, col, value);
        newNode.next = head;
        head = newNode;
    }

    public void delete(int row, int col) {
        if (head == null) return;
        if (row < 0 || col < 0 || row >= dimension || col >= dimension) return;

        // If head is the target
        if (head.row == row && head.col == col) {
            head = head.next;
            return;
        }

        // Traverse to find the node before the target
        COONode current = head;
        while (current.next != null) {
            if (current.next.row == row && current.next.col == col) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public SparseMatrix reducedMatrix(int skipRow, int skipCol) {
        COOMatrix minor = new COOMatrix(dimension - 1);
        COONode current = head;
        while (current != null) {
            if (current.row != skipRow && current.col != skipCol) {
                int newRow = current.row > skipRow ? current.row - 1 : current.row;
                int newCol = current.col > skipCol ? current.col - 1 : current.col;
                minor.set(newRow, newCol, current.value);
            }
            current = current.next;
        }
        return minor;
    }
}