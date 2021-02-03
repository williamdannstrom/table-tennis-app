
package tabletennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoxTournament implements ActionListener{
    
    public JFrame jframe;
    
    public JPanel BoxTournament;
    
    public JLabel BT;
    
    public JButton Back;

    public BoxTournament() {
        jframe = new JFrame("BOX TOURNAMENT");
        jframe.setVisible(true);
        jframe.setSize(800, 800);
        jframe.setLocation(TableTennis.tabletennis.screenX, TableTennis.tabletennis.screenY);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BoxTournament = new JPanel();
        BoxTournament.setBackground(Color.GRAY);
        BoxTournament.setLayout(null);
        
        Font headerFont = new Font("helvetica", Font.PLAIN, 30);
        Font buttonFont = new Font("helvetica", Font.PLAIN, 20);
        
        BT = new JLabel("BOX TOURNAMENT");
        BT.setFont(headerFont);
        BT.setBounds(250, 50, 400, 150);
        
        Back = new JButton("BACK");
        Back.setFont(buttonFont);
        Back.setBounds(50, 50, 150, 50);
        Back.addActionListener(this);
        
        BoxTournament.add(BT);
        BoxTournament.add(Back);
        
        jframe.add(BoxTournament);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back){
            new Tournament();
            jframe.setVisible(false);
            jframe.remove(BoxTournament);
        }
    }
    
}
