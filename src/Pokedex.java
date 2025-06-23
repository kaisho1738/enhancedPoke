import java.util.Scanner;
public class Pokedex {
    public static enum Type{
        NONE, NORMAL, FIRE, WATER, ELECTRIC, GRASS, ICE, FIGHTING, POISON, GROUND, FLYING, PSYCHIC,
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
        System.out.println("Enter Pokedex Number: ");
        int dexNum = scanner.nextInt();

        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Type 1: ");
        String type1 = scanner.next().toUpperCase();
        Type pokeType1 = Type.valueOf(type1);

        System.out.println("Enter Type 2: ");
        String type2 = scanner.nextLine();
        Type pokeType2 = Type.valueOf(type2);


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

    public static void printPokeTypes(){

    }
}
