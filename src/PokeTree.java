/**
* Poke
* @author Kristine Rivera
* @since 4/22/19
*/
public class PokeTree<P> {

   /** Root node instance variable. */
   private PokeNode<P> root = null;
   
   /**Empty PokeTree constructor.*/
   public PokeTree( ) {
      //root already initialized
   }
   
//-------ADDING POKEMON-------

   /** Adds a Pokemon object to the tree.
   * Non-recursive wrapper method
   * @param p  The object to be added
   */
public void add( Pokemon p ) {
   // calls a private recursive add method
   root = add(root, p);
}

   /** Recusively adds an item to the tree.
   * @param node  The root of the tree/subtree
   * @param p     The object to be added
   * @return The current node
   */
private PokeNode add(PokeNode node, Pokemon p ) {
   // base case: empty tree or end of a leaf
   if (node == null) {
      // adds new node and with numCaught = 1
      
      int numCaught = 1;
      return new PokeNode<P>(p, numCaught);
   }
   // recursive case: 

}

//Should increment numCaught if Pokemon p already is in the tree



}