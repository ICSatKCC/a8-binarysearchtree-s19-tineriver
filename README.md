# Assignment 8 - Pokedex Binary Search Tree

 * 100 points
 * Pull Request for code review due Tues. Apr 23.
 * Code reviews must be done by Apr 24
 * Final version due Thurs. Apr 25th.
 
----
Learning Outcomes:

For this assignment, you will practice/learn:
* Creating and using binary search trees.
* Use binary tree traversals.
* Practice your skills in creating and communicating several classes.
----
Finally, we are going to make the Pokedex! :video_game:

In the Pokemon Go game, the Pokedex holds an entry for each species of Pokemon that you have 
caught. This isn't your entire inventory of Pokemon, just a listing of each species you have seen and 
how many seen and caught.

 * Species not yet seen or caught are not in the Pokedex.
 * Species are ordered by Number.
 
You should submit the three new classes described below: 
 * Pokedex.java
 * PokeTree.java
 * PokeNode.java. 
 
If you create any other classes for this assignment (such as a node exception or tree exception), you must submit them as well. 

Include any of the Pokemon class files from previous assignments that are needed to run your program in your GitHub repository
for this assignment.

## Program requirements and structure:

This project will simulate the Pokemon Go Pokedex. A modified Binary Search Tree (BST), a "PokeTree" will function as the Pokedex database. 

 - The PokeTree will formed of nodes that each contain **two** data items:
   1. a Pokemon
   2. An int count of how many times that Pokemon species has been caught. 
 
 - The PokeTree will be ordered by key, this will be the Pokemon species **number** datafield (*NOT the compareTo method ordering!*) 

 - In order to do this you must put Pokemon objects into PokeNodes and add the PokeNodes to the PokeTree object.

----
**Use the example code in Laulima --> Resources --> Session 25 - BinarySearchTree as a template**
* BinaryNode.java
* BinarySearchTree.java
* TreeException.java

**Except** in this assignment, you're not going to make a generic BST, it should be tailored specifically to Pokemon objects (see below).

--- 
Required classes:
---
* Pokedex.java, which is your driver class
* PokeTree.java, which will implement all the binary search tree functionality
* PokeNode.java, (tree node) which will create nodes for your tree.

---

## Pokedex.java

The driver program should have a menu loop with these options:

1. Catch Pokemon
  * Add new Pokemon to the PokeTree
  * Increase the count of number caught of a Pokemon already in the tree.
  * Use your sub-menu from Assignment 4 or 5 to choose Pokemon
  
2. Trade Pokemon
  * Lower the quantity of a caught Pokemon in the PokeTree.
  * Make sure you can't trade Pokemon you don't have! Caught quantity cannot become negative.
  * Remove Pokemon from the tree that are all traded away.
  * Use your sub-menu from Assignment 4 or 5 to choose Pokemon
  
3. Print Pokedex 
  - Print all the Pokemon in the Pokedex ordered by number (*inorder traversal*) and how many of each have been caught.

0. Quit

-----
## Suggested Methods for your classes

The class methods described below are there to give you an idea of what will be needed. 
You are free to organize your project any way you want as long as you have AT LEAST these three required classes 
and functionality given above.

Do not forget that you need to validate everything, thus you will need to have exception classes. 
These may be included in the class files like some of our example code has done, or in their own files.

#### Comments are very important
Since you will have complete authority in regards to your code design, it is VERY important that you add explicit comments 
to your code. This can add or take away points from your grade. 

### PokeNode.java

#### Node constructor
`public PokeNode( Pokemon P, int numCaught, PokeNode lChild,  PokeNode rChild)`
 * Pokemon should be a non-null object.
 * numCaught should be >= 1.
 * lChild and rChild are PokeNodes. They may or not be null depending on your implementation.

#### Get methods
`public Pokemon getPokemon( )`
 * This method will return a Pokemon object from inside a given node
 
`public int getKey( )`
 * This method will return the Pokemon species' number of the Pokemon in a given node. This is the key for the PokeTree.
 
`public int getNumCaught( )`
 * This method will return the numCaught from inside a given node
  
`public PokeNode getLChild( )`
 * This method will return the left child of a given node

`public PokeNode getRChild( )`
 * This method will return the right child of a given node

#### Set methods
`public void increaseNumCaught( )`
 * This method will increment the numCaught in a node
 
 `public void decreaseNumCaught( )`
 * This method will decrement numCaught in a given node
 * Should throw an exception if it becomes < 1
 
`public void setLChild( PokeNode newLChild)`
 * This method will set newLNode as the left child of a node

