package ua.wether.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import ua.wether.interfaces.Observer;
import ua.wether.interfaces.Subject;

public class WetherData extends Observable {

	private float temp;
	private float press;
	private float vlazhnost;

	public WetherData() {

	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getPress() {
		return press;
	}

	public void setPress(float press) {
		this.press = press;
	}

	public float getVlazhnost() {
		return vlazhnost;
	}

	public void setVlazhnost(float vlazhnost) {
		this.vlazhnost = vlazhnost;
	}

	public void mesurmentChanged() {
		setChanged();
		notifyObservers();
	}

	public void setMesurment(float temp, float press, float vlazhnost) throws IOException, InterruptedException {
		while (true) {
			this.temp = new GetWeather().getTemp();
			this.press = new GetWeather().pressure;
			this.vlazhnost = new GetWeather().humidity;
			mesurmentChanged();
			Thread.sleep(600);

		}
	}

}
