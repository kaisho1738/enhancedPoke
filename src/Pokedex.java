import java.util.ArrayList;
import java.util.Scanner;

public class Pokedex {
    public enum Type {
        NONE, BUG, DARK, DRAGON, ELECTRIC, FAIRY, FIGHTING, FIRE, FLYING, GHOST, GRASS,
        GROUND, ICE, NORMAL, POISON, PSYCHIC, ROCK, STEEL, WATER, UNKNOWN
    }

    public enum MoveClass {HM, TM}

    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
    public Scanner scanner = new Scanner(System.in);


    public void initializePokemons() {
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", Pokedex.Type.GRASS, Pokedex.Type.POISON, 1, 0, 2, 16, 45, 49, 49, 45, "RARARAHRAHRAH");
        Pokemon pokemon2 = new Pokemon(2, "Ivysaur", Pokedex.Type.GRASS, Pokedex.Type.POISON, 16, 1, 3, 32, 60, 62, 63, 60);
        Pokemon pokemon3 = new Pokemon(3, "Venusaur", Pokedex.Type.GRASS, Pokedex.Type.POISON, 32, 2, 0, 0, 80, 82, 83, 80);
        Pokemon pokemon4 = new Pokemon(4, "Charmander", Pokedex.Type.FIRE, Pokedex.Type.NORMAL, 1, 0, 5, 16, 39, 52, 43, 65);
        Pokemon pokemon5 = new Pokemon(5, "Charmeleon", Pokedex.Type.FIRE, Pokedex.Type.NORMAL, 16, 4, 6, 36, 58, 64, 58, 80);
        Pokemon pokemon6 = new Pokemon(6, "Charizard", Pokedex.Type.FIRE, Pokedex.Type.FLYING, 36, 5, 0, 0, 78, 84, 78, 100, "HUHUUHUHU");
        Pokemon pokemon7 = new Pokemon(7, "Squirtle", Pokedex.Type.WATER, Pokedex.Type.NORMAL, 1, 0, 8, 16, 44, 48, 65, 43);
        Pokemon pokemon8 = new Pokemon(8, "Wartortle", Pokedex.Type.WATER, Pokedex.Type.NORMAL, 16, 7, 9, 36, 59, 63, 80, 58);
        Pokemon pokemon9 = new Pokemon(9, "Blastoise", Pokedex.Type.WATER, Pokedex.Type.NORMAL, 36, 8, 0, 0, 79, 83, 100, 78);
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

    public void pause() {
        System.out.print("Press ENTER to continue . . .");
        scanner.nextLine();
    }

    public static void clearScreen() {
        System.out.print("\033[2J\033[H");
        System.out.flush();
    }

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
                    viewPokemons(pokemons);
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


    public void addPokemon() {
        System.out.print("Enter Pokedex Number: ");
        int dexNum = scanner.nextInt();

        if(!pokeDexChecker(dexNum)){
            return;
        }

        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        printPokemonTypes();
        System.out.print("Enter Type 1: ");
        String type1 = scanner.next().toUpperCase();
        scanner.nextLine();
        Type pokeType1 = Type.valueOf(type1);

        printPokemonTypes();
        System.out.print("Enter Type 2: ");
        String type2 = scanner.next().toUpperCase();
        Type pokeType2 = Type.valueOf(type2);

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

        pokemons.add(pokemon);
    }


    public void printPokemonTypes() {
        System.out.println("***********************************************************************");
        System.out.println("*                            TYPE SELECTION                           *");
        System.out.println("*    None       \033[1;32m   Bug\033[0m        \033[1;30m   Dark\033[0m      \033[38;2;153;51;255m   Dragon\033[0m     \033[1;33m   Electric\033[0m  *");
        System.out.println("* \033[38;2;255;105;180m   Fairy\033[0m      \033[38;2;220;20;60m   Fighting\033[0m   \033[1;31m   Fire\033[0m      \033[1;34m   Flying\033[0m     \033[1;37m   Ghost\033[0m     *");
        System.out.println("* \033[92m   Grass\033[0m    \033[38;2;139;69;19m     Ground\033[0m    \033[1;96m    Ice\033[0m      \033[1;90m    Normal\033[0m    \033[1;95m    Poison\033[0m    *");
        System.out.println("* \033[38;2;163;73;164m   Psychic\033[0m  \033[38;5;94m     Rock\033[0m      \033[38;2;176;196;222m    Steel\033[0m    \033[1;94m    Water\033[0m         Unknown   *");
        System.out.println("***********************************************************************");
    }

    public void viewPokemons(ArrayList<Pokemon> pokemons){
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


    public void searchPokemon(){
        System.out.print("How would you like to search? [1] Index Number [2] Pokemon Name: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch(option){
            case 1:
                System.out.print("Enter Index Number: ");
                int dexNum = scanner.nextInt();
                for(Pokemon toFind: pokemons){
                    if(dexNum == toFind.getDexNum()){
                        System.out.println("Pokemon Found");
                        viewPokemon(toFind);
                        return;
                    }
                }
                System.out.println("Pokemon not Found");
                break;
            case 2:
                System.out.print("Enter Pokemon Name: ");
                String pokeName = scanner.nextLine();
                for(Pokemon toFind: pokemons){
                    if(pokeName.equalsIgnoreCase(toFind.getPokeName())) {
                        System.out.println("Pokemon Found");
                        viewPokemon(toFind);
                        return;
                    }
                    }
                System.out.println("Pokemon not Found");
                break;
            default:
                System.out.println("Error: Invalid Input");
        }

    }
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
    public boolean pokeDexChecker(int indexNum){
        for(Pokemon checkDex: pokemons){
            if(indexNum == checkDex.getDexNum()){
                System.out.println("Error: Pokedex Number Already Taken!");
                return false;
            }
        }
        return true;
    }

}