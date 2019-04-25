package ppvis.util.search;

import ppvis.util.Player;

public class SearchByPosition implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        return player.getPosition() == (int) object;
    }
}
