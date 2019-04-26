package ppvis.util.search;

import ppvis.util.Player;

import java.text.ParseException;

public class SearchByDate implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) throws ParseException {
        return true;
    }
}
