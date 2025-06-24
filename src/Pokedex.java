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
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", Pokedex.Type.GRASS, Pokedex.Type.POISON, 1, 0, 2, 16, 45, 49, 49, 45);
        Pokemon pokemon2 = new Pokemon(2, "Ivysaur", Pokedex.Type.GRASS, Pokedex.Type.POISON, 16, 1, 3, 32, 60, 62, 63, 60);
        Pokemon pokemon3 = new Pokemon(3, "Venusaur", Pokedex.Type.GRASS, Pokedex.Type.POISON, 32, 2, 0, 0, 80, 82, 83, 80);
        Pokemon pokemon4 = new Pokemon(4, "Charmander", Pokedex.Type.FIRE, Pokedex.Type.NORMAL, 1, 0, 5, 16, 39, 52, 43, 65);
        Pokemon pokemon5 = new Pokemon(5, "Charmeleon", Pokedex.Type.FIRE, Pokedex.Type.NORMAL, 16, 4, 6, 36, 58, 64, 58, 80);
        Pokemon pokemon6 = new Pokemon(6, "Charizard", Pokedex.Type.FIRE, Pokedex.Type.FLYING, 36, 5, 0, 0, 78, 84, 78, 100);
        Pokemon pokemon7 = new Pokemon(7, "Squirtle", Pokedex.Type.WATER, Pokedex.Type.NORMAL, 1, 0, 8, 16, 44, 48, 65, 43);
        Pokemon pokemon8 = new Pokemon(8, "Wartortle", Pokedex.Type.WATER, Pokedex.Type.NORMAL, 16, 7, 9, 36, 59, 63, 80, 58);
        Pokemon pokemon9 = new Pokemon(9, "Blastoise", Pokedex.Type.WATER, Pokedex.Type.NORMAL, 36, 8, 0, 0, 79, 83, 100, 78);
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

    public void menu() {
        int option = -1;
        do {
            System.out.println("Welcome to the Pokedex Module!");
            System.out.println("0. Exit");
            System.out.println("1. Add Pokemon");
            System.out.println("2. View Pokemons");
            System.out.println("3. Search Pokemons");
            System.out.print("What would you like to do?: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addPokemon();
                    break;
                case 2:
                    viewPokemons(pokemons);
                    break;

            }
        } while (option != 0);

    }


    public void addPokemon() {
        System.out.print("Enter Pokedex Number: ");
        int dexNum = scanner.nextInt();

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
            System.out.println("Enter Pokemon Cry: ");
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

    public void pause() {
        System.out.print("Press ENTER to continue . . .");
        scanner.nextLine();
    }

    public void printPokemonTypes() {
        System.out.println("***********************************************************************");
        System.out.println("*                            TYPE SELECTION                           *");
        System.out.println("* 0: None       \033[1;32m1: Bug\033[0m        \033[1;30m2: Dark\033[0m      \033[38;2;153;51;255m3: Dragon\033[0m     \033[1;33m4: Electric\033[0m  *");
        System.out.println("* \033[38;2;255;105;180m5: Fairy\033[0m      \033[38;2;220;20;60m6: Fighting\033[0m   \033[1;31m7: Fire\033[0m      \033[1;34m8: Flying\033[0m     \033[1;37m9: Ghost\033[0m     *");
        System.out.println("* \033[92m10: Grass\033[0m    \033[38;2;139;69;19m11: Ground\033[0m    \033[1;96m12: Ice\033[0m      \033[1;90m13: Normal\033[0m    \033[1;95m14: Poison\033[0m    *");
        System.out.println("* \033[38;2;163;73;164m15: Psychic\033[0m  \033[38;5;94m16: Rock\033[0m      \033[38;2;176;196;222m17: Steel\033[0m    \033[1;94m18: Water\033[0m    >19: Unknown   *");
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
}