package Service;

import Dto.BallResult;
import Dto.OverResult;
import Entity.Match.Ball;
import Entity.Match.Over;
import Entity.Team.Player;

import java.util.List;

public class BallService {

    private final Over over;

    public BallService(Over over) {
        this.over = over;
    }

    public OverResult getScoreForOver(List<Player> batters, Player striker, Player nonStriker, Player bowler, int nextBatsmanIndex)
    {
        int totalRuns = 0;
        int wickets = 0;

        for(Ball ball : over.getBalls()) {
            BallResult result = ball.getResult();

            int batsmanRuns = result.getBatsmanRuns();
            int runs = result.getTotalRuns();

            totalRuns += runs;

            if(result.isWide())
            {
                bowler.addExtraRuns(runs);

                if(runs % 2 == 1)
                {
                    Player temp = striker;
                    striker = nonStriker;
                    nonStriker = temp;
                }

                continue;
            }

            if(result.isNoBall())
            {
                bowler.addExtraRuns(runs);

                if(batsmanRuns > 0)
                    striker.addRunsOnly(batsmanRuns);

                if(runs % 2 == 1)
                {
                    Player temp = striker;
                    striker = nonStriker;
                    nonStriker = temp;
                }

                continue;
            }

            bowler.addBowlingStats(runs, result.isWicket());

            if(result.isWicket())
            {
                striker.facedDotBall();
                wickets++;

                striker.setDismissalInfo("b " + bowler.getName());

                if(nextBatsmanIndex < batters.size())
                    striker = batters.get(nextBatsmanIndex++);
                else break;
                continue;
            }

            if(batsmanRuns > 0)
                striker.addBattingStats(batsmanRuns);
            else
                striker.facedDotBall();

            if(runs % 2 == 1)
            {
                Player temp = striker;
                striker = nonStriker;
                nonStriker = temp;
            }
        }

        Player temp = striker;
        striker = nonStriker;
        nonStriker = temp;

        return new OverResult(totalRuns, wickets, striker, nonStriker, nextBatsmanIndex);
    }

}
