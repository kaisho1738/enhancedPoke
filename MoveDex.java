/**
 * This class, MoveDex is responsible for managing and running the move Module
 * It has the methods to add moves, view moves, and search moves
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MoveDex {
    /** stores the list of created move objects */
    private ArrayList<Move> moves = new ArrayList<>();

    /**
     * Represents all possible classifications a move can take in.
     */
    public enum MoveClass {HM, TM}
    public static Scanner scanner = new Scanner(System.in);

    /** Prints a welcome statement for the move module. */
    public void printTitle() {
        System.out.println("\n" +
                "███╗   ███╗ ██████╗ ██╗   ██╗███████╗███████╗    ███╗   ███╗ ██████╗ ██████╗ ██╗   ██╗██╗     ███████╗\n" +
                "████╗ ████║██╔═══██╗██║   ██║██╔════╝██╔════╝    ████╗ ████║██╔═══██╗██╔══██╗██║   ██║██║     ██╔════╝\n" +
                "██╔████╔██║██║   ██║██║   ██║█████╗  ███████╗    ██╔████╔██║██║   ██║██║  ██║██║   ██║██║     █████╗  \n" +
                "██║╚██╔╝██║██║   ██║╚██╗ ██╔╝██╔══╝  ╚════██║    ██║╚██╔╝██║██║   ██║██║  ██║██║   ██║██║     ██╔══╝  \n" +
                "██║ ╚═╝ ██║╚██████╔╝ ╚████╔╝ ███████╗███████║    ██║ ╚═╝ ██║╚██████╔╝██████╔╝╚██████╔╝███████╗███████╗\n" +
                "╚═╝     ╚═╝ ╚═════╝   ╚═══╝  ╚══════╝╚══════╝    ╚═╝     ╚═╝ ╚═════╝ ╚═════╝  ╚═════╝ ╚══════╝╚══════╝\n" +
                "                                                                                                      \n");
        Pokedex.pause();
    }

    /** This method prints out the menu and is the main access/controller of the methods.
     * This is the method that interacts with the user and calls out the appropriate methods accordingly.
     * */
    public void menu() {
        int option = -1;
        do {
            System.out.println("Welcome to the Move Module!");
            System.out.println("0. Exit");
            System.out.println("1. Add Move");
            System.out.println("2. View Moves");
            System.out.println("3. Search Move");
            System.out.print("What would you like to do?: ");
            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    addMove();
                    break;
                case 2:
                    viewMoves();
                    break;
                case 3:
                    searchMove();
                    break;
                default:
                    System.out.println("Error: Invalid Input");
            }

        } while (option != 0);

    }

    /** This method adds a move to the arraylist if all inputs are valid */
    public void addMove(){
        scanner.nextLine();
        System.out.print("Move Name: ");
        String name = scanner.nextLine();

        if(!checkName(name)){
            System.out.println("Move name already taken!");
            return;
        }

        System.out.print("Move Description: ");
        String descrip = scanner.nextLine();

        printClassification();
        MoveClass classification;

        /* For the following try-catch codes:
         * Reads a string input from the user, then converting it into a enum data type and is then assigned.
         * If the inputs a value that is not within the defined values of type(e,g., "FIRE") or MoveClass (e.g., "HM", "TM")
         * the line : classification = MoveClass.valueOf(classif) will throw an error, called
         * IllegalArgumentException stopping the program entirely.
         * The catch block catches this exception, and informs the user that the input is invalid.
         * Instead of the program crashing, this ends the method early.
         *
         * This is also used for the error handling of the move types
         * */

        try {
            System.out.print("Classification: ");
            String classif = scanner.next().toUpperCase();
            scanner.nextLine();
            classification = MoveClass.valueOf(classif);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Classification!");
            return;
        }

        Pokedex.printPokemonTypes(); //uses the method in class Pokedex to display the types
        Pokedex.Type pokeType1 = Pokedex.Type.NORMAL; //default

        try {
            System.out.print("Type 1: ");
            String type1 = scanner.next().toUpperCase();
             pokeType1 = Pokedex.Type.valueOf(type1);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Move Type!");
            return;
        }

        Pokedex.printPokemonTypes();
        Pokedex.Type pokeType2 = Pokedex.Type.NONE; //default

        try {
            System.out.print("Type 2: ");
            String type2 = scanner.next().toUpperCase();
             pokeType2 = Pokedex.Type.valueOf(type2);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Move Type!");
            return;
        }

        Move move;
        move = new Move(name, descrip, classification, pokeType1, pokeType2);
        moves.add(move); //if all is valid, it will add the move to the arraylist

        System.out.println("Move: " + name + " added!");

    }

    /** This method prints out all the existing moves in the arraylist */
    public void viewMoves(){
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        System.out.println("| Name             | Description                                                                           | Classification | Type One   | Type Two   |");
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        for(Move toPrint: moves){
            System.out.printf("| %-16s | %-85s | %-14s | %-10s | %-10s |\n",  toPrint.getName(), toPrint.getDescription(), toPrint.getClassification(),
            toPrint.getMoveType1(), toPrint.getMoveType2());
            System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        }
    }

    /** This method prints out all the specified move in the parameter
     * @param move      this is the specific move instance that will be displayed */
    public void viewMove(Move move){
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        System.out.println("| Name             | Description                                                                           | Classification | Type One   | Type Two   |");
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
            System.out.printf("| %-16s | %-85s | %-14s | %-10s | %-10s |\n", move.getName(),move.getDescription(), move.getClassification(),
                    move.getMoveType1(), move.getMoveType2());
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
    }

    /** This method is used to instantly create pre-defined moves providing a convenient way to test the functionalities of move module
     * without manually adding several moves. */
    public void initializeMoves(){
        Move move1 = new Move("Surf", "A huge wave that strikes all Pokémon in battle",
                MoveDex.MoveClass.HM, Pokedex.Type.WATER, Pokedex.Type.NONE);

        Move move2 =new Move("Fly", "Flies up high on the first turn, then strikes the next turn",
                MoveDex.MoveClass.HM, Pokedex.Type.FLYING, Pokedex.Type.NONE);

        Move move3 = new Move("Cut", "Cuts the opponent with sharp scythes, claws, etc.",
                MoveDex.MoveClass.HM, Pokedex.Type.NORMAL, Pokedex.Type.NONE);

        Move move4 = new Move("Flamethrower", "A powerful fire attack that may burn the opponent",
                MoveDex.MoveClass.TM, Pokedex.Type.FIRE, Pokedex.Type.NONE);

        Move move5 = new Move("Thunderbolt", "A strong electric attack that may paralyze the opponent",
                MoveDex.MoveClass.TM, Pokedex.Type.ELECTRIC, Pokedex.Type.NONE);

        Move move6 = new Move("Ice Beam", "A freezing attack that may freeze the opponent solid",
                MoveDex.MoveClass.TM, Pokedex.Type.ICE, Pokedex.Type.NONE);

        Move move7 = new Move("Earthquake", "A powerful ground attack that hits all nearby Pokémon",
                MoveDex.MoveClass.TM, Pokedex.Type.GROUND, Pokedex.Type.NONE);

        Move move8 = new Move("Psychic", "A telekinetic attack that may lower the opponent's Special Defense",
                MoveDex.MoveClass.TM, Pokedex.Type.PSYCHIC, Pokedex.Type.NONE);

        Move move9 = new Move("Shadow Ball", "A ghostly attack that may lower the opponent's Special Defense",
                MoveDex.MoveClass.TM, Pokedex.Type.GHOST, Pokedex.Type.NONE);

        moves.add(move1);
        moves.add(move2);
        moves.add(move3);
        moves.add(move4);
        moves.add(move5);
        moves.add(move6);
        moves.add(move7);
        moves.add(move8);
        moves.add(move9);

    }


    /** This method searches a move through the move name */
    public void searchMove(){
        scanner.nextLine();
        System.out.print("Enter Move to Search: ");
        String move = scanner.nextLine();

        for(Move toFind: moves){
            if(toFind.getName().equalsIgnoreCase(move)){
                System.out.println("Move Found!");
                viewMove(toFind);
                return;
            };
        }
        System.out.println("Move not Found!");
        return;
    }

    /**
     * This method is used in addMove() to check if the name entered by the user is taken or not
     * @param name      name entered by the user and will be compared to all other existing moves
     *  @return true if the name is available and valid; false otherwise
     * */
    public boolean checkName(String name){
        for(Move toCheck: moves){
            if(toCheck.getName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }

    /** This method is used to print the available classifications for the move */
    public void printClassification(){
        System.out.println("+-------------------------+");
        System.out.println("|Available Classifications|");
        System.out.println("+-------------------------+");
        System.out.println("|    HM      |     TM     |");
        System.out.println("+-------------------------+");
    }


}
