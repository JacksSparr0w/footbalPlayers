package ppvis.util.search;

import ppvis.util.model.Name;
import ppvis.util.model.Player;
import ppvis.util.model.PlayerDTO;

public class SearchByName implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        String s = ((PlayerDTO) object).getName();
        Name name = new Name(s);
        if (name.equals(player.getName())) return true;
        return player.getName().equalsIgnoreCase(s);


    }
}
