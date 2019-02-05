/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author haritha
 */
public class Temperature implements Runnable{
    
    public static enum Units {KELVIN, CELSIUS, FAHRENHEIT};
    
    private double valueInKelvin;
    
    private Units units;

    public double getValueInKelvin() {
        return valueInKelvin;
    }

    public void setValueInKelvin(double valueInKelvin) {
        this.valueInKelvin = valueInKelvin;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }
    
    public Temperature(Temperature temp) {
        this.valueInKelvin = temp.valueInKelvin;
        this.units = temp.units;
    }
    
    public Temperature(double value, Units units) {
         this.units = units;
        this.valueInKelvin = convertToKelvin(value);
       
    }
    public Temperature() {
      
   }
    protected double convertToKelvin(double value){
        double convertedValue;

      switch (units) {
          case KELVIN:     convertedValue = value;
                           break;
          case CELSIUS:    convertedValue = value + 273.15;
                           break;
          case FAHRENHEIT: convertedValue = (value + 459.67) * 5.0/9.0;
                           break;
          default:         throw new IllegalArgumentException();
      }

      return convertedValue;
    }
    
    public String toString() {
        return getValue() + " " + unitsToString();
    }
    
    public double getValue() { 
      return convertFromKelvin(valueInKelvin);
    }
    
    protected double convertFromKelvin(double value) {
      double convertedValue;

      switch (units) {
          case KELVIN:     convertedValue = value;
                           break;
          case CELSIUS:    convertedValue = value - 273.15;
                           break;
          case FAHRENHEIT: convertedValue = value * 9.0/5.0 - 459.67;
                           break;
          default:         throw new IllegalArgumentException();
      }

      return convertedValue;
  }
    
   protected String unitsToString() {
    String formattedUnits;

      switch (units) {
          case KELVIN:     formattedUnits = "K";
                           break;
          case CELSIUS:    formattedUnits = "°C";
                           break;
          case FAHRENHEIT: formattedUnits = "°F";
                           break;
          default:         throw new IllegalArgumentException();
      }

      return formattedUnits;
  }
   
   public void changeUnits(Units units){
       this.units = units;
   }

@Override
public void run() {
	
	 System.out.println(Thread.currentThread().getName()+" Start. Time = "+new Date());
	System.out.println("checking temperature..."+ Instant.now());
	
}

}
