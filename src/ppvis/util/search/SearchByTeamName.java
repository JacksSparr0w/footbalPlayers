package ppvis.util.search;

import ppvis.util.model.Player;
import ppvis.util.model.PlayerDTO;

public class SearchByTeamName implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        String teamName = ((PlayerDTO) object).getTeamName();
        if (teamName.isEmpty()) return true;
        return player.getTeamName().equals(teamName);
    }
}
