package VectorsRepo_package;

import java.util.ArrayList;
import java.util.List;

import Vectors_package.IVector;

public class VectorRepository {
	private List<IVector> vectorList = new ArrayList<IVector>();

	
	public void addVector (IVector vec)
	{
		
		vectorList.add(vec);
		System.out.println(vec.getVx() + " " + vec.getVy() + " " + vec.getAbs());
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
	
	public IVector getVector(IVector vec) // podajemy wspolrzedne
	{
		
		for(int i = 0; i < vectorList.size(); i++)
		{
			if(vectorList.get(i) == vec)
			{
				return vectorList.get(i);
			}
		}
		return null;
	}
}
