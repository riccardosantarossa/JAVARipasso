
//5BIA Santarossa Riccardo 01/10/2021

package museo;

import java.util.concurrent.Semaphore;

public class ThreadGeneratore implements Runnable 
{

	private int tMax,tMin,nt=0;
	private Semaphore mutexEnt, contatore, mutexUsc;

	//Il thread dovrà usare un semaforo per modificare una variabile quindi lo passo al costruttore, così come i tempi 
	public ThreadGeneratore(Semaphore mutexE, Semaphore contatore, Semaphore mutexU, int tMax, int tMin)
	{
		this.mutexEnt=mutexE;
		this.contatore=contatore;
		this.mutexUsc=mutexU;
		this.tMax=tMax;
		this.tMin=tMin;
	}

	@Override
	public void run() 
	{

		while(true)
		{
			//Creo il generatore di thred
			new Thread(new ThreadVisitatore(mutexEnt, contatore, mutexUsc,tMax,tMin)).start();
			
			nt++;

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
				Thread.sleep(tMin+ (int) Math.random()*tMax);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}

		}
	}


}
