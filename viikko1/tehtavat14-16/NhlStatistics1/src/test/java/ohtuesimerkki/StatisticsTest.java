/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sami
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
            public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }  
    };
    
    Statistics stats;
    
    public StatisticsTest() {
    }
    
    @Test
    public void listTopScorers() {
        List<Player> players = stats.topScorers(1);
        String playerName = players.get(0).getName();
        
        assertEquals("Gretzky", playerName);        
    }

    @Test
    public void existingPlayerName() {
        Player player = stats.search("Kurri");
        String playerName = player.getName();
        
        assertEquals("Kurri", playerName);        
    }

    @Test
    public void nonExistingPlayerName() {
        Player player = stats.search("Aho");
        
        assertEquals(null, player);        
    }
    
    @Test
    public void listTeam() {
        List<Player> players = stats.team("DET");
        
        assertEquals("Yzerman", players.get(0).getName());        
    }

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
