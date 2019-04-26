/**
* PokeTree Class.
* @author Kristine Rivera
* @since 4/22/19
* @param <p> holds generic type object
*/
public class PokeTree<p> {

   /** Root node instance variable. */
   private PokeNode<p> root = null;
   /** counter for incrementing numCaught. */
   private static int plus = 0;
   /**Empty PokeTree constructor.*/
   public PokeTree() {
      //root already initialized
   }
   
//-------ADDING POKEMON-------

   /** Adds a Pokemon object to the tree.
   * Non-recursive wrapper method
   * @param p  The object to be added
   */
   public void add(Pokemon p) {
   // calls a private recursive add method
      root = add(root, p);
   }

   /** Recusively adds an item to the tree.
   * @param node  The root of the tree/subtree
   * @param p     The object to be added
   * @return The current node
   */
   private PokeNode add(PokeNode node, Pokemon p) {
   
   // base case: empty tree or end of a leaf
      if (node == null) {
      // adds new node and with numCaught = 1
         node =  new PokeNode<p>(p, 1, null, null);
         for (int i = 0; i < plus; i++) {
            node.increaseNumCaught();
         }
         return node;
      }
      // recursive case: if item is less than current node
      // then move to the left child node
      else if (p.getNumber() < node.getPokemon().getNumber()) {
      //set the node's left child to the
      //left subtree with item added
         if (p.getNumber() == node.getPokemon().getNumber()) {
            plus = node.getNumCaught();
         }
         node.setLChild(this.add(node.getLChild(), p));
         
         return node;
      }
      // recursive case: if item is greater than current node
      // then traverse to right child node
      else {
      // set the node's right child to the
      // right subtree with item added
         if (p.getNumber() == node.getPokemon().getNumber()) {
            plus = node.getNumCaught();
         }
         node.setRChild(this.add(node.getRChild(), p));
         
         return node;
      }
   }
//------- REMOVE METHOD -------
   
   /** Removes a Pokemon from the tree.
   * @param p Pokemon object to remove.
   */
   public void remove(Pokemon p) {
      root = this.remove(root, p);
   }

   /**Recursively removes Pokemon from the tree.   
   * @param node  The root of the tree/subtree
   * @param p     Pokemon to remove.
   * @return root of current subtree.
   * @throws RuntimeException if item not found in tree.
   */
   private PokeNode remove(PokeNode node, Pokemon p) {
      // if item not found, throw exception
      if (node == null) {
         throw new RuntimeException("Item not found!");
      }
      else if (p.getNumber() == node.getKey()
               && p.getName().equals(node.getPokemon().getName())) {
      // call private method remove
         node = this.remove(node); //sends to remove helper method
         if (p.getNumber() == node.getKey()) {
            node.decreaseNumCaught();
         }
         return node;
      }
      // if Pokemon number is less than node's number,
      // continue to left subtree
      else if (p.getNumber() < node.getKey()) {
         node.setLChild(this.remove(node.getLChild(), p));
         if (node.getKey() == node.getLChild().getKey()) {
            node.decreaseNumCaught();
         }
         return node;
      }
      // if Pokemon number is greater than node's number,
      // continue to right subtree
      else {
         node.setRChild(this.remove(node.getRChild(), p));
         if (node.getKey() == node.getRChild().getKey()) {
            node.decreaseNumCaught();
         }
         return node;
      
      // found node containing object with same search key,
      // so delete it
      }
   }
   
   /** Helper method that takes a node out of tree.
   * @param node The node to remove
   * @return The node that replaces removed node or null.
   */
   private PokeNode<p> remove(PokeNode<p> node) {
   // if node is a leaf,return null
      if (node.getLChild() == null && node.getRChild() == null) {
         return null;
      }
      // if node has a single right child node,
      // then return a reference to the right child node
      else if (node.getLChild() == null) {
         return node.getRChild();
      }
      // if node has a single left child node,
      // then return a reference to the left child node
      else if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if the node has two child nodes
      else {
      // get next Smaller Item, which is Largest Item in Left Subtree
      // The next Smaller Item is stored at the rightmost node in the left
      // subtree.
         Pokemon largestItemInLeftSubtree = 
            this.getItemWithLargestSearchKey(node.getLChild());
      // replace the node's item with this item
         node.setPokemon(largestItemInLeftSubtree); 
      // delete the rightmost node in the left subtree
         node.setLChild(this.removeNodeWithLargestSearchKey(node
             .getLChild()));
         return node;
      }
   }
   
