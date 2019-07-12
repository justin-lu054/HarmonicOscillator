
package lujustinharmonicoscillator;

import java.text.DecimalFormat;

/**
 *
 * @author justi
 */
public class RodPendulum extends Oscillator {
    private double length; //length of the rod pendulum
    private double pointOfRotation; //default pointOfRotation is at the center of mass. Value of 0 indicates default position. 
    
    /**
     * Constructor for a Rod Pendulum object
     * @param initialPosition the initial position of the Rod Pendulum in radians
     * @param mass the mass of the rod in kilograms
     * @param length the length of the rod in meters
     * @param pointOfRotation the point of rotation on the rod (in meters above the COM)
     */
    public RodPendulum(double initialPosition, double mass, double length, double pointOfRotation) {
        super(initialPosition, mass);
        this.length = length;
        this.pointOfRotation = pointOfRotation; 
    }
    
    /**
     * Method that returns a string identifier for the type of oscillator
     * @return A string identifier for the type of oscillator
     */
    public String getOscillatorType() {
        return "Rod Pendulum"; 
    }
    
    /**
     * Method that gets the length of the rod
     * @return length of the rod
     */
    public double getLength() {
        return length; 
    }
    
    /**
     * Method that gets the point of rotation of the rod
     * @return the point of rotation
     */
    public double getPointOfRotation() {
        return pointOfRotation; 
    }
    /**
     * Method that gets the moment of inertia of the rod
     * @return the moment of inertia
     */
    public double getMomentOfInertia() {
        return (((1.0/12.0) * this.getMass() * Math.pow(length, 2)) + 
                (this.getMass() * Math.pow(pointOfRotation, 2))) ;
    }
    
    /**
     * Method that gets the period of the rod oscillator
     * @return the period of the rod oscillator
     */
    public double getPeriod() {
        return (2 * Math.PI)/this.getAngularFrequency();
    }
    
    /**
     * Method that gets the angular frequency of the rod oscillator
     * @return the angular frequency of the rod oscillator 
     */
    public double getAngularFrequency() {
        return Math.sqrt((this.getMass() * 9.8 * this.pointOfRotation) / (this.getMomentOfInertia()));
    }
    
    /**
     * Method that returns the quantity of kinetic energy present at a inputted time
     * @param time a user inputted time
     * @return the amount of kinetic energy, in joules 
     */
    public double getKE(double time) {
        return (0.5 * this.getMomentOfInertia() * 
                Math.pow(this.getAngularFrequency(), 2) * Math.pow(this.getAmplitude(), 2)
                * Math.pow(Math.sin(this.getAngularFrequency() * time), 2));
    }
    
    /**
     * Method that returns the quantity of potential energy present at a inputted time
     * @param time a user inputted time
     * @return the amount of potential energy, in joules 
     */
    public double getPE(double time) {
        double initialPE = this.getMass() * 9.8 * (length) * (1 - Math.cos(this.getInitialPosition()));
        return (initialPE - this.getKE(time));
    }
    
    /**
     * Method that returns the position of the rod pendulum at a inputted time
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
     * Method that returns a string representation of the position time function for the rod pendulum
     * @return A string representation of the position time function
     */
    public String getPositionTimeFunction() {
        return "x = " + (this.getInitialPosition() + "cos(" + this.getAngularFrequency() + "t)");
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
        return "Type: " + this.getOscillatorType() + " , " + super.toString() + " , Initial Position: " + this.getInitialPosition() + " rad " + ", Length: " + length 
               +  " m ," + " Point of Rotation: " + pointOfRotation 
               + " meters above the COM ";
    }
         
    
    
    
    
    
    
    
    
    
    
    
}
