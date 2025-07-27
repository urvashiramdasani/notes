You are designing a tax calculator for a financial application that processes various asset types:

RealEstate

Stock

BankDeposit

Each asset has its own way of calculating tax based on multiple tax rules (e.g., state tax, wealth tax, short/long term gains).

New tax rules are frequently introduced, and you want to apply them without changing the structure of the asset classes every time.

🧠 Design a system where you can add new tax calculation strategies without modifying existing asset classes.

Visitor works best when the set of elements is stable but operations change frequently. If new asset types are being added often, you'd need to change every visitor each time — violating open/closed. In that case, polymorphism or a more dynamic design might be better.

Real world use cases 
- Compilers/Interpreters: For AST traversal (e.g., pretty print, type check, optimization)
- File systems: Apply operations like compression, indexing, antivirus scanning
- Document processing: Convert document elements to HTML, PDF, etc.
- UI Toolkits: Perform operations on component trees
