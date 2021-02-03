
package tabletennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerStatistics implements ActionListener{

    
    public JFrame jframe;
    
    public JPanel PlayerStatistics;
    
    public JLabel PS;
    
    public JButton MM;
    
    public int playerNum;
    
    public int playerNum2;
    
    JLabel[][]name = new JLabel[4][33];
    
    String[]Names = new String[33];
    
    public Scanner scanNames;
    
    public String currentName;
    
    
    public PlayerStatistics() {
        

        
        jframe = new JFrame("PLAYER STATISTICS");
        jframe.setVisible(true);
        jframe.setSize(800, 800);
        jframe.setLocation(TableTennis.tabletennis.screenX, TableTennis.tabletennis.screenY);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        PlayerStatistics = new JPanel();
        PlayerStatistics.setBackground(Color.GRAY);
        PlayerStatistics.setLayout(null);
        
        
        Font headerFont = new Font("helvetica", Font.PLAIN, 30);
        Font buttonFont = new Font("helvetica", Font.PLAIN, 20);
        
        PS = new JLabel("PLAYER STATISTICS");
        PS.setFont(headerFont);
        PS.setBounds(250, 25, 300, 150);
        
        JLabel Names = new JLabel("NAMES:");
        Names.setFont(buttonFont);
        Names.setBounds(100, 100, 100, 20);
       
        MM = new JButton("MAIN MENU");
        MM.setFont(buttonFont);
        MM.setBounds(50, 40, 150, 50);
        MM.addActionListener(this);
        
        initialize();
        
        PlayerStatistics.add(PS);
        PlayerStatistics.add(MM);
        PlayerStatistics.add(Names);
        
        jframe.add(PlayerStatistics);
    }
    
    private void initialize(){
        
                try {
                        File ListOfNames = new File("ListOfNames.txt");
                        scanNames = new Scanner(ListOfNames);
                        for (int t = 1; t < 33; t++){
                            if(scanNames.hasNextLine()){
                            Names[t] = scanNames.nextLine();
                            }
                            else{
                                Names[t] = "";
                            }
                        }
                } catch (FileNotFoundException ex) {
                }
        
        for (int i = 1; i < 2; i++){
            for (int j = 1; j <= 32; j++){

                playerNum = i;
                playerNum2 = j;
                
                name[i][j] = new JLabel(Names[j]);
                name[i][j].setBounds(100, 100 + (j * 20), 100, 20);
                name[i][j].setVisible(true);
                PlayerStatistics.add(name[playerNum][playerNum2]);
            }
        }
}



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == MM){
            new TableTennis();
            jframe.setVisible(false);
            jframe.remove(PlayerStatistics);
        }
    }
    
}
