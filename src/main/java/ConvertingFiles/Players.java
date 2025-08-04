package ConvertingFiles;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Players {
    @JsonProperty("Player")  // Controls XML element name
    private List<Player> playerList;

    public Players() {}

    public Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}

