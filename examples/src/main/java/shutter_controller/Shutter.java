package shutter_controller;

public class Shutter {

	public int moveShutterUp(int ticks) {
		int max = ticks * 10000;
		int sum = 0;
		for (int i = 0; i < max ; i ++) {
			sum++;
		}
		
		System.out.println("Move Shutter up");
		return sum;
	}

	public int moveShutterDown(int ticks) {
		int max = ticks * 10000;
		int sum = 0;
		for (int i = 0; i < max ; i ++) {
			sum++;
		}
		System.out.println("Move Shutter down");
		return sum;
	}

}
