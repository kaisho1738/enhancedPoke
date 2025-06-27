/**
 * This class represents an individual item. The attributes and constructors give a blueprint for the Item.
 * The getters in this class allow other classes to access the assigned values to the attributes.
 * There are currently no setters because there is not an option or a feature to change any of the Item's attributes
 */

public class Items {
    private String name;
    private ItemsDex.Category category;
    private String description;
    private String effect;
    private int minBuyingPrice;
    private int maxBuyingPrice;
    private int sellingPrice;

    /** constructor for move
     * @param name              Name of the item
     * @param category          Category of the item
     * @param description       Description of the item
     * @param effect            Effect/s of the item when held/used
     * @param minBuyingPrice    Minimum buying price of the item
     * @param maxBuyingPrice    Maximum buying price of the item
     * @param sellingPrice      Selling price of the item
     * */

    public Items(String name, ItemsDex.Category category, String description, String effect,
                 int minBuyingPrice, int maxBuyingPrice, int sellingPrice) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.effect = effect;
        this.minBuyingPrice = minBuyingPrice;
        this.maxBuyingPrice = maxBuyingPrice;
        this.sellingPrice = sellingPrice;
    }

    // Getters

    public String getName() {
        return name;
    }
    public ItemsDex.Category getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public String getEffect() {
        return effect;
    }
    public int getMinBuyingPrice() {
        return minBuyingPrice;
    }
    public int getMaxBuyingPrice() {
        return maxBuyingPrice;
    }
    public int getSellingPrice() {
        return sellingPrice;
    }

    public String getBuyPriceString() {
        if (minBuyingPrice == 0 && maxBuyingPrice == 0) {
            return "Not sold";
        } else if (minBuyingPrice == maxBuyingPrice) {
            return "₽" + minBuyingPrice;
        } else {
            return "₽" + minBuyingPrice + " – ₽" + maxBuyingPrice;
        }
    }
}
