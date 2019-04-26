package ppvis.util.search;

import ppvis.util.Player;
import ppvis.util.PlayerDTO;

public class SearchByTeamName implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        String teamName = ((PlayerDTO) object).getTeamName();
        if (teamName.isEmpty()) return true;
        return player.getTeamName().equals(teamName);
    }
}
