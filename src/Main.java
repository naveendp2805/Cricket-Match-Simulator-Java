import Entity.Match.Match;
import Entity.Team.Team;
import Input.UserInput;
import Service.MatchService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserInput userInput = new UserInput();

        System.out.println("Enter no.of players: ");
        int totalPlayers = sc.nextInt();

        Team team1 = userInput.createTeam(totalPlayers);
        Team team2 = userInput.createTeam(totalPlayers);

        System.out.println("Enter no.of Overs: ");
        int overs = sc.nextInt();

        MatchService matchService = new MatchService();

        Match match = userInput.chooseToss(team1, team2, overs);

        matchService.startMatch(match);
    }
}
