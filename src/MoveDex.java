import java.util.ArrayList;
import java.util.Scanner;

public class MoveDex {
    private ArrayList<Move> moves = new ArrayList<>();
    public enum MoveClass {HM, TM}
    public static Scanner scanner = new Scanner(System.in);

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

        System.out.print("Classification: ");
        String classif = scanner.next().toUpperCase();
        scanner.nextLine();
        MoveClass classification = MoveClass.valueOf(classif);

        Pokedex.printPokemonTypes();
        System.out.print("Type 1: ");
        String type1 = scanner.next().toUpperCase();
        Pokedex.Type pokeType1 = Pokedex.Type.valueOf(type1);

        Move move;

        System.out.print("Type 2: ");
        String type2 = scanner.next().toUpperCase();
        Pokedex.Type pokeType2 = Pokedex.Type.valueOf(type2);
        move = new Move(name, descrip, classification, pokeType1, pokeType2);
        moves.add(move);

        System.out.println("Move: " + name + " added!");

    }

    public void viewMoves(){
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        System.out.println("| Name             | Description                                                                           | Classification | Type One   | Type Two   |");
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        int count = 0;
        for(Move toPrint: moves){
            count++;
            System.out.printf("| %-16s | %-85s | %-14s | %-10s | %-10s |\n",  toPrint.getName(), toPrint.getDescription(), toPrint.getClassification(),
            toPrint.getMoveType1(), toPrint.getMoveType2());
            System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        }
    }

    public void viewMove(Move move){
        int i = 0;
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        System.out.println("| Name             | Description                                                                           | Classification | Type One   | Type Two   |");
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
            System.out.printf("| %-16s | %-85s | %-14s | %-10s | %-10s |\n", move.getName(),move.getDescription(), move.getClassification(),
                    move.getMoveType1(), move.getMoveType2());
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
    }

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

    public boolean checkName(String name){
        for(Move toCheck: moves){
            if(toCheck.getName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }




}
