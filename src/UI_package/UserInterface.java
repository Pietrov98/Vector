package UI_package;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import VectorsRepo_package.VectorRepository;
import Vectors_package.IVector;
import Vectors_package.Vector2D;
import Vectors_package.Vector3D;

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
							 + "4.Iloczyn wektorowy");
			@SuppressWarnings("resource")
			int choice = in.nextInt();
			if(choice == 1)
			{
				choice = -1;
				System.out.println("1.Wektor 2D\n2.Wektor 3D");
				choice = in.nextInt();
				if(choice == 1)
				{
					double vx, vy;
					Vector2D obj = new Vector2D();
					System.out.println("Podaj parametry wektora 2D: ");
					vx = in.nextDouble();
					vy = in.nextDouble();
					obj.setVx(vx);
					obj.setVy(vy);
					vecRepo.addVector(obj);
					
				}
				else if(choice == 2)
				{
					double vx, vy, vz;
					Vector3D obj = new Vector3D();
					System.out.println("Podaj parametry wektora 3D: ");
					vx = in.nextDouble();
					vy = in.nextDouble();
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
				if(choice == 1)
				{
					double vx, vy;
					Vector2D obj = new Vector2D();
					System.out.println("Podaj parametry wektora 2D: ");
					vx = in.nextDouble();
					vy = in.nextDouble();
					obj.setVx(vx);
					obj.setVy(vy);
					vecRepo.removeVector(obj);
					
				}
				else if(choice == 2)
				{
					double vx, vy, vz;
					Vector3D obj = new Vector3D();
					System.out.println("Podaj parametry wektora 3D: ");
					vx = in.nextDouble();
					vy = in.nextDouble();
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
				if(choice == 1)
				{
					double vx, vy;
					System.out.println("Podaj parametry wektora 2D, ktory chcesz wybrac: ");
					v1.add(in.nextDouble());
					v1.add(in.nextDouble());
					v1.add(null);
					if(vecRepo.getVector(v1) != null)
					{
						System.out.println("Podaj parametry wektora 2D, ktory chcesz wybrac: ");
						v2.add(in.nextDouble());
						v2.add(in.nextDouble());
						v2.add(null);
						if(vecRepo.getVector(v2) != null)
						{
							/*Vector2D obj1 = new Vector2D();
							Vector2D obj2 = new Vector2D();
							obj1.setVx(v1.get(0));
							obj1.setVx(v1.get(1));
							obj2.setVx(v2.get(0));
							obj2.setVx(v2.get(1));*/
							Vector2D iv = (Vector2D) IVector.scalarProduct(vecRepo.getVector(v1), vecRepo.getVector(v2));
						}
						else
							System.out.println("Brak podanego wektora");
					}
					else
						System.out.println("Brak podanego wektora");
					
					
				}
				else if(choice == 2)
				{
					//vecRepo.addVector(obj); 3D
				}
			}
			else if(choice == 4)
			{
				List<Double> v1 = new ArrayList<Double>();
				List<Double> v2 = new ArrayList<Double>();
				choice = -1;
				System.out.println("1.Wektor 2D\n2.Wektor 3D");
				choice = in.nextInt();
				if(choice == 1)
				{
					double vx, vy;
					System.out.println("Podaj parametry wektora 2D, ktory chcesz wybrac: ");
					v1.add(in.nextDouble());
					v1.add(in.nextDouble());
					v1.add(null);
					if(vecRepo.getVector(v1) != null)
					{
						System.out.println("Podaj parametry wektora 2D, ktory chcesz wybrac: ");
						v2.add(in.nextDouble());
						v2.add(in.nextDouble());
						v2.add(null);
						if(vecRepo.getVector(v2) != null)
						{
							Vector3D vec = (Vector3D) IVector.vectorProduct(vecRepo.getVector(v1), vecRepo.getVector(v2));
							System.out.println("Iloczyn wektorowy to [" + vec.getVx() + ", " + vec.getVy() + ", " + vec.getVz() + "]");
						}
						else
							System.out.println("Brak podanego wektora");
					}
					else
						System.out.println("Brak podanego wektora");
					
					
				}
				else if(choice == 2)
				{
					
						double vx, vy;
						System.out.println("Podaj parametry wektora 3D, ktory chcesz wybrac: ");
						v1.add(in.nextDouble());
						v1.add(in.nextDouble());
						v1.add(in.nextDouble());
						if(vecRepo.getVector(v1) != null)
						{
							System.out.println("Podaj parametry wektora 3D, ktory chcesz wybrac: ");
							v2.add(in.nextDouble());
							v2.add(in.nextDouble());
							v2.add(in.nextDouble());
							if(vecRepo.getVector(v2) != null)
							{
								Vector3D vec = (Vector3D) IVector.vectorProduct(vecRepo.getVector(v1), vecRepo.getVector(v2));
								System.out.println("Iloczyn wektorowy to [" + vec.getVx() + ", " + vec.getVy() + ", " + vec.getVz() + "]");
							}
							else
								System.out.println("Brak podanego wektora");
						}
						else
							System.out.println("Brak podanego wektora");
				}
			}
			else if(choice == 0)
			{
				System.exit(1);;
			}
			
		}
		
		
	}
}
