package Service;

import Dto.BallResult;
import Entity.Ball;
import Entity.BallType;
import Entity.Over;
import Entity.Player;

import java.util.*;

public class OverService {

    public static Over generateBalls(List<Player> batters, int overNumber, int totalRunsUpToNow, int wickets, Integer target)
    {
        Scanner sc = new Scanner(System.in);
        List<Ball> balls = new ArrayList<>();
        List<Integer> randomBalls = Arrays.asList(1, 2, 3, 4, 6);

        Random random = new Random();

        int noOfBalls = 0;
        int currWickets = 0;
        int totalRuns = totalRunsUpToNow;

        while(noOfBalls < 6)
        {
            System.out.println("enter outcome of ball " + (noOfBalls + 1) + " (1, 2, 3, 4, 6, W, w, n): ");
            char outcome = sc.next().charAt(0);

            Ball ball;

            switch(outcome)
            {
                case '1' : ball = new Ball(new BallResult(1, 0, BallType.RUN));
                           noOfBalls++;
                           totalRuns += 1;
                           break;

                case '2' : ball = new Ball(new BallResult(2, 0, BallType.RUN));
                           noOfBalls++;
                           totalRuns += 2;
                           break;

                case '3' : ball = new Ball(new BallResult(3, 0, BallType.RUN));
                           noOfBalls++;
                           totalRuns += 3;
                           break;

                case '4' : ball = new Ball(new BallResult(4, 0, BallType.RUN));
                           noOfBalls++;
                           totalRuns += 4;
                           break;

                case '6' : ball = new Ball(new BallResult(6, 0, BallType.RUN));
                           noOfBalls++;
                           totalRuns += 6;
                           break;

                case 'W' : currWickets++;
                           noOfBalls++;
                           ball = new Ball(new BallResult(0, 0, BallType.WICKET));
                           break;

                case 'w' : int wRun = random.nextInt(randomBalls.size());
                           ball = new Ball(new BallResult(wRun, 1, BallType.WIDE));
                           totalRuns += wRun + 1;
                           break;

                case 'n' : int nRun = random.nextInt(randomBalls.size());
                           ball = new Ball(new BallResult(nRun, 1, BallType.NO_BALL));
                           totalRuns += nRun + 1;
                           break;

                default : System.out.println("Invalid Outcome"); continue;
            }

            balls.add(ball);
            if(wickets + currWickets >= batters.size() - 1 || (target != null && totalRuns >= target))
                return new Over(balls, overNumber);
        }

        return new Over(balls, overNumber);
    }
}
