package java.by.util;

import java.util.ArrayList;
import java.util.List;

public class ViewInfoPerPage {
    private List<Player> info;
    private List<Player> infoOnScreen;
    private int countOfPlayerOnScreen;
    private int page;
    private int pages;


    ViewInfoPerPage(){
        info = new ArrayList<>();
        //infoOnScreen = new ArrayList<>();
        countOfPlayerOnScreen = 25;
        page = 1;
        updatePages();
        updateInfoOnScreen();
    }

    public void addPlayer(Player player){
        info.add(player);
        updatePages();
    }

    public void delPlayer(Player player){
        if (info.contains(player))
            info.remove(player);
        updatePages();
    }

    private void updatePages(){
        pages = info.size() / countOfPlayerOnScreen;
    }

    private void updateInfoOnScreen(){
        infoOnScreen = info.subList((page - 1)* countOfPlayerOnScreen, page * countOfPlayerOnScreen);
    }

    //For XML files
    public void setInfo(List<Player> info) {
        this.info = info;
        page = 1;
        updatePages();
        updateInfoOnScreen();

    }

    public void setCountOfPlayerOnScreen(int countOfPlayerOnScreen) {
        if (countOfPlayerOnScreen >= 0)
            this.countOfPlayerOnScreen = countOfPlayerOnScreen;
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
