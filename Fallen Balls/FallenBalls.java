import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.Timer;

public class FallenBalls implements ActionListener, KeyListener {


    private class Patratul{
        int x,y;
        Patratul(int x, int y){
            this.x=x;
            this.y=y;

        }
    }

    int lungimeecran=600;
    int inaltimeecran=600;
    int dimensiunepatratel=30;
    Random random=new Random();
    Patratul catchboard=new Patratul(8,17);
    Patratul bila=new Patratul(random.nextInt(20),1);
    boolean gameOver=false;
    Timer miscarebila;

    

    JFrame fereastraaplicate=new JFrame("Falling Balls");
    JPanel panel;


    public FallenBalls(){
        fereastraaplicate.setSize(lungimeecran,inaltimeecran);
        fereastraaplicate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel=new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                desenareBile(g);
                deseneazaCatchBoard(g);
                deseneazaBila(g);
                
                panel.repaint();
            
            }
        };


        panel.setBackground(Color.GRAY);
        fereastraaplicate.add(panel);
        fereastraaplicate.setVisible(true);
        fereastraaplicate.addKeyListener(this);
        fereastraaplicate.setFocusable(true);

        miscarebila=new Timer(75, this);
        miscarebila.start();


    }
    

          






    public void desenareBile(Graphics g){

        //Deseneaza Grid-ul
        g.setColor(Color.RED);
        for(int i=0;i<inaltimeecran/dimensiunepatratel;i++){
            g.drawLine(i*dimensiunepatratel,0,i*dimensiunepatratel,inaltimeecran);
            g.drawLine(0,i*dimensiunepatratel,lungimeecran,i*dimensiunepatratel);
        }
 
    }


    public void deseneazaCatchBoard(Graphics g){
        //Deseneaza CatchBoard-ul
        g.setColor(Color.BLUE);
        g.fillRect(catchboard.x*dimensiunepatratel,catchboard.y*dimensiunepatratel, dimensiunepatratel*4, dimensiunepatratel);
        
    }


    public void deseneazaBila(Graphics g){
        //Deseneaza Bila
        g.setColor(Color.GREEN);
        g.fillOval(bila.x*dimensiunepatratel,bila.y*dimensiunepatratel,dimensiunepatratel,dimensiunepatratel);
      
    }



   

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(catchboard.x>0){
                catchboard.x--;
            }

        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(catchboard.x<20){
                catchboard.x++;
            }
        }
   
    }

    @Override
    public void actionPerformed(ActionEvent e){
        move();
        panel.repaint();
    }


    public void move(){
        bila.y++;
        if(bila.y==20){
          bila.y=1;
          bila.x=random.nextInt(20);

        }

        if(bila.y==catchboard.y && bila.x>=catchboard.x && bila.x<=catchboard.x+4){
            bila.y=1;
            bila.x=random.nextInt(20);
        }

    }



    

    


 
    

    public static void main(String[] args){
        FallenBalls fb=new FallenBalls();
    }


}