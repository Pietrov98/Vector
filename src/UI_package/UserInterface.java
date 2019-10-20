package UI_package;

import java.util.Scanner;
import VectorsRepo_package.VectorRepository;
import Vectors_package.Vector2D;

public class UserInterface {
	public void mainLoop()
	{
		VectorRepository vecRepo = new VectorRepository();
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("0.Wyjscie\n1.Dodaj wektor\n2.Usun wektor");
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
					System.out.println(obj.getAngle());
					vecRepo.addVector(obj);
					
				}
				else if(choice == 2)
				{
					//vecRepo.addVector(obj); 3D
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
					//vecRepo.addVector(obj); 3D
				}
			}
			else if(choice == 0)
			{
				System.exit(1);;
			}
		}
		
		
	}
}
