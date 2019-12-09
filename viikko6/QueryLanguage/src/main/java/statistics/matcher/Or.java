/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;
import java.util.List;
import statistics.Player;

/**
 *
 * @author Sami
 */
public class Or implements Matcher {

    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        List<Boolean> conditions = new ArrayList<>();
        for (Matcher matcher : matchers) {
            conditions.add(matcher.matches(p));
        }
        
        Boolean cumCond  = conditions.get(0);
        for (int i = 1; i < conditions.size(); i++) {
            cumCond = cumCond ||  conditions.get(i);
        }

        return cumCond;
    }
    
}
