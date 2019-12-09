import brightness_controller.BrightnessControllerJob;
import brightness_sensor.BrightnessManager;
import display_controller.DisplayControllerJob;
import shutter_controller.ShutterControllerJob;
import temp_controller.TempControllerJob;
import temperature_sensor.TemeratureManger;

public class App {

	public static void main(String[] args) {
		TemeratureManger temperapureSen = new TemeratureManger(0);
		BrightnessManager brightnessManger = new BrightnessManager(0);
				
		Thread t1 = new Thread( new BrightnessControllerJob(brightnessManger) );
		Thread t2 = new Thread( new TempControllerJob(temperapureSen) );
		Thread t3 = new Thread( new DisplayControllerJob() );
		Thread t4 = new Thread ( new ShutterControllerJob());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
