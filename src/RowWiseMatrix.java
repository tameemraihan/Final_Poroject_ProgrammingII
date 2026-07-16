public class RowWiseMatrix implements SparseMatrix {

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

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public double get(int row, int col) {
        if (row < 0 || col < 0 || row >= dimension || col >= dimension) return 0.0;
        RowNode current = rows[row];
        while (current != null) {
            if (current.col == col) {
                return current.value;
            }
            current = current.next;
        }
        return 0.0;
    }

    @Override
    public void set(int row, int col, double value) {
        if (row < 0 || col < 0 || row >= dimension || col >= dimension) return;
        RowNode current = rows[row];
        while (current != null) {
            if (current.col == col) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        // Node not found, insert at head of this row's list
        RowNode newNode = new RowNode(col, value);
        newNode.next = rows[row];
        rows[row] = newNode;
    }

    @Override
    public void delete(int row, int col) {
        if (row < 0 || col < 0 || row >= dimension || col >= dimension) return;
        if (rows[row] == null) return;

        // If head of this row is our target
        if (rows[row].col == col) {
            rows[row] = rows[row].next;
            return;
        }

        // Traverse to find the node before the target
        RowNode current = rows[row];
        while (current.next != null) {
            if (current.next.col == col) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public SparseMatrix reducedMatrix(int skipRow, int skipCol) {
        RowWiseMatrix minor = new RowWiseMatrix(dimension - 1);
        for (int i = 0; i < dimension; i++) {
            if (i == skipRow) continue;
            int newRow = i > skipRow ? i - 1 : i;
            RowNode current = rows[i];
            while (current != null) {
                if (current.col != skipCol) {
                    int newCol = current.col > skipCol ? current.col - 1 : current.col;
                    minor.set(newRow, newCol, current.value);
                }
                current = current.next;
            }
        }
        return minor;
    }
}
