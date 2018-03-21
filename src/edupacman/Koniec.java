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
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * klasa odpowidzialna za panel ukazujacy sie na koniec gry w przypadku przegranej
 * @author sinki
 */
public class Koniec extends JPanel implements ActionListener, KeyListener {

    Dimension wymiary = new Dimension();
    EduPacman glowny;
    Graphics2D g;
    int ilosc;
    Image postac = new ImageIcon(getClass().getResource("ghost.png")).getImage();

    public Koniec(EduPacman glowny, int iloscPunktow) {
        this.glowny = glowny;
        wymiary = new Dimension(1280, 800);
        ilosc = iloscPunktow;
    }
    
    
    /**
     * metoda rysujaca na ostatnim panelu w przypadku przegranej obrazki duszkow oraz informacje o ewentualnym powrocie do menu, liczbie uzyskanych wynikow
     */
    public void rysujKoniec() {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, wymiary.width, wymiary.height);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.red);
        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 120));
        g2d.drawString("KONIEC GRY", 220, 270);

        g2d.setColor(Color.white);
        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 40));
        g2d.drawString("Uzyskany wynik: " + ilosc, 300, 480);
        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 25));
        g2d.drawString("Naciśnij ESC żeby wyjść do menu", 700, 670);
        
        
        
        g.setColor(Color.black);
        g.fill(new Rectangle2D.Double());
        g.drawImage(postac,100,700,null); 
        g.drawImage(postac,200,700,null); 
        g.drawImage(postac,300,700,null); 
        g.drawImage(postac,400,700,null); 
        g.drawImage(postac,500,700,null); 
        g.drawImage(postac,600,700,null); 
        g.drawImage(postac,700,700,null); 
        g.drawImage(postac,800,700,null); 
        g.drawImage(postac,900,700,null); 
        g.drawImage(postac,1000,700,null); 
        g.drawImage(postac,1100,700,null); 
        
        
        
        g.drawImage(postac,100,20,null); 
        g.drawImage(postac,200,20,null); 
        g.drawImage(postac,300,20,null); 
        g.drawImage(postac,400,20,null); 
        g.drawImage(postac,500,20,null); 
        g.drawImage(postac,600,20,null); 
        g.drawImage(postac,700,20,null); 
        g.drawImage(postac,800,20,null); 
        g.drawImage(postac,900,20,null); 
        g.drawImage(postac,1000,20,null); 
        g.drawImage(postac,1100,20,null); 
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.g = (Graphics2D) g;
        rysujKoniec();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    
    
    /**
     * metoda ktora przy kliknieciu przycisku esc na klawiaturze powoduje przejscie do menu
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            glowny.uruchomMenu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
 
    
    
    
    
}
