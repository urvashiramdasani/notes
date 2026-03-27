package DesignBingo;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TambolaGenerationStrategy implements GenerationStrategy {
    private static final int NUMS_PER_ROW = 5;

    @Override
    public void populate(Ticket ticket) {
        int rows = ticket.getRows();
        int cols = ticket.getCols();
        Set<Integer> usedNumbers = new HashSet<>();
        int[] rowCounts = new int[rows];

        // Step 1: Guarantee every column has at least one number
        for (int c = 0; c < cols; c++) {
            int r = ThreadLocalRandom.current().nextInt(rows);
            fillCell(ticket, r, c, usedNumbers);
            rowCounts[r]++;
        }

        // Step 2: Fill remaining slots to reach exactly 5 per row
        for (int r = 0; r < rows; r++) {
            while (rowCounts[r] < NUMS_PER_ROW) {
                int c = ThreadLocalRandom.current().nextInt(cols);
                if (ticket.getCell(r, c) == 0) {
                    fillCell(ticket, r, c, usedNumbers);
                    rowCounts[r]++;
                }
            }
        }

        // Step 3: Sort numbers in each column top-to-bottom
        sortColumns(ticket);
    }

    private void fillCell(Ticket ticket, int r, int c, Set<Integer> used) {
        int min = (c * 10) + 1;
        int max = (c == 8) ? 90 : (c + 1) * 10;
        int num;
        do {
            num = ThreadLocalRandom.current().nextInt(min, max + 1);
        } while (used.contains(num));
        ticket.setCell(r, c, num);
        used.add(num);
    }

    private void sortColumns(Ticket ticket) {
        for (int c = 0; c < ticket.getCols(); c++) {
            List<Integer> vals = new ArrayList<>();
            for (int r = 0; r < ticket.getRows(); r++) {
                if (ticket.getCell(r, c) != 0) vals.add(ticket.getCell(r, c));
            }
            Collections.sort(vals);
            int idx = 0;
            for (int r = 0; r < ticket.getRows(); r++) {
                if (ticket.getCell(r, c) != 0) ticket.setCell(r, c, vals.get(idx++));
            }
        }
    }
}
