
//5BIA Santarossa Riccardo 01/10/2021

package museo;

import java.util.Scanner;
import java.util.concurrent.*;

public class MainClass 
{

	public static int persAttesa = 0; 
	public static int persInterno = 0;
	public static int persUscite = 0;  
	
	public static void main(String[] args) 
	{
		Semaphore mutexEntrata = new Semaphore(1);
		Semaphore contatore = new Semaphore(4);
		Semaphore mutexUscita = new Semaphore(1);
		
		Scanner listener = new Scanner(System.in);
		
		while(!listener.nextLine().equals("status"))
		{
			try {mutexEntrata.acquire();} 
			catch (InterruptedException e){e.printStackTrace();}
			
			System.out.println("Persone in attesa : " + persAttesa);
			System.out.println("Persone all'interno del museo : " + persInterno);
			System.out.println("Persone in attesa : " + persUscite);
		}
	}
	
}
