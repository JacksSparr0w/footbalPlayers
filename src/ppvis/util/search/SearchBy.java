package ppvis.util.search;

import ppvis.util.model.Player;

import java.text.ParseException;

//comparator
//comparable
public interface SearchBy {
    public boolean compare(Player player, Object object) throws ParseException;
}
