/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lujustinharmonicoscillator;
import java.text.DecimalFormat;
import java.util.*; 
/**
 *
 * @author justi
 */
public class Menu {
    
    /**
     * Method that handles the main menu
     */
    
    public static void run() {
        Scanner f = new Scanner(System.in); 
        ArrayList<Oscillator> oscillatorList = new ArrayList<>(); 
        SaveLoad s = new SaveLoad(oscillatorList);
        DecimalFormat round = new DecimalFormat("###.####"); //Rounds to three decimal places 
        int response; 
        String fileName; //for 3 and 4
        do {
            System.out.println("What would you like to do?");
            System.out.println("1. Create a new oscillator");
            System.out.println("2. View all oscillators on file");
            System.out.println("3. Load an existing file of oscillators");
            System.out.println("4. Sort all oscillators currently on file");
            System.out.println("5. Save all oscillators");
            System.out.println("6. Exit the program");
            response = getIntegerInputWithinBounds(1,6,f);
            
            switch(response) {
                case 1:
                    double initialPosition;
                    double mass;
                    Oscillator o;
                    System.out.println("Which type of oscillator would you like to create?");
                    System.out.println("1. Spring Oscillator");
                    System.out.println("2. String Pendulum");
                    System.out.println("3. Rod Pendulum");
                    System.out.println("4. Return to menu");
                    response = getIntegerInputWithinBounds(1,4,f); 
                    switch(response) {
                        case 1:
                            System.out.println("Enter the initial stretch/compression of the spring in meters. Use positive values for compression and negative values for extension.");
                            initialPosition = getDoubleInputWithinBounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, f);
                            System.out.println("Enter the mass of the attached block in kilograms");
                            mass = getDoubleInputWithinBounds(0, f); 
                            System.out.println("Enter the spring coefficient of the spring in Newtons/Meter");
                            double springCoefficient = getDoubleInputWithinBounds(0, f);
                            o = new SpringOscillator(initialPosition, mass, springCoefficient); 
                            s.add(o);
                            System.out.println("The spring oscillator has been added to the file");
                            
                            
                            break; 
                        case 2:
                            System.out.println("Please note that the program only supports angles of up to 0.5 radians.");
                            System.out.println("Enter the initial angle of the pendulum in radians");
                            initialPosition = getDoubleInputWithinBounds(-0.5, 0.5, f); 
                            System.out.println("Enter the mass attached in kilograms");
                            mass = getDoubleInputWithinBounds(0, f);
                            System.out.println("Enter the length of the rope in meters");
                            double ropeLength = getDoubleInputWithinBounds(0, f);
                            o = new Pendulum(initialPosition, mass, ropeLength); 
                            s.add(o);
                            System.out.println("The pendulum has been added ot the file");
                            
                            break;
                        case 3:
                            System.out.println("Please note that the program only supports angles of up to 0.5 radians.");
                            System.out.println("Enter the initial angle of the pendulum in radians");
                            initialPosition = getDoubleInputWithinBounds(-0.5, 0.5, f); 
                            System.out.println("Enter mass of the pendulum in kilograms");
                            mass = getDoubleInputWithinBounds(0, f); 
                            System.out.println("Enter the length of the pendulum in meters"); 
                            double length = getDoubleInputWithinBounds(0, f); 
                            System.out.println("Enter the point of rotation (in meters away from the center of mass)");
                            double pointOfRotation = getDoubleInputWithinBounds(0.0000000001, length/2, f);
                            o = new RodPendulum(initialPosition, mass, length, pointOfRotation); 
                            s.add(o); 
                            System.out.println("The rod pendulum has been added to the file");
                            
                            break; 
                        case 4:
                            break; 
                    }
                    break; 
                
                case 2:
                    s.displayAllOscillators();
                    System.out.println("What would you like to do?");
                    System.out.println("1. View specific information for an oscillator");
                    System.out.println("2. Return to main menu");
                    response = getIntegerInputWithinBounds(1,2,f);
                    switch (response) {
                        case 1:
                            if(s.getNumOfOscillators() == 0) {
                                System.out.println("There are no oscillators to view.");
                                break; 
                            }
                            
                            System.out.println("Enter the number of the Oscillator you wish to view.");
                            //An additional variable is created here to prevent the program from quitting if the input is 6.
                            int oscillatorNumber = getIntegerInputWithinBounds(1, s.getNumOfOscillators(), f);
                            o = s.get(oscillatorNumber - 1); 
                            System.out.println("What information would you like to view?");
                            System.out.println("1. The Position Time Function");
                            System.out.println("2. The period (in seconds)");
                            System.out.println("3. The angular frequency");
                            System.out.println("4. The kinetic energy at a given time");
                            System.out.println("5. The potential energy at a given time");
                            System.out.println("6. The position at a given time");
                            System.out.println("7. The amplitude of the oscillator");
                            System.out.println("8. A brief table of different times, and their respective position/KE/PE.");
                            int oscillatorInfoOption = getIntegerInputWithinBounds(1, 8, f); 
                            double time; //Used for options 4,5,6
                            switch (oscillatorInfoOption) {
                                case 1:
                                    System.out.println(o.getPositionTimeFunction());
                                    break;
                                case 2:
                                    System.out.println(round.format(o.getPeriod()) + " seconds");
                                    break;
                                case 3:
                                    System.out.println(round.format(o.getAngularFrequency()) + " hz");
                                    break;
                                case 4:
                                    System.out.println("Enter a specific time (in seconds)");
                                    time = getDoubleInputWithinBounds(0, f); 
                                    System.out.println(round.format(o.getKE(time)) + " J");
                                    break;
                                case 5:
                                    System.out.println("Enter a specific time (in seconds)");
                                    time = getDoubleInputWithinBounds(0, f);
                                    System.out.println(round.format(o.getPE(time)) + " J");
                                    break;
                                case 6:
                                    System.out.println("Enter a specific time (in seconds)");
                                    time = getDoubleInputWithinBounds(0, f); 
                                    if (o instanceof SpringOscillator) {
                                        System.out.println(round.format(o.getPosition(time)) + " m");
                                    }
                                    else {
                                        System.out.println(round.format(o.getPosition(time)) + " rad");
                                    }
                                    
                                    break;
                                case 7:
                                    System.out.println(round.format(o.getAmplitude()) + " m ");
                                    break;
                                case 8: 
                                    o.displayInfo();
                                    break; 
                                   
                            }
                            break; 
                        case 2:
                            break; 
                    }
                    break;
                
                case 3:
                    System.out.println("Enter the file name");
                    fileName = f.nextLine();
                    s.loadConfig(fileName);
                    break;
                
                case 4:
                    System.out.println("What would you like to sort by?");
                    System.out.println("1. Sort by oscillator type");
                    System.out.println("2. Sort by mass");
                    System.out.println("3. Return to main menu");
                    response = getIntegerInputWithinBounds(1,3,f); 
                    switch (response) {
                        case 1:
                            s.sortType();
                            System.out.println("Successfully sorted by type");
                            break;
                        case 2:
                            s.sortMass();
                            System.out.println("Successfully sorted by mass");
                            break; 
                        case 3:
                            break;
                            
                    }
                    
                    break;
                    
                case 5: 
                    System.out.println("Enter the file name");
                    fileName = f.nextLine();
                    s.saveConfig(fileName);
                    break;
                
                case 6: 
                    break; 
                
                
            }
            
            
        } while (response != 6); 
        
        
        
        
    }
    
    /**
     * Method for getting a valid double input within user specified bounds
     * @param lowerBound the lower bound
     * @param upperBound the upper bound
     * @param f the scanner for processing user input
     * @return a valid double input 
     */
    public static double getDoubleInputWithinBounds(double lowerBound, double upperBound, Scanner f) {
        boolean isValid = false; 
        double input = 0; 
        while (!isValid) {
            try {
                input = Double.parseDouble(f.nextLine());
                if (input <= upperBound && input >= lowerBound) {
                    isValid = true;                     
                }
                else {
                    System.out.println("Please enter a NUMBER between " + lowerBound + " and " + upperBound);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a NUMBER between " + lowerBound + " and " + upperBound);
            }
            
        }
        
        return input; 
        
    }
    
    /**
     * Method for getting a valid double input greater than a specified number
     * @param lowerBound the lower bound
     * @param f the scanner for processing user input
     * @return a valid double input 
     */
    
    public static double getDoubleInputWithinBounds(double lowerBound, Scanner f) {
        boolean isValid = false; 
        double input = 0; 
        while (!isValid) {
            try {
                input = Double.parseDouble(f.nextLine());
                if (input >= lowerBound) {
                    isValid = true;                     
                }
                else {
                    System.out.println("Please enter a NUMBER greater than " + lowerBound);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a NUMBER greater than " + lowerBound);
            }
            
        }
        
        return input; 
        
    }
    
    /**
     * A method for getting a valid integer input within user specified bounds
     * @param lowerBound the lower bound
     * @param upperBound the upper bound
     * @param f scanner for processing user input
     * @return a valid integer input 
     */
    
     public static int getIntegerInputWithinBounds(int lowerBound, int upperBound, Scanner f) {
        boolean isValid = false; 
        int input = 0; 
        while (!isValid) {
            try {
                input = Integer.parseInt(f.nextLine());
                if (input <= upperBound && input >= lowerBound) {
                    isValid = true;                     
                }
                else {
                    System.out.println("Please enter a NUMBER between " + lowerBound + " and " + upperBound);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a NUMBER between " + lowerBound + " and " + upperBound);
            }
            
        }
        
        return input; 
        
    }
    
    
}
