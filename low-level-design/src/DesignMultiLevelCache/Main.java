package DesignMultiLevelCache;

public class Main {
    public static void main(String[] args) {
        // Setup Storage (Capacity: L1=2, L2=3, L3=4)
        Storage<String, Integer> s1 = new HashMapStorage<>(2);
        Storage<String, Integer> s2 = new HashMapStorage<>(3);
        Storage<String, Integer> s3 = new HashMapStorage<>(4);

        // Setup Eviction Policies
        EvictionPolicy<String> e1 = new LruEvictionPolicy<>();
        EvictionPolicy<String> e2 = new LruEvictionPolicy<>();
        EvictionPolicy<String> e3 = new LruEvictionPolicy<>();

        // Build the Chain: L1 -> L2 -> L3
        Cache<String, Integer> c3 = new Cache<>(e3, s3, 3, null, 5, 10); // Slowest
        Cache<String, Integer> c2 = new Cache<>(e2, s2, 2, c3, 3, 7);
        Cache<String, Integer> c1 = new Cache<>(e1, s1, 1, c2, 1, 2);    // Fastest

        System.out.println("--- TESTING PUT (Write-Through) ---");
        c1.put("one", 1);
        c1.put("two", 2);
        c1.put("three", 3); // This will evict "one" from L1 (Capacity 2), but it remains in L2 & L3

        System.out.println("\n--- TESTING GET ---");

        // "two" is still in L1
        ReadResponse<Integer> r1 = c1.get("two");
        System.out.println("Key: two, Value: " + r1.val + ", Found at Level: " + r1.level + ", Total Time: " + r1.totalTime);

        // "one" was evicted from L1, so it should be found in L2 and brought back up to L1
        ReadResponse<Integer> r2 = c1.get("one");
        System.out.println("Key: one, Value: " + r2.val + ", Found at Level: " + r2.level + ", Total Time: " + r2.totalTime);

        // Because "one" was brought back to L1, "three" was evicted from L1. 
        // Let's check "one" again. It should now be lightning fast (found in L1).
        ReadResponse<Integer> r3 = c1.get("one");
        System.out.println("Key: one, Value: " + r3.val + ", Found at Level: " + r3.level + ", Total Time: " + r3.totalTime);
    }
}
