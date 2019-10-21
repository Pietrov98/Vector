package Vectors_package;

public class Vector3D extends Vector2D {
	private double vz;
	
	public double getVz()
	{
		return vz;
	}
	
	public void setVz(double vz)
	{
		this.vz = vz;
	}
	public double getAbs()
	{
		return Math.abs(Math.sqrt((Math.pow(this.getVx(), 2) + Math.pow(this.getVy(), 2)) + Math.pow(this.vz, 2)));
	}
	
	
	public double get2Angle()
	{
		double angle = Math.acos(this.getVy() / getAbs());
		return angle;
	}
}
