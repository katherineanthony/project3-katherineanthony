# project3-katherineanthony

#### Overall Project Structure
This project has three different classes, UserInterface, FamilyTree, and Person.
UserInterface is where the FamilyTree is crafted, and has a tester method.
FamilyTree and Person are more complicated because they contain the data that
make up the tree.

I found it easier to use HashMaps for people and a DisjointSet that was an 
ArrayList, specifically because the tree is ever-growing. It was difficult to 
figure out how to connect the disjoint set to printing out the entire tree, 
but an adjacency list made it a lot easier to connect and demonstrate the 
generations. One of the most difficult parts of the entire project was printing
correctly, and that's why I chose to ues recursion in my FamilyTree method
and an adjacencylist.

#### Family Tree
FamilyTree has three instance variables: adjacencyList, people, and disjointSet.
These three variables have distance purposes:
- AdjacencyList: to show which people are connected from generation to generation.
- People: to hold all the People and their information
- DisjointSet: to show which person is the root

When creating the FamilyTree, `addPerson()`, `addEvent()`, and `addRelationship()`.
All of these are important in establishing connections between people and their
family.

`addPerson()` adds a person to the tree as their own person, and initializes them
into the tree. It does not connect them to anyone else.

`addRelationship()` takes the type of the relationship and the two people. Using
another helper function, `union()`, to properly union them in the disjointSet,
and then adds the correct person to the other's ArrayList in the adjacencyList.

`addEvent()` adds an event to one person.

`traceTree()` and `printTree()` are the final methods that work together to
recursively call down the tree and prints everyone in order. `printTree()` is
the recursive method that goes down the adjacencyList.

#### Person

This class contains all the information for one person. It has many instance
variables: name, birthYear, deathYear, events, index and marriage. deathYear
and marriage are both optional and are only printed if they are not null.
- events: holds all the events of one person in a HashMap (key is the year,
value is the description) -- events are sorted before printed
- index: index of person in the disjointset and adjacencyList in FamilyTree

The functions in Person are mostly getters and setters, and much of the
interesting work goes in the toString because that is where I sorted the events.