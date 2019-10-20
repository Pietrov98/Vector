package VectorsRepo_package;

import java.util.ArrayList;
import java.util.List;

import Vectors_package.IVector;
import Vectors_package.Vector3D;

public class VectorRepository {
	private List<IVector> vectorList = new ArrayList<IVector>();

	
	public void addVector (IVector vec)
	{
		
		vectorList.add(vec);
		if(vec instanceof Vector3D)
			System.out.println(vectorList.get(0).getVx() + " " + vectorList.get(0).getVy() + " " + ((Vector3D) vectorList.get(0)).getVz() + " " + vectorList.get(0).getAbs() + " " + vectorList.get(0).getAngle());
		else
			System.out.println(vectorList.get(0).getVx() + " " + vectorList.get(0).getVy() + " " + vectorList.get(0).getAbs() + " " + vectorList.get(0).getAngle());

		//vectorList.get(0);
	}
	
	public void removeVector(IVector vec)
	{
		for(int i = 0; i < vectorList.size(); i++)
		{
			if(vectorList.get(i) == vec)
			{
				vectorList.remove(i);
				break;
			}
		}
	}
	
	public IVector getVector(List<Double> v) // podajemy wspolrzedne
	{
		System.out.println("getV " + v.get(0) + " " + v.get(1) + " " + v.get(2));
		
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
			Vector3D vec3d = new Vector3D();
			for(int i = 0; i < vectorList.size(); i++)
			{
				vec3d = (Vector3D) vectorList.get(i);
				System.out.println(vectorList.get(i).getVx() + " " + vectorList.get(i).getVy() + " " + ((Vector3D) vectorList.get(i)).getVz());
				System.out.println(v.get(0) + " " + v.get(1)  + " " + v.get(2));
				//System.out.println(vec3d.getVz());
				if(Double.compare(vec3d.getVx(), v.get(0)) == 0 && Double.compare(vec3d.getVy(), v.get(1)) == 0 && Double.compare(vec3d.getVz(), v.get(2)) == 0)
				{
					System.out.println("szukam");
					return vectorList.get(i);
				}
			}
		}
		
		return null;
	}
}
