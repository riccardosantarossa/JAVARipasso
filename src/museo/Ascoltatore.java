
//Santarossa Riccardo 5BIA 01/10/2021
package museo;

import java.util.Scanner;
import java.util.concurrent.*;

public class Ascoltatore implements Runnable 
{
	Scanner listener = new Scanner(System.in);
	private Semaphore mutexEnt, contatore, mutexUsc;

	public Ascoltatore(Semaphore mutexE, Semaphore contatore, Semaphore mutexU)
	{
		this.mutexEnt=mutexE;
		this.contatore=contatore;
		this.mutexUsc=mutexU;
	}

	@Override
	public void run() 
	{
		while(true)
		{
			if(!listener.nextLine().equals("status"))
			{
				try {mutexEnt.acquire();} 
				catch (InterruptedException e) {e.printStackTrace();}
				try {contatore.acquire();} 
				catch (InterruptedException e) {e.printStackTrace();}
				try {mutexUsc.acquire();} 
				catch (InterruptedException e) {e.printStackTrace();}

				System.out.println("Visitatori in attesa: " + MainClass.persAttesa);
				System.out.println("Visitatori all'interno del museo: " + MainClass.persInterno);
				System.out.println("Persone che hanno completato la visita: " + MainClass.persUscite);

			}
		}
		
	}

}
