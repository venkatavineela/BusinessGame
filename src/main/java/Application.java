public class Application {
    public static void main(String args[]) {
        Board board = new Board();
        InputOutput io = new ConsoleInputOutput();
        BusinessHouse house = new BusinessHouse(io,board);
        Game game = new Game(io,house);
        game.start();
    }
}
