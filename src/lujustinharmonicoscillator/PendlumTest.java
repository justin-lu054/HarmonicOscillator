package lujustinharmonicoscillator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PendlumTest {
	
	Pendulum test;
	@Before 
	public void init() {
		test = new Pendulum(0.3, 2, 1); 
	}
	
	@Test
	public void testPeriod() {
		assertTrue(test.getPeriod() < 2.01 && test.getPeriod() > 2.00); 
	}
	
	@Test
	public void testFreq() {
		assertTrue(test.getAngularFrequency() < 3.135 && test.getAngularFrequency() > 3.130);
	}
	
	@Test
	public void testKE() {
		assertTrue(test.getKE(0.5) > 0.88 && test.getKE(0.5) < 0.9);
	}
	
	@Test
	public void testPE() {
		assertTrue(test.getPE(0.5) > -0.007 && test.getPE(0.5) < -0.006); 
	}
	
	@Test
	public void testPosition() {
		assertTrue(test.getPosition(0.5) > 0.0016 && test.getPosition(0.5) < 0.0018);
	}
	
	@Test
	public void testAmplitude() {
		assertTrue(test.getAmplitude() == 0.3); 
	}
	

}
