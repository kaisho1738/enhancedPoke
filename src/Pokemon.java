/**
This class represents an individual pokemon, the attributes and constructors gives a blueprint for the pokemon.
The getters in this class allow other classes to access the assigned values to the attributes.
There are currently no setters because there is not an option or a feature to change any of the pokemon's attributes
*/

public class Pokemon {

    //Pokemon attributes
    private int dexNum;
    private String pokeName;
    private Pokedex.Type type1;
    private Pokedex.Type type2;
    private int baseLevel;
    private int evolvesFrom;
    private int evolvesTo;
    private int evoLevel;
    private int hp;
    private int atk;
    private int def;
    private int spd;
    private String cry;


    /** constructor to create pokemon with cry
     * @param dexNum        Pokedex Number
     * @param pokeName      Pokemon Name
     * @param type1         Primary Type
     * @param type2         Secondary Type
     * @param baseLevel     Starting Level
     * @param evolvesFrom   Pokedex Number of the Pokemon it evolves from
     * @param evolvesTo     Pokedex Number of the Pokemon it evolves to
     * @param evoLevel      Level required to evolve
     * @param hp            Health points
     * @param atk           Attack stat
     * @param def           Defense Stat
     * @param spd           Speed stat
     * @param cry           Pokemon's cry (text based)
     */
    public Pokemon(int dexNum, String pokeName, Pokedex.Type type1, Pokedex.Type type2, int baseLevel,
                   int evolvesFrom, int evolvesTo, int evoLevel, int hp, int atk, int def, int spd, String cry){
        this(dexNum, pokeName, type1, type2, baseLevel, evolvesFrom, evolvesTo, evoLevel, hp, atk, def, spd);
        this.cry = cry;
    }

    //constructor create pokemon with cry
    //This contains the same parameters as the first constructor but does not take String Cry
    public Pokemon(int dexNum, String pokeName, Pokedex.Type type1, Pokedex.Type type2, int baseLevel,
                   int evolvesFrom, int evolvesTo, int evoLevel, int hp, int atk, int def, int spd){
        this.dexNum = dexNum;
        this.pokeName = pokeName;
        this.type1 = type1;
        this.type2 = type2;
        this.baseLevel = baseLevel;
        this.evolvesFrom = evolvesFrom;
        this.evolvesTo = evolvesTo;
        this.evoLevel = evoLevel;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }


    //getters
    public int getDexNum(){
        return dexNum;
    }
    public String getPokeName(){
        return pokeName;
    }
    public Pokedex.Type getType1(){
        return type1;
    }
    public Pokedex.Type getType2(){
        return type2;
    }
    public int getBaseLevel(){
        return baseLevel;
    }
    public int getEvolvesFrom(){
        return evolvesFrom;
    }
    public int getEvolvesTo(){
        return evolvesTo;
    }
    public int getEvoLevel(){return evoLevel; }
    public int getHp(){
        return hp;
    }
    public int getAtk(){
        return atk;
    }
    public int getDef(){
        return def;
    }
    public int getSpd(){
        return spd;
    }
    public String getCry(){return cry;}

    //Method to make a pokemon cry
    //@param pokemon    the specific pokemon instance
    public void goCry(Pokemon pokemon){
        System.out.println(pokemon.getCry());
    }



}
