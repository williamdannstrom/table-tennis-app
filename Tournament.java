
package tabletennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tournament implements ActionListener{
    
    public JFrame jframe;
    public JPanel Tournament;
    public JLabel NT;
    public JLabel subHeader;
    public JButton KT;
    public JButton IRT;
    public JButton BT;
    public JButton MM;

    public Tournament() {
        
        jframe = new JFrame("NEW TOURNAMENT");
        jframe.setVisible(true);
        jframe.setSize(800, 800);
        jframe.setLocation(TableTennis.tabletennis.screenX, TableTennis.tabletennis.screenY);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Tournament = new JPanel();
        Tournament.setBackground(Color.GRAY);
        Tournament.setLayout(null);
        
        Font headerFont = new Font("helvetica", Font.PLAIN, 30);
        Font buttonFont = new Font("helvetica", Font.PLAIN, 20);
        
        NT = new JLabel("NEW TOURNAMENT");
        NT.setFont(headerFont);
        NT.setBounds(250, 100, 300, 150);
        
        subHeader = new JLabel("SELECT TYPE OF TOURNAMENT");
        subHeader.setFont(buttonFont);
        subHeader.setBounds(250, 200, 370, 50);
        
        KT = new JButton("KNOCKOUT TOURNAMENT");
        KT.setFont(buttonFont);
        KT.setBounds(220, 250, 350, 100);
        KT.addActionListener(this);
        
        IRT = new JButton("INITIAL RATING TOURNAMENT");
        IRT.setFont(buttonFont);
        IRT.setBounds(220, 400, 350, 100);
        IRT.addActionListener(this);
        
        BT = new JButton("BOX TOURNAMENT");
        BT.setFont(buttonFont);
        BT.setBounds(220, 550, 350, 100);
        BT.addActionListener(this);
        
        MM = new JButton("MAIN MENU");
        MM.setFont(buttonFont);
        MM.setBounds(50, 50, 150, 50);
        MM.addActionListener(this);
        
        Tournament.add(NT);
        Tournament.add(subHeader);
        Tournament.add(KT);
        Tournament.add(IRT);
        Tournament.add(BT);
        Tournament.add(MM);
        
        jframe.add(Tournament);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == KT){
            new KnockOutTournament();
            jframe.setVisible(false);
            jframe.remove(Tournament);
        }
        if (e.getSource() == IRT){
            new InitialRatingTournament();
            jframe.setVisible(false);
            jframe.remove(Tournament);
        }
        if (e.getSource() == BT){
            new BoxTournament();
            jframe.setVisible(false);
            jframe.remove(Tournament);
        }
        if (e.getSource() == MM){
            new TableTennis();
            jframe.setVisible(false);
            jframe.remove(Tournament);
        }
    }
    
}
