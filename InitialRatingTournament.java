
package tabletennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InitialRatingTournament implements ActionListener{
    
    public JFrame jframe;
    
    public JPanel InitialRatingTournament;
    
    public JLabel IRT;
    
    public JButton Back;

    public InitialRatingTournament() {
        jframe = new JFrame("INITIAL RATING TOURNAMENT");
        jframe.setVisible(true);
        jframe.setSize(800, 800);
        jframe.setLocation(TableTennis.tabletennis.screenX, TableTennis.tabletennis.screenY);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        InitialRatingTournament = new JPanel();
        InitialRatingTournament.setBackground(Color.GRAY);
        InitialRatingTournament.setLayout(null);
        
        Font headerFont = new Font("helvetica", Font.PLAIN, 30);
        Font buttonFont = new Font("helvetica", Font.PLAIN, 20);
        
        IRT = new JLabel("KNOCKOUT TOURNAMENT");
        IRT.setFont(headerFont);
        IRT.setBounds(200, 50, 400, 150);
        
        Back = new JButton("BACK");
        Back.setFont(buttonFont);
        Back.setBounds(50, 50, 150, 50);
        Back.addActionListener(this);
        
        InitialRatingTournament.add(IRT);
        InitialRatingTournament.add(Back);
        
        jframe.add(InitialRatingTournament);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back){
            new Tournament();
            jframe.setVisible(false);
            jframe.remove(InitialRatingTournament);
        }
        
    }
    
}
