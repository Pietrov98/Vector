package XML_package;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Vectors_package.IVector;
import Vectors_package.Vector2D;
import Vectors_package.Vector3D;


public abstract class XMLReader {
	public static List<IVector> xmlReadFromFile() throws SAXException, IOException, ParserConfigurationException
	{
		List<IVector> vectorList = new ArrayList<IVector>();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse("src/vectors.xml");
		NodeList list = document.getElementsByTagName("Vector");
		System.out.println("Czytam dane z pliku...");
		for(int i = 0; i < list.getLength(); i++)
		{
			Node node = list.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element) node;
				double vx = Double.parseDouble(element.getElementsByTagName("Vx").item(0).getTextContent());
				double vy = Double.parseDouble(element.getElementsByTagName("Vy").item(0).getTextContent());
				String vz = element.getElementsByTagName("Vz").item(0).getTextContent();
				if(vz.compareTo("null") == 0)
				{
					Vector2D vec2D = new Vector2D();
					vec2D.setVx(vx);
					vec2D.setVy(vy);
					vectorList.add(vec2D);
				}
				else
				{

					Vector3D vec3D = new Vector3D();
					vec3D.setVx(vx);
					vec3D.setVy(vy);
					((Vector3D) vec3D).setVz(1);
					vectorList.add(vec3D);
				}				

			}
		}
		
		return vectorList;
		
	}
}
