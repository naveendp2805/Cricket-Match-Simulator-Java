package Service;

import Entity.Player;

import java.util.List;

public class ScoreCardService {

    public static void printScoreCard(List<Player> players, int totalRuns, int wickets)
    {

        System.out.println("\nScorecard:");
        System.out.println("-----------------");

        for(Player player : players)
        {
            if(player.getRuns() > 0)
            {
                System.out.println(player.getName() + ": " + player.getRuns() + " (" + player.getBalls() + ")");
            }
        }

        System.out.println("Total Runs : " + totalRuns + "/" + wickets);
    }

}
