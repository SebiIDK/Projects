
import java.awt.*;
import javax.swing.*;

public class interfata{
    public static void main(String[] args)throws Exception{

        int lungime=600;
        int inaltime=600;

        JFrame fereastra=new JFrame("Aplicatie");
        fereastra.setVisible(true);
        fereastra.setSize(lungime, inaltime);
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fereastra.setLocationRelativeTo(null);

        Sarpele jocuSarpele=new Sarpele(lungime, inaltime);
        fereastra.add(jocuSarpele);
        fereastra.pack();
        jocuSarpele.requestFocus();

    }
}