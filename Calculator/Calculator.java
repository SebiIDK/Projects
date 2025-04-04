import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Calculator extends JFrame  {
     private static Color color=new Color(6,6,6);
     private static Color LettersColor=new Color(12,213,34);
     private static Color buttonColor=new Color(255,255,255);
     private static Color textFieldColor=new Color(158,157,157);

    public static void main(String[]args) throws IOException{
        JFrame frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        String imagePath="/171352_calculator_icon.png";
        InputStream imgStream=Calculator.class.getResourceAsStream(imagePath);
        BufferedImage img=ImageIO.read(imgStream);
    
        JTextField textField=new JTextField(10);
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        textField.setPreferredSize(new Dimension(50,50));
        textField.setBackground(Color.WHITE);
        textField.setEditable(false);
        JPanel panel=new JPanel(new GridLayout(5,4, 5,5));
        JButton button1=new JButton("1");
        JButton button2=new JButton("2");
        JButton button3=new JButton("3");
        JButton button4=new JButton("4");
        JButton button5=new JButton("5");
        JButton button6=new JButton("6");
        JButton button7=new JButton("7");
        JButton button8=new JButton("8");
        JButton button9=new JButton("9");
        JButton button0=new JButton("0");
        JButton buttonPlus=new JButton("+");
        JButton buttonMinus=new JButton("-");
        JButton buttonMultiply=new JButton("*");
        JButton buttonDivide=new JButton("/");
        JButton buttonEqual=new JButton("=");
        JButton buttonClear=new JButton("C");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText= textField.getText();
                textField.setText(currentText + "1");
            }
        });

        button2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+"2");
            }
        });


        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText +"3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+ "4");
            }
        });

        button5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+ "5");
            }
        });

        button6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+ "6");
            }

        });

        button7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+ "7");
            }
        });

        button8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+"8");
            }
        });
        button9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+ "9");

            }
        });

        button0.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+ "0");
            }
        });

        buttonPlus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+ "+");
            }
        });

        buttonMinus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+ "-");
            }
        });

        buttonMultiply.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+ "*");
            }
        });

        buttonDivide.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String currentText=textField.getText();
                textField.setText(currentText+ "/");
            }
        });

        buttonClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                textField.setText("");
            }
        });


        buttonEqual.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String equalText=textField.getText();
                int operatorIndex=-1;
                for(int i=0;i<equalText.length();i++){
                    char c=equalText.charAt(i);
                    if(c=='+'||c=='-'||c=='*'||c=='/'){
                        operatorIndex=i;
                        break;
                    }
                }
                

                    int operand1=Integer.parseInt(equalText.substring(0, operatorIndex));
                    int operand2=Integer.parseInt(equalText.substring(operatorIndex+1));
                    char operator=equalText.charAt(operatorIndex);
                    int result=0;
                    switch(operator){
                        case '+':
                        result=summation(operand1, operand2);
                        break;


                        case '-':
                        result=substraction(operand1, operand2);
                        break;

                        case '*':
                        result=multiplication(operand1, operand2);
                        break;

                        case'/':
                        result=division(operand1, operand2);
                        break;
                     }

                    textField.setText(String.valueOf(result));
                    textField.setFont(new Font("Arial", Font.PLAIN, 30));

                
            }
        });

        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonPlus);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonMinus);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonMultiply);
        panel.add(button0);
        panel.add(buttonDivide);
        panel.add(buttonClear);
        panel.add(buttonEqual);


        button1.setBackground(buttonColor);
        button2.setBackground(buttonColor);
        button3.setBackground(buttonColor);
        button4.setBackground(buttonColor);
        button5.setBackground(buttonColor);
        button6.setBackground(buttonColor);
        button7.setBackground(buttonColor);
        button8.setBackground(buttonColor);
        button9.setBackground(buttonColor);
        button0.setBackground(buttonColor);
        buttonPlus.setBackground(buttonColor);
        buttonMinus.setBackground(buttonColor);
        buttonMultiply.setBackground(buttonColor);
        buttonDivide.setBackground(buttonColor);
        buttonEqual.setBackground(buttonColor);
        buttonClear.setBackground(buttonColor);
        button1.setForeground(LettersColor);
        button2.setForeground(LettersColor);
        button3.setForeground(LettersColor);
        button4.setForeground(LettersColor);
        button5.setForeground(LettersColor);
        button6.setForeground(LettersColor);
        button7.setForeground(LettersColor);
        button8.setForeground(LettersColor);
        button9.setForeground(LettersColor);
        button0.setForeground(LettersColor);
        buttonPlus.setForeground(LettersColor);
        buttonMinus.setForeground(LettersColor);
        buttonMultiply.setForeground(LettersColor);
        buttonDivide.setForeground(LettersColor);
        buttonEqual.setForeground(LettersColor);
        buttonClear.setForeground(LettersColor);
        button1.setFont(new Font("Arial", Font.PLAIN, 30));
        button2.setFont(new Font("Arial", Font.PLAIN, 30));
        button3.setFont(new Font("Arial", Font.PLAIN, 30));
        button4.setFont(new Font("Arial", Font.PLAIN, 30));
        button5.setFont(new Font("Arial", Font.PLAIN, 30));
        button6.setFont(new Font("Arial", Font.PLAIN, 30));
        button7.setFont(new Font("Arial", Font.PLAIN, 30));
        button8.setFont(new Font("Arial", Font.PLAIN, 30));
        button9.setFont(new Font("Arial", Font.PLAIN, 30));
        button0.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonPlus.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonMinus.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonMultiply.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonDivide.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonEqual.setFont(new Font("Arial", Font.PLAIN, 30));
        buttonClear.setFont(new Font("Arial", Font.PLAIN, 30));
        textField.setBackground(textFieldColor);
        panel.setBackground(color);
        frame.setIconImage(img);
        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel , BorderLayout.CENTER);
        frame.setVisible(true);
        
    

        
        

        
    }


   private static int summation(int a, int b){
    return a+b;
   }

   private static int substraction(int a, int b){
    return a-b;
   }

   private static int multiplication(int a, int b){
    return a*b;
   }

   private static int division(int a, int b){
    if(b==0){
        JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
        return 0;
    }
    else{
        return a/b;
    }
   }



   
}

