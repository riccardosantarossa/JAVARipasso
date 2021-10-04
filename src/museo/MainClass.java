
//5BIA Santarossa Riccardo 01/10/2021

package museo;

import java.util.concurrent.*;

public class MainClass 
{

	public static int persAttesa = 0; 
	public static int persInterno;
	public static int persUscite; 

	public static void main(String[] args) 
	{
		Semaphore mutex = new Semaphore(1);
		Semaphore contatore = new Semaphore(4);


	}

}
