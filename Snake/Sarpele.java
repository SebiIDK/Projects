import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Sarpele extends JPanel implements ActionListener, KeyListener {

    private class Patratel {
        int x, y;

        Patratel(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int lungime, inaltime;
    int dimensiunepatratel = 25;

    Patratel capulsarpelui;
    Patratel mancaresarpe;
    Random random = new Random();
    Timer gameloop;
    int velocityX, velocityY;
    ArrayList<Patratel> corpulsarpelui;
    boolean gameOver;

    Sarpele(int lungime, int inaltime) {
        this.lungime = lungime;
        this.inaltime = inaltime;
        setPreferredSize(new Dimension(this.lungime, this.inaltime));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
        capulsarpelui = new Patratel(5, 5);
        mancaresarpe = new Patratel(10, 10);
        corpulsarpelui = new ArrayList<>();
        gameloop = new Timer(100, this);
        gameloop.start();
        randommancare();
        velocityX = 0;
        velocityY = 0;
        gameOver = false;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenareSarpele(g);
    }

    public void desenareSarpele(Graphics g) {
        g.setColor(Color.GRAY);
        for (int i = 0; i < inaltime / dimensiunepatratel; i++) {
            g.drawLine(i * dimensiunepatratel, 0, i * dimensiunepatratel, inaltime);
            g.drawLine(0, i * dimensiunepatratel, lungime, i * dimensiunepatratel);
        }

        g.setColor(Color.GREEN);
        g.fillRect(capulsarpelui.x * dimensiunepatratel, capulsarpelui.y * dimensiunepatratel, dimensiunepatratel, dimensiunepatratel);

        for (int i = 0; i < corpulsarpelui.size(); i++) {
            Patratel corpsarpe = corpulsarpelui.get(i);
            g.fillRect(corpsarpe.x * dimensiunepatratel, corpsarpe.y * dimensiunepatratel, dimensiunepatratel, dimensiunepatratel);
        }

        g.setColor(Color.RED);
        g.fillRect(mancaresarpe.x * dimensiunepatratel, mancaresarpe.y * dimensiunepatratel, dimensiunepatratel, dimensiunepatratel);
    }

    public void randommancare() {
        mancaresarpe.x = random.nextInt(lungime / dimensiunepatratel);
        mancaresarpe.y = random.nextInt(inaltime / dimensiunepatratel);
    }

    public void move() {
        capulsarpelui.x += velocityX;
        capulsarpelui.y += velocityY;

        if (coliziuni(capulsarpelui, mancaresarpe)) {
            corpulsarpelui.add(new Patratel(mancaresarpe.x, mancaresarpe.y));
            randommancare();
        }

        for (int i = corpulsarpelui.size() - 1; i >= 0; i--) {
            Patratel corpsarpe = corpulsarpelui.get(i);
            if (i == 0) {
            corpsarpe.x = capulsarpelui.x;
            corpsarpe.y = capulsarpelui.y;
            } else {
            Patratel urmatorulcorp = corpulsarpelui.get(i - 1);
            corpsarpe.x = urmatorulcorp.x;
            corpsarpe.y = urmatorulcorp.y;
            }
        }



        if (capulsarpelui.x < 0 || capulsarpelui.x >= lungime / dimensiunepatratel || capulsarpelui.y < 0 || capulsarpelui.y >= inaltime / dimensiunepatratel) {
            gameOver = true;
            gameloop.stop();
            JOptionPane.showMessageDialog(this, "Game Over");
        }
    }

    public boolean coliziuni(Patratel p1, Patratel p2) {
        return p1.x == p2.x && p1.y == p2.y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            move();
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP && velocityY != 1) {
            velocityX = 0;
            velocityY = -1;
        } else if (key == KeyEvent.VK_DOWN && velocityY != -1) {
            velocityX = 0;
            velocityY = 1;
        } else if (key == KeyEvent.VK_LEFT && velocityX != 1) {
            velocityX = -1;
            velocityY = 0;
        } else if (key == KeyEvent.VK_RIGHT && velocityX != -1) {
            velocityX = 1;
            velocityY = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        Sarpele game = new Sarpele(500, 500);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
