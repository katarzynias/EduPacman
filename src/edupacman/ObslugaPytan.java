/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edupacman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 *klasa odpowiedzialna za obsluge pytan
 * @author sinki
 */
public class ObslugaPytan {
    
    ArrayList<Pytanie> pytania = new ArrayList<Pytanie>();
    Random rand;
    
    public ObslugaPytan() {

        rand = new Random();
    }

    /**
     * losowanie pytania z listy pytan
     * @return 
     */
    public Pytanie losujPytanie() {
        
        return pytania.get(rand.nextInt(pytania.size()));
    }
    
    /**
     * wcyztywanie pytania z pliku w zaleznosci od poziomu
     * @param poziom poziom gry 
     */
    public void wczytajPytania(int poziom) {
        pytania.removeAll(pytania);
        try {

            File f = new File("Pytania"+poziom+".txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            while ((readLine = b.readLine()) != null) {
                Pytanie pytanie = new Pytanie();
                pytanie.trescPytania = readLine;
                pytanie.prawidlowaOdpowiedz = b.readLine();
                pytanie.odpowiedzi.add(pytanie.prawidlowaOdpowiedz);
                pytanie.odpowiedzi.add(b.readLine());
                pytanie.odpowiedzi.add(b.readLine());
                pytanie.odpowiedzi.add(b.readLine());
                pytania.add(pytanie);
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    
    
}
