package ppvis.util.search;

import ppvis.util.Player;
import ppvis.util.PlayerDTO;
import ppvis.util.Role;

public class SearchByRole implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        Role role = ((PlayerDTO) object).getRoleInTeam();
        if (role == Role.NoMatter)
            return true;
        return player.getRoleInTeam() == role;
    }
}
