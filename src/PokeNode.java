/**
* PokeNode: Generic class for binary node.
* @author Kristine Rivera
* @since 4/22/19
* @param <P> Pokemon data held in Nodes.
*/
public class PokeNode<P> {

   //data fields
   /** Pokemon Data held in Node. */
   private Pokemon data;
   /** Number of when Pokemon was caught. */
   private int num;
   /** Link to Left child Node. */
   private PokeNode<P> left;
   /** Link to Right child Node. */
   private PokeNode<P> right;
   
   /**
   * CONSTRUCTOR.
   * @param P           The address of Pokemon object stored in node
   * @param numCaught   The address of number when Pokemon was caught
   * @param lChild      The address of left child
   * @param rChild      The address of right child
   */
   public PokeNode( Pokemon P, int numCaught,
         PokeNode lChild, PokeNode rChild) {
      data = P; //Pokemon should be a non-null object.***
      num = numCaught; //numCaught should be >= 1.***
      left = lChild;
      right = rChild;  
   }  //end constructor
   
   
   /**
   * GETPOKEMON METHOD.
   * returns a Pokemon object from inside a given node
   */
   public Pokemon getPokemon( ) {
      return data;
   }
   
   /**
   * GETKEY METHOD.
   * return the Pokemon species' number of the Pokemon in a given node.***
   */
   public int getKey( ) {
    return data.getNumber();
   }
   
    /**
   * GETNUMCAUGHT METHOD.
   * return the numCaught from inside a given node
   */
   public int getNumCaught( ) {
      return num;
   }
   
   /**
   * GETLCHILD METHOD.
   * return the left child of a given node
   */
   public PokeNode getLChild( ) {
      return left;
   }
   
   /**
   * GETRCHILD METHOD.
   * return the right child of a given node
   */
   public PokeNode getRChild( ) {
      return right;
   }

   //------------------------------------------------------
   
   /**
   * IncreaseNumCaught METHOD.
   * increments the numCaught in a node
   */
   public void increaseNumCaught( ) {
      num++;
   }

   /**
   * DecreaseNumCaught METHOD.
   * decrements numCaught in a given node
   * throws an exception if it becomes < 1 ***
   */
   public void decreaseNumCaught( ) {
      num++;
   }

   /**
   * SetLChild METHOD.
   * sets newLNode as the left child of a node
   * @param newLChild    new left child adress
   */
   public void setLChild( PokeNode newLChild) {
      left = newLChild;
   }
   
   /**
   * SetRChild METHOD.
   * sets newLNode as the right child of a node
   * @param newRChild   new right child adress
   */
   public void setRChild( PokeNode newRChild) {
      right = newRChild;
   }



}