package ppvis.util.search;

import ppvis.util.Player;
import ppvis.util.Role;

public class SearchByRole implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        return player.getRoleInTeam() == (Role) object;
    }
}
