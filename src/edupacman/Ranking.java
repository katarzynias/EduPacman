/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edupacman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * klasa odpowiedzialna za ranking
 * @author sinki
 */
public class Ranking extends JPanel implements ActionListener, MouseListener {

    Dimension wymiary = new Dimension();
    EduPacman glowny;
    Graphics2D g;
    ObslugaRankingu obsluga;
    HashMap<String, Integer> wyniki;
    Point pozycjaPowrot;
    Image przyciskImage;

    public Ranking(EduPacman glowny) {
        this.glowny = glowny;
        wymiary = new Dimension(1280, 800);
        obsluga = new ObslugaRankingu();
        wyniki = obsluga.odczytajWyniki();
        pozycjaPowrot = new Point(950, 600);
        przyciskImage = new ImageIcon(getClass().getResource("button2.png")).getImage();
    }

    /**
     * wypisywanie rankigu oraz uzyskanego wyniku
     */
    public void rysujRanking() {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, wymiary.width, wymiary.height);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.orange);
        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 90));
        g2d.drawString("Ranking", 400, 100);
        
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 40));
        int i = 1;
        for(String imie : wyniki.keySet()) {
            g2d.drawString(i + ". " + imie + ": " + wyniki.get(imie), 300, 150 + i*50);
            i++;
            if(i == 11) {
                break;
            }
        }
        
        g2d.drawImage(przyciskImage, pozycjaPowrot.x, pozycjaPowrot.y, this);
        
        g2d.setColor(Color.white);
        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 30));
        g2d.drawString("Powrót", 990, 640);
       
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.g = (Graphics2D) g;
        rysujRanking();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

/**
 *  obsluga klikniecia przycisku powrot, powrot do menu
 * @param e parametr obsługi zdarzenia
 */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("width: " + przyciskImage.getWidth(null) + ", " + pozycjaPowrot.x + ", aktualny: " + x);
        System.out.println("height: " + przyciskImage.getHeight(null) + ", " + pozycjaPowrot.y + ", aktualny: " + y);
        if(x > pozycjaPowrot.x && x < pozycjaPowrot.x + przyciskImage.getWidth(null) + 20) {
            if(y > pozycjaPowrot.y && y < pozycjaPowrot.y + przyciskImage.getHeight(null) + 40) {
                glowny.uruchomMenu();
            }
           
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
