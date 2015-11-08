package niti2zadatak;

public class Datum 
{
	private int d;
	private int m;
	private int g;
	
	public Datum(int d, int m, int g)
	{
		this.d = d;
		this.m = m;
		this.g = g;
	}
	
	public int getDay() 
	{ 
		return d; 
	}
	
	public int getMonth() 
	{ 
		return m;
	}
	
	public int getYear() 
	{ 
		return g; 
	}
}
