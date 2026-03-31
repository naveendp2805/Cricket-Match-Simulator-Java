package Entity;

import java.util.List;

public class Team {

    private final String name;
    private final List<Player> players;
    private final List<Player> battingOrder;
    private final List<Player> bowlingOrder;

    public Team(String name, List<Player> players, List<Player> battingOrder, List<Player> bowlingOrder) {
        this.name = name;
        this.players = players;
        this.battingOrder = battingOrder;
        this.bowlingOrder = bowlingOrder;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Player> getBattingOrder() {
        return battingOrder;
    }

    public List<Player> getBowlingOrder() {
        return bowlingOrder;
    }
}