   /**
   * Returns the item with the largest search key in the (sub)tree.
   * Helper method for removing interior nodes.
   * @param node The root of the tree/subtree
   * @return The data item with largest key
   */
   private Pokemon getItemWithLargestSearchKey(PokeNode<p> node) {
   // if no right child, then this node contains the largest item
      if (node.getRChild() == null) {
         return node.getPokemon();
      }
      // if not, keep looking on the right
      else {
         return this.getItemWithLargestSearchKey(node.getRChild());
      }
   }

  /**
   * Removes the node with the largest search key.
   * Helper method for removing interior nodes.
   * Remove the node formerly occupied by item with largest search key.
   * To be called after item is moved to new node location.
   * 
   * @param node The root of the tree/subtree
   * @return root of (sub)tree with node removed.
   */
   private PokeNode<p> removeNodeWithLargestSearchKey(PokeNode<p> node) {
   // if no right child, then this node contains the largest item
   // so replace it with its left child
      if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if not, keep looking on the right
      else {
         node.setRChild(this.removeNodeWithLargestSearchKey(node
             .getRChild()));
         return node;
      }
   }
    



//------- GET METHOD -------

   /** gets an item from the tree with the same search key.
   * @param searchKey An object containing the search key
   * @return the Pokemon object in the tree with matching key.
   */
   public Pokemon get(Pokemon searchKey) {
      return this.get(root, searchKey);
   }

   /** Recursive method to get Pokemon from the tree.
   * @param node The root of the tree/subtree
   * @param searchKey An object storing the key to get.
   * @return the Pokemon object in tree with matching key.
   * @throws RuntimeException if item not found in tree.
   */
   private Pokemon get(PokeNode node, Pokemon searchKey) {
   // if not found, throw exception
      if (node == null) {
         throw new RuntimeException("Item not found!");
      } 
      else {
      // if the search key matches, return the item's address
         if (searchKey.getNumber() == node.getKey()
               && searchKey.getName().equals(node.getPokemon().getName())) {
            return node.getPokemon();
            
         }
         // if the search key of the searchKey is less than the node,
         // then search the left subtree
         else if (searchKey.getNumber() < node.getKey()) {
            return this.get(node.getLChild(), searchKey);
         }
         // if the search key of the searchKey is greater than the node,
         // then search the right subtree
         else {
            return this.get(node.getRChild(), searchKey);
         }
      }
   }



//------- PRINT METHOD --------
   /** In-order transversal print method. */
   public void printPokeTree() {
      this.printPokeTree(root);
   }
   
   /** In-order print method.
   * @param root  The root of the tree/subtree
   */
   private void printPokeTree(PokeNode root) {
      try {
         if (root != null) {
            printPokeTree(root.getLChild());
            System.out.println("  " + root.getPokemon().toString() 
               + "\nCaught: " + root.getNumCaught() + "\n"); 
            printPokeTree(root.getRChild());
         }   
      }
      catch (NullPointerException nfe) {
      }
   }
   
   
   /** Pre-order transversal print method. */
   public void preorderPokeTree() {
      this.preorderPokeTree(root);
   }
   
   /** Pre-order print method.
   * @param root  The root of the tree/subtree
   */
   private void preorderPokeTree(PokeNode root) {
      if (root != null) {
         System.out.println("  " + root.getPokemon().toString() 
            + "\nCaught: " + root.getNumCaught());
         preorderPokeTree(root.getLChild());
         preorderPokeTree(root.getRChild());
      }
   }


//------- DRIVER: TEST CLASS -------
   /** Driver code to test class.
   * @param args are not used
   */
   public static void main(String[] args) {
      PokeTree<Pokemon> tree = new PokeTree<Pokemon>();
      System.out.println("Test add() method:");
   
      tree.add(new Squirtle());
      tree.add(new Charmander());
      tree.add(new Bulbasaur());
      tree.add(new Venusaur());
      tree.add(new Blastoise());
      tree.add(new Charizard());
      Pokemon j = new Squirtle("Jesse");
      tree.add(j);
      tree.add(new Charmander("Sunny"));
      Pokemon s = new Squirtle("Tom");
      tree.add(s);
   
      System.out.println("\n\nTest printPokeTree() method:");
      tree.printPokeTree();
   
      System.out.println("\n\nTest preorderPokeTree() method:");
      tree.preorderPokeTree();
      
      System.out.println("\n\nTest get() method:");
      
      System.out.println(tree.get(s).toString());
      Pokemon a = new Charmeleon();
      
      //Removes Jesse but Tom should still be there 
      //and his numcaught should be 2***
      System.out.println("\n\nTest remove() method:");
      tree.remove(j);
      tree.printPokeTree();
      
      
      //throws runtime error "not found"
      //System.out.println(tree.get(a).toString());
      
   }  //end main

} //end class