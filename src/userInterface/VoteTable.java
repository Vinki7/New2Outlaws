package userInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * This class represents the content of the VoteTablePanel. It contains a table with the results of the voting.
 * 
 * @version 1.0
 * @since 1.3.2024
 * @author Šimon Vinkler
 */
public class VoteTable extends JPanel implements TableUI{
    private JTable table;
    private DefaultTableModel model;

    /**
     * Constructor of the VoteTable class. It initializes the content of the panel.
     */
    public VoteTable() {
        this.setLayout(new BorderLayout());
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * This method overrides the method from the TableUI interface. It returns the instance of the table.
     * 
     * @return JTable instance of the table
     */
    @Override
    public JTable getTable() {
        return this.table;
    }

    /**
     * This method overrides the method from the TableUI interface. It sets the table with the given content.
     * 
     * @param tableHead the head of the table
     * @param tableContent the content of the table
     */
    @Override
    public void setTable(String[] tableHead, Object[][] tableContent) {
        model.setDataVector(tableContent, tableHead);
    }
}
