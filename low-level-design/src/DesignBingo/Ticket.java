package DesignBingo;

// Data Model - used to hold state
public class Ticket {
    private final int rows;
    private final int cols;
    private final int[][] grid;

    // 1. Constructor
    public Ticket(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new int[rows][cols];
    }

    // 2. getters
    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public int getCell(int r, int c) {
        return this.grid[r][c];
    }

    // 3. setters
    public void setCell(int r, int c, int value) {
        this.grid[r][c] = value;
    }

    // Never ever write system.out.println in data models
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------------------\n");
        for (int[] row : grid) {
            for (int val : row) {
                sb.append((val == 0) ? ".." : String.format("%02d", val)).append(" ");
            }
            sb.append("\n");
        }
        sb.append("-----------------------------------------");
        return sb.toString();
    }
}