`public void setRChild( PokeNode newRChild)`
 * This method will set newRNode as the right child of a node

**Note:** There is no public setPokemon method. We don't want anybody to change the species of Pokemon in a node that is already part of the tree, this will break the Binary Search Tree rules. You can make a private one as a helper method for removing if you want to.

---

### PokeTree.java

#### Constructor:
`public PokeTree( )`
 * Empty PokeTree constructor.

#### Adding Pokemon: 
`public void add( Pokemon p )`
 * This method should call the private recursive add method with root (below)
 
`private PokeNode add(PokeNode node, Pokemon p )`
 * Recursive add method
 * Should make a new node and put Pokemon p in it with numCaught = 1 if not already in the tree
 * Should increment numCaught if Pokemon p already is in the tree
 
#### Removing Pokemon:
***Hint:*** Do this part last, it is hardest because you have to reorder the tree

`public void remove( Pokemon p)`
 * Wrapper method that calls recursive remove method with root
 
`private Pokenode remove(PokeNode node,  Pokemon p)`
 * decrements numCaught
 * Removes Pokemon p from the tree if numCaught == 0
 * Throws exception if p not in the tree
 
#### Getting Pokemon in Tree by number:
`public Pokemon get(Pokemon searchKey){`
 * Public wrapper method that calles recursive method with root
 
`private Pokemon get(PokeNode node, Pokemon searchKey){`
 * Private recursive get method
 * Returns Pokemon object with number == searchKey.getNumber()
 * Should throw an exception if Pokemon with number == searchKey.getNumber() not in the tree
 
#### PokeTree Print method:
`public void printPokeTree()`
 * Overloaded wrapper method in order to access private data field `root` to send to recursive method.
 
`private void printPokeTree(PokeNode root){`
 * private recursive method that prints the PokeTree **inorder** 
 
 Use the below example to print the PokeTree tree in preorder, you can then modify the order to make the printPokeTree:

```java
public void preorderPokeTree()
```
 * Overloaded wrapper method in order to access private data field `root` to send to recursive method.
 
```java	
private void preorderPokeTree(PokeNode root){
      if(root != null){
       System.out.println("  " + root.getPokemon( ).toString() + "\nCaught: "+root.getNumCaught( ) );
           preorderPokeTree(root.getLChild());
           preorderPokeTree(root.getRChild());
      }
}
```
 * The recursive method takes the root as a parameter and will print tree in **preorder traversal**. 
 * It is good for debugging purposes.
 * You may copy and paste this into your PokeTree class.
 
---

## Extra Credit
1. Add more Pokemon families. 1 point per family - see: [Species Stats](https://thesilphroad.com/research) 
2. Add ASCII art images to your Pokemon classes and print them with the Pokedex. These can be stored as long Strings in your objects. Or make a HashMap with the Pokemon species as the key and the ASCII art string as the value. Store this as part of the PokeTree (hard coded to build when constructor is called) and access during printing. examples: [Pokemon ASCII art](http://www.ascii-code.com/ascii-art/video-games/pokemon.php) (variable points)
3. Write JUnit tests for the PokeTree and PokeNode classes. These should test all functionality listed in the Grading Rubric (main method/driver class doesn't need test). (50 points).


## Grading Rubric

### Code Review 10/10
- [x] Review Code For: (      )
- [x] Reply to Review From: (        )

### Pokedex Driver 20/20
- [x] Catch Pokemon
 *  Add new Pokemon to the BST
 *  Increase the count of number caught of a Pokemon already in the tree.
- [x] Trade Pokemon
 * Lower the quantity of a caught Pokemon in the BST.
 * Caught quantity cannot become negative.
 * Remove Pokemon from the tree that are all traded away.
- [x]  Print out the Pokedex

- [x] Commenting and coding style


### PokeNode 20/20
- [x]  Node constructor
 *  Pokemon should be a non-null object.
 *  numCaught should be >= 1.
 * lChild and rChild are PokeNodes.

- [x]  Get methods
- [x]  Set methods
 * increaseNumCaught( )
 * decreaseNumCaught( )
 * no (or private) setPokemon method. 
- [x] Commenting and coding style

### PokeTree.java 50/50
- [x] Constructor:
- [x] public/private add methods
- [x] public/private remove methods
 * decrements numCaught
 * Removes Pokemon p from the tree if numCaught == 0
 * Throws exception if p not in the tree
- [x] Getting Pokemon in Tree by number:
 * public/private get methods
 * throws exception if Pokemon not in the tree
- [x] Inorder traversal print method
- [x] Commenting and coding style
------
If you have any questions please e-mail Lisa:  ljmiller@hawaii.edu
