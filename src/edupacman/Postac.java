/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edupacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

/**
 * klasa odpowiedzialna za postac w grze
 * @author sinki
 */
public class Postac extends Kafelek {

    /**
     * typ wyliczeniowy dla poruszania sie postaci
     */
    public enum Kierunek {
        prawo,
        lewo,
        gora,
        dol
    }

    Image postac_prawo = new ImageIcon(getClass().getResource("pacman_prawo.png")).getImage();
    Image postac_lewo = new ImageIcon(getClass().getResource("pacman_lewo.png")).getImage();
    Image postac_gora = new ImageIcon(getClass().getResource("pacman_gora.png")).getImage();
    Image postac_dol = new ImageIcon(getClass().getResource("pacman_dol.png")).getImage();
    Kierunek kierunek = Kierunek.prawo;

    public Postac(int wielkoscKafelka, int rodzaj, int pozycjaX, int pozycjaY) {
        super(wielkoscKafelka, rodzaj, pozycjaX, pozycjaY);
    }

    /**
     * metoda opisujaca rysowanie postaci w zaleznosci od kierunku 
     * @param g obiekt do rysowania grafiki
     */
    @Override
    public void rysujKafelek(Graphics2D g) {
        g.setColor(Color.black);
        g.fill(new Rectangle2D.Double(pozycjaX, pozycjaY, wielkoscKafelka, wielkoscKafelka));
        Image postac = null;
        switch(kierunek) {
            case prawo:
                postac =  postac_prawo;
                break;
            case lewo: 
                postac = postac_lewo;
                break;
            case gora:
                postac = postac_gora;
                break;
            case dol:
                postac = postac_dol;
                break;
        }
        g.drawImage(postac, pozycjaX, pozycjaY, wielkoscKafelka, wielkoscKafelka, null);

    }


}
