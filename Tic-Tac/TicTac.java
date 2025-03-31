import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class TicTac {
    int BorderWidth=600;
    int BorderHeight=650;

    JFrame frame=new JFrame("Aplicatie");
    JLabel label=new JLabel();
    JPanel panel=new JPanel();
    JPanel board=new JPanel();
    String player1="X";
    String player2="O";
    boolean win=false;
    ImageIcon imaginefundal=new ImageIcon("stele.jpeg");
    
    String currentPlayer=player1;
    JButton [][] buttons=new JButton[3][3];
   



    public TicTac(){
        frame.setSize(BorderWidth,BorderHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        label.setText("Tic Tac Toe");
        label.setOpaque(true);
        label.setFont(new Font( "Arial", Font.BOLD, 50));
        label.setBackground(Color.darkGray);
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        
        panel.setLayout(new BorderLayout());
        panel.add(label);
        frame.add(panel,BorderLayout.NORTH);
        board.setLayout(new GridLayout(3,3));
        board.setBackground(Color.darkGray);
        board.setVisible(true);
        frame.add(board,BorderLayout.CENTER);

     for(int r=0;r<3;r++){
        for(int c=0;c<3;c++){
            buttons[r][c]=new JButton();
            buttons[r][c].setBackground(Color.white);
            board.add(buttons[r][c]);
            buttons[r][c].addActionListener((ActionEvent e)->{
                JButton b=(JButton)e.getSource();
                if(b.getText().equals("")){
                    b.setText(currentPlayer);
                    currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
                    b.setFont(new Font("Arial",Font.BOLD,100));
                    checkwin();
                    
                    
                    

                    
                     
                      
                }
                else{
                    if(currentPlayer.equals(player1)){
                        currentPlayer=player2;
                    }
                    else{
                        currentPlayer=player1;
                    }
                }
        });
        }
        frame.add(board,BorderLayout.CENTER);
    board.setVisible(true); 
    frame.setVisible(true);   
    }   
}

 public void checkwin(){
        {
            if(!buttons[0][0].getText().equals("") &&buttons[0][0].getText().equals(buttons[0][1].getText()) && buttons[0][1].getText().equals(buttons[0][2].getText()))
            {
                label.setText(buttons[0][0].getText() + " wins ");
            label.setForeground(Color.GREEN);
                disablebuttons();
               
        }

                
        else if(!buttons[1][0].getText().equals("") &&buttons[1][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[1][2].getText()))
        {
            label.setText(buttons[1][0].getText() + " wins ");
            label.setForeground(Color.GREEN);
            disablebuttons();
            
        }
         
            
        
        else if(!buttons[2][0].getText().equals("") &&buttons[2][0].getText().equals(buttons[2][1].getText()) && buttons[2][1].getText().equals(buttons[2][2].getText()))
        {
            label.setText(buttons[2][0].getText() + " wins ");
            label.setForeground(Color.GREEN);
            disablebuttons();
            
        }
        else if(!buttons[0][0].getText().equals("") &&buttons[0][0].getText().equals(buttons[1][0].getText()) && buttons[1][0].getText().equals(buttons[2][0].getText()))
        {
            label.setText(buttons[0][0].getText() + " wins ");
            label.setForeground(Color.GREEN);
            disablebuttons();
           
        }
        else if(!buttons[0][1].getText().equals("") &&buttons[0][1].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][1].getText()))
        {
            label.setText(buttons[0][1].getText() + " wins ");
            label.setForeground(Color.GREEN);
            disablebuttons();
            
        }
        else if(!buttons[0][2].getText().equals("") &&buttons[0][2].getText().equals(buttons[1][2].getText()) && buttons[1][2].getText().equals(buttons[2][2].getText()))
        {
            label.setText(buttons[0][2].getText() + " wins ");
            label.setForeground(Color.GREEN);
            disablebuttons();
            ;
        }
        else if(!buttons[0][0].getText().equals("") &&buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()))
        {
            label.setText(buttons[0][0].getText() + " wins ");
            label.setForeground(Color.GREEN);
            disablebuttons();
           
        }
    }
    

    }
    public void disablebuttons() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c].setEnabled(false);
                
            }
        }
    }
    



}