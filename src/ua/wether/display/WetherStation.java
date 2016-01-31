package ua.wether.display;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;

import ua.wether.src.WetherData;

public class WetherStation {

    public static void main(String[] args) throws IOException {
	WetherData wetherData = new WetherData();
	CurrentCondDisplay curDisplay = new CurrentCondDisplay(wetherData);
	StatisticDisplay statisticDisplay = new StatisticDisplay(wetherData);
	wetherData.setMesurment(33, 40, 65);
	wetherData.setMesurment(40, 40, 60);
	wetherData.setMesurment(26, 40, 80);
	URL xml = new URL("http://xml.weather.yahoo.com/forecastrss?p=UPXX0016&u=c");
	String ff = "f.xml";
	File f = new File(ff);
	InputStream in = new BufferedInputStream(xml.openStream());
	FileOutputStream file = new FileOutputStream(f);
	byte[] byt = new byte[1024];
	int count = -1;
	while((count = in.read(byt))!= -1){
	    file.write(byt, 0, count);
	}
	in.close();
	file.close();
	Scanner sc = new Scanner(f);
	StringBuilder a = new StringBuilder();
	while(sc.hasNextLine()){
	    a.append(sc.nextLine());
	}
	
	System.out.println(a);
	
    }

}
