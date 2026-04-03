package Input;

import Entity.Match.Match;
import Entity.Team.Player;
import Entity.Team.PlayerType;
import Entity.Team.Team;
import Service.MatchService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    
    public Team createTeam(int n)
    {
        Scanner sc = new Scanner(System.in);

        List<Player> Players = new ArrayList<>();

        System.out.println("Enter Team name: ");
        String teamName = sc.next().toUpperCase();

        System.out.println("enter Player name and PlayerType as number (Batsman : 1/ Bowler : 2/ All_Rounder : 3)");
        for(int i=1; i<=n; i++)
        {
            System.out.println("Enter details of Player " + i + ": ");
            String name = sc.next();
            int ch = sc.nextInt();

            PlayerType type;
            switch(ch)
            {
                case 1 : type = PlayerType.BATSMAN; break;
                case 2 : type = PlayerType.BOWLER; break;
                case 3 : type = PlayerType.ALL_ROUNDER; break;
                default : System.out.println("Please choose from the above 3 types"); continue;
            }

            Players.add(new Player(name, type));
        }

        System.out.println("Players List:");
        for(int i=0; i<n; i++)
        {
            Player p = Players.get(i);
            System.out.println((i+1) + " -> " + p.getName() + "(" + p.getType() +")");
        }

        System.out.println("Enter Batting Order of Players: ");
        List<Player> battingOrder =  new ArrayList<>();
        boolean[] used = new boolean[n];

        int c = 0;
        while(c < n)
        {
            int idx = sc.nextInt() - 1;

            if(idx < 0 || idx >= n)
            {
                System.out.println("Invalid index!!");
                continue;
            }

            if(used[idx])
            {
                System.out.println("This Player already selected!");
                continue;
            }

            battingOrder.add(Players.get(idx));
            used[idx] = true;
            c++;
        }

        System.out.println("Available Bowlers");
        int m = 0;
        for(int i=0; i<n; i++)
        {
            Player p = Players.get(i);

            if(p.getType() == PlayerType.BOWLER)
            {
                m++;
                System.out.println((i+1) + " -> " + p.getName());
            }
        }

        List<Player> bowlingOrder = new ArrayList<>();
        c = 0;
        while(c < m)
        {
            int idx = sc.nextInt() - 1;

            if(idx < 0 || idx >= n)
            {
                System.out.println("Invalid index!!");
                continue;
            }

            Player p = Players.get(idx);

            if(p.getType() == PlayerType.BATSMAN)
            {
                System.out.println("Batsman cannot bowl!!");
                continue;
            }

            bowlingOrder.add(p);
            c++;
        }

        return  new Team(teamName, Players, battingOrder, bowlingOrder);
    }

    public Match chooseToss(Team team1, Team team2, int overs)
    {
        Scanner sc = new Scanner(System.in);

        MatchService matchService = new MatchService();

        System.out.println("Team A: Choose Heads/Tails: ");
        String tossA = sc.next().toLowerCase();

        System.out.println("Team B: Choose Heads/Tails: ");
        String tossB = sc.next().toLowerCase();

        if(tossB.equals(tossA)) throw new RuntimeException("Both shouldn't be equal");
        String toss = matchService.tossCoin();

        System.out.println("Tossing the coin!!!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if(toss.equals(tossA))
        {
            System.out.println("Team A wins the Toss.\nTeam A: Choose Batting or Bowling: ");
            String chooses = sc.next().toLowerCase();
            if(chooses.equals("batting"))
            {
                System.out.println("Team A chooses Batting");
                return new Match(team1, team2, overs);
            }
            else
            {
                System.out.println("Team A chooses Bowling");
                return new Match(team2, team1, overs);
            }
        }
        else
        {
            System.out.println("Team B wins the Toss.\nTeam B: Choose Batting or Bowling: ");
            String chooses = sc.next().toLowerCase();
            if(chooses.equals("batting"))
            {
                System.out.println("Team B chooses Batting");
                return new Match(team2, team1, overs);
            }
            else
            {
                System.out.println("Team B chooses Bowling");
                return new Match(team1, team2, overs);
            }
        }

    }
}
