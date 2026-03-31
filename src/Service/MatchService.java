package Service;

import Dto.OverResult;
import Entity.*;

import java.util.List;

public class MatchService {

    public void playMatch(Innings innings, Integer target)
    {
        List<Player> batters = innings.getBattingTeam().getBattingOrder();
        List<Player> bowlers = innings.getBowlingTeam().getBowlingOrder();

        Player striker = batters.get(0);
        Player nonStriker = batters.get(1);

        int nextBatsmanIndex = 2;

        for(int overs = 0; overs < innings.getTotalOvers(); overs++)
        {
            Player bowler = bowlers.get(overs % bowlers.size());

            Over over = OverService.generateBalls(batters, overs + 1, innings.getTotalRuns(), innings.getWickets(), target);
            BallService ballService = new BallService(over);

            OverResult result = ballService.getScoreForOver(batters, striker, nonStriker, bowler, nextBatsmanIndex);

            innings.addRuns(result.getRuns());
            for(int i=0; i< result.getWickets(); i++)
                innings.addWicket();

            striker = result.getStriker();
            nonStriker = result.getNonStriker();
            nextBatsmanIndex = result.getNextBatsmanIndex();

            over.getBalls().forEach(ball -> System.out.print(ball.getResult().getTotalRuns() + " "));
            System.out.println();

            System.out.println("Over " + over.getOverNumber()+ " -> score: " + result.getRuns() + "/" + result.getWickets());

            System.out.println("Total score : " + innings.getTotalRuns() + "/" + innings.getWickets());
            if(target != null && innings.getTotalRuns() >= target) {
                System.out.println("Target Chased!!");
                break;
            }

            if(innings.getWickets() >= batters.size() - 1) {
                System.out.println("All out !!");
                break;
            }

        }

    }

    public void startMatch(Match match)
    {
        match.startMatch();

        System.out.println("First innings started");
        playMatch(match.getFirstInnings(), null);

        int target = match.getFirstInnings().getTotalRuns() + 1;

        System.out.println("Second innings started");
        playMatch(match.getSecondInnings(), target);

        int teamBScore = match.getSecondInnings().getTotalRuns();

        if(teamBScore >= target)
            System.out.println("Team B Wins!!!");
        else
            System.out.println("Team A Wins!!!");

    }

}
