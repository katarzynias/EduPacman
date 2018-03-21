/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edupacman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




/**
 *klasa odpowiedzialna za pytania w grze
 * @author sinki
 */
public class Pytanie {
    
    String trescPytania;
    List<String> odpowiedzi;
    String prawidlowaOdpowiedz;

    /**
     * inicjalizacja listy odpowiedzi
     */
    public Pytanie() {
        this.odpowiedzi = new ArrayList();
        
    }
   
    
    /**
     * mieszanie odpowiedzi 
     */
    public void losujOdpowiedzi() {
        Collections.shuffle(odpowiedzi);
    }
    
    
    
    
}
