package hms;

public class Fever {
	
	public static enum UNITS {CELSIUS, FAHRENHEIT, KELVIN};
	public static enum MEASUREDBY {MOUTH, AARMPIT};
	
	private UNITS units;
	private MEASUREDBY measuredBy;
	private float value;
	
	public Fever(float value, UNITS units, MEASUREDBY measuredBy) {
		this.units = units;
		this.measuredBy = measuredBy;
		this.value = value;
	}
	public UNITS getUnits() {
		return units;
	}
	public void setUnits(UNITS units) {
		this.units = units;
	}
	public MEASUREDBY getMeasuredBy() {
		return measuredBy;
	}
	public void setMeasuredBy(MEASUREDBY measuredBy) {
		this.measuredBy = measuredBy;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	
	public boolean convert() {
		float convertedValue = 0;
		boolean hasFever = false;
		switch(units) {
			case CELSIUS:
				convertedValue =  value - 273;
				if(convertedValue > 38) 
					hasFever = true;
				break;
			case FAHRENHEIT:
				convertedValue =  (value * 9/5) - 459.67f;
				if(convertedValue > 98.4)
					hasFever = true;
				break;	
			default:
				throw new IllegalArgumentException();
		}
		System.out.println("convertedValue"+convertedValue);
		return hasFever;
	}
	
	
}
