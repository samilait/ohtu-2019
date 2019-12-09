/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author Sami
 */
public class QueryBuilder {
    Matcher matcher;
    private Matcher[] matchers;

    public QueryBuilder() {
        this.matcher = new All();
    }
    
    public QueryBuilder playsIn(String team) {
        
        this.matcher = new And( new PlaysIn(team) );
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher = new And( new HasAtLeast(value, category) );
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher = new And( new HasFewerThan(value, category) );
        return this;
    }
    
    public Matcher build() {
//        Matcher m = new All();
        return matcher;
    }    
}
