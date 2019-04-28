package ppvis.util.view;

import ppvis.util.model.Constants;
import ppvis.util.model.Player;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class JTableModel extends AbstractTableModel {
    public static final int COL_NAME = 0;
    public static final int DATE_OF_BIRTH = 1;
    public static final int TEAM_NAME = 2;
    public static final int CITY = 3;
    public static final int ROLE_IN_TEAM = 4;
    public static final int POSITION = 5;

    private java.util.List<Player> players;

    JTableModel(List<Player> players){
        this.players = players;
    }

    @Override
    public String getColumnName(int col){
        return Constants.header[col];
    }
    @Override
    public int getRowCount() {
        return players.size();
    }

    @Override
    public int getColumnCount() {
        return Constants.COUNT_OF_FIELDS;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Player p = players.get(row);
        switch (col){
            case COL_NAME:
                return p.getName();
            case DATE_OF_BIRTH:
                return p.getDateOfBirthBeautiful();
            case TEAM_NAME:
                return p.getTeamName();
            case CITY:
                return p.getCity();
            case ROLE_IN_TEAM:
                return p.getRoleInTeam();
            case POSITION:
                return p.getPosition();
            default:
                return null;
        }
    }
}
