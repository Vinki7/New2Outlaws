package userInterface;

import javax.swing.*;

/**
 * This interface represents the content of the TablePanel. It contains a table with data.
 * 
 * @version 1.0
 * @since 1.3.2024
 * @author Šimon Vinkler
 */
public interface TableUI {
    /**
     * This method returns instance of the table.
     * 
     * @return the table
     */
    JTable getTable();

    /**
     * This method sets the table with the given content.
     * 
     * @param tableHead the head of the table
     * @param tableContent the content of the table
     */
    void setTable(String[] tableHead, Object[][] tableContent);
}
