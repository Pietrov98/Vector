package VectorsRepo_package;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import Vectors_package.IVector;
import Vectors_package.Vector3D;
import XML_package.XMLReader;

public class VectorRepository {
	private List<IVector> vectorList = new ArrayList<IVector>();

	public VectorRepository()
	{
		try {
			vectorList = XMLReader.xmlReadFromFile();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<IVector> getList()
	{
		return vectorList;
	}
	
	
	public void addVector (IVector vec)
	{
		vectorList.add(vec);
		if(vec instanceof Vector3D)
		{
			System.out.println("Dodano wektor [" + vec.getVx() + ", " + vec.getVy() + ", " + ((Vector3D) vec).getVz() + "] " + vec.getAbs() + " " + vec.getAngle() + " " + ((Vector3D)vec).get2Angle());
		}
		else
			System.out.println("Dodano wektor [" + vec.getVx() + ", " + vec.getVy() + "] " + vec.getAbs() + " " + vec.getAngle());

		//vectorList.get(0);
	}
	
	public void removeVector(IVector vec)
	{
		if(vec instanceof Vector3D)
		{
			for(int i = 0; i < vectorList.size(); i++)
			{
				if(vectorList.get(i) instanceof Vector3D)
				{
					if(Double.compare(vectorList.get(i).getVx(), vec.getVx()) == 0 && Double.compare(vectorList.get(i).getVy(), vec.getVy()) == 0 && Double.compare(((Vector3D) vectorList.get(i)).getVz(), ((Vector3D) vec).getVz()) == 0)
					{
						System.out.println("Wektor ["+ vec.getVx() + ", " + vec.getVy() + ", " + ((Vector3D) vec).getVz() +  "] zostal usuniety");
						vectorList.remove(i);
						break;
					}
				}
				
			}
		}
		else
		{
			for(int i = 0; i < vectorList.size(); i++)
			{
				if(Double.compare(vectorList.get(i).getVx(), vec.getVx()) == 0 && Double.compare(vectorList.get(i).getVy(), vec.getVy()) == 0)
				{
					System.out.println("Wektor ["+ vec.getVx() + ", " + vec.getVy() + "] zostal usuniety");
					vectorList.remove(i);
					break;
				}
			}
		}
	}
	
	public IVector getVector(List<Double> v) // podajemy wspolrzedne
	{
		if(v.get(2) == null)
		{
			for(int i = 0; i < vectorList.size(); i++)
			{
				if(Double.compare(vectorList.get(i).getVx(), v.get(0)) == 0 && Double.compare(vectorList.get(i).getVy(), v.get(1)) == 0)
				{
					
					return vectorList.get(i);
				}
			}
		}
		if(v.get(2) != null)
		{
			//System.out.println(v.get(0)+ " " + v.get(1) + " " + v.get(2));
			for(int i = 0; i < vectorList.size(); i++)
			{
				if(Double.compare(vectorList.get(i).getVx(), v.get(0)) == 0 && Double.compare(vectorList.get(i).getVy(), v.get(1)) == 0 && Double.compare(((Vector3D) vectorList.get(i)).getVz(), v.get(2)) == 0)
				{
					System.out.println("dziaala");
					return vectorList.get(i);
				}
			}
		}
		
		return null;
	}
}
