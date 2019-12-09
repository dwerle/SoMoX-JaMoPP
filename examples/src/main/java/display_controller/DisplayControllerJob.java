package display_controller;

public class DisplayControllerJob implements Runnable {

	DisplayControllerTemperatureJmsClient jmsClient;
	DisplayControllerDaylightJmsClient jmsClientDaylight;
	
	Display display;
	
	public DisplayControllerJob () {
		display = new Display();
		jmsClient = new DisplayControllerTemperatureJmsClient();
		jmsClient.prepareDisplayTemperatureCommunication();
		
		jmsClientDaylight = new DisplayControllerDaylightJmsClient();
		jmsClientDaylight.prepareDisplayDaylightCommunication();
		
	}
	
    public void run() {
		int repeat = 0;
		boolean isDaylight = false;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		do {
			float temperature = jmsClient.receiveTemperature();
			isDaylight = jmsClientDaylight.receiveIsDaylight();
			
			if ( temperature < 10) { // one digit
				display.printADigit();
			} else if (temperature < 100) { // two digits
				display.printADigit();
				display.printADigit();
			} else {
				display.printADigit();
				display.printADigit();
				display.printADigit();
			}
			
			if (isDaylight == false) {
				display.turnOnLED(true);
				display.turnOnLED(false);
				display.turnOnLED(true);
			}
			
			repeat++;
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (repeat < 500);
		
		System.out.println("DisplayControllerEnd");
		jmsClient.endDisplayTemperatureCommunication();
		jmsClientDaylight.endDisplayDaylightCommunication();
	} 
}
