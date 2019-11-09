package lujustinharmonicoscillator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RodPendulumTest {

	RodPendulum test;
	@Before 
	public void init() {
		test = new RodPendulum(0.3, 2, 1, 0.5); 
	}
	
	@Test
	public void testPeriod() {
		assertTrue(test.getPeriod() < 1.64 && test.getPeriod() > 1.63); 
	}
	
	@Test
	public void testFreq() {
		assertTrue(test.getAngularFrequency() < 3.84 && test.getAngularFrequency() > 3.83);
	}
	
	@Test
	public void testKE() {
		assertTrue(test.getKE(0.5) > 0.39 && test.getKE(0.5) < 0.4);
	}
	
	@Test
	public void testPE() {
		assertTrue(test.getPE(0.5) < 0.486 && test.getPE(0.5) > 0.485); 
	}
	
	@Test
	public void testPosition() {
		assertTrue(test.getPosition(0.5) > -0.11 && test.getPosition(0.5) < -0.10);
	}
	
	@Test
	public void testAmplitude() {
		assertTrue(test.getAmplitude() == 0.3); 
	}
}
