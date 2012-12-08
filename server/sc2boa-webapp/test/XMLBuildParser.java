import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import com.ALC.SC2BOAserver.dao.SC2BOADAO;
import com.ALC.SC2BOAserver.dao.SC2BOADAOSimpleDBImpl;
import com.ALC.SC2BOAserver.entities.OnlineBuildOrder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
 
public class XMLBuildParser {
 
	public static void main(String argv[]) {
		System.out.println("select build xml file");
		JFileChooser fc = new JFileChooser();		
		fc.showOpenDialog(null);
		System.out.println("processing build xml file");
		File fXmlFile = fc.getSelectedFile();
		System.out.println("file: "+fXmlFile);
		List<OnlineBuildOrder> list = new ArrayList<OnlineBuildOrder>();
		OnlineBuildOrder build;
 
	  try {
 
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
 
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		NodeList nList = doc.getElementsByTagName("buildorder");
		System.out.println("-----------------------");
 
		for (int temp = 0; temp < nList.getLength(); temp++) {
			System.out.println("cycling through list");
 
		   Node nNode = nList.item(temp);
		   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
		      Element eElement = (Element) nNode;
		      build = new OnlineBuildOrder();
		      build.setBuildName(getTagValue("buildname", eElement));
		      System.out.println("buildname Name : " + getTagValue("buildname", eElement));
		      build.setRace(getTagValue("race", eElement));
		      System.out.println("race: " + getTagValue("race", eElement));
		      build.setBuildOrderInstructions(getTagValue("buildinstructions", eElement).replace("\n", "<br />\n"));
	          System.out.println("build instructions: " + getTagValue("buildinstructions", eElement));
	          list.add(build);
		      
 
		   }
		}
	  } catch (Exception e) {
		  System.out.println("shit happened");
		e.printStackTrace();
	  }
	  SC2BOADAO doa = new SC2BOADAOSimpleDBImpl();
	  for(OnlineBuildOrder buildorder : list){
		  System.out.println("adding build: "+buildorder);
		  doa.addOnlineBuildOrder(buildorder);
	  }
	  System.out.println("finished");
	  
  }
 
  private static String getTagValue(String sTag, Element eElement) {
	NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
 
        Node nValue = (Node) nlList.item(0);
 
	return nValue.getNodeValue();
  }
 
}