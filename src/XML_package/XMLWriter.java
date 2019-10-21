package XML_package;
import java.util.List;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import Vectors_package.IVector;
import Vectors_package.Vector2D;
import Vectors_package.Vector3D;

 
public abstract class XMLWriter {
 
    public static void writeToXml(List<IVector> vectorList) {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElementNS("", "Vectors");
            doc.appendChild(mainRootElement);
 
            // append child elements to root element
            for(int i = 0; i < vectorList.size(); i++)
            {
            	if(vectorList.get(i) instanceof Vector3D)	
            	{	
            		Vector3D vec3D = (Vector3D) vectorList.get(i);
            		mainRootElement.appendChild(getVector(doc, Integer.toString(i), Double.toString(vec3D.getVx()), Double.toString(vec3D.getVy()), Double.toString(vec3D.getVz())));
            	}
            	else
            	{
            		Vector2D vec2D = (Vector2D) vectorList.get(i);
            		mainRootElement.appendChild(getVector(doc, Integer.toString(i), Double.toString(vec2D.getVx()), Double.toString(vec2D.getVy()), "null"));
            	}
            	
            }
            
            // output DOM XML to file 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult("src/vectors.xml");
            transformer.transform(source, console);
 
            System.out.println("\nDane zostaly zapisane do pliku Xml...");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
 
    private static Node getVector(Document doc, String id, String name, String age, String role) {
        Element vector = doc.createElement("Vector");
        //vector.setAttribute("id", id);
        vector.appendChild(getVectorElements(doc, vector, "Vx", name));
        vector.appendChild(getVectorElements(doc, vector, "Vy", age));
        vector.appendChild(getVectorElements(doc, vector, "Vz", role));
        return vector;
    }
 
    // utility method to create text node
    private static Node getVectorElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}