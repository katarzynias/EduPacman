/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edupacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *klasa odpowiedzialna za gre
 * @author sinki
 */
public class Gra extends JPanel implements ActionListener, KeyListener {

    final int WIELKOSC_KAFELKA = 40;
    final int ILOSC_KAFELKOW = 16;
    int PREDKOSC_DUCHOW = 7;
    final int START_X = 0;
    final int START_Y = 0;
    private EduPacman glowny;
    int iloscPunktow;
    int[][] mapa1 = new int[][]{
        {0, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};
    int[][] mapa2 = new int[][]{
        {0, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 7, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0},
        {0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0},
        {0, 0, 6, 1, 1, 1, 1, 1, 3, 0, 0, 7, 0, 0, 0, 0},
        {0, 0, 5, 1, 1, 1, 1, 1, 4, 0, 0, 7, 0, 0, 0, 0},
        {0, 0, 0, 7, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};
    int[][] mapa3 = new int[][]{
        {7, 0, 7, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 7, 7, 0},
        {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 2, 7, 0, 0, 0, 0, 6, 1, 1, 1},
        {0, 0, 0, 0, 2, 0, 5, 1, 1, 0, 0, 0, 2, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
        {0, 0, 1, 1, 4, 0, 0, 0, 0, 0, 0, 1, 4, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0},
        {7, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0},
        {0, 7, 5, 1, 1, 1, 1, 1, 1, 3, 0, 7, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 7, 0, 0, 0, 2, 0, 7, 0, 0, 0, 0},
        {7, 0, 0, 0, 0, 0, 0, 0, 7, 2, 0, 0, 0, 0, 0, 0},};
    int[][] mapa4 = new int[][]{
        {7, 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0},
        {7, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0},
        {7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};
    private Kafelek[][] kafelki = new Kafelek[ILOSC_KAFELKOW][ILOSC_KAFELKOW];
    private ArrayList<Duch> duszki = new ArrayList<Duch>();
    private Timer timer;
    private int odliczanieRuchu = 0;
    private Postac postac;
    private Zycia zycia;
    int iloscZyc;
    int poziom = 1;
    String imie;
    ObslugaRankingu ranking;
    ObslugaPytan obslugaPytan;
    Graphics2D g2d;
    Pytanie aktualnePytanie = null;

    public Gra(String imie, EduPacman glowny) {
        this.imie = imie;
        this.glowny = glowny;
        ranking = new ObslugaRankingu();
        obslugaPytan = new ObslugaPytan();
        stworzGre();

        timer = new Timer(40, this);
        timer.start();

        iloscPunktow = 0;

    }

    /**
     * glowna metoda rysujaca gre
     * @param g 
     */
    
    private void rysujGre(Graphics g) {
        g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 1280, 800);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (czyWszystkoZjedzone()) {
            poziom++;
            PREDKOSC_DUCHOW -= 2;
            stworzGre();
        }

        ruszajDuszki();

        rysujKafelki(g2d);
        rysujDuszki(g2d);
        rysujRamke(g2d);
        rysujPunkty(g2d);
        rysujPostac(g2d);
        rysujPytanie(g2d);
        rysujPoziom(g2d);
        zycia.rysujZycia(g2d, iloscZyc);
        obslugaZycia();

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }
    
    
    /**
     * metoda rysujaca ramke wyznaczajca pole poruszania sie postaci i duszkow
     * @param g 
     */
    private void rysujRamke(Graphics2D g) {
        g.setColor(Color.green);
        g.drawRect(START_X, START_Y, WIELKOSC_KAFELKA * ILOSC_KAFELKOW, WIELKOSC_KAFELKA * ILOSC_KAFELKOW);
    }
    
    
    /**
     * metoda tworzaca 3 nowe duszki poruszajace sie po planszy
     */
    private void stworzDuszki() {
        Duch duch1 = new Duch(WIELKOSC_KAFELKA, 1, START_X + 10 * WIELKOSC_KAFELKA, START_Y + 8 * WIELKOSC_KAFELKA);
        Duch duch2 = new Duch(WIELKOSC_KAFELKA, 1, START_X + 1 * WIELKOSC_KAFELKA, START_Y + 2 * WIELKOSC_KAFELKA);
        Duch duch3 = new Duch(WIELKOSC_KAFELKA, 1, START_X + 9 * WIELKOSC_KAFELKA, START_Y + 9 * WIELKOSC_KAFELKA);
        duszki = new ArrayList();
        duszki.add(duch1);
        duszki.add(duch2);
        duszki.add(duch3);
    }

    
    /**
     * rysuje duszki na swoich miejscach
     * @param g obiekt do rysowania grafiki
     */
    private void rysujDuszki(Graphics2D g) {
        for (Duch duch : duszki) {
            duch.rysujKafelek(g);
        }
    }
/**
 * metoda odpowiedzialna za poruszanie sie duszkow po planszy gry, duszki poruszaja sie randomowo. duch moze stanac na kafelek w przypadku gyd nie znajduje sie na nim inny duch
 */
    private void ruszajDuszki() {
        odliczanieRuchu++;
        if (odliczanieRuchu < PREDKOSC_DUCHOW) {
            return;
        }
        odliczanieRuchu = 0;
        for (Duch duch : duszki) {
            int ruch = (int) (Math.random() * 4);
            int duchX = (duch.pozycjaX - START_X) / WIELKOSC_KAFELKA;
            int duchY = (duch.pozycjaY - START_Y) / WIELKOSC_KAFELKA;
            switch (ruch) {
                case 0:
                    if (duchY < ILOSC_KAFELKOW - 1 && kafelki[duchX][duchY + 1].mozeStanac() && !czySaInneDuchy(duchX, duchY + 1)) {
                        duch.przesunKafelek(0, 1);
                        break;
                    } else {
                        ruch++;
                    }
                case 1:
                    if (duchX < ILOSC_KAFELKOW - 1 && kafelki[duchX + 1][duchY].mozeStanac() && !czySaInneDuchy(duchX + 1, duchY)) {
                        duch.przesunKafelek(1, 0);
                        break;
                    } else {
                        ruch++;
                    }
                case 2:
                    if (duchY > 0 && kafelki[duchX][duchY - 1].mozeStanac() && !czySaInneDuchy(duchX, duchY - 1)) {
                        duch.przesunKafelek(0, -1);
                        break;
                    } else {
                        ruch++;
                    }
                case 3:
                    if (duchX > 0 && kafelki[duchX - 1][duchY].mozeStanac() && !czySaInneDuchy(duchX - 1, duchY)) {
                        duch.przesunKafelek(-1, 0);
                        break;
                    } else {
                        ruch++;
                    }
            }
        }
    }

    /**
     * wybiera na podstawie poziomu rodzaj mapy i generuje tablice kafelkow
     */
    private void stworzKafelki() {
        int mapa[][] = null;
        switch (poziom) {
            case 1:
                mapa = mapa1;
                break;
            case 2:
                mapa = mapa2;
                break;
            case 3:
                mapa = mapa3;
                break;
            case 4:
                mapa = mapa4;
            default:
                break;
        }
        for (int i = 0; i < ILOSC_KAFELKOW; i++) {
            for (int j = 0; j < ILOSC_KAFELKOW; j++) {
                kafelki[i][j] = new Kafelek(WIELKOSC_KAFELKA, mapa[i][j], START_X + (i * WIELKOSC_KAFELKA), START_Y + (j * WIELKOSC_KAFELKA));
            }
        }
    }

    private void rysujKafelki(Graphics2D g) {
        for (int i = 0; i < ILOSC_KAFELKOW; i++) {
            for (int j = 0; j < ILOSC_KAFELKOW; j++) {
                kafelki[i][j].rysujKafelek(g);
            }
        }
    }

    
    /**
     * metoda ryujaca tekst punkty w odpowiedniej lokalizacji oraz ilosc punktow i informacje dotyczaca powrotu do menu
     * @param g 
     */
    private void rysujPunkty(Graphics2D g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 30));
        g2d.setColor(Color.WHITE);

        g2d.drawString("Punkty: " + iloscPunktow, START_X + 20, WIELKOSC_KAFELKA * (ILOSC_KAFELKOW + 2));
        g2d.drawString("Naciśnij ESC żeby wyjść", 800, WIELKOSC_KAFELKA * (ILOSC_KAFELKOW + 2));
    }

    /**
     * metoda przerysowujaca gre
     * @param g obiekt do rysowania grafiki
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        rysujGre(g);
    }

    
    /**
     * metoda przerysowujaca scene
     * @param e parametr obslugi zdarzen
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    /**
     * tworzy obiekt klasy postac
     */

    private void stworzPostac() {
        postac = new Postac(WIELKOSC_KAFELKA, 1, START_X + 4 * WIELKOSC_KAFELKA, START_Y + 5 * WIELKOSC_KAFELKA);

    }

    /**
     * rysuje postac w odpowiednim iejscu na planszy
     * @param g obiekt do rysowania grafiki
     */
    private void rysujPostac(Graphics2D g) {
        postac.rysujKafelek(g);

    }

    /**
     * stworzenine obiektow klasy zycia
     */
    private void stworzZycia() {
        zycia = new Zycia();

    }

    private void ruszajPostac() {

    }

    
    /**
     * metoda pbsluguja klawisze do sterowania postacia
     * @param e parametr obslugi zdarzen
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        int postacX = (postac.pozycjaX - START_X) / WIELKOSC_KAFELKA;
        int postacY = (postac.pozycjaY - START_Y) / WIELKOSC_KAFELKA;

        if (key == KeyEvent.VK_LEFT) {

            if (postac.pozycjaX <= START_X) {

            } else {
                if (postacX > 0 && kafelki[postacX - 1][postacY].mozeStanac()) {
                    postac.pozycjaX -= WIELKOSC_KAFELKA;
                    postac.kierunek = Postac.Kierunek.lewo;
                    if (kafelki[postacX - 1][postacY].rodzaj != 8) {
                        if (kafelki[postacX - 1][postacY].rodzaj == 7) {
                            ustawPytanie();
                        }
                        kafelki[postacX - 1][postacY].rodzaj = 8;
                        iloscPunktow += 5;
                    }
                }

            }
        }

        if (key == KeyEvent.VK_RIGHT) {

            if (postac.pozycjaX >= WIELKOSC_KAFELKA * (ILOSC_KAFELKOW - 1)) {
            } else {
                if (postacX < ILOSC_KAFELKOW && kafelki[postacX + 1][postacY].mozeStanac()) {
                    postac.pozycjaX += WIELKOSC_KAFELKA;
                    postac.kierunek = Postac.Kierunek.prawo;
                    if (kafelki[postacX + 1][postacY].rodzaj != 8) {
                        if (kafelki[postacX + 1][postacY].rodzaj == 7) {
                            ustawPytanie();
                        }
                        kafelki[postacX + 1][postacY].rodzaj = 8;
                        iloscPunktow += 5;
                    }

                }
            }
        }

        if (key == KeyEvent.VK_UP) {

            if (postac.pozycjaY <= START_Y) {
            } else {
                if (postacY > 0 && kafelki[postacX][postacY - 1].mozeStanac()) {
                    postac.pozycjaY -= WIELKOSC_KAFELKA;
                    postac.kierunek = Postac.Kierunek.gora;
                    if (kafelki[postacX][postacY - 1].rodzaj != 8) {
                        if (kafelki[postacX][postacY - 1].rodzaj == 7) {
                            ustawPytanie();
                        }
                        kafelki[postacX][postacY - 1].rodzaj = 8;
                        iloscPunktow += 5;
                    }

                }
            }
        }

        if (key == KeyEvent.VK_DOWN) {

            if (postac.pozycjaY >= WIELKOSC_KAFELKA * (ILOSC_KAFELKOW - 1)) {

            } else {
                if (postacY < ILOSC_KAFELKOW && kafelki[postacX][postacY + 1].mozeStanac()) {
                    postac.pozycjaY += WIELKOSC_KAFELKA;
                    postac.kierunek = Postac.Kierunek.dol;
                    if (kafelki[postacX][postacY + 1].rodzaj != 8) {
                        if (kafelki[postacX][postacY + 1].rodzaj == 7) {
                            ustawPytanie();
                        }
                        kafelki[postacX][postacY + 1].rodzaj = 8;
                        iloscPunktow += 5;
                    }
                }

            }
        }
        if (aktualnePytanie != null) {
            switch (key) {
                case KeyEvent.VK_1:
                    wybranoOdp(1);
                    break;
                case KeyEvent.VK_2:
                    wybranoOdp(2);
                    break;
                case KeyEvent.VK_3:
                    wybranoOdp(3);
                    break;
                case KeyEvent.VK_4:
                    wybranoOdp(4);
                    break;
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            glowny.uruchomMenu();
        }
    }

    
    /**
     * metoda sprawdzajaca czy postac znajduje sie w tym samym miejscy do duch
     * @return 
     */
    private boolean czyZginal() {

        for (Duch duch : duszki) {

            if (duch.pozycjaX == postac.pozycjaX && duch.pozycjaY == postac.pozycjaY) {

                return true;
            }

        }
        return false;

    }

    
        /**
         * metoda sprawdzajaca czy uzytkownik zginal wtedy odejmuje zycie i tworzy na nowo postacie gry, a w przypadku gdy ilosc zyc jest rowna 0 uruchamaia koncowy panel 
         */
    public void obslugaZycia() {
        if (czyZginal()) {

            iloscZyc--;
            stworzDuszki();
            stworzPostac();

            if (iloscZyc == 0) {
                ranking.dodajWynik(imie, iloscPunktow);
                glowny.uruchomKoniec(iloscPunktow);
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
/**
 * randomizuje kolejnosc wyswietlanych odpowiedzi
 */
    private void ustawPytanie() {
        aktualnePytanie = obslugaPytan.losujPytanie();
        aktualnePytanie.losujOdpowiedzi();
    }
    
    
    
    /**
     * metoda odpowiedzialna za rysowanie pytania oraz odpowiedzi w odpowiednim mejscu
     * @param g2d obiekt do rysowania grafiki
     */
    private void rysujPytanie(Graphics2D g2d) {
        if (aktualnePytanie == null) {
            return;
        }
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 30));
        g2d.setColor(Color.orange);
        String tresc = aktualnePytanie.trescPytania;
        int przesuniecie = 0;
        int limit = 30;
        while (true) {
            if (tresc.length() < limit) {
                g2d.drawString(tresc, (ILOSC_KAFELKOW + 2) * WIELKOSC_KAFELKA, WIELKOSC_KAFELKA * 3 + przesuniecie);
                break;
            } else {
                int spacja = aktualnePytanie.trescPytania.subSequence(0, limit).toString().lastIndexOf(" ");
                g2d.drawString(tresc.substring(0, spacja), (ILOSC_KAFELKOW + 2) * WIELKOSC_KAFELKA, WIELKOSC_KAFELKA * 3 + przesuniecie);
                tresc = tresc.substring(spacja+1);
                przesuniecie += WIELKOSC_KAFELKA;
            }
            if(tresc.length() == 0) {
                 break;
            }
        }
        g2d.setColor(Color.YELLOW);
        int i = 1;
        for (String odpowiedz : aktualnePytanie.odpowiedzi) {
            g2d.drawString(i + ". " + odpowiedz, (ILOSC_KAFELKOW + 2) * WIELKOSC_KAFELKA, WIELKOSC_KAFELKA * 3 + i * 50 + 50 + przesuniecie);
            i++;
        }
    }

    
    /**
     * metoda sprawdza poprawnosc odpowiedzi do zadanego pytania, w przypadku poprawnej odpowiedzi dodaje 100punktow do ilosci punktow
     * @param i przechowuje numer wybranej odpowiedzi np 1,2,3,4
     */
    private void wybranoOdp(int i) {
        String wybranaOdp = aktualnePytanie.odpowiedzi.get(i - 1);
        if (wybranaOdp.equals(aktualnePytanie.prawidlowaOdpowiedz)) {
            iloscPunktow += 100;

        }
        aktualnePytanie = null;
    }

    
    
    /**
     * metoda sprawdzajaca czy w polu obok duszka nie znajduje sie inny duszek, w ten sposob duszki nie nachodza na siebie
     * @param x wspolrzedna x przechowywujaca wspolrzedne do sprawdzenia czy jest tam duszek
     * @param y wspolrzedna y przechowywujaca wspolrzedne do sprawdzenia czy jest tam duszek
     * @return 
     */
    private boolean czySaInneDuchy(int x, int y) {
        for (Duch duch : duszki) {
            int duchX = (duch.pozycjaX - START_X) / WIELKOSC_KAFELKA;
            int duchY = (duch.pozycjaY - START_Y) / WIELKOSC_KAFELKA;
            if (duchX == x && duchY == y) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * metoda sprawdzajaca czy na planszy zjedzone wszystkie kropki
     * @return 
     */
    private boolean czyWszystkoZjedzone() {
        for (int i = 0; i < ILOSC_KAFELKOW; i++) {
            for (int j = 0; j < ILOSC_KAFELKOW; j++) {
                if (kafelki[i][j].rodzaj == 0 || kafelki[i][j].rodzaj == 7) {
                    return false;
                }
            }
        }
        return true;
    }

    
    /**
     * metoda wypisuje tekst poziom na planszy w okreslonej lokalizacji
     * @param g2d obiekt do rysowania grafiki
     */
    private void rysujPoziom(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.drawString("Poziom: " + poziom, (ILOSC_KAFELKOW - 4) * WIELKOSC_KAFELKA, (ILOSC_KAFELKOW + 2) * WIELKOSC_KAFELKA);
    }

    
    /**
     * inicjalizuje wszystkie kompenenty gry
     */
    private void stworzGre() {

        stworzDuszki();
        stworzKafelki();
        stworzPostac();
        stworzZycia();
        obslugaPytan.wczytajPytania(poziom);
        iloscZyc = 3;
    }
}
