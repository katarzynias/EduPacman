/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edupacman;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * glowna klasa gry
 * @author sinki
 */
public class EduPacman extends JFrame {

    
    public EduPacman() {

        initUI();
    }

    
    /**
     * inicjalizacja interfejsu uzytkownika
     */
    private void initUI() {

        uruchomMenu();
        //uruchomNowaGra();

        setTitle("EduPacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * metoda uruchamiajaca menu
     */
    public void uruchomMenu() {
        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().revalidate();
        add(new Menu(this));
        getContentPane().repaint();
        getContentPane().revalidate();
    }

    
    /**
     * metodauruchamiajaca nowa gre
     * @param imie imie gracza
     */
    public void uruchomNowaGra(String imie) {
        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().revalidate();

        Gra gra = new Gra(imie, this);
        addKeyListener(gra);
        gra.setFocusable(true);

        add(gra);
    }

    
    
    /**
     * metoda uruchamiajaca ranking
     */
    public void uruchomRanking() {
        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().revalidate();

        Ranking ranking = new Ranking(this);
        addMouseListener(ranking);
        ranking.setFocusable(true);

        add(ranking);
    }

    
    /**
     * metoda uruchamiajaca instrukcje
     */
    public void uruchomInstrukcja() {
        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().revalidate();

        Instrukcja instrukcja = new Instrukcja(this);
        addMouseListener(instrukcja);
        instrukcja.setFocusable(true);

        add(instrukcja);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EduPacman edupacman = new EduPacman();
                edupacman.setVisible(true);
            }
        });

    }

    
    /**
     * metoda uruchamiajaca koniec
     * @param iloscPunktow 
     */
    public void uruchomKoniec(int iloscPunktow) {
        getContentPane().removeAll();
        getContentPane().repaint();
        getContentPane().revalidate();

        Koniec koniec = new Koniec(this, iloscPunktow);
        koniec.setFocusable(true);

        add(koniec);

    }
}
