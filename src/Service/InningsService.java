package Service;

import Dto.BallResult;
import Dto.OverResult;
import Entity.Match.Ball;
import Entity.Match.Innings;
import Entity.Match.Over;
import Entity.Team.Player;

import java.util.List;

public class InningsService {

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

            for(Ball ball : over.getBalls())
            {
                BallResult result1 = ball.getResult();

                if(!result1.isWide() && !result1.isNoBall())
                    innings.addBall();

                if(result1.isWide())
                    innings.addWide(result1.getTotalRuns());

                if(result1.isNoBall())
                    innings.addNoBall(result1.getTotalRuns());
            }

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
}
