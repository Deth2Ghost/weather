package ua.wether.src;

import java.io.IOException;
import java.util.Observable;

public class GetWeather extends Observable{
	public WetherData wetherData = new WetherData();
	private float temp;
	private float pressure;
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	private float humidity;
	public void mesurmentChanged(){
		setChanged();
		notifyObservers();
	}
	public GetWeather() throws IOException {
		this.temp = new SourceXml().getTcoo();
		this.pressure = new SourceXml().getPcoo();
		this.humidity = new SourceXml().getHcoo();
		//wetherData.setMesurment(getTemp(), pressure, humidity);
		mesurmentChanged();
	}
	public void setMesumant() throws IOException, InterruptedException {
		
    		
		
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	
	
}
