/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lujustinharmonicoscillator;

/**
 *
 * @author justi
 */
abstract class Oscillator {
    private double initialPosition; 
    private double mass; 
    
    public Oscillator(double initialPosition, double mass) {
        this.initialPosition = initialPosition; 
        this.mass = mass; 
    }
    
    public double getMass() {
        return mass;
    }
    
    public double getInitialPosition() {
        return initialPosition; 
    }
    
    abstract String getPositionTimeFunction();
    abstract String getOscillatorType();
    abstract double getPeriod(); 
    abstract double getAngularFrequency(); 
    abstract double getKE(double time);
    abstract double getPE(double time); 
    abstract double getPosition(double time);
    abstract double getAmplitude(); 
    abstract void displayInfo();
    
    
    @Override
    public String toString() {
        return "Mass: " + mass + " kg"; 
    }
    
}
