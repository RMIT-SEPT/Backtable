package teammates.ui.template;

import java.util.ArrayList;
import java.util.List;

public class ArchivedTopicsTable {
    private List<ArchivedTopicsTableRow> rows;

    public ArchivedTopicsTable() {
        rows = new ArrayList<>();
    }

    public List<ArchivedTopicsTableRow> getRows() {
        return rows;
    }

    public void setRows(List<ArchivedTopicsTableRow> rows) {
        this.rows = rows;
    }
}
