package brightness_sensor;

public class BrightnessManager implements IBrightness{


		private IBrightness datagenerator;
		
		@SuppressWarnings("unused")
		private BrightnessManager () {}
		
		public BrightnessManager(int datgeneratortype) {
			
			switch (datgeneratortype) {
			case 0: this.datagenerator = new BrightnessDataGenerator1();
				break;
			default: this.datagenerator = new BrightnessDataGenerator1();
				break;
			}
			
		}

		public float getBrightness() {
			return datagenerator.getBrightness();
		}

}

