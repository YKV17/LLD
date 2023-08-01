SOLID
S - Single responsibility
O - Open Close
L - Liskov's Substitution
I - Interface Segregation
D - Dependency Inversion

One Extra
Don't repeat yourself





Solve:
- Handle single responsibility principle in much better way
- open close principle




Problems:
 - there are some birds which do not fly (ex. Ostrich, Penguin) but we are still having fly methods for them.
 - Violates Liskov's substitution behaviour (Class Explosion) - Objects of every child class should be as is  substitutable  with a  variable of parent.


 Workaround (But not a good idea)
 - Throwing exception
 - Not implementing fly method
 - create 2 child classes flyable and non flyable (Class Explosion)
 - you cannot create a list of birds which can fly using class explosion (inability to recognize all instance which demonstrate a particular behaviour)