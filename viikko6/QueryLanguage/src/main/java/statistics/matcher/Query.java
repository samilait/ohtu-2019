/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.LinkedList;
import statistics.Player;

/**
 *
 * @author Sami
 */
public class Query implements Matcher {
    private LinkedList<String> elements;

    public Query() {
        elements = new LinkedList<String>();
    }

    public void push(String alkio){
        elements.addFirst(alkio);
    }

    public String pop(){
        return elements.remove();
    }

    public boolean empty(){
        return elements.isEmpty();
    }    

    @Override
    public boolean matches(Player p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
