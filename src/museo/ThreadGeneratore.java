
//5BIA Santarossa Riccardo 01/10/2021

package museo;

import java.util.concurrent.Semaphore;

public class ThreadGeneratore implements Runnable 
{

	private int tMax,tMin,tPermMin,tPermMax;
	private Semaphore mutexEnt, contatore, mutexUsc;

	//Il thread dovrà usare un semaforo per modificare una variabile quindi lo passo al costruttore, così come i tempi 
	public ThreadGeneratore(Semaphore mutexE, Semaphore contatore, Semaphore mutexU, int tMax, int tMin, int permMin, int permMax)
	{
		this.mutexEnt=mutexE;
		this.contatore=contatore;
		this.mutexUsc=mutexU;
		this.tMax=tMax;
		this.tMin=tMin;
		this.tPermMax=permMax;
		this.tPermMin=permMin;
	}

	@Override
	public void run() 
	{

		while(true)
		{
			//Creo il generatore di thred
			new Thread(new ThreadVisitatore(mutexEnt, contatore, mutexUsc,tPermMax,tPermMin)).start();

			try 
			{
				//Faccio acquire del semaforo per modificare la variabile statica che conta i thread in attesa
				mutexEnt.acquire();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			//Incremento la variabile statica e rilascio il semaforo
			MainClass.persAttesa++;
			mutexEnt.release();

			try 
			{
				//Thread.sleep(tMin+ (int) Math.random()*tMax);
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}

		}
	}


}
