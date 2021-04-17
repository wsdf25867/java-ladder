package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {
    private final Players players;
    private Ladder ladder;

    public LadderGame(Players players, int height) {
        this.players = players;
        ladder = new Ladder(height, players.getPlayerCount());
    }

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public List<String> build() {
        return ladder.build();
    }

    public List<String> getAllPlayerNames() {
        return players.getAllPlayerNames();
    }

    public void start() {
        for (int i = 0; i < players.getPlayerCount(); i++) {
            players.updatePlayerPoint(i, ladder.rideLadder(players.getPlayerByIndex(i)));
        }
    }

    public Player findPlayerByName(String name) {
        return players.findPlayerByName(name);
    }
}