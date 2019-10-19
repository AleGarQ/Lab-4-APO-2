package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.*;
import model.*;

class worldCupTest {
	private WorldCup system;
	
	private void setupEscenario() {
		system = new WorldCup("");
		Competitor comp = new Competitor("a","a","a","a","a","a","a","a");
		Competitor comp1 = new Competitor("q","b","b","b","b","b","b","b");
		Competitor comp2 = new Competitor("c","c","c","c","c","c","c","c");
		Competitor comp3 = new Competitor("d","d","d","d","d","d","d","d");
		system.addCompetitorSorted(comp);
		system.addCompetitorSorted(comp1);
		system.addCompetitorSorted(comp2);
		system.addCompetitorSorted(comp3);
	}
	
	@Test
	void testFoundCompetitor() throws CompetitorNotFound {
		setupEscenario();
		Competitor expected = new Competitor("q","b","b","b","b","b","b","b");
		assertEquals(expected.toString(), system.findCompetitor("q"));
	}

	@Test
	void addCompetitor() throws CompetitorNotFound{
	    setupEscenario();
	    Competitor comp = new Competitor("e","d","d","d","d","d","d","d");
	    system.addCompetitorSorted(comp);
	    
	    assertEquals(comp.toString(), system.findCompetitor("e"));
	}

}
