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
 * klasa rysujaca duszki
 * @author sinki
 */
public class Duch  extends Kafelek {
    
    Image postac = new ImageIcon(getClass().getResource("ghost.png")).getImage();
    
    public Duch(int wielkoscKafelka, int rodzaj, int pozycjaX, int pozycjaY) {
        super(wielkoscKafelka, rodzaj, pozycjaX, pozycjaY);
    }
    
    
    
    @Override
    public void rysujKafelek(Graphics2D g) {
        g.setColor(Color.black);
        g.fill(new Rectangle2D.Double(pozycjaX, pozycjaY, wielkoscKafelka, wielkoscKafelka));
        g.drawImage(postac, pozycjaX, pozycjaY, wielkoscKafelka, wielkoscKafelka, null); 
    }
}
