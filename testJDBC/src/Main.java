import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main extends JFrame {
    public static Connection c = null;
    private JPanel contentPane;
    private JButton butt_con;
    private JButton butt_insert;

    public Main(){
        setContentPane(contentPane);
        this.setSize(600,600);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        butt_con.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Class.forName("org.postgresql.Driver");
                    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dreamhouse", "sagues", "1234");
                    System.out.println("Connexió OK");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());

                }
            }
        });
        butt_insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Insert insertForm = new Insert(c);
                insertForm.pack();
                insertForm.setSize(400,400);
                insertForm.setVisible(true);
            }
        });
    }
    public static void main (String[] args){
        Main main = new Main();
        main.setVisible(true);
    }
}
