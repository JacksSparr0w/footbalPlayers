package ppvis.util.search;

import ppvis.util.Player;

import java.text.ParseException;

public interface SearchBy {
    public boolean compare(Player player, Object object) throws ParseException;
}
