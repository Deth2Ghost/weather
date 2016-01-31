package ua.wether.display;



import java.io.IOException;


import ua.wether.src.WetherData;

public class WetherStation {

    public static void main(String[] args) throws IOException, InterruptedException  {
	WetherData wetherData = new WetherData();
	CurrentCondDisplay curDisplay = new CurrentCondDisplay(wetherData);
	//StatisticDisplay statisticDisplay = new StatisticDisplay(wetherData);
	curDisplay.dislplay();
	System.out.println();
	//wetherData.setMesurment(new SourceXml().getTcoo(), new SourceXml().getPcoo(), new SourceXml().getHcoo());
    
    
    }

}
