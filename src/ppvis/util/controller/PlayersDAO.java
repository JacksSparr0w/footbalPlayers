package ppvis.util.controller;

import ppvis.util.model.Player;
import ppvis.util.search.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class PlayersDAO {
    private List<Player> players;

    public PlayersDAO(){
        players = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if (player != null)
            players.add(player);
    }

    public void delPlayers(List<Player> players){
        for (Player player : players)
            delPlayer(player);
    }

    private void delPlayer(Player player){
        players.remove(player);
    }

    public List<Player> search(Object object) throws ParseException {
        SearchBy[] searchers = new SearchBy[]{new SearchByName(), new SearchByDate(),
                new SearchByTeamName(), new SearchByCity(), new SearchByRole(), new SearchByPosition()};
        List<Player> buf = new ArrayList<>();

        for(Player player : players){
            if (searchers[0].compare(player, object) &&
                    searchers[1].compare(player, object) &&
                    searchers[2].compare(player, object) &&
                    searchers[3].compare(player, object) &&
                    searchers[4].compare(player, object) &&
                    searchers[5].compare(player, object))

                buf.add(player);
        }
        return buf;
    }

    //For XML files
    public void setInfo(List<Player> players) {
        if (players != null)
            this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(int index){
        if (index >= 0 && index < players.size())
            return players.get(index);
        else return null;
    }

    public int getSize(){
        return players.size();
    }

    public void clear(){
        players.clear();
    }

}
