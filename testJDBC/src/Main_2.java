import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main_2 extends JFrame{
    public static Connection c = null;
    private JPanel panel1;
    private JButton butt_search;
    private JButton butt_edit;

    public Main_2(){
        setContentPane(panel1);
        this.setSize(600,600);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dreamhouse", "sagues", "1234");
            System.out.println("Connexió OK");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        butt_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search searchForm = new Search(c);
                searchForm.pack();
                searchForm.setSize(200,200);
                searchForm.setVisible(true);
            }
        });
        butt_edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Insert insertForm = new Insert(c);
                insertForm.pack();
                insertForm.setSize(200,200);
                insertForm.setVisible(true);
            }
        });
    }
    public static void main (String[] args){
        Main_2 main = new Main_2();
        main.setVisible(true);
    }
}


