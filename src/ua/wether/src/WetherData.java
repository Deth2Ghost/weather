package ua.wether.src;

import java.util.ArrayList;

import ua.wether.interfaces.Observer;
import ua.wether.interfaces.Subject;

public class WetherData implements Subject {
    private ArrayList observers;
    private float temp;
    private float press;
    private float vlazhnost;

    public WetherData() {
	observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
	observers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
	int i;
	i = observers.indexOf(o);
	if(i>=0){
	observers.remove(i);
	}
    }

    @Override
    public void notifyObserver() {
	for (int i = 0; i < observers.size(); i++) {
	    Observer observer = (Observer)observers.get(i);
	    observer.update(temp, press, vlazhnost);
	}

    }
    public void mesurmentChanged(){
	notifyObserver();
    }
    public void setMesurment(float temp, float press, float vlazhnost){
	this.temp = temp;
	this.press = press;
	this.vlazhnost = vlazhnost;
	mesurmentChanged();
    }

   

}
