package ua.wether.src;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ua.wether.gui.WetherGui;

	
public class ImageParse{
	String img;
	private String imgSrc;
	BufferedImage image;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public static String getCharacterDataFromElement(Element e) {

	    NodeList list = e.getChildNodes();
	    String data;

	    for(int index = 0; index < list.getLength(); index++){
	        if(list.item(index) instanceof CharacterData){
	            CharacterData child = (CharacterData) list.item(index);
	            data = child.getData();

	            if(data != null && data.trim().length() > 0)
	                return child.getData();
	        }
	    }
	    return "";
	}
	
   public  ImageParse() throws MalformedURLException, IOException {
	   
	   try
	    {
	        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	        DocumentBuilder db=dbf.newDocumentBuilder();
	        Document doc=db.parse(new SourceXml().f);
	        
	        doc.getDocumentElement().normalize();
	   
	        NodeList nodeLst=doc.getElementsByTagName("description");
	       
	        for(int je=0;je<nodeLst.getLength();je++)
	        {
	        	Element elj = (Element)nodeLst.item(je);
	        	
	            
	        img = getCharacterDataFromElement(elj);
	        Matcher matcher = Pattern.compile("<img src=\"([^\"]+)").matcher(img);
	        while (matcher.find()) {
	           
	            img = matcher.group(1);
	        }
	    }}
	        catch(Exception ei){}
   
	   image = ImageIO.read(new URL(getImg()));
	   File imgg = new File("1.gif");
	   ImageIO.write(image, "gif", imgg);
	   setImgSrc(imgg.getPath());
   }
public String getImgSrc() {
	return imgSrc;
}
public void setImgSrc(String imgSrc) {
	this.imgSrc = imgSrc;
}
   
   	
}