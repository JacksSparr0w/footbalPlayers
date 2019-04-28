package ppvis.util.search;

import ppvis.util.model.Name;
import ppvis.util.model.Player;
import ppvis.util.model.PlayerDTO;

public class SearchByName implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        PlayerDTO playerDTO = (PlayerDTO) object;
        Name playerName = player.getName();
        return playerName.compareTo(new Name(playerDTO.getName())) == 0;

    }
}

