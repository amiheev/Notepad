import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexey on 23.10.2015.
 */
public class NotepadTable extends DefaultTableModel {
    JFrame frame = new JFrame("Notepad");

    NotepadModel etm = new NotepadModel();
    JTable employees = new JTable(etm);
    JScrollPane  employeesScroolPane = new JScrollPane(employees);

    JTextField searchContext = new JTextField(10);
    JButton find = new JButton("find");

    JTextField record = new JTextField(10);
    JButton add = new JButton("ADD");

    public void setFrameParam(){
        frame.setSize(new Dimension(600,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        frame.add(employeesScroolPane, new GridBagConstraints(0,0,2,1,1,1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1,1,1,1), 0,0));

        frame.add(searchContext, new GridBagConstraints(1,1,1,1,1,1, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(1,1,1,1), 0,0));
        frame.add(find, new GridBagConstraints(1,2,1,1,1,1, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(1,1,1,1), 0,0));
        frame.add(record, new GridBagConstraints(GridBagConstraints.RELATIVE,GridBagConstraints.RELATIVE,1,1,1,1, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(1,1,1,1), 0,0));
        frame.add(add, new GridBagConstraints(GridBagConstraints.RELATIVE,GridBagConstraints.RELATIVE,1,1,1,1, GridBagConstraints.NORTH, GridBagConstraints.NONE, new Insets(1,1,1,1), 0,0));


        find.addActionListener(new FindButtonActionListener());
        add.addActionListener(new AddButtonActionListner());

        frame.setVisible(true);
        frame.pack();

    }

    public void AddScrool(){
        employeesScroolPane.setPreferredSize(new Dimension(400, 400));
    }

    class FindButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            TableRowSorter sorter = new TableRowSorter(etm);
            employees.setRowSorter(sorter);
            String text = searchContext.getText();
            if (text.length() == 0) {
                sorter.setRowFilter(null);
            } else {
                sorter.setRowFilter(RowFilter.regexFilter(text, 0));
            }

        }
    }

    class AddButtonActionListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            etm.addData(record.getText());
            etm.fireTableDataChanged();
            

        }
    }




}









