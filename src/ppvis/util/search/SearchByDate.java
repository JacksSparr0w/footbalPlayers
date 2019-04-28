package ppvis.util.search;

import ppvis.util.model.Player;

import java.text.ParseException;

public class SearchByDate implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) throws ParseException {
        return true;
    }
}
