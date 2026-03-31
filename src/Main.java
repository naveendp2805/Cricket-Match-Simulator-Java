import Entity.*;
import Service.BallService;
import Service.MatchService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Player> team1Players = new ArrayList<>();
        Player p1 = new Player("Rohit", PlayerType.ALL_ROUNDER);
        Player p2 = new Player("Virat", PlayerType.BATSMAN);
        Player p3 = new Player("Dhoni", PlayerType.BOWLER);
        Player p4 = new Player("Surya", PlayerType.BATSMAN);

        team1Players.add(p1);
        team1Players.add(p2);
        team1Players.add(p3);
        team1Players.add(p4);

        List<Player> team1BattingOrder = List.of(p2, p4, p1, p3);
        List<Player> team1BowlingOrder = List.of(p1, p3);
        Team team1 = new Team("India", team1Players, team1BattingOrder, team1BowlingOrder);

        List<Player> team2Players = new ArrayList<>();
        Player q1 = new Player("Babar", PlayerType.BATSMAN);
        Player q2 = new Player("Rizwan", PlayerType.ALL_ROUNDER);
        Player q3 = new Player("Afridi", PlayerType.BOWLER);
        Player q4 = new Player("Malik", PlayerType.BATSMAN);

        team2Players.add(q1);
        team2Players.add(q2);
        team2Players.add(q3);
        team2Players.add(q4);

        List<Player> team2BattingOrder = List.of(q1, q2, q4, q3);
        List<Player> team2BowlingOrder = List.of(q2, q3);

        Team team2 = new Team("Pakistan", team2Players, team2BattingOrder, team2BowlingOrder);

        Match match = new Match(team1, team2, 3);
        MatchService matchService = new MatchService();

        matchService.startMatch(match);

    }
}
