
# HarmonicOscillator
A simple harmonic oscillator simulator that can calculate and display properties of common oscillating systems.
This simulator supports the following oscillating systems: 

**Block-Spring System**    
![Blockspring](https://i.imgur.com/FVq620j.png)    
**Standard Pendulum**    
![Pendulum](https://i.imgur.com/MLfB6mV.png)   
**Physical Pendulum**    
![PhysicalPendulum](https://i.imgur.com/BJJJbvM.png)    

# Instructions
To configure an oscillator system, select option 1 from the menu, select the type of oscillator, and enter the measurements.
To view specific information, select option 2 from the menu, and select the configured oscillator you wish to view. 
To save/load, simply select the option on the menu to do so, and enter a file name. All files are stored as .csv's 

# Classes
## Oscillator
Parent class with abstract methods present

## SpringOscillator
Child of Oscillator, a class for a horizontally mounted spring-block oscillator system

## Pendulum
Child of Oscillator, a class for a string-mass oscilllator system

## PhysicalPendulum
Child of Oscillator, a class for a rigid rod oscillator system

## SaveLoad
Class responsible for saving and loading user inputted configurations

## Menu
Class responsible for displaying the menu and handling all input verification

# Calculations
All of the mathematical calculations involved in the program can be found in Appendix.pdf
