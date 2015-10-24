import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alexey on 23.10.2015.
 */
public class NotepadModel extends AbstractTableModel {
    private int columnCount = 2;
    private ArrayList<String[]> dataArrayList;

    public NotepadModel(){
        dataArrayList = new ArrayList<String[]>();
        for (int i = 0; i < dataArrayList.size(); i++) {
            dataArrayList.add(new String[getColumnCount()]);
        }
    }



    public void addData(String[] row) {
        String[] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
    }
    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }

    public String getColumnName(int columnIndex){
        switch (columnIndex) {
            case 0:
                return "Date";
            case 1:
                return "Record";
        }
        return "";
    }

    public void addData(String text) {
        String[] row = {
                dateToString(now(), "dd/MM/yyyy"),
                text};
        addData(row);
    }

    public void addData(String date, String record) {
        String[] row = {
                date,
                record};
        addData(row);
    }

    public static Date now(){
        return new Date();
    }

    public static String dateToString(Date a_date, String a_dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(a_dateFormat);
        return sdf.format(a_date);
    }

}
