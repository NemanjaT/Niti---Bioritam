package niti2zadatak;

public class Bioritam extends Thread
{
	private char[][] mat;
	private final String naziv;
	private int ovolikosamziv;
	private int ciklus;
	
	public Bioritam(Datum danasnjiDatum, Datum datumRodjenja, String naziv)
	{
		ovolikosamziv = brojDana(danasnjiDatum.getDay(), danasnjiDatum.getMonth(), danasnjiDatum.getYear())
				- brojDana(datumRodjenja.getDay(), danasnjiDatum.getMonth(), danasnjiDatum.getYear());
		ciklus = 23;
		mat = new char[20][64];
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 64; j++)
			{
				mat[i][j] = '_';
			}
		}
		this.naziv = naziv;
	}
	
	public void setCiklus( int ciklus )
	{
		this.ciklus = ciklus;
	}
	
	@Override
	public void run()
	{
		for(int i = 0; i < 64; i++)
		{
			int nesto = 9 + (int)(9 * Math.sin(((ovolikosamziv + i) % ciklus) * 2 * Math.PI / ciklus));
			zameni(nesto, i);
			yield();
		}
	}
	
	public synchronized void zameni(int x, int y)
	{
		//System.out.println(naziv + " se update-ovao!");
		mat[x][y] = 'F';
	}
	
	public synchronized void stampaj()
	{
		System.out.println(naziv + ":");
		for(int i = 19; i >= 0; i--)
		{
			for(int j = 0; j < 64; j++)
			{
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
	
	public int brojDana(int d, int m, int g)
	{
		boolean bprestupna = ((g % 4 == 0) && (g % 100 != 0)) || (g % 400 == 0);
		
		int br = (int)(g * 365.25) + (int)(m * 30.56) + d;
		int popravak = 0;
		if(m > 2) popravak = 0;
		else if (bprestupna) popravak = 1; 
		else popravak = 2;
		
		return br + popravak;
	}
}
