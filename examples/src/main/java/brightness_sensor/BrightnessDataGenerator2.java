package brightness_sensor;

public class BrightnessDataGenerator2 implements IBrightness{

	int counter = 0;
	int maxcounter =  3600;
	
	float data[] =  {
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			100f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f,
			10f		
	};
	
	public float getBrightness() {
		float dataelement = data[counter];
		
		counter++;
		
		if (counter >= maxcounter) {
			counter = 0;
		}

		return dataelement ;
	}
}
