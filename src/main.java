/** This class is responsible for allowing the user to access all modules*/

import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Pokedex pokedex = new Pokedex();
        MoveDex moveDex = new MoveDex();
        Scanner scanner = new Scanner(System.in);

        pokedex.initializePokemons();
        moveDex.initializeMoves();

        int option = -1;
        do {
            System.out.println("Welcome to the Enhanced Pokedex!");
            System.out.println("0. Exit");
            System.out.println("1. Pokedex Module");
            System.out.println("2. Move Module");
            System.out.println("3. Item Module");
            System.out.print("What would you like to do?: ");
            option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    pokedex.printTitle();
                    pokedex.menu();
                    break;
                case 2:
                    moveDex.printTitle();
                    moveDex.menu();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Error: Invalid Input");
            }

        } while (option != 0);

    }
}
