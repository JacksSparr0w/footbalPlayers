package ppvis.util;

import javax.swing.table.AbstractTableModel;

public class JTableModel extends AbstractTableModel {
    private java.util.List<Player> info;

    JTableModel(Service logic){
        this.info = logic.getInfoOnScreen();
    }

    @Override
    public String getColumnName(int col){
        return Constants.header[col];
    }
    @Override
    public int getRowCount() {
        return info.size();
    }

    @Override
    public int getColumnCount() {
        return Constants.COUNT_OF_FIELDS;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Player p = info.get(row);
        switch (col){
            case 0:
                return p.getName();
            case 1:
                return p.getDateOfBirthBeautiful();
            case 2:
                return p.getTeamName();
            case 3:
                return p.getCity();
            case 4:
                return p.getRoleInTeam();
            case 5:
                return p.getPosition();
            default:
                return null;
        }
    }
}
