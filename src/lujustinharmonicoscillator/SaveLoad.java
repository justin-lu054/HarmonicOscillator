/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lujustinharmonicoscillator;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author justi
 */
//A class for saving and loading configurations
public class SaveLoad {
    private ArrayList<Oscillator> oscillatorList = new ArrayList<>(); 
    
    /**
     * Constructs a SaveLoad session with an ArrayList of oscillator objects
     * @param oscillatorList ArrayList of oscillator objects
     */
    public SaveLoad(ArrayList<Oscillator> oscillatorList) {
       this.oscillatorList = oscillatorList;  
    }
    
    /**
     * Adds an oscillator to the oscillatorList
     * @param o oscillator to be added
     */
    public void add(Oscillator o) {
        oscillatorList.add(o);
    }
    
    /**
     * Prints out all oscillators and relevant information in an organized fashion
     */
    public void displayAllOscillators() {
        for (int i = 0; i < oscillatorList.size(); i++) {
            System.out.println((i+1) + ":");
            System.out.println(oscillatorList.get(i));
            System.out.println();
        }
    }
    
    /**
     * Gets an oscillator from the oscillatorList
     * @param index index on oscillatorList
     * @return 
     */
    public Oscillator get(int index) {
        return oscillatorList.get(index);
    }
    
    /**
     * Gets the number of oscillators currently on file in the oscillatorList
     * @return 
     */
    public int getNumOfOscillators() {
        return oscillatorList.size();
    }
    
    /**
     * Saves all oscillators currently on file in the oscillatorList to a csv file
     * @param fileName name of the csv file
     */
    public void saveConfig(String fileName) {
        try {
            File f = new File("src/lujustinharmonicoscillator/" + fileName + ".csv.txt");
            FileWriter writer = new FileWriter(f);
            for (Oscillator o : oscillatorList) {
                if (o instanceof Pendulum) {
                    writer.write(o.getOscillatorType() + "," + o.getInitialPosition() + ","
                                 + o.getMass() + "," + ((Pendulum)o).getRopeLength());
                    writer.write("\n");
                }
                
                if (o instanceof RodPendulum) {
                    writer.write(o.getOscillatorType() + "," + o.getInitialPosition() + ","
                                 + o.getMass() + "," + ((RodPendulum)o).getLength() + ","
                                 + ((RodPendulum)o).getPointOfRotation());
                    writer.write("\n");
                }
                
                if (o instanceof SpringOscillator) {
                    writer.write(o.getOscillatorType() + "," + o.getInitialPosition() + ","
                                 + o.getMass() + "," + ((SpringOscillator)o).getSpringCoefficient());
                    writer.write("\n");
                }  
            }
            System.out.println("Successfully saved to file");
            writer.close();
        } catch (IOException iox) {
            System.out.println("Error writing to file");
        }
    }
    
    /**
     * Loads a csv file full of oscillators into the oscillatorList
     * @param fileName name of file to be read
     */
    public void loadConfig(String fileName) {
        String line;
        try {
            Scanner reader = new Scanner(new File("src/lujustinharmonicoscillator/" + fileName + ".csv.txt"));
            while (reader.hasNext()) {
                String[] oscillatorInfo;
                line = reader.nextLine();
                if (line.contains("Pendulum")) {
                    oscillatorInfo = new String[3];
                    oscillatorInfo = line.split(",");
                    
                    Oscillator o = new Pendulum(Double.parseDouble(oscillatorInfo[1]),
                                                Double.parseDouble(oscillatorInfo[2]),
                                                Double.parseDouble(oscillatorInfo[3]));
                                                
                    oscillatorList.add(o);
                    
                }
                
                if (line.contains("Rod Pendulum")) {
                    oscillatorInfo = new String[4];
                    oscillatorInfo = line.split(",");
                    
                    Oscillator o = new RodPendulum(Double.parseDouble(oscillatorInfo[1]),
                                                   Double.parseDouble(oscillatorInfo[2]),
                                                   Double.parseDouble(oscillatorInfo[3]),
                                                   Double.parseDouble(oscillatorInfo[4]));
                    
                    oscillatorList.add(o);
                }
                
                if (line.contains("Spring")) {
                    oscillatorInfo = new String[3];
                    oscillatorInfo = line.split(","); 
                    
                    Oscillator o = new SpringOscillator(Double.parseDouble(oscillatorInfo[1]),
                                                        Double.parseDouble(oscillatorInfo[2]),
                                                        Double.parseDouble(oscillatorInfo[3])); 
                    
                    oscillatorList.add(o);
         
                }
            }
            reader.close();
            System.out.println("Succesfully loaded file");
        } catch (IOException iox) {
            System.out.println("Error reading file");
        }
    }
    
    /**
     * Sorts the oscillators on file on oscillatorList by the type of oscillator, alphabetically
     */
    public void sortType() {
        for (int i = 0; i < oscillatorList.size(); i++) {
            this.swap(i, this.IndexOfLowestAlphabetStartingFrom(i));
        }
    }
    
    /**
     * Sorts the oscillators on file on oscillatorList by increasing mass
     */
    public void sortMass() {
       for (int i = 0; i < oscillatorList.size(); i++) {
           this.swap(i, this.IndexOfLowestMassStartingFrom(i));
       }
    }
    
    /**
     * Swaps two elements in oscillatorList
     * @param index1 index of first
     * @param index2 index of second
     */
    public void swap(int index1, int index2) {
        Oscillator temp = oscillatorList.get(index1); 
        oscillatorList.set(index1,oscillatorList.get(index2));
        oscillatorList.set(index2, temp);
    }
    
    /**
     * Returns the index of the lowest alphabetical oscillator type from a starting index
     * @param startingIndex the starting index
     * @return index of lowest alphabetical oscillator type
     */
    public int IndexOfLowestAlphabetStartingFrom(int startingIndex) {
        Oscillator o = oscillatorList.get(startingIndex);
        char lowestAlphabet = o.getOscillatorType().charAt(0);
        int smallestIndex = startingIndex;
        
        for (int i = startingIndex; i < oscillatorList.size(); i++) {
            if (oscillatorList.get(i).getOscillatorType().charAt(0) < lowestAlphabet) {
                lowestAlphabet = oscillatorList.get(i).getOscillatorType().charAt(0);
                smallestIndex = i; 
            }
        }
        return smallestIndex; 
        
    }
    
    /**
     * Returns the index of the lowest mass oscillator from a starting index
     * @param startingIndex the starting index
     * @return index of lowest mass oscillator 
     */
    public int IndexOfLowestMassStartingFrom(int startingIndex) {
        Oscillator o = oscillatorList.get(startingIndex);
        double lowestMass = o.getMass();
        int smallestIndex = startingIndex;
        
        for (int i = startingIndex; i < oscillatorList.size(); i++) {
            if (oscillatorList.get(i).getMass() < lowestMass) {
                lowestMass = oscillatorList.get(i).getMass();
                smallestIndex = i; 
            }
        }
        return smallestIndex; 
    }
    
}





