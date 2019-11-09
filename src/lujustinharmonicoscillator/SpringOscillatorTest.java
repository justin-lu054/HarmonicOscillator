package lujustinharmonicoscillator;

import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpringOscillatorTest {
	
	SpringOscillator test;
	@Before
	public void init() {
		test = new SpringOscillator(0.02, 5, 10000);
	}
	
	@Test
	public void testPeriod() {
		assertTrue(test.getPeriod() < 0.141 && test.getPeriod() > 0.140);
	}
	
	@Test
	public void testFreq() {
		assertTrue(test.getAngularFrequency() < 44.75 && test.getAngularFrequency() > 44.7);
	}
	
	@Test
	public void testKE() {
		assertTrue(test.getKE(0.5) < 0.261 && test.getKE(0.5) > 0.26);
	}
	
	@Test
	public void testPE() {
		assertTrue(test.getPE(0.5) < 1.74 && test.getPE(0.5) > 1.739);
	}
	
	@Test
	public void testPosition() {
		assertTrue(test.getPosition(0.5) > -0.019 && test.getPosition(0.5) < -0.018);
	}
	
	@Test
	public void testAmplitude() {
		assertTrue(test.getAmplitude() < 0.021 && test.getAmplitude() > 0.019);
	}
	
	
}
