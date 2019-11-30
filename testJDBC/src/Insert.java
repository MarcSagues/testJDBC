import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Insert extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField text_city;
    private JTextField text_postcode;
    private JTextField text_branch;
    private JTextField text_street;
    Connection con;
    Statement stmt;

    public Insert(Connection c) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        con = c;

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String newInsertBranch = getDataNewBranch();
        executeUpdate(newInsertBranch);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    // funcions auxiliars
    public String getDataNewBranch(){

        String sql = "INSERT INTO branch (branch_id, street, city, postcode) "

                + "VALUES (" +

                "'" + this.text_branch.getText() + "'"

                + "," +

                "'" + this.text_street.getText() + "'"

                + "," +

                "'" + this.text_city.getText() + "'"

                + "," +

                "'" + this.text_postcode.getText() + "'" +

                ");";

        System.out.println(sql);

        return sql;

    }

    public void executeUpdate(String sql){

        try {

            stmt = con.createStatement();

            stmt.executeUpdate(sql);

            JOptionPane.showMessageDialog(this, "New branch created!", "Status", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e){

            JOptionPane.showMessageDialog(this, e.getMessage(), "Status", JOptionPane.INFORMATION_MESSAGE);

        }
    }

}
