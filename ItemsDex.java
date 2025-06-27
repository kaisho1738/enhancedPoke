import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *
 */

public class ItemsDex {
    public static Scanner scanner = new Scanner(System.in);

    private List<Items> items = new ArrayList<>();

    public enum Category {
        VITAMIN,
        LEVELING_ITEM,
        FEATHER,
        EVOLUTION_STONE

    }
    public void initializeItems() { // fix later
        items.add(new Items("HP Up", "Vitamin", "A nutritious drink for Pokémon.", "+10 HP EVs", 10000, 10000, 5000));
        items.add(new Items("Protein", "Vitamin", "A nutritious drink for Pokémon.", "+10 Attack EVs", 10000, 10000,5000));
        items.add(new Items("Iron", "Vitamin", "A nutritious drink for Pokémon.", "+10 Defense EVs", 10000, 10000, 5000));
        items.add(new Items("Carbos", "Vitamin", "A nutritious drink for Pokémon.", "+10 Speed EVs", 10000, 10000,5000));
        items.add(new Items("Rare Candy", "Leveling Item", "A candy that is packed with energy.", "Increases level by 1", 0, 0,2400));
        items.add(new Items("Health Feather", "Feather", "A feather that slightly increases HP.", "+1 HP EV", 300, 300,150));
        items.add(new Items("Muscle Feather", "Feather", "A feather that slightly increases Attack.", "+1 Attack EV", 300, 300,150));
        items.add(new Items("Resist Feather", "Feather", "A feather that slightly increases Defense.", "+1 Defense EV", 300, 300, 150));
        items.add(new Items("Swift Feather", "Feather", "A feather that slightly increases Speed.", "+1 Speed EV", 300, 300, 150));
        items.add(new Items("Zinc", "Vitamin", "A nutritious drink for Pokémon.", "+10 Special Defense EVs", 10000, 10000,5000));
    }

    public void searchItems() {
        scanner.nextLine(); // consume leftover newline
        System.out.print("Enter keyword to search: ");
        String item = scanner.nextLine().toLowerCase();
        for(Items toFind: items){
            if(toFind.getName().equalsIgnoreCase(item)){
                System.out.println("Move Found!");
                viewItem(toFind);
                return;
            };
        }
        System.out.println("Move not Found!");
        return;
    }

    public void viewItems(){
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        System.out.println("| Name             | Description                                                                           | Classification | Type One   | Type Two   |");
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        for(Items toPrint: items){
            System.out.printf("| %-16s | %-85s | %-14s | %-10s | %-10s |\n",  toPrint.getName(), toPrint.getCategory(), toPrint.getDescription(),
                    toPrint.getEffect(), toPrint.getBuyPriceString(), toPrint.getSellingPrice());
            System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        }
    }

    public void viewItem(Items items) {
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        System.out.println("| Name             | Description                                                                           | Classification | Type One   | Type Two   |");
        System.out.println("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+");
        System.out.printf("| %-16s | %-85s | %-14s | %-10s | %-10s |\n", items.getName(), items.getCategory(), items.getDescription(),
                    items.getEffect(), items.getBuyPriceString(), items.getSellingPrice());
        System.out.printf("+------------------+---------------------------------------------------------------------------------------+----------------+------------+------------+\n");
    }


/** represents all possible categories that an Item can be in */

/** Prints a welcome statement for the move module.
 *  CHANGE THIS TO ITEMS MODULE: di magawa-gawa ng ai ahhahaha
 *  */
public void printTitle() {
    System.out.println("██╗████████╗███████╗███╗   ███╗███████╗    ███╗   ███╗ ██████╗ ██████╗ ██╗   ██╗██╗     ███████╗\n" +
                       "██║╚══██╔══╝██╔════╝████╗ ████║██╔════╝    ████╗ ████║██╔═══██╗██╔══██╗██║   ██║██║     ██╔════╝\n" +
                       "██║   ██║   █████╗  ██╔████╔██║███████╗    ██╔████╔██║██║   ██║██║  ██║██║   ██║██║     █████╗  \n" +
                       "██║   ██║   ██╔══╝  ██║╚██╔╝██║╚════██║    ██║╚██╔╝██║██║   ██║██║  ██║██║   ██║██║     ██╔══╝  \n" +
                       "██║   ██║   ███████╗██║ ╚═╝ ██║███████║    ██║ ╚═╝ ██║╚██████╔╝██████╔╝╚██████╔╝███████╗███████╗\n" +
                       "╚═╝   ╚═╝   ╚══════╝╚═╝     ╚═╝╚══════╝    ╚═╝     ╚═╝ ╚═════╝ ╚═════╝  ╚═════╝ ╚══════╝╚══════╝\n" +
                    "                                                                                                \n");
    Pokedex.pause();
}

/** This method prints out the menu and is the main access/controller of the methods.
 * This is the method that interacts with the user and calls out the appropriate methods accordingly.
 * */
public void menu() {
    int option = -1;
    do {
        System.out.println("Welcome to the Items Module!");
        System.out.println("0. Exit");
        System.out.println("1. View Items");
        System.out.println("2. Search Items");
        System.out.print("What would you like to do?: ");
        option = scanner.nextInt();

        initializeItems();
        switch (option) {
            case 0:
                System.out.println("");
                System.out.println("Exiting...");
                break;
            case 1:
                viewItems();
                break;
            case 2:
                searchItems();
                break;
            default:
                System.out.println("Error: Invalid Input");
        }

    } while (option != 0);

}

}


