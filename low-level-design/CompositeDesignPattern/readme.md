You are designing a file system explorer (like Windows Explorer or macOS Finder).
A user should be able to perform operations like:

Show structure

Calculate size

Rename

A directory can contain files or other directories.
Both File and Directory should be treated uniformly (i.e., the user should not care whether it's a file or folder when performing actions).

Benefit - Uniform operations on individual objects and compositions (files and directories).

Can you use Composite Pattern with GUI components?

➤ Yes, frameworks like Swing and JavaFX use it for building UI hierarchies (e.g., panels containing labels, buttons, etc.).