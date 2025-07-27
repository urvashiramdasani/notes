You are building a chatroom/messaging system where users can join, send messages, and receive updates.
Initially, each user holds a reference to every other user and directly sends messages to them.

As the number of users grows, managing this peer-to-peer communication becomes hard to scale and modify.

✅ Design a system that allows users to communicate without referring to each other directly, so that communication logic is centralized and easier to maintain.

Mediator vs Observer

- Mediator centralizes and manages communication between components.
- Observer lets components subscribe to changes in another without tight coupling.
- Mediator is more command-driven, Observer is event-driven.

Real World User cases
- UI components (buttons, sliders) coordinated by a mediator (like dialog box logic)
- Chat applications and message routers
- Event buses and pub-sub mechanisms (like in Angular or Backbone.js)
- Air traffic control systems (classic example)