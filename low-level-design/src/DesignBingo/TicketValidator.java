package DesignBingo;

import java.util.Set;
import java.util.HashSet;

public class TicketValidator {
    private static final int EXPECTED_ROWS = 3;
    private static final int EXPECTED_COLS = 9;
    private static final int NUMS_PER_ROW = 5;

    public void validate(Ticket ticket) {
        if (ticket.getRows() != EXPECTED_ROWS || ticket.getCols() != EXPECTED_COLS) {
            throw new InvalidTicketException("Invalid ticket dimensions.");
        }

        Set<Integer> seenNumbers = new HashSet<>();
        int[] colCounts = new int[EXPECTED_COLS];

        for (int r = 0; r < ticket.getRows(); r++) {
            int rowCount = 0;
            for (int c = 0; c < ticket.getCols(); c++) {
                int val = ticket.getCell(r, c);
                if (val != 0) {
                    rowCount++;
                    colCounts[c]++;

                    // 5a. Check Uniqueness
                    if (!seenNumbers.add(val)) {
                        throw new InvalidTicketException("Duplicate number found: " + val);
                    }

                    // 5b. Check Column Bounds
                    int min = (c * 10) + 1;
                    int max = (c == 8) ? 90 : (c + 1) * 10;
                    if (val < min || val > max) {
                        throw new InvalidTicketException("Number " + val + " is out of bounds for column " + c);
                    }
                }
            }

            // 5c. Check Row Count Constraint
            if (rowCount != NUMS_PER_ROW) {
                throw new InvalidTicketException("Row " + r + " does not have exactly " + NUMS_PER_ROW + " numbers.");
            }
        }

        // 5d. Check Column Constraints & Sorting
        for (int c = 0; c < ticket.getCols(); c++) {
            if (colCounts[c] == 0) {
                throw new InvalidTicketException("Column " + c + " is completely empty.");
            }

            int previousVal = -1;
            for (int r = 0; r < ticket.getRows(); r++) {
                int val = ticket.getCell(r, c);
                if (val != 0) {
                    if (previousVal != -1 && val <= previousVal) {
                        throw new InvalidTicketException("Column " + c + " is not sorted properly.");
                    }
                    previousVal = val;
                }
            }
        }
    }
}
