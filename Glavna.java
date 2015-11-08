package niti2zadatak;

public class Glavna {
	public static void main(String... args)
	{
		Datum current = new Datum(4, 11, 2015);
		Datum birth   = new Datum(28, 9, 1994);
		
		Bioritam fizicki = new Bioritam(current, birth, "Fizicki");
		Bioritam intelektualni = new Bioritam(current, birth, "Intelektualni"); intelektualni.setCiklus(33);
		Bioritam emocionalni = new Bioritam(current, birth, "Emocionalni"); emocionalni.setCiklus(28);
		
		fizicki.start();
		intelektualni.start();
		emocionalni.start();
		
		try {
			fizicki.join();
			intelektualni.join();
			emocionalni.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		fizicki.stampaj();
		intelektualni.stampaj();
		emocionalni.stampaj();
		
		System.out.println("Gotov program");
	}
}
