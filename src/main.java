public class main {
    public static void main(String[] args){
        Pokedex pokedex = new Pokedex();
        MoveDex moveDex = new MoveDex();
        //pokedex.printTitle();
        pokedex.initializePokemons();
        moveDex.initializeMoves();

        moveDex.printTitle();
        moveDex.menu();
        //pokedex.menu();

    }
}
