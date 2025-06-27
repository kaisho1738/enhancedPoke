import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * THINGS TO FIX:
 * - Search method
 * - uml
 * - recording
 * - study the enum
 */

/**
 *
 *
 */

public class ItemsDex {
    public static Scanner scanner = new Scanner(System.in);

    private List<Items> items = new ArrayList<>();

    public enum Category {
        FEATHER("Feather"),
        VITAMIN("Vitamin"),
        LEVELING_ITEM("Leveling Item"),
        EVOLUTION_STONE("Evolution Stone");

        private final String displayName;

        Category(String displayName) {
            this.displayName = displayName;
        }

        public String toString() {
            return displayName;
        }
    }

    public void initializeItems() { // fix later
        items.add(new Items("HP Up", Category.VITAMIN, "A nutritious drink for Pokémon.", "+10 HP EVs", 10000, 10000, 5000));
        items.add(new Items("Protein", Category.VITAMIN, "A nutritious drink for Pokémon.", "+10 Attack EVs", 10000, 10000,5000));
        items.add(new Items("Iron", Category.VITAMIN, "A nutritious drink for Pokémon.", "+10 Defense EVs", 10000, 10000, 5000));
        items.add(new Items("Carbos", Category.VITAMIN, "A nutritious drink for Pokémon.", "+10 Speed EVs", 10000, 10000,5000));
        items.add(new Items("Rare Candy", Category.LEVELING_ITEM, "A candy that is packed with energy.", "Increases level by 1", 0, 0,2400));
        items.add(new Items("Health Feather", Category.FEATHER, "A feather that slightly increases HP.", "+1 HP EV", 300, 300,150));
        items.add(new Items("Muscle Feather", Category.FEATHER, "A feather that slightly increases Attack.", "+1 Attack EV", 300, 300,150));
        items.add(new Items("Resist Feather", Category.FEATHER, "A feather that slightly increases Defense.", "+1 Defense EV", 300, 300, 150));
        items.add(new Items("Swift Feather", Category.FEATHER, "A feather that slightly increases Speed.", "+1 Speed EV", 300, 300, 150));
        items.add(new Items("Zinc", Category.VITAMIN, "A nutritious drink for Pokémon.", "+10 Special Defense EVs", 10000, 10000,5000));
        items.add(new Items("Fire Stone", Category.EVOLUTION_STONE, "A stone that radiates heat.", "Evolves Pokemon like Vulpix, Growlithe, Eevee (into Flareon), etc", 3000, 5000,1500));
        items.add(new Items("Water Stone", Category.EVOLUTION_STONE, "A stone with a blue, watery appearance.", "Evolves Pokemon like Poliwhirl, Shellder, Eevee (into Vaporeon), etc", 3000, 5000,1500));
        items.add(new Items("Thunder Stone", Category.EVOLUTION_STONE, "A stone that sparkles with electricity.", "Evolves Pokemon like Pikachu, Elctrik, Eevee (into Jolteon), etc", 3000, 5000,1500));
        items.add(new Items("Leaf Stone", Category.EVOLUTION_STONE, "A stone with a leaf pattern.", "Evolves Pokemon like Gloom, Weepinbell, Exeggcute, etc", 3000, 5000,1500));
        items.add(new Items("Moon Stone", Category.EVOLUTION_STONE, "A stone that glows faintly in the moonlight.", "Evolves Pokemon like Nidorina, Clefairy, Jigglypuff, etc", 3000, 5000,1500));
        items.add(new Items("Sun Stone", Category.EVOLUTION_STONE, "A stone that glows like the sun.", "Evolves Pokemon like Gloom (into Bellossom), Sunkern, Cottonee, etc", 3000, 5000,1500));
        items.add(new Items("Shiny Stone", Category.EVOLUTION_STONE, "A stone that sparkles brightly.", "Evolves Pokemon like Togetic, Rosalia, Minccino, etc", 3000, 5000,1500));
        items.add(new Items("Dusk Stone", Category.EVOLUTION_STONE, "A dark stone that is ominous in appearance.", "Evolves Pokemon like Murkrow, Misdreavus, Doublade, etc", 3000, 5000,1500));
        items.add(new Items("Dawn Stone", Category.EVOLUTION_STONE, "A stone that sparkles like the morning sky.", "Evolves male Kirlia into Gallade, femail Snorunt into Froslass.", 3000, 5000,1500));
        items.add(new Items("Ice Stone", Category.EVOLUTION_STONE, "A stone that is cold to the touch.", "Evolves Pokemon like Alolan Vulpix, Galarian Darumaka, Eevee (into Glaceon)", 3000, 5000,1500));



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

    public void viewItems() {
        for(Items toPrint: items) {
            System.out.println("");
            System.out.println("=======================================================================================================================================================");
            System.out.println("Item Name: " + toPrint.getName());
            System.out.println("Category: " + toPrint.getCategory());
            System.out.println("Buying Price: " + toPrint.getBuyPriceString() + " | Selling Price: ₽" + toPrint.getSellingPrice());
            System.out.println("");
            System.out.println("Item Description: " + toPrint.getDescription());
            System.out.println("Effect: " + toPrint.getEffect());
        }

        System.out.println("");
        System.out.println("=======================================================================================================================================================");
    }

    public void viewItem(Items items) {
        System.out.println("=======================================================================================================================================================");
        System.out.println("Item Name: " + items.getName());
        System.out.println("Category: " + items.getCategory());
        System.out.println("Buying Price: " + items.getBuyPriceString() + " | Selling Price: ₽" + items.getSellingPrice());
        System.out.println("");
        System.out.println("Item Description: " + items.getDescription());
        System.out.println("Effect: " + items.getEffect());
        System.out.println("");
        System.out.println("=======================================================================================================================================================");

    }


/** represents all possible categories that an Item can be in */

/** Prints a welcome statement for the move module.
 *  CHANGE THIS TO ITEMS MODULE: di magawa-gawa ng ai ahhahaha
 *  */
public void printTitle() {
    System.out.println("\n" +
                       "██╗████████╗███████╗███╗   ███╗███████╗    ███╗   ███╗ ██████╗ ██████╗ ██╗   ██╗██╗     ███████╗\n" +
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
        System.out.println("");
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


