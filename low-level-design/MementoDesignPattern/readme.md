You're developing a text editor (like Notepad or VS Code).
Users can type text, delete, and make changes.
You are now asked to implement an Undo/Redo feature, where the editor can revert to previous states without exposing or tightly coupling with the internal structure of the text document.

✅ Design a solution that allows the editor to save and restore its state over time — in a clean, encapsulated way.

Memento vs Command

Memento captures state, and can restore it.

Command captures intent or action, and can redo/undo the operation by re-executing or reversing it.

it's widely used in games to implement save/load features (e.g., checkpoints, game states, undo last move in chess)

Is this pattern memory-efficient?
Not always.
If state objects are large (e.g., images, documents), saving full snapshots is expensive.
In such cases, delta-based (difference-based) mementos or command pattern might be more appropriate.

Imagine a text editor where:

The entire content is stored in the editor's state (say, 10,000 lines).

Every keystroke creates a new snapshot (memento).

After typing 100 characters, you have 100 full copies of the editor's state.

📉 That’s inefficient, especially if the state is large. In this case, we can use Command pattern over Memento Pattern.

Best of both worlds - In real-world apps (like VS Code, Photoshop, etc.), it’s common to:

Use Command pattern for fine-grained changes (text, UI actions)

Use Memento for full snapshots (e.g., checkpoint, file save)

This offers performance + flexibility.
