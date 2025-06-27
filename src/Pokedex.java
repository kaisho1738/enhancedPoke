/**
 * This class, Pokedex is responsible for managing and running the pokedex Module
 * It has the methods to add pokemons, view all pokemons, and search for a specific pokemon
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Pokedex {

    /**
     * Represents all possible types a pokemon can take in. By default, if the user does not choose to hand out a type 2
     * for the pokemon, they are assigned to "NONE"
     * Any other inputs that are not found within this enum Type will be marked invalid.
     */
    public enum Type {
        NONE, BUG, DARK, DRAGON, ELECTRIC, FAIRY, FIGHTING, FIRE, FLYING, GHOST, GRASS,
        GROUND, ICE, NORMAL, POISON, PSYCHIC, ROCK, STEEL, WATER, UNKNOWN
    }

    /** Stores the list of all created Pokemon objects. */
    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    public static Scanner scanner = new Scanner(System.in);

    /** This method is used to instantly create pre-defined pokemons providing a convenient way to test the functionalities of Pokedex
     * without manually adding several pokemons. */
    public void initializePokemons() {
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", Type.GRASS, Type.POISON, 1, 0, 2, 16, 45, 49, 49, 45, "RARARAHRAHRAH");
        Pokemon pokemon2 = new Pokemon(2, "Ivysaur", Type.GRASS, Type.POISON, 16, 1, 3, 32, 60, 62, 63, 60);
        Pokemon pokemon3 = new Pokemon(3, "Venusaur", Type.GRASS, Type.POISON, 32, 2, 0, 0, 80, 82, 83, 80);
        Pokemon pokemon4 = new Pokemon(4, "Charmander", Type.FIRE, Type.NORMAL, 1, 0, 5, 16, 39, 52, 43, 65);
        Pokemon pokemon5 = new Pokemon(5, "Charmeleon", Type.FIRE, Type.NORMAL, 16, 4, 6, 36, 58, 64, 58, 80);
        Pokemon pokemon6 = new Pokemon(6, "Charizard", Type.FIRE, Type.FLYING, 36, 5, 0, 0, 78, 84, 78, 100, "HUHUUHUHU");
        Pokemon pokemon7 = new Pokemon(7, "Squirtle", Type.WATER, Type.NORMAL, 1, 0, 8, 16, 44, 48, 65, 43);
        Pokemon pokemon8 = new Pokemon(8, "Wartortle", Type.WATER, Type.NORMAL, 16, 7, 9, 36, 59, 63, 80, 58);
        Pokemon pokemon9 = new Pokemon(9, "Blastoise", Type.WATER, Type.NORMAL, 36, 8, 0, 0, 79, 83, 100, 78);
        pokemons.add(pokemon1);
        pokemons.add(pokemon2);
        pokemons.add(pokemon3);
        pokemons.add(pokemon4);
        pokemons.add(pokemon5);
        pokemons.add(pokemon6);
        pokemons.add(pokemon7);
        pokemons.add(pokemon8);
        pokemons.add(pokemon9);

    }

    /** Prints a welcome statement for the Pokedex module. */
    public void printTitle() {
        System.out.println("\n" +
                "██████╗  ██████╗ ██╗  ██╗███████╗██████╗ ███████╗██╗  ██╗    ███╗   ███╗ ██████╗ ██████╗ ██╗   ██╗██╗     ███████╗\n" +
                "██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝██╔══██╗██╔════╝╚██╗██╔╝    ████╗ ████║██╔═══██╗██╔══██╗██║   ██║██║     ██╔════╝\n" +
                "██████╔╝██║   ██║█████╔╝ █████╗  ██║  ██║█████╗   ╚███╔╝     ██╔████╔██║██║   ██║██║  ██║██║   ██║██║     █████╗  \n" +
                "██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██║  ██║██╔══╝   ██╔██╗     ██║╚██╔╝██║██║   ██║██║  ██║██║   ██║██║     ██╔══╝  \n" +
                "██║     ╚██████╔╝██║  ██╗███████╗██████╔╝███████╗██╔╝ ██╗    ██║ ╚═╝ ██║╚██████╔╝██████╔╝╚██████╔╝███████╗███████╗\n" +
                "╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═════╝ ╚══════╝╚═╝  ╚═╝    ╚═╝     ╚═╝ ╚═════╝ ╚═════╝  ╚═════╝ ╚══════╝╚══════╝\n" +
                "                                                                                                                  \n");
        pause();
    }

    /** This method allows provides a brief pause before proceeding. Pressing enter in the user's keyboard will end this method. */
    public static void pause() {
        System.out.print("Press ENTER to continue . . .");
        scanner.nextLine();
    }

    /** This method prints out the menu and is the main access/controller of the methods.
     * This is the method that interacts with the user and calls out the appropriate methods accordingly.
     * */
    public void menu() {
        int option = -1;
        do {
            System.out.println("Welcome to the Pokedex Module!");
            System.out.println("0. Exit");
            System.out.println("1. Add Pokemon");
            System.out.println("2. View Pokemons");
            System.out.println("3. Search Pokemons");
            System.out.println("4. View Pokemon Cry");
            System.out.print("What would you like to do?: ");
            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    addPokemon();
                    break;
                case 2:
                    viewPokemons();
                    break;
                case 3:
                    searchPokemon();
                    break;
                case 4:
                    makePokemonCry();
                    break;
                default:
                    System.out.println("Error: Invalid Input");
            }

        } while (option != 0);

    }

    /**
     * Creates a new Pokémon based on user input and adds it to the Pokémon ArrayList
     * if all input values are valid.
     */

    public void addPokemon() {
        System.out.print("Enter Pokedex Number: ");
        int dexNum = scanner.nextInt();

        if(!pokeDexChecker(dexNum)){
            return;
        }

        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        Type pokeType1 = Type.NORMAL; //default
        printPokemonTypes();

        /* For the following try-catch codes:
         * Reads a string input from the user, then converting it into a enum data type and is then assigned.
         * If the inputs a value that is not within the defined values of type(e,g., "FIRE")
         * the line : pokeType1 = Type.valueof(type1) will throw an error, called
         * IllegalArgumentException stopping the program entirely
         * The catch block catches this exception, and informs the user that the input is invalid.
         * Instead of the program crashing, this ends the method early.
         * */

        try {
            System.out.print("Enter Type 1: ");
            String type1 = scanner.next().toUpperCase();
            scanner.nextLine();
            pokeType1 = Type.valueOf(type1);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Pokemon Type!");
            return;
        }

        Type pokeType2 = Type.NONE; //default
        printPokemonTypes();
        try {
            System.out.print("Enter Type 2: ");
            String type2 = scanner.next().toUpperCase();
            pokeType2 = Type.valueOf(type2);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Pokemon Type!");
            return;
        }

        System.out.print("Enter Base Level: ");
        int baseLevel = scanner.nextInt();

        System.out.print("Enter Evolves From: ");
        int evolvesFrom = scanner.nextInt();

        System.out.print("Enter Evolves To: ");
        int evolvesTo = scanner.nextInt();

        System.out.print("Enter Evolution Level: ");
        int evoLevel = scanner.nextInt();

        System.out.print("Enter Health Points: ");
        int hp = scanner.nextInt();

        System.out.print("Enter Attack: ");
        int atk = scanner.nextInt();

        System.out.print("Enter Defense: ");
        int def = scanner.nextInt();

        System.out.print("Enter Speed: ");
        int spd = scanner.nextInt();

        System.out.print("Would you like to create a cry for your pokemon? (Y/N): ");
        char option = scanner.next().charAt(0);
        scanner.nextLine();

        Pokemon pokemon;

        if (Character.toUpperCase(option) == 'Y') {
            System.out.print("Enter Pokemon Cry: ");
            String cry = scanner.nextLine();
            pokemon = new Pokemon(dexNum, name, pokeType1, pokeType2, baseLevel, evolvesFrom
                    , evolvesTo, evoLevel, hp, atk, def, spd, cry);
        } else if (Character.toUpperCase(option) == 'N') {
            System.out.println("No Cry was Selected");
            pokemon = new Pokemon(dexNum, name, pokeType1, pokeType2, baseLevel, evolvesFrom
                    , evolvesTo, evoLevel, hp, atk, def, spd);
        } else {
            System.out.println("Error: Invalid Input!");
            return;
        }

        pokemons.add(pokemon);  //adds pokemon to the arrayList of pokemons
        System.out.println("Pokemon: " + name + " added!");
    }

    /** This method prints out all the pokemon types with colors */
    public static void printPokemonTypes() {
        System.out.println("***********************************************************************");
        System.out.println("*                            TYPE SELECTION                           *");
        System.out.println("*    None       \033[1;32m   Bug\033[0m        \033[1;30m   Dark\033[0m      \033[38;2;153;51;255m   Dragon\033[0m     \033[1;33m   Electric\033[0m  *");
        System.out.println("* \033[38;2;255;105;180m   Fairy\033[0m      \033[38;2;220;20;60m   Fighting\033[0m   \033[1;31m   Fire\033[0m      \033[1;34m   Flying\033[0m     \033[1;37m   Ghost\033[0m     *");
        System.out.println("* \033[92m   Grass\033[0m    \033[38;2;139;69;19m     Ground\033[0m    \033[1;96m    Ice\033[0m      \033[1;90m    Normal\033[0m    \033[1;95m    Poison\033[0m    *");
        System.out.println("* \033[38;2;163;73;164m   Psychic\033[0m  \033[38;5;94m     Rock\033[0m      \033[38;2;176;196;222m    Steel\033[0m    \033[1;94m    Water\033[0m         Unknown   *");
        System.out.println("***********************************************************************");
    }

    /** This method prints out all the pokemons in arrayList in a tabular form */
    public void viewPokemons(){
        System.out.println("+--------+--------------------+------------+------------+------------+------------+-----+-----+-----+-----+-----------------+---------------+");
        System.out.println("| No.    | Name               | Type One   | Type Two   |Base Lvl    |Evo Lvl     | \033[32mHP\033[0m  | \033[31mAtk\033[0m | \033[34mDfs\033[0m | \033[33mSpd\033[0m | Evolves From    | Evolves To    |");
        System.out.println("+--------+--------------------+------------+------------+------------+------------+-----+-----+-----+-----+-----------------+---------------+");

        for(Pokemon pokemon: pokemons){
            String evoTo = "n/a", evoFrom = "n/a";
            int evoToFind = pokemon.getEvolvesTo();
            int evoFromFind = pokemon.getEvolvesFrom();

            for(Pokemon findPokemon: pokemons){
                if(evoToFind == findPokemon.getDexNum()){
                    evoTo = findPokemon.getPokeName();
                }

                if(evoFromFind == findPokemon.getDexNum()){
                    evoFrom = findPokemon.getPokeName();
                }
            }

            System.out.printf("| %-6d | %-17s  | %-8s   | %-8s   | %-3d        | %-3d        | %-3d | %-3d | %-3d | %-3d | %-15s | %-13s |\n", pokemon.getDexNum(), pokemon.getPokeName(), pokemon.getType1(), pokemon.getType2(),
                    pokemon.getBaseLevel(), pokemon.getEvoLevel(), pokemon.getHp(),pokemon.getAtk(), pokemon.getDef(), pokemon.getSpd(), evoFrom, evoTo);
            System.out.println("+--------+--------------------+------------+------------+------------+------------+-----+-----+-----+-----+-----------------+---------------+");

        }
    }

    /** This method prints out all the pokemon specified in the parameter in a tabular form
     * @param pokemon       this represents the specific pokemon instance that will be viewed
     * */
    public void viewPokemon(Pokemon pokemon){
        System.out.println("+--------+--------------------+------------+------------+------------+------------+-----+-----+-----+-----+-----------------+---------------+");
        System.out.println("| No.    | Name               | Type One   | Type Two   |Base Lvl    |Evo Lvl     | \033[32mHP\033[0m  | \033[31mAtk\033[0m | \033[34mDfs\033[0m | \033[33mSpd\033[0m | Evolves From    | Evolves To    |");
        System.out.println("+--------+--------------------+------------+------------+------------+------------+-----+-----+-----+-----+-----------------+---------------+");
        String evoTo = "n/a", evoFrom = "n/a";

        int evoToFind = pokemon.getEvolvesTo();
        int evoFromFind = pokemon.getEvolvesFrom();
        for(Pokemon findPokemon: pokemons){
            if(evoToFind == findPokemon.getDexNum()){
                evoTo = findPokemon.getPokeName();
            }

            if(evoFromFind == findPokemon.getDexNum()){
                evoFrom = findPokemon.getPokeName();
            }
        }

        System.out.printf("| %-6d | %-17s  | %-8s   | %-8s   | %-3d        | %-3d        | %-3d | %-3d | %-3d | %-3d | %-15s | %-13s |\n", pokemon.getDexNum(), pokemon.getPokeName(), pokemon.getType1(), pokemon.getType2(),
                pokemon.getBaseLevel(), pokemon.getEvoLevel(), pokemon.getHp(),pokemon.getAtk(), pokemon.getDef(), pokemon.getSpd(), evoFrom, evoTo);
        System.out.println("+--------+--------------------+------------+------------+------------+------------+-----+-----+-----+-----+-----------------+---------------+");

    }

    /** This method is responsible for searching a pokemon through the index number or pokemon name */
    public void searchPokemon(){
                scanner.nextLine();
                Type pokeType = null;
                System.out.print("Enter Keyword to Search: ");
                String input = scanner.nextLine();

                boolean found = false;
                String type = input.toUpperCase();

                //tries to assign the string input to the enum data type
                try {
                    pokeType = Type.valueOf(type);
                } catch (IllegalArgumentException e) {
                }

            for(Pokemon toFind: pokemons){
                boolean nameMatch = toFind.getPokeName() != null &&
                    toFind.getPokeName().toUpperCase().contains(input.toUpperCase());
                boolean cryMatch = toFind.getCry() != null &&
                    toFind.getCry().toUpperCase().contains(input.toUpperCase());
                boolean typeMatch = pokeType == toFind.getType1() || pokeType == toFind.getType2();

                if(nameMatch || cryMatch || typeMatch) {
                viewPokemon(toFind);
                found = true;
                }
            }
                if(!found){
                    System.out.println(input + " Pokemons not Found!");
                }
    }

    /** This method is reponsible for playing the cry of a pokemon */
    public void makePokemonCry(){
        System.out.print("Enter Pokemon Index Number: ");
        int dexNum = scanner.nextInt();

        for(Pokemon toFind: pokemons){
            if(dexNum == toFind.getDexNum()){
                if(toFind.getCry() != null){
                    System.out.println(toFind.getPokeName()+ ": " + toFind.getCry());
                    return;
                } else{
                    System.out.println("Pokemon does not have a cry");
                    return;
                }
            }
        }
        System.out.println("Pokemon not Found");
    }

    /** This method is used in the addPokemon() method to check if the pokemon index number entered is taken already
     * and also checks if the pokedex number is not negative
     * @param indexNum      the index number of the pokemon to be checked
     * @return true if the index number is available and valid; false otherwise
     * */
    public boolean pokeDexChecker(int indexNum){
        if(indexNum < 0){
            System.out.println("Pokedex Number Cannot be Less than 0");
            return false;
        }

        for(Pokemon checkDex: pokemons){
            if(indexNum == checkDex.getDexNum()){
                System.out.println("Error: Pokedex Number Already Taken!");
                return false;
            }
        }
        return true;
    }

}