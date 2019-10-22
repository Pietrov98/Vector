package UI_package;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import VectorsRepo_package.PrintList;
import VectorsRepo_package.VectorRepository;
import Vectors_package.IVector;
import Vectors_package.Vector2D;
import Vectors_package.Vector3D;
import XML_package.XMLWriter;

public class UserInterface {
	public void mainLoop()
	{
		VectorRepository vecRepo = new VectorRepository();
		Scanner in = new Scanner(System.in);
		while(true)
		{
			System.out.println("0.Wyjscie\n"
							 + "1.Dodaj wektor\n"
							 + "2.Usun wektor\n"
							 + "3.Iloczyn skalarny\n"
							 + "4.Iloczyn wektorowy\n"
							 + "5.Dodaj wektory\n"
							 + "6.Lista wektorow\n" 
							 + "7.Zapisz wektory do pliku");
			@SuppressWarnings("resource")
			int choice = in.nextInt();
			
			if(choice == 1)
			{
				choice = -1;
				System.out.println("1.Wektor 2D\n2.Wektor 3D");
				choice = in.nextInt();
				double vx, vy;
				System.out.println("Podaj parametry wektora: ");
				vx = in.nextDouble();
				vy = in.nextDouble();
				if(choice == 1)
				{
					Vector2D obj = new Vector2D();
					obj.setVx(vx);
					obj.setVy(vy);
					vecRepo.addVector(obj);
				}
				else if(choice == 2)
				{
					double vz;
					Vector3D obj = new Vector3D();
					vz = in.nextDouble();
					obj.setVx(vx);
					obj.setVy(vy);
					obj.setVz(vz);
					vecRepo.addVector(obj);
				}		
			}
			else if(choice == 2)
			{
				choice = -1;
				System.out.println("1.Wektor 2D\n2.Wektor 3D");
				choice = in.nextInt();
				double vx, vy;
				System.out.println("Podaj parametry wektora: ");
				vx = in.nextDouble();
				vy = in.nextDouble();
				if(choice == 1)
				{
					Vector2D obj = new Vector2D();					
					obj.setVx(vx);
					obj.setVy(vy);
					vecRepo.removeVector(obj);
					
				}
				else if(choice == 2)
				{
					double vz;
					Vector3D obj = new Vector3D();
					vz = in.nextDouble();
					obj.setVx(vx);
					obj.setVy(vy);
					obj.setVz(vz);
					vecRepo.removeVector(obj);
				}
			}
			else if(choice == 3)
			{
				List<Double> v1 = new ArrayList<Double>();
				List<Double> v2 = new ArrayList<Double>();
				choice = -1;
				System.out.println("1.Wektor 2D\n2.Wektor 3D");
				choice = in.nextInt();
				double vx, vy;
				System.out.println("Podaj parametry wektora, ktory chcesz wybrac: ");
				v1.add(in.nextDouble());
				v1.add(in.nextDouble());
				if(choice == 1)
				{
					v1.add(null);
					if(vecRepo.getVector(v1) != null)
					{
						System.out.println("Podaj parametry wektora, ktory chcesz wybrac: ");
						v2.add(in.nextDouble());
						v2.add(in.nextDouble());
						v2.add(null);
						if(vecRepo.getVector(v2) != null)
						{
							double scalar = IVector.scalarProduct(vecRepo.getVector(v1), vecRepo.getVector(v2));
							System.out.println("Iloczyn skalarany to " + scalar + "\n");
						}
						else
							System.out.println("Brak podanego wektora");
					}
					else
						System.out.println("Brak podanego wektora");
					
					
				}
				else if(choice == 2)
				{
					v1.add(in.nextDouble());
					if(vecRepo.getVector(v1) != null)
					{
						System.out.println("Podaj parametry wektora, ktory chcesz wybrac: ");
						v2.add(in.nextDouble());
						v2.add(in.nextDouble());
						v2.add(in.nextDouble());
						if(vecRepo.getVector(v2) != null)
						{
							double scalar = IVector.scalarProduct(vecRepo.getVector(v1), vecRepo.getVector(v2));
							System.out.println("Iloczyn skalarany to " + scalar + "\n");
						}
						else
							System.out.println("Brak podanego wektora");
					}
					else
						System.out.println("Brak podanego wektora");
				}
			}
			else if(choice == 4)
			{
				List<Double> v1 = new ArrayList<Double>();
				List<Double> v2 = new ArrayList<Double>();
				choice = -1;
				System.out.println("1.Wektor 2D\n2.Wektor 3D");
				choice = in.nextInt();
				double vx, vy;
				System.out.println("Podaj parametry wektora, ktory chcesz wybrac: ");
				v1.add(in.nextDouble());
				v1.add(in.nextDouble());
				if(choice == 1)
				{
					v1.add(null);
					if(vecRepo.getVector(v1) != null)
					{
						System.out.println("Podaj parametry wektora, ktory chcesz wybrac: ");
						v2.add(in.nextDouble());
						v2.add(in.nextDouble());
						v2.add(null);
						if(vecRepo.getVector(v2) != null)
						{
							Vector3D vec = (Vector3D) IVector.vectorProduct(vecRepo.getVector(v1), vecRepo.getVector(v2));
							System.out.println("Iloczyn wektorowy to [" + vec.getVx() + ", " + vec.getVy() + ", " + vec.getVz() + "]\n");
						}
						else
							System.out.println("Brak podanego wektora");
					}
					else
						System.out.println("Brak podanego wektora");
					
					
				}
				else if(choice == 2)
				{
					
					double vz;
					v1.add(in.nextDouble());
					if(vecRepo.getVector(v1) != null)
					{
						System.out.println("Podaj parametry wektora, ktory chcesz wybrac: ");
						v2.add(in.nextDouble());
						v2.add(in.nextDouble());
						v2.add(in.nextDouble());
						if(vecRepo.getVector(v2) != null)
						{
							Vector3D vec = (Vector3D) IVector.vectorProduct(vecRepo.getVector(v1), vecRepo.getVector(v2));
							System.out.println("Iloczyn wektorowy to [" + vec.getVx() + ", " + vec.getVy() + ", " + vec.getVz() + "]\n");
						}
						else
							System.out.println("Brak podanego wektora");
					}
					else
						System.out.println("Brak podanego wektora");
				}
			}
			else if(choice == 5)
			{
				List<Double> v1 = new ArrayList<Double>();
				List<Double> v2 = new ArrayList<Double>();
				choice = -1;
				System.out.println("1.Wektor 2D\n2.Wektor 3D");
				choice = in.nextInt();
				double vx, vy;
				System.out.println("Podaj parametry wektora, ktory chcesz wybrac: ");
				v1.add(in.nextDouble());
				v1.add(in.nextDouble());
				if(choice == 1)
				{
					v1.add(null);
					if(vecRepo.getVector(v1) != null)
					{
						System.out.println("Podaj parametry wektora, ktory chcesz wybrac: ");
						v2.add(in.nextDouble());
						v2.add(in.nextDouble());
						v2.add(null);
						if(vecRepo.getVector(v2) != null)
						{
							Vector2D vec = (Vector2D) IVector.addVector(vecRepo.getVector(v1), vecRepo.getVector(v2));
							System.out.println("Suma wektorow to [" + vec.getVx() + ", " + vec.getVy() + "]\n");
						}
						else
							System.out.println("Brak podanego wektora");
					}
					else
						System.out.println("Brak podanego wektora");
				}
				else if(choice == 2)
				{
					double vz;
					v1.add(in.nextDouble());
					if(vecRepo.getVector(v1) != null)
					{
						System.out.println("Podaj parametry wektora, ktory chcesz wybrac: ");
						v2.add(in.nextDouble());
						v2.add(in.nextDouble());
						v2.add(in.nextDouble());
						if(vecRepo.getVector(v2) != null)
						{
							Vector3D vec = (Vector3D) IVector.addVector(vecRepo.getVector(v1), vecRepo.getVector(v2));
							System.out.println("Suma wektorow to [" + vec.getVx() + ", " + vec.getVy() + ", " + vec.getVz() + "]\n");
						}
						else
							System.out.println("Brak podanego wektora");
					}
					else
						System.out.println("Brak podanego wektora");
				}
			}
			else if(choice == 6)
			{
				PrintList.printVectorList(vecRepo.getList());
			}
			else if(choice == 7)
			{
				
				XMLWriter.writeToXml(vecRepo.getList());
			}
			else if(choice == 0)
			{
				XMLWriter.writeToXml(vecRepo.getList());
				System.exit(1);;
			}
			
		}
		
		
	}
}
