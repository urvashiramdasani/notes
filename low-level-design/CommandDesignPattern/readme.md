You're building an undo-redo feature for a text editor application. Users should be able to perform actions like typing text, deleting text, copy-paste, and formatting (bold, italic, etc.). How would you design the system so that these actions can be undone and redone easily?

It provides full encapsulation of user actions, allows logging/queuing/replaying, supports undo/redo, and decouples UI controls from logic.

How is it different from Strategy Pattern?

Command - provides undo functionality, history,
**Encapsulate actions**
What to do and when

Strategy - does not provide above
**Encapsulate behavior**
How to do something