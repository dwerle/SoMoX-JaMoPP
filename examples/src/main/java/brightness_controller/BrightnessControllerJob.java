package brightness_controller;

import brightness_sensor.IBrightness;

public class BrightnessControllerJob implements Runnable {

	private IBrightness sensor;
	
	private float brightness;
	private float oldBrightness = 0;
	
	BrightnessControllerJmsClient jmsClient;
	
	@SuppressWarnings("unused")
	private BrightnessControllerJob() {}
	
	public BrightnessControllerJob(IBrightness sensor) {
		this.sensor = sensor;
		this.jmsClient = new BrightnessControllerJmsClient();
		jmsClient.prepareBrightnessCommunication();
	}
	
	public void run() {
		int repeat = 0;
		boolean isDaylight = false;
		boolean oldisDaylight = false;
		do {
			brightness = sensor.getBrightness();
			 if (brightness > 60.0f || oldBrightness == 35.0f) {
				 isDaylight = true;			 
			 } else if (brightness < 30.0f || oldBrightness == 55.0f) {
				 isDaylight = false;
			 }
			 
			 if (brightness == 35.0f || brightness == 55.0f) {
				 oldBrightness = brightness;
			 } 
			 
			 if (oldisDaylight != isDaylight) {
				 jmsClient.sendIsDaylight(isDaylight);
				 oldisDaylight = isDaylight;
			 }
			 
			 repeat++;
			 
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} while (repeat <= 3600);
		
		jmsClient.endBrightnessCommunication();
		System.out.println("BController End");
	}

}
