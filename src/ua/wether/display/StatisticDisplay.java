package ua.wether.display;

import ua.wether.interfaces.Display;
import ua.wether.interfaces.Observer;
import ua.wether.interfaces.Subject;

public class StatisticDisplay implements Observer, Display{
    private float temp;
    private float vlazhnost;
    private float press;
    private Subject wetherData;
    private float min;
    private float max;
    public StatisticDisplay(Subject wetherData) {
	 this.wetherData = wetherData;
	    wetherData.registerObserver(this);
    }
    @Override
    public void update(float temp, float press, float vlazhnost) {
	this.temp = temp;
	this.vlazhnost = vlazhnost;
	this.press = press;
	dislplay();
	min = temp;
	if(this.temp>temp){
	    min = temp;
	}else{min = this.temp;}
    }
    @Override
    public void dislplay() {
	System.out.println("Average statistic: \n"+min+"min temp \n"+"max temp");
	
	
    }

   

}
