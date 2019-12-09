package display_controller;

public class Display {
	public int printADigit() {
		int sum = 0;
		
		for (int i = 0; i < 1000; i++) {
			sum++;
		}
		
		return sum;
	}

	public int turnOnLED(boolean b) {
		int sum = 0;
		if (b) {
			for (int i = 0; i < 100; i++) {
				sum++;
			}
		} else {
			for (int i = 0; i < 500; i++) {
				sum++;
			}
		}
		return sum;
	}
}
