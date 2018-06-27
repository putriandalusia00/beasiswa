/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author asus
 */
import java.awt.*;
import javax.swing.*;

public class panel1 extends JPanel {

    Image gambar;
    public panel1(){
        gambar=new ImageIcon(getClass().getResource("/image/unsera-02.jpg")).getImage();
    }
 @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D)g.create();
        gd.drawImage(gambar,0,0,getWidth(),getHeight(),null);
        gd.dispose();
           
}}