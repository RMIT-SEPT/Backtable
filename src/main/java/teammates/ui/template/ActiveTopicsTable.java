
/**
 * Template for the topics table used on discussion board
 */
package teammates.ui.template;

import java.util.ArrayList;
import java.util.List;

public class ActiveTopicsTable {
    private List<ActiveTopicsTableRow> rows;

    public ActiveTopicsTable() {
        rows = new ArrayList<>();
    }

    public List<ActiveTopicsTableRow> getRows() {
        return rows;
    }

    public void setRows(List<ActiveTopicsTableRow> rows) {
        this.rows = rows;
    }
}


