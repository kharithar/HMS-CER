/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author haritha
 */
public class Vitals {
    
    private int vitalsId;
    private int patientId;
    public static enum Units {CELSIUS, FAHRENHEIT};
    private Units units;
    private double temperature;
    private Calendar date  = new GregorianCalendar();
    private float bmi = 0.0f;
    private float height = 0.0f;//inches
    private float weight = 0.0f;//pounds
    private boolean hasFever = false;

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }
    
    	public Vitals()
	{
		
	}
	public Vitals(int id, int pid, float h, float w, float t)
	{
		patientId = pid;
		vitalsId = id;
		temperature = t;
		weight = w;
		height = h;
	}
	
	public Vitals(int id, int pid, float Bmi)
	{
		patientId = pid;
		vitalsId = id;
		this.bmi = Bmi;
	}
	
	public Vitals(int id, int pid, float Bmi, float temp)
	{
		patientId = pid;
		vitalsId = id;
		this.bmi = Bmi;
		temperature = temp;
	}
	
	public Vitals(int id, int pid, Calendar date, float Bmi, float temp)
	{
		patientId = pid;
		vitalsId = id;
		this.bmi = Bmi;
		this.date = date;
		temperature = temp;
	}

    public int getVitalsId() {
        return vitalsId;
    }

    public void setVitalsId(int vitalsId) {
        this.vitalsId = vitalsId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
        
    public String getDateStirng(){
		String dateString = "";
                dateString += date.get(Calendar.MONTH)+1 +"/"+date.get(Calendar.DAY_OF_MONTH) +"/"+date.get(Calendar.YEAR);
                        
                return dateString;
	}
    
    public String getTemperatureString(){
                String value = "";
		NumberFormat formatter = new DecimalFormat("#00.##");
		value = formatter.format(temperature);
		return value;
		//return NumberUtil.getTwoDigits(temperature);
	}
    public boolean getHasFever() {
        if((temperature > 98.4 && units == Units.FAHRENHEIT) || (temperature > 36.88 && units == Units.CELSIUS)) {
            return true;     
        }else{
            return false;
        }
    }
    
    public void setHasFever(boolean hasFever){
        this.hasFever = hasFever;
    }
    
}
