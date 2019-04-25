package ppvis.util.search;

import ppvis.util.Player;

public class SearchByCity implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        String city = (String) object;
        return player.getCity().equals(city);
    }
}
