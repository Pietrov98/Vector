package Vectors_package;

public class Vector2D implements IVector{

	private double vx, vy;
	
	@Override
	public double getAbs() 
	{
		return Math.abs(Math.sqrt((vx*vx + vy*vy)));
	}

	@Override
	public double getVx() 
	{
		return vx;
	}

	@Override
	public double getVy() 
	{	
		return vy;
	}

	@Override
	public void setVx(double vx) 
	{

		this.vx = vx;
	}

	@Override
	public void setVy(double vy) 
	{
		this.vy = vy;
		
	}
	
	public double getAngle()
	{
		double angle = Math.acos(this.vx / getAbs());
		return angle;
	}
			

}
