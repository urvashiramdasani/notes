You're building a Music Streaming App (like Spotify). Each user can create multiple playlists, and each playlist contains songs from different genres.

Now you need to support a feature where:

A user can browse through songs in a playlist, one by one.

In the future, they might want to iterate only through songs of a specific genre, or in reverse order, or based on a custom filter (e.g., songs longer than 3 minutes).

🔹 Design the playlist module such that the client can iterate over songs without exposing the internal structure of the playlist.

🔹 Which design pattern would you use? How would you implement different ways of iteration?