package ppvis.util;

import java.util.ArrayList;
import java.util.List;

public class Logic {
    public List<Player> getInfo() {
        return info;
    }

    private List<Player> info;
    private List<Player> infoOnScreen;
    private int countOfPlayerOnScreen;
    private int page;
    private int pages;


    Logic(){
        info = new ArrayList<>();
        infoOnScreen = new ArrayList<>();
        countOfPlayerOnScreen = 3;
        page = 1;
        update();
    }

    public void addPlayer(Player player){
        info.add(player);
        update();
    }

    public void delPlayer(Player player){
        if (info.contains(player))
            info.remove(player);
        update();
    }

    private void updatePages(){
        pages = info.size() / countOfPlayerOnScreen;
    }

    private void updateInfoOnScreen(){
        int start = (page - 1)*countOfPlayerOnScreen;
        int finish = 0;
        if (info.size() >= page*countOfPlayerOnScreen){
            finish = page*countOfPlayerOnScreen;
        } else {
            finish = info.size();
        }
        //infoOnScreen = info.subList(start, finish);
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