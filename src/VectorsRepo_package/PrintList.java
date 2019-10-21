package VectorsRepo_package;

import java.util.List;

import Vectors_package.IVector;
import Vectors_package.Vector3D;

public abstract class PrintList 
{
	public static void printVectorList(List<IVector> vectorList)
	{
		for(int i = 0; i < vectorList.size(); i++)
		{
			if(vectorList.get(i) instanceof Vector3D)
				System.out.println(vectorList.get(i).getVx() + " " + vectorList.get(i).getVy() + " " + ((Vector3D) vectorList.get(i)).getVz());
			else
				System.out.println(vectorList.get(i).getVx() + " " + vectorList.get(i).getVy());
		}
	}
}
