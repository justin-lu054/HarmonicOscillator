/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lujustinharmonicoscillator;

import java.text.DecimalFormat;

/**
 *
 * @author justi
 */
public class Pendulum extends Oscillator {
    private double ropeLength;
    
    /**
     * Constructor for the pendulum object
     * @param initialPosition the initial position of the pendulum in radians
     * @param mass the mass attached in kilograms
     * @param ropeLength the length of the rope/string
     */
    public Pendulum(double initialPosition, double mass, double ropeLength) {
        super(initialPosition, mass); 
        this.ropeLength = ropeLength; 
    }
    
    /**
     * Method that returns a string identifier for the type of oscillator
     * @return A string identifier for the type of oscillator
     */
    public String getOscillatorType() {
        return "Pendulum";
    }
    
    /**
     * Method that returns the length of the rope/string
     * @return length of the rope/string
     */
    public double getRopeLength() {
        return ropeLength; 
    }
    
    /**
     * Method that returns a string representation of the position time function for the pendulum
     * @return A string representation of the position time function
     */
    public String getPositionTimeFunction() {
        return "x = " + (this.getInitialPosition() + "cos(" + this.getAngularFrequency() + "t)");
    }

    /**
     * Method that gets the period of the rod oscillator
     * @return the period of the rod oscillator
     */
    public double getPeriod() {
        return ((2 * Math.PI) / this.getAngularFrequency());
    }

    /**
     * Method that gets the angular frequency of the rod oscillator
     * @return the angular frequency of the rod oscillator 
     */
    public double getAngularFrequency() {
        return (Math.sqrt(9.8/ropeLength));
    }
    
    /**
     * Method that returns the quantity of kinetic energy present at a inputted time
     * @param time a user inputted time
     * @return the amount of kinetic energy, in joules 
     */
    public double getKE(double time) {
        return ((0.5) * this.getMass() * Math.pow(ropeLength, 2) * Math.pow(this.getAngularFrequency(), 2)
                * Math.pow(this.getAmplitude(), 2) * Math.pow(Math.sin(this.getAngularFrequency() * time), 2));
    }
    
    /**
     * Method that returns the quantity of potential energy present at a inputted time
     * @param time a user inputted time
     * @return the amount of potential energy, in joules 
     */
    public double getPE(double time) {
        double initialPE = this.getMass() * 9.8 * (ropeLength * (1 - Math.cos(this.getInitialPosition())));
        return (initialPE - this.getKE(time));
    }
    
    /**
     * Method that returns the position of the pendulum at a inputted time
     * @param time a user inputted time
     * @return the position, in radians 
     */
    public double getPosition(double time) {
        return (this.getAmplitude() * Math.cos(this.getAngularFrequency() * time)); 
    }
    
    /**
     * Method that returns the amplitude of the rod pendulum
     * @return amplitude 
     */
    public double getAmplitude() {
        return this.getInitialPosition();
    }
    
    /**
     * Method that displays the time, position, kinetic energy, and potential energy of a rod pendulum across six
     * evenly spaced out time intervals. The method displays the information for one full period of the rod pendulum.
     */
    public void displayInfo() {
        DecimalFormat f = new DecimalFormat("###.####");
        double timeInterval = this.getPeriod()/6;
        for (double i = 0; i <= (6 * timeInterval); i += timeInterval) {
            System.out.println("Time: " + f.format(i) + " s " + " Position: " + f.format(this.getPosition(i)) + " rad "
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
        return "Type: " + this.getOscillatorType() + " , "  + super.toString() + " , Initial Position: " + this.getInitialPosition() + " rad " + ", Rope Length: " + ropeLength + " m "; 
    }
    
}
