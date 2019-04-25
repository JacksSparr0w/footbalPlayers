package ppvis.util.search;

import ppvis.util.Player;

public class SearchByTeamName implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        String teamName = (String) object;
        return player.getTeamName().equals(teamName);
    }
}
