
package lujustinharmonicoscillator;

import java.io.*;
import java.text.DecimalFormat;

/**
 *
 * @author justi
 */
public class SpringOscillator extends Oscillator{
    private double springCoefficient; 
    
    /**
     * Constructor for a Spring Oscillator object
     * @param initialPosition the initial compression/extension of the spring (in meters)
     * @param mass The mass attached in kilograms
     * @param springCoefficient the spring coefficient in newtons per meter
     */
    public SpringOscillator(double initialPosition, double mass, double springCoefficient) {
        super(initialPosition, mass);
        this.springCoefficient = springCoefficient; 
    }
    
    /**
     * Method that returns a string identifier for the type of oscillator
     * @return A string identifier for the type of oscillator
     */
    public String getOscillatorType() {
        return "Spring"; 
    }
    
    /**
     * Method that gets the spring coefficient
     * @return spring coefficient
     */
    public double getSpringCoefficient() {
        return springCoefficient;
    }
    
    /**
      * Method that returns the amplitude of the rod pendulum
      * @return amplitude 
      */
    public double getAmplitude() {
        return this.getInitialPosition();
    }
    
    /**
     * Method that gets the angular frequency of the rod oscillator
     * @return the angular frequency of the rod oscillator 
     */
    public double getAngularFrequency() {
        return Math.sqrt(springCoefficient / this.getMass());
    }
    
    /**
     * Method that gets the period of the spring oscillator
     * @return the period of the spring oscillator
     */
    public double getPeriod() {
        return ((2 * Math.PI) / this.getAngularFrequency());
    }
    
    /**
     * Method that returns the quantity of potential energy present at a inputted time
     * @param time a user inputted time
     * @return the amount of potential energy, in joules 
     */
    public double getPE(double time) {
        return (0.5 * this.getMass() * Math.pow(this.getAngularFrequency(), 2) * Math.pow(this.getInitialPosition(),2) * Math.pow(Math.cos(this.getAngularFrequency() * time), 2));
    }
    
    /**
     * Method that returns the quantity of kinetic energy present at a inputted time
     * @param time a user inputted time
     * @return the amount of kinetic energy, in joules 
     */
    public double getKE(double time) {
        return (0.5 * this.getMass() * Math.pow(this.getAngularFrequency(), 2) * Math.pow(this.getInitialPosition(),2) * Math.pow(Math.sin(this.getAngularFrequency() * time), 2));
    }
    
    /**
     * Method that returns the position of the rod pendulum at a inputted time
     * @param time a user inputted time
     * @return the position, in meters
     */
    public double getPosition(double time) {
        return (this.getAmplitude() * Math.cos(this.getAngularFrequency() * time)); 
    }
    
    /**
     * Method that returns a string representation of the position time function for the spring oscillator
     * @return A string representation of the position time function
     */
    public String getPositionTimeFunction() {
        return "x = " + (this.getInitialPosition() + "cos(" + this.getAngularFrequency() + "t)");
    }
    
    /**
     * Displays an organized table of the respective position, kinetic energy, and potential energy
     * at evenly spaced out time intervals.
     * 
     */
    public void displayInfo() {
        DecimalFormat f = new DecimalFormat("###.####");
        double timeInterval = this.getPeriod()/6;
        for (double i = 0; i <= (6 * timeInterval); i += timeInterval) {
            System.out.println("Time: " + f.format(i) + " s " + " Position: " + f.format(this.getPosition(i)) + " m "
                                + " Kinetic Energy: " + f.format(this.getKE(i)) + " J "
                                + " Potential Energy: " + f.format(this.getPE(i)) + " J ");            
        }
    }
    
    /**
     * Displays all relevant information in an organized String
     * @return all relevant information in an organized String
     */
    @Override
    public String toString() {
        return "Type: " + this.getOscillatorType() + " , "  + super.toString() + " , " + "Initial Position: " + this.getInitialPosition() + " m " + ", Spring Coefficient: " + springCoefficient + " N/m";
    }
    

        
    
    
    
    
    
    
    
}
