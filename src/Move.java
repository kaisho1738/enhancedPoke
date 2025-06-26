/**
 * This class represents an individual move with its own traits. The attributes and constructors
 * serve as blueprint of the move.
 * The getters in this class allow other classes to access the assigned values to the attributes.
 * There are currently no setters because there is not an option or a feature to change any of the move's attributes
 */

public class Move {

    //attributes
    private String name;
    private String description;
    private MoveDex.MoveClass classification;
    private Pokedex.Type moveType1;
    private Pokedex.Type moveType2;


    /** constructor for move
     * @param name      name of the move
     * @param description       description of the move
     * @param classification    move classification
     * @param movetype1         primary type
     * @param movetype2         secondary type
     * */
    public Move(String name, String description, MoveDex.MoveClass classification,
                Pokedex.Type movetype1, Pokedex.Type movetype2){
        this.name = name;
        this.description = description;
        this.classification = classification;
        this.moveType1 = movetype1;
        this.moveType2 = movetype2;
    }

    //getters
    public String getName(){return name;}
    public String getDescription(){return description;}
    public MoveDex.MoveClass getClassification(){return classification;}
    public Pokedex.Type getMoveType1(){return moveType1;}
    public Pokedex.Type getMoveType2(){return moveType2;}



}
