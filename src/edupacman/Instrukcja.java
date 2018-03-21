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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * klasa odpowiedzialna za instrukcje
 * @author sinki
 */
public class Instrukcja extends JPanel implements ActionListener, MouseListener {

    Dimension wymiary = new Dimension();
    EduPacman glowny;
    Graphics2D g;

    Point pozycjaPowrot;
    Image przyciskImage;

    /**
     * konstruktos klasy intrukcja
     * @param glowny  obiekt klasy edupacman
     */
    public Instrukcja(EduPacman glowny) {
        this.glowny = glowny;
        wymiary = new Dimension(1280, 800);
        pozycjaPowrot = new Point(950, 600);
        przyciskImage = new ImageIcon(getClass().getResource("button2.png")).getImage();
    }

    
    
        /**
         * metoda rysujaca naglowek intrukcja, tresc instrukcji oraz przycisk powrot
         */
    public void rysujRanking() {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, wymiary.width, wymiary.height);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.orange);
        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 90));
        g2d.drawString("Instrukcja", 400, 100);
        
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 30));
        g2d.drawString("Użytkownik kieruje postacią przez labirynt pełen", 100, 200);
        g2d.drawString("kulek. Warunkiem przejścia do następnego poziomu ", 100, 250);
        g2d.drawString("jest zjedzenie ich wszystkich. Podczas gry należy", 100, 300);
        g2d.drawString("uważać na duszki, które poruszają się w losowych", 100, 350);
        g2d.drawString("kierunkach po całej planszy. Trafienie na duszka", 100, 400);
        g2d.drawString("oznacza utratę jednego z trzech żyć. Na planszy", 100, 450);
        g2d.drawString("znajdują się także większe kulki, których zjeddzenie", 100, 500);
        g2d.drawString("powoduje wyświetlenie pytania. Udzielenie poprawnej", 100, 550);
        g2d.drawString("odpowiedzi na pytania oznacza dodatkowe punkty. ", 100, 600);
        g2d.drawString("Po utracie wszystkich 3 żyć gra kończy się.", 100, 650);
        
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
     * metoda powodujaca powrot do menu w przypadku klikniecia napisu "powrot"
     * @param e parametr obslugi zdarzenia
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

}
