package Vectors_package;

public interface IVector {
	public double getAbs();
	public double getVx();
	public double getVy();
	public double getAngle();
	public void setVx(double vx);
	public void setVy(double vy);
	public static IVector scalarProduct(IVector a, IVector b) //to chyba ma byc double
	{
		//System.out.println(b.getAbs() + " " + b.getAngle());
		//System.out.println(Math.acos(a.getAngle()));
		if(a instanceof Vector2D)
		{
			double cos_angle = Math.cos(a.getAngle()) * Math.cos(b.getAngle()) + Math.sin(a.getAngle()) * Math.sin(b.getAngle());
			double scalar = a.getAbs() * b.getAbs() * cos_angle;
			System.out.println("Iloczyn skalarany to " + scalar);
		}
		
		return null;
	}
	public static IVector vectorProduct(IVector a, IVector b) //to chyba ma byc double
	{
		Vector3D vec = new Vector3D();
		if(a instanceof Vector3D)
		{
			vec.setVx(a.getVy() * ((Vector3D) b).getVz() - ((Vector3D) a).getVz() * b.getVy());
			vec.setVy(((Vector3D) a).getVz() * b.getVx() - a.getVx() * ((Vector3D) b).getVz());
			((Vector3D) vec).setVz(a.getVx() * b.getVy() - a.getVy() * b.getVx());
		}
		else
		{
			System.out.println(a.getVx() + " " + b.getVx());
			vec.setVz(a.getVx() * b.getVy() - a.getVy() * b.getVx());
		}
		return vec;
	}
}
