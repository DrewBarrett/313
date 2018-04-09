import java.io.FileOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * p1
 */
public class p1 {
    
    public static void main(String[] args) {
        try {
            File file = new File("output.txt");
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);
        } catch (Exception e) {
            System.out.println("Cannot open output.txt for printing");
        }
        

        int totalGames = (int) (Math.random() * 40 + 1);
        for (int game = 0; game < totalGames; game++){
            System.out.println("Game " + (game + 1) + ":");
            Deck deck = new Deck();
            deck.print();
            int turn = 0;
            ArrayList<Player> players = new ArrayList();
            players.add(new Player("Player 1", false));
            players.add(new Player("Player 2", true));
            while (!deck.isEmpty()) {
                int player = turn % 2;
                Player p = players.get(player);

                p.doTurn(deck);

                turn++;
            }
            System.out.println(players.get(0));
            System.out.println(players.get(1));
            if (players.get(0).getMatched() > players.get(1).getMatched()) {
                System.out.println("Player 1 is the winner!");
            }
            else if (players.get(0).getMatched() < players.get(1).getMatched()) {
                System.out.println("Player 2 is the winner!");
            }
            else {
                System.out.println("Its a tie!");
            }
        }
        
    }
        
}
