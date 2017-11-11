import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class RunTest {



	//@Test
	public void testRun() {
    Run r = new Run(4,50,2);
		assertEquals(r.getTime(), 50);
	}
}
