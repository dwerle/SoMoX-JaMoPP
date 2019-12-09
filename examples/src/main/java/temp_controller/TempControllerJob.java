package temp_controller;

import temperature_sensor.ITemperature;

public class TempControllerJob implements Runnable {

	private ITemperature sensor;
	private int counter = 0;
	private int counter_max = 100;
	private float[] datas = new float[counter_max];
	
	private float temperature;
	
	TempControllerJmsClient jmsClient;
	
	public TempControllerJob(ITemperature sensor) {
		this.sensor = sensor;
		this.jmsClient = new TempControllerJmsClient();
		jmsClient.prepareCommunication();
	}
	
   public void run() {
		int repeat = 0;
		
		do {
			if (counter >= counter_max) {
				for (int i = 0; i < counter_max; i++ )
				{
					temperature += datas[i];
				}
				temperature = temperature / counter_max;
				
				jmsClient.sendTemperature(temperature);
				
				counter = 0;
				
				datas[0] = this.sensor.getTemperature();
			} else {
				
				datas[counter] = this.sensor.getTemperature();
				counter++;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repeat++;
		} while (repeat <= 3600);
		
		jmsClient.endCommunication();
		System.out.println("TController end");
	}
}
