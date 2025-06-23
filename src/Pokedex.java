import java.util.Scanner;
public class Pokedex {
    public static enum Type{
        NORMAL, FIRE, WATER, ELECTRIC, GRASS, ICE, FIGHTING, POISON, GROUND, FLYING, PSYCHIC,
        BUG, ROCK, GHOST, DRAGON, DARK, STEEL, FAIRY
    }
    public static enum MoveClass{ HM, TM }
    public static Pokemon[] pokemon = new Pokemon[100];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int option = -1;
        printTitle();
        menu();
    }

    public static void printTitle(){
        System.out.println("\n" +
                "██████╗  ██████╗ ██╗  ██╗███████╗██████╗ ███████╗██╗  ██╗    ███████╗██╗███╗   ███╗██╗   ██╗██╗      █████╗ ████████╗ ██████╗ ██████╗ \n" +
                "██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝██╔══██╗██╔════╝╚██╗██╔╝    ██╔════╝██║████╗ ████║██║   ██║██║     ██╔══██╗╚══██╔══╝██╔═══██╗██╔══██╗\n" +
                "██████╔╝██║   ██║█████╔╝ █████╗  ██║  ██║█████╗   ╚███╔╝     ███████╗██║██╔████╔██║██║   ██║██║     ███████║   ██║   ██║   ██║██████╔╝\n" +
                "██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██║  ██║██╔══╝   ██╔██╗     ╚════██║██║██║╚██╔╝██║██║   ██║██║     ██╔══██║   ██║   ██║   ██║██╔══██╗\n" +
                "██║     ╚██████╔╝██║  ██╗███████╗██████╔╝███████╗██╔╝ ██╗    ███████║██║██║ ╚═╝ ██║╚██████╔╝███████╗██║  ██║   ██║   ╚██████╔╝██║  ██║\n" +
                "╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═════╝ ╚══════╝╚═╝  ╚═╝    ╚══════╝╚═╝╚═╝     ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝\n" +
                "                                                                                                                                      \n");
        pause();
        clearScreen();
    }

    public static void menu(){
        int option = -1;
        do{
            System.out.println("Welcome to the Pokedex!");
            System.out.println("0. Exit");
            System.out.println("1.Pokedex Module");
            System.out.println("2.Moves Module");
            System.out.println("3.Items Module");
            System.out.print("Which module would you like to access? ");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    System.out.println("0. Exit");
                    System.out.println("1.Add Pokemon");
                    System.out.println("2.View all Pokemons");
                    System.out.println("3.Search Pokemon");
                    System.out.print("What do you want to do? ");
                    option = scanner.nextInt();
                    pokedexModule(option);
                    break;
            }
        } while(option != 0);

    }

    public static void pokedexModule(int option){
        switch(option){
            case 1: //addpokemon
            case 2: //viewpokemon
            case 3: //searchpokemon
        }
    }


    public static void addPokemon(){
        System.out.print("Enter Pokedex Number: ");
        int dexNum = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Type 1: ");
        String type1 = scanner.next().toUpperCase();
        scanner.nextLine();
        Type pokeType1 = Type.valueOf(type1);


        System.out.print("Enter Type 2: ");
        String type2 = scanner.nextLine();
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

        if(Character.toUpperCase(option) == 'Y'){
            System.out.println("Enter Pokemon Cry: ");
            String cry = scanner.nextLine();
            Pokemon pokemon = new Pokemon(dexNum, name, pokeType1, pokeType2, baseLevel, evolvesFrom
                    ,evolvesTo,evoLevel,hp,atk,def,spd,cry);
        } else if (Character.toUpperCase(option) == 'N'){
            System.out.println("No Cry was Selected");
            Pokemon pokemon = new Pokemon(dexNum, name, pokeType1, pokeType2, baseLevel, evolvesFrom
                    ,evolvesTo,evoLevel,hp,atk,def,spd);
        } else{
            System.out.println("Error: Invalid Input!");
        }

        System.out.println();
    }

    public static void clearScreen() {
        System.out.print("\033[2J\033[H");
        System.out.flush();
    }

    public static void pause() {
        System.out.print("Press ENTER to continue . . .");
        scanner.nextLine();
    }
}
