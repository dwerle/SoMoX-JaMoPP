package shutter_controller;


public class ShutterControllerJob implements Runnable{
	ShutterControllerJmsClient jmsClient;
	
	Shutter shutter;
	
	public ShutterControllerJob () {
		shutter = new Shutter();
		jmsClient = new ShutterControllerJmsClient();
		jmsClient.prepareCommunication();
		
	}
	
    public void run() {
		int repeat = 0;
		boolean isDaylight = false;
		boolean oldIsDaylight = false;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		do {
			isDaylight = jmsClient.receiveIsDaylight();
			
			if (isDaylight == true && oldIsDaylight == false) {
				shutter.moveShutterUp(50);
			} else if (isDaylight == false && oldIsDaylight == true) {
				shutter.moveShutterDown(50);
			}
			 oldIsDaylight = isDaylight;
			repeat++;
			
			float div = 0;
			for (int i = 1; i < 100; i++) {
				div = (100 + div) / (i *2);
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (repeat < 500);
		
		System.out.println("ShutterController End");
		jmsClient.endCommunication();
	} 
}
