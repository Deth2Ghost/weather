package ua.wether.display;

import ua.wether.interfaces.Display;
import ua.wether.interfaces.Observer;
import ua.wether.interfaces.Subject;
import ua.wether.src.WetherData;

public class CurrentCondDisplay implements Observer, Display{
private float temp;
private float vlazhnost;
private Subject wetherData;
public CurrentCondDisplay(Subject wetherData) {
    this.wetherData = wetherData;
    wetherData.registerObserver(this);
}
    

    @Override
    public void update(float temp, float press, float vlazhnost) {
	this.temp = temp;
	this.vlazhnost = vlazhnost;
	dislplay();
	
    }
    @Override
    public void dislplay() {
	System.out.println("Current conditions: "+temp+"C"
		+"\n"+vlazhnost+"% humidity");
	
    }
}
