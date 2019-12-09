package temperature_sensor;

public class TemeratureManger implements ITemperature{

	private ITemperature datagenerator;
	
	@SuppressWarnings("unused")
	private TemeratureManger () {}
	
	public TemeratureManger(int datgeneratortype) {
		
		switch (datgeneratortype) {
		case 0: this.datagenerator = new TempDataGenerator1();
			break;
		default: this.datagenerator = new TempDataGenerator1();
			break;
		}
		
	}
	
	public float getTemperature() {
		return datagenerator.getTemperature();
	}

}
