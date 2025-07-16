You're building a map rendering engine like Google Maps. The system needs to display thousands of markers (e.g., gas stations, restaurants, hospitals) on the map. Many of these markers share the same icon, color, or shape. How would you design the system to minimize memory usage while rendering large volumes of such objects?

rendering performance also improves, as shared resources (like icons) can be cached on GPU.

Flyweight works best with immutable shared state.

We avoid object bloat and GC pressure by minimizing how many full-featured objects we allocate.