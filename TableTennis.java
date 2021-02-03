
package tabletennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TableTennis implements ActionListener{
    public static TableTennis tabletennis;
    
    public JFrame jframe;
    
    public JPanel App;
    
    public JLabel TTA;
    
    public JButton NewTournament;
    public JButton PlayerStatistics;
    
    public int screenX = 300;
    public int screenY = 0;
  
    
    public TableTennis() {
        
        jframe = new JFrame("Table Tennis App");
        jframe.setVisible(true);
        jframe.setSize(800, 800);
        jframe.setLocation(screenX, screenY);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        App = new JPanel();
        App.setBackground(Color.GRAY);
        App.setLayout(null);
        
        Font headerFont = new Font("helvetica", Font.PLAIN, 30);
        Font buttonFont = new Font("helvetica", Font.PLAIN, 20);
        
        TTA = new JLabel("TABLE TENNIS APP");
        TTA.setFont(headerFont);
        TTA.setBounds(250, 100, 300, 150);
        

        NewTournament = new JButton("NEW TOURNAMENT");
        NewTournament.setFont(buttonFont);
        NewTournament.setBounds(220, 250, 350, 150);
        NewTournament.addActionListener(this);
        
        PlayerStatistics = new JButton("PLAYER STATISTICS");
        PlayerStatistics.setFont(buttonFont);
        PlayerStatistics.setBounds(220, 450, 350, 150);
        PlayerStatistics.addActionListener(this);
        
        App.add(TTA);
        App.add(NewTournament);
        App.add(PlayerStatistics);
        
        jframe.add(App);
    }
    
    public static void main(String[] args) {
        tabletennis = new TableTennis();
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == NewTournament){
            new Tournament();
            jframe.setVisible(false);
            jframe.remove(App);
        }
        if (e.getSource() == PlayerStatistics){
            new PlayerStatistics();
            jframe.setVisible(false);
            jframe.remove(App);
        }
}
}