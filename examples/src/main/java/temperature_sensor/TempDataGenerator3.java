package temperature_sensor;

public class TempDataGenerator3 implements ITemperature{
	
	int counter = 0;
	int maxcounter =  40;
	
	float[] data = {
			5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
			50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50
	};
	public float getTemperature() {
		float dataelement = data[counter];
		
		counter++;
		
		if (counter >= maxcounter) {
			counter = 0;
		}

		return dataelement ;
	}

}
