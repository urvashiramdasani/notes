LSP states that objects of a superclass should be replaceable with objects of a subclass without altering the correctness of the program.
In simpler terms, if class S is a subclass of class T, then we should be able to use S wherever T is expected, and the behavior should remain consistent.

Inheritance provides a structural relationship, but LSP is about behavioral substitutability.
Just because a subclass "is-a" parent class syntactically doesn’t mean it’s safe to substitute. LSP ensures behavioral consistency when doing so.

LSP reinforces the Open/Closed Principle by ensuring new subclasses can be introduced without breaking existing code.
It also complements Interface Segregation by encouraging us to expose only relevant behavior to subclasses, so we don’t force them to implement methods they can’t fulfill.

**Approach 1** works better when the client knows in advance whether it needs a flying bird or not.
Cons- 
- Adding behavior (e.g., swimming) leads to explosion of abstract subclasses (SwimmingBird, FlyingSwimmingBird, etc.).
- Rigid hierarchy: What if we want to change flying behavior at runtime (e.g., bird with broken wing)?

In **Approach 2**, we have made flay behavior plug and play types, meaning if in runtime we want to change the fly behavior
we can do that. Let's say the sparrow has a broken wing and it cannot fly. In Approach 1, it won't work because we have 
strictly defined it to fly. But in Approach 2, we can decide at runtime what behavior we want for the class.

Approach 2 implement **Strategy Design Pattern**