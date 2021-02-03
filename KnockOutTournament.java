
package tabletennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KnockOutTournament implements ActionListener, KeyListener{
    
    
    public JFrame jframe;
    public JFrame infoFrame;

    
    public JLabel KOT;
    public JLabel infoLabel;
    public JLabel NOP;
    public JLabel error;
    public JLabel inputNames;
    public JLabel inputNames2;
    public JLabel score;
    public JLabel scoreSubmitted;
    public JLabel errorMessage;
    public JLabel winner;
    JLabel[][] BI= new JLabel[2][16];
    JLabel[][] nextPlayer = new JLabel[2][17];
    JLabel[][] nextPlayer2 = new JLabel[2][9];
    JLabel[][] nextPlayer3 = new JLabel[2][5];
    JLabel[][] nextPlayer4 = new JLabel[2][3];
    JLabel[][] nextPlayer5 = new JLabel[2][2];
    
    
    public JLabel test;
    
    public JButton Back;
    public JButton submit;
    JButton[][]button = new JButton[4][17];
    JButton[][]button2 = new JButton[2][9];
    JButton[][]button3 = new JButton[2][5];
    JButton[][]button4 = new JButton[2][3];
    JButton[][]button5 = new JButton[2][2];
    public JButton InfoButton;
    
    
    public JPanel KnockOutTournament;
    
    
    public JTextField Players;
    public JTextField scoreInput;
    public JTextField scoreInput2;
    JTextField[][]name = new JTextField[4][33];
    
    //global variables for winners
    public int NumberOfPlayers = 0;
    public int playerNum;
    public int playerNum2;
    public int buttonNum;
    public int buttonNum2;
    public int nameAtButton1;
    public int nameAtButton2;
    public int ListNumber;
    public int BInum;
    public int BInum2;
    public int ResultsPlayer1;
    public int ResultsPlayer2;
    public int BI1 = 0;
    public int pairNr;
    public int addedPlayers = 0;
    public int addedPlayersR2= 0;
    public int addedPlayersR3= 0;
    public int addedPlayersR4 = 0;
    public int hasBeenChecked = 0;
    public int hasBeenChecked2 = 0;
    public int roundNr = 0;

    
    
    public static String TemporaryName;
    public String player1;
    public String player2;
    public String thisName;
    public String thisName2;
    public String p1;
    public String p2;
    public String[]playerR3 = new String[8];
    
    public KnockOutTournament() {
        
        jframe = new JFrame("KNOCKOUT TOURNAMENT");
        jframe.setVisible(true);
        jframe.setSize(800, 800);
        jframe.setLocation(TableTennis.tabletennis.screenX, TableTennis.tabletennis.screenY);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        KnockOutTournament = new JPanel();
        KnockOutTournament.setBackground(Color.GRAY);
        KnockOutTournament.setLayout(null);
        
        Font headerFont = new Font("helvetica", Font.PLAIN, 30);
        Font buttonFont = new Font("helvetica", Font.PLAIN, 20);
        Font textFont = new Font("helvetica", Font.PLAIN, 15);
        
        KOT = new JLabel("KNOCKOUT TOURNAMENT");
        KOT.setFont(headerFont);
        KOT.setBounds(200, 50, 400, 150);
        
        Back = new JButton("BACK");
        Back.setFont(buttonFont);
        Back.setBounds(50, 50, 150, 50);
        Back.addActionListener(this);
        
        NOP = new JLabel("CHOOSE NUMBER OF PLAYERS");
        NOP.setFont(textFont);
        NOP.setBounds(450, 700, 275, 50);
        
        Players = new JTextField(2);
        Players.setBounds(700, 700, 50, 50);
        Players.addKeyListener(this);
        
        InfoButton = new JButton("information");
        InfoButton.setFont(buttonFont);
        InfoButton.setBounds(10, 10, 120, 20);
        InfoButton.setVisible(true);
        InfoButton.addActionListener(this);
        KnockOutTournament.add(InfoButton);
        
        scoreInput = new JTextField(2);
        scoreInput.setBounds(550, 150, 100, 20);
        scoreInput.setVisible(false);
        scoreInput.addActionListener(this);
        KnockOutTournament.add(scoreInput);
            
        scoreInput2 = new JTextField(2);
        scoreInput2.setBounds(550, 170, 100, 20);
        scoreInput2.setVisible(false);
        scoreInput2.addActionListener(this);
        KnockOutTournament.add(scoreInput2);
        
        score = new JLabel("SCORE:");
        score.setVisible(false);
        score.setBounds(600, 130, 100, 20);
        score.setFont(buttonFont);
        KnockOutTournament.add(score);
        
        infoLabel = new JLabel("press blue button after submit");
        infoLabel.setFont(textFont);
        infoLabel.setBounds(10, 100, 200, 20);
        infoLabel.setVisible(false);
        KnockOutTournament.add(infoLabel);
        
        errorMessage = new JLabel("choose a value less than 11");
        errorMessage.setVisible(false);
        errorMessage.setBounds(550, 190, 250, 20);
        errorMessage.setFont(textFont);
        KnockOutTournament.add(errorMessage);
        
        submit = new JButton("SUBMIT");
        submit.setVisible(false);
        submit.setBounds(650, 150, 100, 40);
        submit.addActionListener(this);
        KnockOutTournament.add(submit);
        
        scoreSubmitted = new JLabel("score is submitted");
        scoreSubmitted.setVisible(false);
        scoreSubmitted.setBounds(550, 190, 200, 20);
        scoreSubmitted.setFont(buttonFont);
        KnockOutTournament.add(scoreSubmitted);
        
        winner = new JLabel("WON THE GAME");
        
        error = new JLabel("PLEASE ENTER A NUMBER BETWEEN 8 - 32");
        error.setBounds(450, 750, 335, 25);
        error.setFont(textFont);
        error.setVisible(false);
        
        initialize();

        KnockOutTournament.add(KOT);
        KnockOutTournament.add(Back);
        KnockOutTournament.add(NOP);
        KnockOutTournament.add(Players);
        KnockOutTournament.add(error);

        jframe.add(KnockOutTournament);
    }
    
        private void addPlayers() {
            if(NumberOfPlayers == 8){
                BI1 = 0;
            }
            if (NumberOfPlayers > 8 && NumberOfPlayers < 17){
                BI1 = 16 - NumberOfPlayers;
            }
            if (NumberOfPlayers > 16 && NumberOfPlayers < 33){
                BI1 = 32 - NumberOfPlayers;
            }
            NumberOfPlayers = (NumberOfPlayers + BI1);
            
            for (int addPlayers = 1; addPlayers <= NumberOfPlayers; addPlayers++){
                for (int i = 1; i <= BI1; i++){
                    BI[BInum][i].setVisible(true);
                }
                for (int j = 1; j <= (BI1 * 2); j++){
                    int vis = 0;
                    vis = vis + j;
                    if (vis % 2 == 0){
                    name[playerNum][j].setVisible(false);
                    }
                    else{
                        name[playerNum][j].setVisible(true);
                    }
                    
                }
                for (int k = 1; k <= NumberOfPlayers; k++){
                    int skip = (BI1 * 2);
                    if (!(k <= skip)){
                        name[playerNum][k].setVisible(true);
                    }
                    
                }
                
            }
            
            for (int addButtons = 1; addButtons <= (NumberOfPlayers / 2); addButtons++){
                int skip = BI1;
                if (!(addButtons <= skip)){
                    button[buttonNum][addButtons].setVisible(true);
                    }
            }
    }
        
        private void initialize(){
            for (int i = 1; i < 2; i++){
                for (int j = 1; j <= 32; j++){
                    playerNum = i;
                    playerNum2 = j;
                    name[i][j] = new JTextField(2);
                    name[i][j].setBounds(20, 100 + (j * 20), 100, 20);
                    name[i][j].setVisible(false);
                    name[i][j].addActionListener(this);
                    KnockOutTournament.add(name[playerNum][playerNum2]);  
                }
            }
            for (int i = 1; i < 2; i++){
                    for (int l = 1; l <= 16; l++){
                    buttonNum = i;
                    buttonNum2 = l;
                    Color buttonColor = new Color(0, 162, 255);
                    button[i][l] = new JButton("");
                    button[i][l].setBackground(buttonColor);
                    button[i][l].setOpaque(true);
                    button[i][l].setBorderPainted(false);
                    button[i][l].setBounds(120, 90 + (l * 40), 20, 20);
                    button[i][l].setVisible(false);
                    button[i][l].addActionListener(this);
                    KnockOutTournament.add(button[i][l]);
                }
            }
            for (int i = 1; i < 2; i++){
                    for (int l = 1; l <= 15; l++){
                        BInum = i;
                        BInum2 = l;
                        BI[i][l] = new JLabel("BI");
                        BI[i][l].setBounds(20, 100 + (l * 40), 100, 20);
                        BI[i][l].setVisible(false);
                        KnockOutTournament.add(BI[BInum][BInum2]);
                        

                    }
                    for (int g = 1; g <= 8; g++){
                        Color buttonColor = new Color(0, 162, 255);
                        button2[i][g] = new JButton("");
                        button2[i][g].setBackground(buttonColor);
                        button2[i][g].setOpaque(true);
                        button2[i][g].setBorderPainted(false);
                        button2[i][g].setBounds(220, 70 + (g * 80), 20, 20);
                        button2[i][g].setVisible(false);
                        button2[i][g].addActionListener(this);
                        KnockOutTournament.add(button2[i][g]);
                    }
                    for (int y = 1; y <=4; y++){
                        Color buttonColor = new Color(0, 162, 255);
                        button3[i][y] = new JButton("");
                        button3[i][y].setBackground(buttonColor);
                        button3[i][y].setOpaque(true);
                        button3[i][y].setBorderPainted(false);
                        button3[i][y].setBounds(320, 30 + (y * 160), 20, 20);
                        button3[i][y].setVisible(false);
                        button3[i][y].addActionListener(this);
                        KnockOutTournament.add(button3[i][y]);
                    }
                    for(int y = 1; y <= 2; y++){
                        Color buttonColor = new Color(0, 162, 255);
                        button4[i][y] = new JButton("");
                        button4[i][y].setBackground(buttonColor);
                        button4[i][y].setOpaque(true);
                        button4[i][y].setBorderPainted(false);
                        button4[i][y].setBounds(420, -50 + (y * 320), 20, 20);
                        button4[i][y].setVisible(false);
                        button4[i][y].addActionListener(this);
                        KnockOutTournament.add(button4[i][y]);
                    }
                    Color buttonColor = new Color(0, 162, 255);
                        button5[1][1] = new JButton("");
                        button5[1][1].setBackground(buttonColor);
                        button5[1][1].setOpaque(true);
                        button5[1][1].setBorderPainted(false);
                        button5[1][1].setBounds(520, 430, 20, 20);
                        button5[1][1].setVisible(false);
                        button5[1][1].addActionListener(this);
                        KnockOutTournament.add(button5[1][1]);
            }
            
        }
        
        
        
        

    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == InfoButton){
            infoFrame = new JFrame("INFORMATION");
            infoFrame.setVisible(true);
            infoFrame.setSize(400, 400);
            infoFrame.setLocation(320, 0);
            
            JPanel infoPanel = new JPanel();
            infoPanel.setBackground(Color.DARK_GRAY);
            infoPanel.setLayout(null);
            
            Font infoFont = new Font("helvetica", Font.PLAIN, 20);
            
            JLabel infoLabel = new JLabel("<html>How the game works:<br>The user can input a number of players between 8 and 32. Enter a name in the provided spaces. Once a pair of players have been entered, press the blue button next to the names. The computer will substitute the amount of missing players with a 'BI', so that the correct numbers of players can go to round 2. Once the blue button is pressed, write the results of the game in the provided spaces. <br> The maximum number of points a player can have is 11.</html>");
            infoLabel.setVisible(true);
            infoLabel.setFont(infoFont);
            infoLabel.setForeground(Color.WHITE);
            infoLabel.setBounds(0, 0, 400, 400);
            infoPanel.add(infoLabel);
            
            infoFrame.add(infoPanel);
        }
        
        if (e.getSource() == Back){
            new Tournament();
            jframe.setVisible(false);
            jframe.remove(KnockOutTournament);
        }
        for (int i = 1; i < 2; i++){
                for (int j = 1; j <= 32; j++){
                    if(e.getSource() == name[i][j]){
                        TemporaryName = name[i][j].getText();
                        ListNumber = j;
                        WriteName();
                }
            }
        }

        for (int i = 1; i < 2; i++){
            for (int j = 1; j <= 16; j++){
                if (e.getSource().equals(button[i][j])){
                    roundNr = 1;
                    nameAtButton1 = (j * 2) - 1;
                    nameAtButton2 = j * 2;
                    
                    inputNames();
                    pairNr = j;
                }
            }
        }
        
        for (int i=1; i<2;i++){
            for (int j = 1; j <= 8; j++){
                if (e.getSource().equals(button2[i][j])){
                    roundNr = 2;
                    nameAtButton1 = (j * 2) - 1;
                    nameAtButton2 = j * 2;
                    inputNames();
                    pairNr = j;
                }
            }
        }
        for (int i=1; i<2; i++){
            for(int j=1; j <=4; j++){
                if(e.getSource().equals(button3[i][j])){
                    if(NumberOfPlayers == 8){
                    roundNr = 3;
                    nameAtButton1 = (j * 2) - 1;
                    nameAtButton2 = j * 2;
                    inputNames();
                    pairNr = j;
                    }
                    else{
                    roundNr = 3;
                    nameAtButton1 = (j * 2) - 1;
                    nameAtButton2 = j * 2;
                    inputNames();
                    pairNr = j;
                    }
                }
            }
        }
        for (int i=1; i<2; i++){
            for(int j=1; j <=2; j++){
                if(e.getSource().equals(button4[i][j])){
                    roundNr = 4;
                    nameAtButton1 = (j * 2) - 1;
                    nameAtButton2 = j * 2;
                    inputNames();
                    pairNr = j;
                }
            }
        }
        for (int i=1; i<2; i++){
            int j = 1;
            if(e.getSource().equals(button5[i][j])){
                roundNr = 5;
                nameAtButton1 = (j * 2) - 1;
                nameAtButton2 = j * 2;
                inputNames();
                pairNr = j;
            }
        }
        if(e.getSource() == submit){
                           
            if (scoreInput.getText().length() == 2){
                if((scoreInput.getText().charAt(0) - 48) * 10 + (scoreInput.getText().charAt(1) - 48) > 11){
                    errorMessage.setVisible(true);
                }
                else{
                    ResultsPlayer1 = (scoreInput.getText().charAt(0) - 48) * 10 + (scoreInput.getText().charAt(1) - 48);
                }
            }
            if (scoreInput.getText().length() == 1){
                ResultsPlayer1 = scoreInput.getText().charAt(0) - 48;
            }
            
            if (scoreInput2.getText().length() == 2){
                if((scoreInput2.getText().charAt(0) - 48) * 10 + (scoreInput2.getText().charAt(1) - 48) > 11){
                    errorMessage.setVisible(true);
                }
                else{
                    ResultsPlayer2 = (scoreInput2.getText().charAt(0) - 48) * 10 + (scoreInput2.getText().charAt(1) - 48);
                }
            }
            if (scoreInput2.getText().length() == 1){
                ResultsPlayer2 = scoreInput2.getText().charAt(0) - 48;
            }
            
            
            player1 = thisName;
            player2 = thisName2;
            
            
            
            if(!(errorMessage.isVisible())){
                
               if (!checkIfNameExists(player1)){
                   addName(player1);
               }
               if (!checkIfNameExists(player2)){
                   addName(player2);
               }
                addScoresToFile(player1, ResultsPlayer1, player2, ResultsPlayer2);
                CheckScores();
            }  
        } 
    }
    

    private void inputNames() {
        scoreInput.setVisible(true);
        scoreInput2.setVisible(true);

        if (inputNames != null) inputNames.setVisible(false);
        if (inputNames2 != null) inputNames2.setVisible(false);

        submit.setVisible(true);
        score.setVisible(true);
        infoLabel.setVisible(true);

        if (roundNr == 1){
            thisName = name[1][nameAtButton1].getText();
            thisName2 = name[1][nameAtButton2].getText();

            inputNames = new JLabel(thisName);
            inputNames.setVisible(true);
            inputNames.setBounds(470, 150, 100, 20);
            KnockOutTournament.add(inputNames);

            inputNames2 = new JLabel(thisName2);
            inputNames2.setVisible(true);
            inputNames2.setBounds(470, 170, 100, 20);
            KnockOutTournament.add(inputNames2);
        }

        if (roundNr == 2){
            if(pairNr%2 == 1){
                pairNr = pairNr + 1;
            }
            thisName = nextPlayer[1][nameAtButton1].getText();
            thisName2 = nextPlayer[1][nameAtButton2].getText();

            inputNames = new JLabel(thisName);    
            inputNames.setVisible(true);
            inputNames.setBounds(470, 150, 100, 20);
            KnockOutTournament.add(inputNames);

            inputNames2 = new JLabel(thisName2);
            inputNames2.setVisible(true);
            inputNames2.setBounds(470, 170, 100, 20);
            KnockOutTournament.add(inputNames2);
        }
        if (roundNr == 3){
            if(pairNr%2 == 1){
                pairNr = pairNr + 1;
            }
            thisName = nextPlayer2[1][nameAtButton1].getText();
            thisName2 = nextPlayer2[1][nameAtButton2].getText();

            inputNames = new JLabel(thisName);
            inputNames.setVisible(true);
            inputNames.setBounds(470, 150, 100, 20);
            KnockOutTournament.add(inputNames);

            inputNames2 = new JLabel(thisName2);
            inputNames2.setVisible(true);
            inputNames2.setBounds(470, 170, 100, 20);
            KnockOutTournament.add(inputNames2);
        }
        if (roundNr == 4){
            if(pairNr%2 == 1){
                pairNr = pairNr + 1;
            }
            thisName = nextPlayer3[1][nameAtButton1].getText();
            thisName2 = nextPlayer3[1][nameAtButton2].getText();

            inputNames = new JLabel(thisName);
            inputNames.setVisible(true);
            inputNames.setBounds(470, 150, 100, 20);
            KnockOutTournament.add(inputNames);

            inputNames2 = new JLabel(thisName2);
            inputNames2.setVisible(true);
            inputNames2.setBounds(470, 170, 100, 20);
            KnockOutTournament.add(inputNames2);
        }
        if (roundNr == 5){
            if(pairNr%2 == 1){
                pairNr = pairNr + 1;
            }
            thisName = nextPlayer4[1][nameAtButton1].getText();
            thisName2 = nextPlayer4[1][nameAtButton2].getText();

            inputNames = new JLabel(thisName);
            inputNames.setVisible(true);
            inputNames.setBounds(470, 150, 100, 20);
            KnockOutTournament.add(inputNames);

            inputNames2 = new JLabel(thisName2);
            inputNames2.setVisible(true);
            inputNames2.setBounds(470, 170, 100, 20);
            KnockOutTournament.add(inputNames2);
        }
    }
        
    private boolean checkIfNameExists(String name){
        File result = new File("Results1.txt");
        try {
            Scanner read = new Scanner(result);
            while (read.hasNextLine()) {
                String here = read.next();
                if (here.equals(name)) {
                    return true;
                }
            }
        }
        catch (FileNotFoundException e) {
            //
        }
        return false;

    }

    private void addName(String name) {

        File result = new File("Results1.txt");

        ArrayList<String> list = new ArrayList<String>();

        try {
          Scanner myReader = new Scanner(result);
          String currName = "!null";
          while (myReader.hasNextLine()) {
            String curr = myReader.next();
            list.add(curr);
          }
        } catch (FileNotFoundException e) {
          // 
        }

        list.add(name);

        String resultString = list.get(0);

        for (int i=1; i<list.size(); i++) {
          String currItem = list.get(i);
          if (Character.isDigit(currItem.charAt(0))) {
            resultString = resultString + " " + currItem;
          }
          else {
            resultString = resultString + "\n" + currItem;
          }
        }

        try {
          FileWriter myWriter = new FileWriter("Results1.txt");
          myWriter.write(resultString);
          myWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

    }

        
    private void addScoresToFile(String player1, int ResultsPlayer1, String player2, int ResultsPlayer2) {
        scoreSubmitted.setVisible(true);
        File result = new File("Results1.txt");
        ArrayList<String> list = new ArrayList<String>();
        try {
          Scanner myReader = new Scanner(result);
          String currName = "!null";
          while (myReader.hasNextLine()) {
            String curr = myReader.next();
            if (Character.isDigit(curr.charAt(0))) {
                list.add(curr);
            }
            else {



                if (currName.equals(player1)) {
                // add score1 here
                    list.add(Integer.toString(ResultsPlayer1));
                }
                else if (currName.equals(player2)) {
                // add score2 here
                    list.add(Integer.toString(ResultsPlayer2));
                }

                currName = curr;
                list.add(curr);
            }
        }
          if (currName.equals(player1)) {
            // add score1 here
            list.add(Integer.toString(ResultsPlayer1));
            }
          else if (currName.equals(player2)) {
            // add score2 here
            list.add(Integer.toString(ResultsPlayer2));
            }
            } catch (FileNotFoundException e) {
          // 
        }

        String resultString = list.get(0);

        for (int i=1; i<list.size(); i++) {
            String currItem = list.get(i);
            if (Character.isDigit(currItem.charAt(0))) {
                resultString = resultString + " " + currItem;
            }
            else {
                resultString = resultString + "\n" + currItem;
            }
        }

        try {
            FileWriter myWriter = new FileWriter("Results1.txt");
            myWriter.write(resultString);
            myWriter.close();
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void CheckScores(){
        if (hasBeenChecked == 0){

            for (int i = 1; i <= BI1; i++){
                nextPlayer[1][i] = new JLabel(name[1][-1 + (i * 2)].getText());
                nextPlayer[1][i].setVisible(true);
                nextPlayer[1][i].setBounds(150, 90 + (i * 40), 100, 20);
                KnockOutTournament.add(nextPlayer[1][i]);
            if (BI1 % 2 == 0){
            for (int j = 1; j <= (BI1 / 2); j++){
                button2[1][j].setVisible(true);
            }
            } else{
                for (int j = 1; j <= (BI1 - 1) / 2; j++){
                    button2[1][j].setVisible(true);
            }
                addedPlayers++;
            }
            hasBeenChecked = 1;
            }
        }

        if(roundNr == 1){

            if(ResultsPlayer1 > ResultsPlayer2){
                nextPlayer[1][pairNr] = new JLabel(player1);
            }
            else{
                nextPlayer[1][pairNr] = new JLabel(player2);
            }

            nextPlayer[1][pairNr].setVisible(true);
            nextPlayer[1][pairNr].setBounds(150, 90 + (pairNr * 40), 100, 20);
            KnockOutTournament.add(nextPlayer[1][pairNr]);
            addedPlayers = addedPlayers + 1;

            if (addedPlayers % 2 == 0){
                button2[1][pairNr / 2].setVisible(true);
            }

            ResultsPlayer1 = 0;
            ResultsPlayer2 = 0;
        }
        if(roundNr == 2){

            if(ResultsPlayer1 > ResultsPlayer2){
                nextPlayer2[1][pairNr] = new JLabel(player1);
            }
            else{
                nextPlayer2[1][pairNr] = new JLabel(player2);

            }
            nextPlayer2[1][pairNr].setBounds(250, 70 + (pairNr * 80), 100, 20);
            nextPlayer2[1][pairNr].setVisible(true);
            KnockOutTournament.add(nextPlayer2[1][pairNr]);
            addedPlayersR2 = addedPlayersR2 + 1;

            if (addedPlayersR2 % 2 == 0){
                button3[1][pairNr / 2].setVisible(true);
        }
    }
        if(roundNr == 3){
            if(ResultsPlayer1 > ResultsPlayer2){
                nextPlayer3[1][pairNr] = new JLabel(player1);
            }
            else{
                nextPlayer3[1][pairNr] = new JLabel(player2);
            }
            nextPlayer3[1][pairNr].setBounds(350, 30 + (pairNr * 160), 100, 20);
            nextPlayer3[1][pairNr].setVisible(true);
            KnockOutTournament.add(nextPlayer3[1][pairNr]);
            addedPlayersR3 = addedPlayersR3 + 1;

            if(addedPlayersR3 % 2 == 0){
                button4[1][pairNr / 2].setVisible(true);
            }
            if(NumberOfPlayers == 8){
                winner.setBounds(350, 210, 100, 20);
                winner.setVisible(true);
                KnockOutTournament.add(winner);
            }
        }
        if(roundNr == 4){
            if(ResultsPlayer1 > ResultsPlayer2){
                nextPlayer4[1][pairNr] = new JLabel(player1);
            }
            else{
                nextPlayer4[1][pairNr] = new JLabel(player2);
            }
            nextPlayer4[1][pairNr].setBounds(450, -50 + (pairNr * 320), 100, 20);
            nextPlayer4[1][pairNr].setVisible(true);
            KnockOutTournament.add(nextPlayer4[1][pairNr]);
            addedPlayersR4 = addedPlayersR4 + 1;

            if(addedPlayersR4 % 2 == 0){
                button5[1][pairNr / 2].setVisible(true);
            }
            if(NumberOfPlayers > 8 && NumberOfPlayers < 17){
                winner.setBounds(450, 290, 100, 20);
                winner.setVisible(true);
                KnockOutTournament.add(winner);
            }
        }
        if(roundNr == 5){
            if(ResultsPlayer1 > ResultsPlayer2){
                nextPlayer5[1][pairNr] = new JLabel(player1);
            }
            else{
                nextPlayer5[1][pairNr] = new JLabel(player2);
            }
            nextPlayer5[1][pairNr].setBounds(550, -210 + (pairNr * 640), 100, 20);
            nextPlayer5[1][pairNr].setVisible(true);
            KnockOutTournament.add(nextPlayer5[1][pairNr]);

            if(NumberOfPlayers > 16){
                winner.setBounds(550, 450, 100, 20);
                winner.setVisible(true);
                KnockOutTournament.add(winner);
            }
        }
    }
        
    
    private void WriteName() {
        try {
            File ListOfNames = new File("ListOfNames.txt");
            FileWriter WriteNames = new FileWriter("ListOfNames.txt", true);
            Scanner scanNames = new Scanner(ListOfNames);
            int WriteName = 1;
            while (scanNames.hasNextLine()){
                if (scanNames.nextLine().equals(TemporaryName)){
                    System.out.println("Name is already in the list");
                    WriteName = 0;
                }
            }
            if (WriteName == 1){
                WriteNames.write(TemporaryName + "\n");
                WriteNames.close();
                System.out.println("hello world");
            }
        } catch (IOException ex) {
            System.out.println("something went wrong");
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        char p = e.getKeyChar();
        if (!(Character.isDigit(p) || p == KeyEvent.VK_BACK_SPACE || p == KeyEvent.VK_DELETE)){
            e.consume();
    }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int pressed = e.getKeyCode();
        if (pressed == KeyEvent.VK_ENTER){
            if (Players.getText().length() < 2){
                NumberOfPlayers = (Players.getText().charAt(0) - 48);
                if(NumberOfPlayers <= 7){
                    error.setVisible(true);
                }
                else{
                error.setVisible(false);
                addPlayers();
                }
            }
            else{
                NumberOfPlayers = ((Players.getText().charAt(0) - 48) * 10 + Players.getText().charAt(1) - 48);
                if(NumberOfPlayers > 32){
                    error.setVisible(true);
                }
                else{
                error.setVisible(false);
                addPlayers();
                }
            }
        }
 }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
