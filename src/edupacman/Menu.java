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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *klasa odpowiedzialna za menu
 * @author sinki
 */
public class Menu extends JPanel implements ActionListener, MouseListener {

    Dimension wymiary = new Dimension();
    EduPacman glowny;
    Point pozycjaNowaGra;
    Point pozycjaRanking;
    Point pozycjaInstrukcja;
    Point pozycjaWyjscie;
    Point pozycjaNaglowek;
    Image przyciskImage;
    Image naglowekImage;

    public Menu(EduPacman glowny) {
        wymiary = new Dimension(1280, 800);

        przyciskImage = new ImageIcon(getClass().getResource("button1.png")).getImage();
        naglowekImage = new ImageIcon(getClass().getResource("PacmanDuzy.png")).getImage();
        addMouseListener(this);
        this.glowny = glowny;
    }

    /**
     * metoda rysujaca menu
     * @param g obiekt do rysowania grafiki
     */
    private void rysujMenu(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, wymiary.width, wymiary.height);

        
        dodajPrzyciski(g2d);
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
       
    }

    
    /**
     * metoda rysujaca przyciski graficzne w menu oraz napisy znajdujace sie na przyciskach oraz naglowek informujacy o nazwie gry
     * @param g obiekt do rysowania grafiki
     */
    private void dodajPrzyciski(Graphics2D g) {
        int przyciskWidth = przyciskImage.getWidth(null);
        int przyciskHeight = przyciskImage.getHeight(null);
        pozycjaNowaGra = new Point(wymiary.width/2 - przyciskWidth/2, 240);
        pozycjaRanking = new Point(wymiary.width/2 - przyciskWidth/2, 360);
        pozycjaInstrukcja = new Point(wymiary.width/2 - przyciskWidth/2, 480);
        pozycjaWyjscie = new Point(wymiary.width/2 - przyciskWidth/2, 600);
        pozycjaNaglowek = new Point(280, 100);
        g.drawImage(przyciskImage, pozycjaNowaGra.x, pozycjaNowaGra.y, null); 
        g.drawImage(przyciskImage, pozycjaRanking.x, pozycjaRanking. y, null);   
        g.drawImage(przyciskImage, pozycjaInstrukcja.x, pozycjaInstrukcja.y, null);        
        g.drawImage(przyciskImage, pozycjaWyjscie.x, pozycjaWyjscie.y, null);
        g.drawImage(naglowekImage, pozycjaNaglowek.x, pozycjaNaglowek.y, 90,90, null);
        
        g.setFont(new Font("Segoe Script", Font.BOLD, 40));
        g.setColor(Color.WHITE);
        String nowaGra = "Nowa gra";
        int nowaGraWidth = g.getFontMetrics().stringWidth(nowaGra);
        g.drawString(nowaGra, wymiary.width/2 - nowaGraWidth/2, 308);
        
        String ranking = "Ranking";
        int rankingWidth = g.getFontMetrics().stringWidth(ranking);
        g.drawString(ranking, wymiary.width/2 - rankingWidth/2, 428);
        
        String instrukcja = "Instrukcja";
        int instrukcjaWidth = g.getFontMetrics().stringWidth(instrukcja);
        g.drawString(instrukcja, wymiary.width/2 - instrukcjaWidth/2, 548);
        
        String wyjscie = "Wyjście";
        int wyjscieWidth = g.getFontMetrics().stringWidth(wyjscie);
        g.drawString(wyjscie, wymiary.width/2 - wyjscieWidth/2, 668);
        
        String naglowek = "EduPacman";
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 90));
        g.setColor(Color.orange);
        g.drawString(naglowek,380 , 170);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        rysujMenu(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    
    /**
     * po kliknieciu w dane miejsce wywoluje metody np wcisnietoWyjscie
     * @param e parametr obslugi zdarzen
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(x > pozycjaNowaGra.x && x < pozycjaNowaGra.x + przyciskImage.getWidth(null)) {
            // wszyskie przyciski zaczynaja sie w tym samym X, zmienia sie tylko Y
            if(y > pozycjaNowaGra.y && y < pozycjaNowaGra.y + przyciskImage.getHeight(null)) {
                wcisnietoNowaGra();
            }
            else if (y > pozycjaRanking.y && y < pozycjaRanking.y + przyciskImage.getHeight(null)) {
                wcisnietoRanking();
            }
            else if (y > pozycjaInstrukcja.y && y < pozycjaInstrukcja.y + przyciskImage.getHeight(null)) {
                wcisnietoInstrukcja();
            }
            else if (y > pozycjaWyjscie.y && y < pozycjaWyjscie.y + przyciskImage.getHeight(null)) {
                wcisnietoWyjscie();
            }
        }
    }
    
    /**
     * po wcisnieciu nowej gry pyta o imie uzytkownika
     */
    private void wcisnietoNowaGra() {
        String imie = zapytajOImie();
        glowny.uruchomNowaGra(imie);
        
    }
    
    
    /**
     * po wcisnieciu ranking uruchamia ranking
     */
    private void wcisnietoRanking() {
        glowny.uruchomRanking();
    }
    
    
    /**
     * po wcisnieciu instrukcja uruchamia instrukcja
     */
    private void wcisnietoInstrukcja() {
        glowny.uruchomInstrukcja();
    }
    
    /**
     * po wcisnieciu wyjscie nastepuje zamkniecie panelu
     */
    private void wcisnietoWyjscie() {
        System.exit(0);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
 /**
  * pyta o imie w osobnym messageboxie
  * @return 
  */
    public String zapytajOImie()
    {
        return JOptionPane.showInputDialog(null, "Twoje imie: ", "Imie", JOptionPane.INFORMATION_MESSAGE);
    }

    
   
    
       
    
    
   
}
