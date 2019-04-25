package ppvis.util.search;

import ppvis.util.Player;

import java.util.Date;

public class SearchByDate implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) {
        Date date = (Date) object;
        return player.getDateOfBirth().equals(date);
    }
}
