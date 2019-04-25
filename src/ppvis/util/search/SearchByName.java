package ppvis.util.search;

import ppvis.util.Player;

public class SearchByName implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        String name = (String) object;
        return player.getName().equalsIgnoreCase(name);
    }
}
