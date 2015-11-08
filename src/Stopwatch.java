import javafx.scene.paint.Stop;

import javax.swing.*;
import java.awt.*;

/**
 * Created by BlackSpheres on 11/7/2015.
 */
public class Stopwatch extends JFrame implements Runnable {
    public static void main(String args[]){
        Stopwatch s = new Stopwatch();
        Runnable r = s;
        Thread t = new Thread(r);
        t.start();
    }
    private Clock c;
    JLabel labelTime;
    JButton btnToggle;
    JPanel panelCenter;
    public Stopwatch(){
        c = new Clock();
        Runnable r = c;
        Thread t = new Thread(r);
        t.start();
        this.setVisible(true);
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        labelTime = new JLabel("00");
        try{
            labelTime.setFont(new Font("Calibri",Font.PLAIN,50));
        }
        catch (Exception ae){

        }
        btnToggle = new JButton("Start");
        panelCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelCenter.add(labelTime);
        this.getContentPane().add(panelCenter,BorderLayout.CENTER);
        this.getContentPane().add(btnToggle,BorderLayout.SOUTH);
        btnToggle.addActionListener(e->{
           if(c.isRun){
               btnToggle.setText("Resume");
           }
           else{
               btnToggle.setText("Pause");
           }
            c.isRun=!c.isRun;
        });
    }
    @Override
    public void run() {
        while(true){
            labelTime.setText(c.getTime());
        }
    }
}
