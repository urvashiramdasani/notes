package DesignRevenueCalculator;

import java.util.*;

public class CustomerRevenueTracker {
    // Maps Customer ID to their total cents
    private final Map<String, Long> customerRevenueMap = new HashMap<>();

    // Maps Total Cents -> Sorted Set of Customer IDs (TreeSet ensures deterministic tie-breaking)
    private final TreeMap<Long, TreeSet<String>> sortedRevenues = new TreeMap<>();

    /**
     * Updates the customer's total revenue in O(log N) time.
     */
    public void addRevenue(String customerId, Money amount) {
        long currentCents = customerRevenueMap.getOrDefault(customerId, 0L);
        long newCents = currentCents + amount.getCents();

        // 1. Remove old revenue entry from the sorted map
        if (currentCents > 0) {
            Set<String> customersWithOldRevenue = sortedRevenues.get(currentCents);
            customersWithOldRevenue.remove(customerId);
            if (customersWithOldRevenue.isEmpty()) {
                sortedRevenues.remove(currentCents);
            }
        }

        // 2. Update the direct lookup map
        customerRevenueMap.put(customerId, newCents);

        // 3. Add to the new revenue bucket in the sorted map
        sortedRevenues.computeIfAbsent(newCents, k -> new TreeSet<>()).add(customerId);
    }

    /**
     * Gets the lowest K customers who have spent at least minRevenue.
     * Uses tailMap() to jump directly to the threshold in O(log N) time!
     */
    public List<String> getLowestKCustomers(int k, Money minRevenue) {
        List<String> result = new ArrayList<>();
        if (k <= 0) return result;

        // THE FIX: tailMap instantly gives us a view of all revenues >= the minimum.
        // No more O(N) linear scanning from the beginning of the map!
        SortedMap<Long, TreeSet<String>> eligibleRevenues = sortedRevenues.tailMap(minRevenue.getCents());

        for (TreeSet<String> customers : eligibleRevenues.values()) {
            for (String customerId : customers) {
                result.add(customerId);
                if (result.size() == k) {
                    return result; // We found K customers, exit early
                }
            }
        }
        return result;
    }
}
