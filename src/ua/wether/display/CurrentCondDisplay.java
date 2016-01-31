package ua.wether.display;

import java.util.Observable;
import java.util.Observer;

import ua.wether.interfaces.Display;

import ua.wether.interfaces.Subject;
import ua.wether.src.WetherData;


public class CurrentCondDisplay implements Observer,Display{
private float temp;
private float vlazhnost;
Observable observable;
public CurrentCondDisplay(Observable observable) {
	this.observable = observable;
	observable.addObserver(this);
	// TODO Auto-generated constructor stub
}
	public void update(Observable o, Object arg) {
		if(o instanceof WetherData){
			WetherData wetherData = (WetherData)o;
			this.temp = wetherData.getTemp();
			this.vlazhnost = wetherData.getVlazhnost();
		}
		
	}
	@Override
	public void dislplay() {
		System.out.println("Temp"+temp);
		
	}
}
