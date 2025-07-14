Design a notification system that supports multiple channels (like Email, SMS, and Push Notification) and allows different types of messages (like Alerts, Reminders, and Promotions). Ensure that both the message types and the delivery channels can evolve independently.

Recognition that this is a two-dimensional hierarchy:

→ Abstractions: Message types

→ Implementations: Delivery channels

A solution where adding a new message type or channel does not affect the other

**Bridge Pattern** — decouple abstraction (what you're doing) from implementation (how it's done).