import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.*;
public class MyFrame extends JFrame implements ActionListener{
    Random random=new Random();
    MyPanel panel;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton resetButton;
    ImageIcon image;
    JLabel label;
    ArrayList<String> game;
    int answ;
    double correct;
    int total;
    String[] str;
    MyFrame(){
       game = new ArrayList<String>();
       String[] str = {"100y+7=9 || What is y?","1/50","700/9","100/7",
                        "80x+5=9 || What is x?","1/20","5/80","9/5",
                         "5=9z-7 || What is z?","3/4","7/5","-9/7"};
       for(String s: str){
           game.add(s);
       }
       image =new ImageIcon("game_show.jpg");
       label = new JLabel();
       label.setIcon(image);
       label.setHorizontalTextPosition(JLabel.CENTER);
       label.setVerticalTextPosition(JLabel.TOP);
       label.setFont(new Font("Ariel",Font.PLAIN,50));
       label.setForeground(new Color(255, 41, 230));
       label.setBackground(Color.black);
       label.setOpaque(true);
       label.setVerticalAlignment(JLabel.CENTER);
       label.setHorizontalAlignment(JLabel.CENTER);
        
        
        
        
        button1=new JButton();
        button1.setBounds(460,675,210,145);
        button1.addActionListener(this);
        button1.setFocusable(false);
        button1.setFont(new Font("Comic Sans",Font.BOLD,30));
        button1.setBackground(Color.blue);
        button1.setForeground(Color.white);
        
        
        
        
        
        button2=new JButton();
        button2.setBounds(785,697,210,145);
        button2.addActionListener(this);
        button2.setFocusable(false);
        button2.setFont(new Font("Comic Sans",Font.BOLD,30));
        button2.setBackground(Color.blue);
        button2.setForeground(Color.white);
        
        button3=new JButton();
        button3.setBounds(1105,720,210,145);
        button3.addActionListener(this);
        button3.setFocusable(false);
        button3.setFont(new Font("Comic Sans",Font.BOLD,30));
        button3.setBackground(Color.blue);
        button3.setForeground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        this.setSize(1600,1200);
        this.setVisible(true);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(label);
        answ = setAnswers();
 }
  //@Override
   public void actionPerformed(ActionEvent e){
        if(e.getSource()==button1){
            System.out.println("click");
            if(answ==0)
                correct++;
            total++;
            if(game.size()==0)
                end(str);
            if(game.size()!=0)
                answ = setAnswers();
        }
        if(e.getSource()==button2){
            System.out.println("click2");
            if(answ==1)
                correct++;
            total++;
            if(game.size()==0)
                end(str);
            if(game.size()!=0)
                answ = setAnswers();
        }
        if(e.getSource()==button3){
            System.out.println("click3");
            if(answ==2)
                correct++;
            total++;
            if(game.size()==0)
                end(str);
            if(game.size()!=0)
                answ = setAnswers();
        }
   }
   public int setAnswers(){
       int bol = random.nextInt(3);
       if(bol==0){
           button1.setText(game.get(1)); 
           button2.setText(game.get(2)); 
           button3.setText(game.get(3)); 
       }
       if(bol==1){
           button1.setText(game.get(2)); 
           button2.setText(game.get(1)); 
           button3.setText(game.get(3)); 
       }
       if(bol==2){
           button1.setText(game.get(3)); 
           button2.setText(game.get(2)); 
           button3.setText(game.get(1)); 
       }
       label.setText(game.get(0));
       game.remove(0);
       game.remove(0);
       game.remove(0);
       game.remove(0);
       return bol;
   }
   public void end(String[] str){
       int answ2 = (int)(100*correct/total); 
       label.setText("You Finished! Your score was: "+answ2 +" points!");
       this.remove(button1);
       this.remove(button2);
       this.remove(button3);
   }
}
