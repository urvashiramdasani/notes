You're building a video streaming platform like YouTube or Netflix.
Videos can be stored in high resolution, and loading them is expensive in terms of bandwidth and memory.

Users can browse through a list of video thumbnails. When they click on a video, the full-resolution video is loaded and played.

✅ Design a system that delays the loading of heavy video content until it’s needed.

You should also consider access control — certain videos are only viewable by premium users.

1. What types of proxies can be implemented here?
   Answer:

Virtual Proxy: Delays the actual video load until play() is called.

Protection Proxy: Checks if the user has the right to view the video.

Remote Proxy (optional): If the video is stored on a different server.

Caching Proxy: To reuse already-loaded videos and reduce load time.

2. Where have you seen proxy used in real-world frameworks? Answer:

Hibernate (Java): Uses proxies for lazy-loading entities from the database.

Spring AOP: Uses proxies for applying aspects like logging, security.

Browser caching/CDNs: Can act as proxies to reduce network latency.

