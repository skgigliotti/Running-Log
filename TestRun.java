import static org.junit.Assert.*;

import org.junit.Test;


public class TestRun {



	@Test
	public void testRun() {
    Run r = new Run(4,50,2);
		assertEquals(r.getTime(), 50);
	}
}
