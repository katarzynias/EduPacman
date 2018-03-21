/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edupacman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * klasa odpowiedzialna za obsluge rankingu
 * @author sinki
 */
public class ObslugaRankingu {



    public ObslugaRankingu() {

    }

    /**
     * dodawanie wyniku do pliku
     * @param imie imie uzytkownika
     * @param wynik uzyskany wynik uzytkownika
     */
    public void dodajWynik(String imie, int wynik) {
        try {
            final Path path = Paths.get("Wyniki.txt");
            Files.write(path, Arrays.asList(imie + ":" + wynik+"\n"), StandardCharsets.UTF_8,
                    Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
        } catch (final IOException ioe) {
            // Add your own exception handling...
        }
    }

    /**
     *odczytywanie wynikow z pliku
     * @return 
     */
    public HashMap<String, Integer> odczytajWyniki() {
        HashMap<String, Integer> tabelaWynikow = new HashMap<String, Integer>();
        try {

            File f = new File("Wyniki.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            while ((readLine = b.readLine()) != null) {
                String[] wartosci = readLine.split(":");
                if(wartosci.length < 2) {
                    continue;
                }
                tabelaWynikow.put(wartosci[0], Integer.parseInt(wartosci[1]));
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sortByValues(tabelaWynikow);
    }
    

    /**
     * sortowanie wynikow z pliku w kolejnosci od najwiekszego do najmniejszego wyniku
     * @param map
     * @return 
     */
    private static HashMap sortByValues(HashMap map) { 
       List list = new LinkedList(map.entrySet());
       Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
               return ((Comparable) ((Map.Entry) (o2)).getValue())
                  .compareTo(((Map.Entry) (o1)).getValue());
            }
       });

       
       HashMap sortedHashMap = new LinkedHashMap();
       for (Iterator it = list.iterator(); it.hasNext();) {
              Map.Entry entry = (Map.Entry) it.next();
              sortedHashMap.put(entry.getKey(), entry.getValue());
       } 
       return sortedHashMap;
  }

}
