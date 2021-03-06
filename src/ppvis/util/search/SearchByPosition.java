package ppvis.util.search;

import ppvis.util.model.Player;
import ppvis.util.model.PlayerDTO;

public class SearchByPosition implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        if (((PlayerDTO) object).getPosition().isEmpty()) return true;
        int position = Integer.parseInt(((PlayerDTO) object).getPosition());
        return player.getPosition() == position;
    }
}
