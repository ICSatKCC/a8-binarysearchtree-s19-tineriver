import java.util.*;

/**
* Abstract class for CONSTRUCTING POKEMON.
* @author Kristine Rivera
* @since 3/07/19
*/
public abstract class ChoosePokemon {

   /**SCANNER.*/
   private static Scanner userIn = new Scanner(System.in);
   /**USER INPUT IN STRINGS.*/
   private static String inString = new String("");  
   /**ABS OBJECT.*/
   private static Pokemon p;
   /**BORDER.*/
   private static String b = "------------------------------------------------";
   
   /** makePokemon Method.
   *@return    Pokemon object
   */
   public static Pokemon choosePokemon() {
      String species = "";
      String newName = "";
      int num = 0;
      //Asks user for Species of Pokemon
      boolean speciesLoop = false;
      boolean nameLoop = false;
      while (!speciesLoop) {
      
         String s = " 1. Bulbasaur \t 2. Ivysaur \t 3. Venasaur";
         s = s + "\n 4. Charmander  5. Charmeleon  6. Charizard";
         s = s + "\n 7. Squirtle \t 8. Wartortle \t 9. Blastoise";
         s = s + "\n10. Eevee \t\t 11. Vaporeon \t 12. Jolteon";
         s = s + "\n13. Flareon \t 0. Back";
      
         System.out.println(s);
         species = userIn.nextLine().trim();
         try {
            num = Integer.parseInt(species);
            if (num > 0 && num < 14) {
               speciesLoop = true; 
            } else if (num == 0) {
               speciesLoop = true;
               nameLoop = true;
            }  
         } catch (NumberFormatException nfe) {
            System.out.println("Invalid: Please enter a number from the list.");
         }
      }  //end while       
      //Asks user for Name of Pokemon
      while (!nameLoop) {
         System.out.println("Does the Pokemon have a name Y/N?");
         inString = userIn.nextLine().trim().toUpperCase();
         switch (inString) {
            case "N": 
               nameLoop = true;
               break;
            case "Y": 
               System.out.println("What is the Pokemon's name?");
               inString = userIn.nextLine().trim();
               if (inString.length() > 0) {
                  newName = inString;
                  nameLoop = true;
               } else {
                  System.out.println("Did you change your mind?"); 
               }
               break;
            default: nameLoop = true;
               break;
         }  //end switch
      }  //end while
      switch (num) {
         case 0: 
            break;
         case 1: 
            if (newName.length() > 0) {
               p = new Bulbasaur(newName);
            } else { 
               p = new Bulbasaur();
            }
            break;
         case 2:
            if (newName.length() > 0) {
               p = new Ivysaur(newName);
            } else { 
               p = new Ivysaur();
            } 
            break;
         case 3: 
            if (newName.length() > 0) {
               p = new Venusaur(newName);
            } else { 
               p = new Venusaur();
            } 
            break;
         case 4:
            if (newName.length() > 0) {
               p = new Charmander(newName);
            } else { 
               p = new Charmander();
            } 
            break;
         case 5: 
            if (newName.length() > 0) {
               p = new Charmeleon(newName);
            } else { 
               p = new Charmeleon();
            } 
            break;
         case 6: 
            if (newName.length() > 0) {
               p = new Charizard(newName);
            } else { 
               p = new Charizard();
            } 
            break;
         case 7: 
            if (newName.length() > 0) {
               p = new Squirtle(newName);
            } else { 
               p = new Squirtle();
            } 
            break;
         case 8: 
            if (newName.length() > 0) {
               p = new Wartortle(newName);
            } else { 
               p = new Wartortle();
            } 
            break;
         case 9: 
            if (newName.length() > 0) {
               p = new Blastoise(newName);
            } else { 
               p = new Blastoise();
            } 
            break;
         case 10: 
            if (newName.length() > 0) {
               p = new Eevee(newName);
            } else { 
               p = new Eevee();
            } 
            break;
         case 11: 
            if (newName.length() > 0) {
               p = new Vaporeon(newName);
            } else { 
               p = new Vaporeon();
            } 
            break;
         case 12: 
            if (newName.length() > 0) {
               p = new Jolteon(newName);
            } else { 
               p = new Jolteon();
            } 
            break; 
         case 13: 
            if (newName.length() > 0) {
               p = new Flareon(newName);
            } else { 
               p = new Flareon();
            } 
            break;
         default:
            break;
      }  //end switch    
      return p;   
   }  //end choosePokemon Method  
}  //end Class