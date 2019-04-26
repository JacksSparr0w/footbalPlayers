package ppvis.util;

import ppvis.util.search.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<Player> info;
    private List<Player> infoOnScreen;
    private int countOfPlayerOnScreen;
    private int page;
    private int pages;


    Service(){
        info = new ArrayList<>();
        infoOnScreen = new ArrayList<>();
        countOfPlayerOnScreen = 2;
        page = 1;
        pages = 1;
        update();
    }

    public void addPlayer(Player player){
        info.add(player);
        update();
    }

    public void addPlayer(PlayerDTO playerDto) throws ParseException {
        addPlayer(new Player(playerDto));
    }

    public void delPlayers(List<Player> players){
        for (Player player : players)
            delPlayer(player);
    }

    private void delPlayer(Player player){
        if (info.contains(player))
            info.remove(player);
        update();
    }

    private void updatePages(){
        int temp = info.size() / countOfPlayerOnScreen;
        if (info.size() % countOfPlayerOnScreen == 0)
            pages = temp;
        else
            pages = ++temp;

        if (pages == 0)
            pages++;
    }

    public List<Player> search(Object object) throws ParseException {
        SearchBy searchers[] = new SearchBy[]{new SearchByName(), new SearchByDate(),
                new SearchByTeamName(), new SearchByCity(), new SearchByRole(), new SearchByPosition() };
        List<Player> buf = new ArrayList<>();

        for(Player player : info){
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

    private void updateInfoOnScreen(){
        int start = (page - 1)*countOfPlayerOnScreen;
        int finish;
        if (info.size() >= page*countOfPlayerOnScreen){
            finish = page*countOfPlayerOnScreen;
        } else {
            finish = info.size();
        }
        infoOnScreen.clear();
        for (int i = start; i < finish; i++)
            infoOnScreen.add(info.get(i));

    }

    //For XML files
    public void setInfo(List<Player> info) {
        this.info = info;
        page = 1;
        update();
    }

    public void setCountOfPlayerOnScreen(int countOfPlayerOnScreen) {
        if (countOfPlayerOnScreen >= 0)
            this.countOfPlayerOnScreen = countOfPlayerOnScreen;
        setFirstPage();
        update();

    }

    private void update(){
        updatePages();
        updateInfoOnScreen();
    }

    public void incPage(){
        if (page < pages)
            page++;
        updateInfoOnScreen();
    }

    public void decPage(){
        if (page > 1)
            page--;
        updateInfoOnScreen();
    }

    public void setLastPage(){
        page = pages;
        updateInfoOnScreen();
    }

    public void setFirstPage(){
        page = 1;
        updateInfoOnScreen();
    }

    public List<Player> getInfo() {
        return info;
    }

    public List<Player> getInfoOnScreen() {
        return infoOnScreen;
    }

    public int getCountOfPlayerOnScreen() {
        return countOfPlayerOnScreen;
    }

    public int getPage() {
        return page;
    }

    public int getPages() {
        return pages;
    }
}