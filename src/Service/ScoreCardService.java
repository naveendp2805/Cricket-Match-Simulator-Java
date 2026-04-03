package Service;

import Entity.Match.Innings;
import Entity.Team.Player;
import Entity.Team.Team;

import java.util.List;

public class ScoreCardService {

    private void printLine() {
        System.out.println("----------------------------------------------------");
    }

    private void printHeader(String title) {
        System.out.println("\n+--------------------------------------------------+");
        System.out.printf("| %-48s |\n", title);
        System.out.println("+--------------------------------------------------+");
    }

    public void printBattingScoreCard(List<Player> players)
    {

        System.out.println("\nBatting Scorecard:");
        System.out.println("-----------------");

        System.out.printf("%-18s %-20s %-4s %-4s %-4s %-4s %-6s\n", "Batsman", "Dismissal", "R", "B", "4s", "6s", "SR");

        for(Player player : players)
        {
            System.out.printf("%-18s %-20s %-4d %-4d %-4d %-4d %-6.2f\n",
                    player.getName(),
                    player.getDismissal(),
                    player.getRuns(),
                    player.getBalls(),
                    player.getFours(),
                    player.getSixes(),
                    player.getStrikeRate());
        }

    }

    public void printBowlingScoreCard(List<Player> players)
    {
        System.out.println("\nBowling Scorecard:");
        System.out.println("-----------------");

        System.out.printf("%-18s %-6s %-4s %-4s %-6s\n", "Bowler", "Overs", "Runs", "Wickets", "Economy");

        for(Player player : players)
        {
            if(player.getBallsBowled() == 0) continue;

            System.out.printf("%-18s %-6s %-4d %-4d %-6.2f\n",
                    player.getName(),
                    player.getOversBowled(),
                    player.getRunsGiven(),
                    player.getWicketsTaken(),
                    player.getEconomy());
        }
    }

    public void printInningsSummary(Innings innings, Team batting, Team bowling)
    {
        printHeader(batting.getName() + " INNINGS");

        System.out.println("\nBATTING");
        printLine();
        printBattingScoreCard(batting.getPlayers());

        System.out.println("\nBOWLING");
        printLine();
        printBowlingScoreCard(bowling.getPlayers());

        printLine();
        System.out.println("Extras: (w " + innings.getWides() + ", nb " + innings.getNoBalls() + ") " + innings.getWidesAndNoBalls());
        System.out.println("Total: " + innings.getTotalRuns() + "/" + innings.getWickets() + " (" + innings.getOvers() + " Ov)");
        System.out.printf("Run Rate: %.2f\n", innings.getRunRate());
        printLine();
    }

}
