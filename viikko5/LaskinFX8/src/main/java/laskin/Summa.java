/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Sami
 */
public class Summa extends Komento {
    
    private int tulos;
    private int luku;
    private Sovelluslogiikka sovellus;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tulos = Integer.parseInt(tuloskentta.getText());
        
        try {
            this.luku = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            this.luku = 0;
        }
        this.sovellus = sovellus;
    }

    @Override
    public void suorita(int luku) {
        sovellus.plus(luku);
    }

    @Override
    public void peru(int luku) {
        sovellus.miinus(luku);
    }
    
}
