package userInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * This class represents the content of the VoteResultPanel. It contains a table with the results of the voting.
 * 
 * @version 1.0
 * @since 1.3.2024
 * @author Šimon Vinkler
 */
public class VoteResult extends JPanel implements TableUI{
    private JButton newGame = new JButton("New game!");
    private JTable table;
    private DefaultTableModel model;

    /**
     * Constructor of the VoteResult class. It initializes the content of the panel.
     */
    public VoteResult(){
        this.setLayout(new BorderLayout(25,1));
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
        this.newGame.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.newGame, BorderLayout.SOUTH);
    }

    /**
     * This method returns the instance of the new game button.
     * 
     * @return JButton newGame
     */
    public JButton getNewGame(){
        return this.newGame;
    }

    /**
     * This method overrides the method from the TableUI interface. It returns the instance of the table.
     * 
     * @return JTable instance of the table
     */
    @Override
    public JTable getTable(){
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
