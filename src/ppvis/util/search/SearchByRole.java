package ppvis.util.search;

import ppvis.util.model.Player;
import ppvis.util.model.PlayerDTO;
import ppvis.util.model.Role;

public class SearchByRole implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        Role role = ((PlayerDTO) object).getRoleInTeam();
        if (role == Role.NoMatter)
            return true;
        return player.getRoleInTeam() == role;
    }
}
