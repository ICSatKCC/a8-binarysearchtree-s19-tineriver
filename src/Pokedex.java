import java.util.*;
import java.util.Random;
/**
* Pokemon Driver Program.
* adds Pokemon catched, remove Pokemon traded and print Pokedex.
* @author Kristine Rivera
* @since 4/22/19
*/
public class Pokedex {

   /**SCANNER.*/
   private static Scanner userIn = new Scanner(System.in);
   /**USER INPUT IN STRINGS.*/
   private static String inString = new String("");
   /**RANDOMIZER.*/
   private static Random randGen = new Random();
   /**BORDER.*/
   private static String b = "------------------------------------------------";
   /**POKETREE.*/
   private static PokeTree<Pokemon> tree = new PokeTree<Pokemon>();
   /**TEMP POKEMON OBJ.*/
   private static Pokemon p;
   /**CAUGHT.*/
   private static int Count = 0;
   
   /** Main Method.
   *@param     args not used
   */
   public static void main(String[] args) { 
   
   boolean endLoop = false;
   
      //loop until stopping condition is given
      while (!endLoop) {
         //menu text
        
         System.out.println("Interactive Pokedex.");
         System.out.println("1. Add Pokemon");
         System.out.println("2. Trade Pokemon");
         System.out.println("3. Print Pokeded");
         System.out.println("0. Exit the program");
         System.out.println("What would you like to do?");
         
         //take off any spaces on the string
         inString = userIn.nextLine().trim();
         System.out.println(b);       
         switch(inString) {
            case "0": endLoop = true; //ends loop and ends program
               System.out.println("Good bye!");
               break;
            case "1": //adds Pokemon catched
               System.out.println("Catch a Pokemon"); 
               p = ChoosePokemon.choosePokemon();
               tree.add(p);
               Count++;
               break;
            case "2": //remove Pokemon Traded
               p = ChoosePokemon.choosePokemon();
               tree.remove(p);
               Count--;
               break;
            case "3": //prints Pokedex
                  System.out.println("Pokemon caught: " + Count + "\n");
                  tree.printPokeTree();
                  System.out.println("\n" + b);
               break;
            default: //not a valid menu entry
               System.out.println("\n****Invalid menu choice.****");
               System.out.println("Please enter a 0, 1, 2 or 3\n");
               break;
         }  //end Switch menu statement   
      }  //end While endLoop


}  //end main

}