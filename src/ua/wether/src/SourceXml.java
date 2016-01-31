package ua.wether.src;


import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class SourceXml {
	float tcoo,pcoo,hcoo;
	private BufferedImage im;
	public float getTcoo() {
		return tcoo;
	}
	public void setTcoo(float tcoo) {
		this.tcoo = tcoo;
	}
	public float getPcoo() {
		return pcoo;
	}
	public void setPcoo(float pcoo) {
		this.pcoo = pcoo;
	}
	public float getHcoo() {
		return hcoo;
	}
	public void setHcoo(float hcoo) {
		this.hcoo = hcoo;
	}
	String ff;
	URL xml;
	File f ;
	public SourceXml() throws IOException {
		
	xml = new URL("http://xml.weather.yahoo.com/forecastrss?p=UPXX0016&u=c");
	ff = "f.xml";
	f = new File(ff);
	InputStream in = new BufferedInputStream(xml.openStream());
	FileOutputStream file = new FileOutputStream(f);
	byte[] byt = new byte[1024];
	int count = -1;
	while((count = in.read(byt))!= -1){
	    file.write(byt, 0, count);
	}
	in.close();
	file.close();
	String scoo;
    
    
	try
    {
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        Document doc=db.parse(f);
        
        doc.getDocumentElement().normalize();
   
        NodeList nodeLst=doc.getElementsByTagName("yweather:atmosphere");
       
        for(int je=0;je<nodeLst.getLength();je++)
        {
            Node fstNode=nodeLst.item(je);
            if(fstNode.getNodeType()==Node.ELEMENT_NODE)
            {
            	
            	Element elj=(Element)fstNode;
                scoo=elj.getAttribute("humidity");
                hcoo=(float) Double.parseDouble(scoo);
                scoo=elj.getAttribute("pressure");
                pcoo=(float) Double.parseDouble(scoo);
               
            }
            nodeLst=doc.getElementsByTagName("yweather:condition");
            fstNode=nodeLst.item(je);
            if(fstNode.getNodeType()==Node.ELEMENT_NODE){
            	Element elj=(Element)fstNode;
            	 scoo=elj.getAttribute("temp");
                 tcoo=(float) Double.parseDouble(scoo);
                 
            }
          
            }
        
    }
    catch(Exception ei){}
	
	
	
}
	public BufferedImage getIm() {
		return im;
	}
	public void setIm(BufferedImage im) {
		this.im = im;
	}
	
	
	
}
