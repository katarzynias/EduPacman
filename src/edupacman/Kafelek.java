/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edupacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 *klasa odpowiedzialna za kafelki na planie gry
 * @author sinki
 */
public class Kafelek {

    /**
     * typ wyliczeniowy odpowiadajacy kierunkowi rysowania postaci
     */
    public enum RodzajKafelka {
        Horyzontalny,
        Wertykalny,
        GoraLewo,
        GoraPrawo,
        DolLewo,
        DolPrawo,
        Kropka,
        Duch,
        Postac
    }
    
    protected int rodzaj;
    protected int pozycjaX;
    protected int pozycjaY;
    protected int wielkoscKafelka;
    
    public Kafelek(int wielkoscKafelka, int rodzaj, int pozycjaX, int pozycjaY) {
        this.wielkoscKafelka = wielkoscKafelka;
        this.rodzaj = rodzaj;
        this.pozycjaX = pozycjaX;
        this.pozycjaY = pozycjaY;
        
    }
    
    
    
    /**
     * definiuje ktore rodzaj kafelka znajdzie sie po wpisaniu odpowiedniej liczby na mapie
     * @param g obiekt do rysowania grafiki
     */
    public void rysujKafelek(Graphics2D g) {
        g.setColor(Color.GREEN);
        switch(rodzaj) {
            case 0:
            
                rysujKropke(g);
                break;
            case 1:
                rysujWertykalny(g);
                break;
            case 2:
                rysujHoryzontalny(g);
                break;
                
            case 3:
                rysujGoraLewo(g);
                break;
            case 4:
                rysujGoraPrawo(g);
                break;
            case 5:
                rysujDolPrawo(g);
                break;
            case 6:
                rysujDolLewo(g);
                break;
            case 7:
                rysujGwiazdki(g);
                break;
            case 8:
                break;
        }
    }
    
   /**
    * zwraca informacje czy kafelek jest pusty czy z kropka lub duza kropka 
    * @return 
    */
    public boolean mozeStanac() {
        return rodzaj == 0 || rodzaj==8 || rodzaj==7;
    }
    
    /**
     * przesuniecie kafelka mapy gry
     * @param oIleX ile jednostek na osi x przesunac kafelek
     * @param oIleY ile jednostek na osi y przesunac kafelek
     */
    public void przesunKafelek(int oIleX, int oIleY) {
        pozycjaX = pozycjaX + (oIleX * wielkoscKafelka);
        pozycjaY = pozycjaY + (oIleY * wielkoscKafelka);
    }
    
    /**
     * rysowanie na mapie przeszkody kreska pozioma
     * @param g obiekt do rysowania grafiki
     */
    private void rysujHoryzontalny(Graphics2D g) {
        g.drawLine(pozycjaX , pozycjaY + wielkoscKafelka/2, pozycjaX + wielkoscKafelka, pozycjaY + wielkoscKafelka/2);
    }
    /**
     * rysowanie na mapie przeszkody kreska pionowa
     * @param g obiekt do rysowania grafiki
     */
    private void rysujWertykalny(Graphics2D g) {
        g.drawLine(pozycjaX + wielkoscKafelka/2, pozycjaY, pozycjaX + wielkoscKafelka/2, pozycjaY + wielkoscKafelka);
    }
    
    /**
     * rysowanie na mapie przeszkody rogu dolnego prawego
     * @param g obiekt do rysowania grafiki
     */
    private void rysujGoraLewo(Graphics2D g) {
        g.drawLine(pozycjaX + wielkoscKafelka/2, pozycjaY, pozycjaX + wielkoscKafelka/2, pozycjaY + wielkoscKafelka/2);
        g.drawLine(pozycjaX + wielkoscKafelka/2, pozycjaY + wielkoscKafelka/2, pozycjaX + wielkoscKafelka, pozycjaY + wielkoscKafelka/2);
    }

    /**
     * rysowanie na mapie przeszkody rogu dolnego lewego
     * @param g obiekt do rysowania grafiki
     */
    private void rysujGoraPrawo(Graphics2D g) {
        g.drawLine(pozycjaX + wielkoscKafelka/2, pozycjaY, pozycjaX + wielkoscKafelka/2, pozycjaY + wielkoscKafelka/2);
        g.drawLine(pozycjaX + wielkoscKafelka/2, pozycjaY + wielkoscKafelka/2, pozycjaX, pozycjaY + wielkoscKafelka/2);
    }

    /**
     * rysowanie na mapie przeszkody rogu gornego lewego
     * @param g obiekt do rysowania grafiki
     */
    private void rysujDolPrawo(Graphics2D g) {
        g.drawLine(pozycjaX + wielkoscKafelka/2, pozycjaY+wielkoscKafelka/2, pozycjaX + wielkoscKafelka/2, pozycjaY + wielkoscKafelka);
        g.drawLine(pozycjaX + wielkoscKafelka/2, pozycjaY + wielkoscKafelka/2, pozycjaX, pozycjaY + wielkoscKafelka/2);
    }

    
    /**
     * rysowanie na mapie przeszkody rogu gornego prawego
     * @param g  obiekt do rysowania grafiki
     */
    private void rysujDolLewo(Graphics2D g) {
         g.drawLine(pozycjaX + wielkoscKafelka/2, pozycjaY+wielkoscKafelka/2, pozycjaX + wielkoscKafelka/2, pozycjaY + wielkoscKafelka);
        g.drawLine(pozycjaX + wielkoscKafelka/2, pozycjaY + wielkoscKafelka/2, pozycjaX + wielkoscKafelka, pozycjaY + wielkoscKafelka/2);
    }
    
    
    
    
    /**
     * metoda rysujaca kropki na planszy
     * @param g obiekt do rysowania grafiki
     */
    private void rysujKropke(Graphics2D g) {
        int radius = wielkoscKafelka/8;
        Shape theCircle = new Ellipse2D.Double(pozycjaX + wielkoscKafelka/2 - radius, pozycjaY + wielkoscKafelka/2 - radius, 2.0 * radius, 2.0 * radius);
        g.draw(theCircle);
    }
    
    
    
    /**
     * metoda rysujaca kropki na planszy odpowiedzialne za wyswietlenie pytania
     * @param g 
     */
      private void rysujGwiazdki(Graphics2D g) {
        int radius = wielkoscKafelka/4;
        Shape theCircle = new Ellipse2D.Double(pozycjaX + wielkoscKafelka/2 - radius, pozycjaY + wielkoscKafelka/2 - radius, 2.0 * radius, 2.0 * radius);
        g.draw(theCircle);
        g.fill(theCircle);
    }
}
