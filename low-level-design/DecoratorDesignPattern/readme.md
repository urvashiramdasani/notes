You're designing a coffee ordering system for a coffee shop.
Each coffee (like Espresso, Latte, etc.) can be customized with add-ons like milk, soy, whipped cream, caramel, etc.

These customizations:

Affect the description of the coffee (e.g., "Espresso with Soy and Caramel")

Increase the cost of the base drink

✅ Design a flexible system that allows adding any number of combinations of add-ons without creating a new subclass for every combination.

How does it follow Open/Closed Principle?

The base beverage classes and decorators are open for extension (you can add new add-ons like Chocolate or Vanilla without modifying existing code), but closed for modification. The core logic of Latte, Espresso, etc., remains untouched as we build new functionality through decorators.