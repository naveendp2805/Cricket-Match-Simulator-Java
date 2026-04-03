package Service;

import Entity.Match.Match;

import java.util.Random;

public class MatchService {



    public void startMatch(Match match)
    {
        match.startMatch();

        InningsService inningsService = new InningsService();
        ScoreCardService scoreCardService = new ScoreCardService();

        System.out.println("\nFirst innings started");
        inningsService.playMatch(match.getFirstInnings(), null);

        scoreCardService.printInningsSummary(match.getFirstInnings(),
                match.getFirstInnings().getBattingTeam(),
                match.getFirstInnings().getBowlingTeam());

        int target = match.getFirstInnings().getTotalRuns() + 1;

        System.out.println("\nSecond innings started");
        inningsService.playMatch(match.getSecondInnings(), target);

        scoreCardService.printInningsSummary(match.getSecondInnings(),
                match.getSecondInnings().getBattingTeam(),
                match.getSecondInnings().getBowlingTeam());

        int teamBScore = match.getSecondInnings().getTotalRuns();

        if(teamBScore >= target)
            System.out.println("Team B Wins!!!");
        else
            System.out.println("Team A Wins!!!");

    }

    public String tossCoin()
    {
        Random random = new Random();
        String[] toss = {"heads", "tails"};

        int index = random.nextInt(toss.length);

        return toss[index];
    }

}
