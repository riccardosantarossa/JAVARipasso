
//5BIA Santarossa Riccardo 01/10/2021

package museo;

import java.util.Scanner;
import java.util.concurrent.*;

import javax.print.attribute.standard.Media;

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

		int tMax=0,tMin=0;

		ThreadGeneratore tg= new ThreadGeneratore(mutexEntrata, contatore, mutexUscita, tMax, tMin);
		Ascoltatore a = new Ascoltatore(mutexEntrata, contatore, mutexUscita);

		//Istanzio un thred collegato al generatore di istanze
		Thread t1 = new Thread(tg);
		//Istanzio un thred collegato al thred ascoltatore
		//Thread t2 = new Thread(a);

		Scanner listener = new Scanner(System.in);

		System.out.println("Inserisci il tempo minimo: ");
		tMin= listener.nextInt();
		System.out.println("Inserisci il tempo massimo: ");
		tMax= listener.nextInt();

		t1.start();
		//t2.start();

		while(true)
		{
			if(listener.nextLine().equals("status"))
			{
				/*try {mutexEntrata.acquire();} 
				catch (InterruptedException e) {e.printStackTrace();}*/
				try {contatore.acquire();} 
				catch (InterruptedException e) {e.printStackTrace();}
				/*try {mutexUscita.acquire();} 
				catch (InterruptedException e) {e.printStackTrace();}*/

				System.out.println("Visitatori in attesa: " + MainClass.persAttesa);
				System.out.println("Visitatori all'interno del museo: " + MainClass.persInterno);
				System.out.println("Persone che hanno completato la visita: " + MainClass.persUscite);

				mutexEntrata.release();
				contatore.release();
				mutexUscita.release();

			}
		}

	}
	
}
