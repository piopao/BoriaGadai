package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import authorization.Hasher;

public class HasherTest {

	@Test
	public void test() {		
			assertTrue(Hasher.generate_hash("molly").equals("4181eecbd7a755d19fdf73887c54837cbecf63fd"));
			assertTrue(Hasher.generate_hash("flomo").equals("886ffd41c568469795a19f52486bdde64f5f5bcc"));		
	}
}
