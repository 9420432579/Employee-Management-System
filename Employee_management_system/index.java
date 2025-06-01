package Employee_management_system;

import java.awt.Image;
import javax.swing.*;

public class index extends JFrame {
    index(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/em.jpg"));
        Image i2=i1.getImage().getScaledInstance(1170, 650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0, 0, 1170, 650);
        add(img);
        
        setSize(1170,650);
        setLayout(null);
        setLocation(200, 50);
        setVisible(true);

        try {
            Thread.sleep(5000);
            setVisible(false);
            new Login();  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String [] args){
        new index();
    }
}
