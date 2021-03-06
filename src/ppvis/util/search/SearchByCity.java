package ppvis.util.search;

import ppvis.util.model.Player;
import ppvis.util.model.PlayerDTO;

public class SearchByCity implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        String city = ((PlayerDTO) object).getCity();
        if (city.isEmpty()) return true;
        return player.getCity().equals(city);
    }
}
