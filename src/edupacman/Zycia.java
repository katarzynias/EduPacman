/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edupacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * klasa odpowiedzialna za wyrysowanie serc oznaczajacych ilsoc zyc na planszy w odpowiednim miejscu
 * @author sinki
 */
public class Zycia {
    
       Image serce = new ImageIcon(getClass().getResource("serce.png")).getImage();
    
      
   /**
    * metoda rysujaca serca oznaczajaca ilosc zyc w odpowiednim miejscu w zaleznosci od ich ilosci 
    * @param g obiekt do rysowania grafiki
    * @param iloscZyc oznacza ilosc zyc jakie posiada uzytkownik
    */
    public void rysujZycia(Graphics2D g, int iloscZyc) {
        g.setColor(Color.black);
        int przesuniecie=0;
        
        for(int i=0; i<iloscZyc;i++){
        
        g.drawImage(serce, 280+przesuniecie,690, null);
        przesuniecie=50+przesuniecie;
        
        }
    }
    
 
    
}
