```mermaid
classDiagram
Item_bank : TYPE type
Item_bank : Item_List market
Item_bank : HashMap<Double, Item_List> q

Item_bank --* Item_List
Item_List --* Item

Item --> Order
Item : TYPE type
Item : double price
Item : int qty
Item : boolean market
```
Presentation Slides: https://docs.google.com/presentation/d/1QzMx7iviBLeLkJZpkpZxpZpYfqdndcNIaZn2C6NHAAE/edit?usp=sharing
By Team 10: Elliot Phua, Benny Goh & Matthew Lalonde for Bank Of America Code To Connect 2024
