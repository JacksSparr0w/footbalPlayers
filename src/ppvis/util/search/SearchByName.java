package ppvis.util.search;

import ppvis.util.Player;
import ppvis.util.PlayerDTO;

public class SearchByName implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        String name = ((PlayerDTO) object).getName();
        if (name.isEmpty()) return true;
        return player.getName().equalsIgnoreCase(name);


    }
}
