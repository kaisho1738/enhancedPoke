public class Move {

    //attributes
    private String name;
    private String description;
    private MoveDex.MoveClass classification;
    private Pokedex.Type moveType1;
    private Pokedex.Type moveType2;


    //constructor
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
