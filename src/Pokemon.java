public class Pokemon {

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
    private static int totalPokemons = 0;
    private String cry;
    private Move[] moves = new Move[10];
    private int moveCount = 0;
    //to add item object
    //to add move object

    //constructor - create pokemon with cry
    public Pokemon(int dexNum, String pokeName, Pokedex.Type type1, Pokedex.Type type2, int baseLevel,
                   int evolvesFrom, int evolvesTo, int evoLevel, int hp, int atk, int def, int spd, String cry){
        this.dexNum = dexNum;
        this.pokeName = pokeName;
        this.type1 = type1;
        this.type2 = type2;
        this.baseLevel = baseLevel;
        this.evolvesFrom = evolvesFrom;
        this.evolvesTo = evolvesTo;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.cry = cry;
        totalPokemons++;
    }

    //pokemon w/o cry
    public Pokemon(int dexNum, String pokeName, Pokedex.Type type1, Pokedex.Type type2, int baseLevel,
                   int evolvesFrom, int evolvesTo, int evoLevel, int hp, int atk, int def, int spd){
        this.dexNum = dexNum;
        this.pokeName = pokeName;
        this.type1 = type1;
        this.type2 = type2;
        this.baseLevel = baseLevel;
        this.evolvesFrom = evolvesFrom;
        this.evolvesTo = evolvesTo;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        totalPokemons++;
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
    public Move[] getMoves(){return moves;}

    //setter to change cry
    public void setCry(String cry){
        this.cry = cry;
    }

    //methods; (1) view all pokemon to be implemented in main (2) search pokemon in main
    public void addMove(Move move){
        if(moveCount < moves.length){
            for(int i = 0; i< moveCount;i++){
                if(moves[i].getName().equalsIgnoreCase(move.getName())){
                    System.out.println("Error: Move already exists!");
                    return;
                }
            }
            moves[moveCount++] = move;
            System.out.println(move.getName() + " added successfully!");
        } else{
            System.out.println("Error: No more slots available!");
        }
    }

    public void goCry(Pokemon pokemon){
        System.out.println(pokemon.getCry());
    }



}
