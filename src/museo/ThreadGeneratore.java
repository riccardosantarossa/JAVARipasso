
//5BIA Santarossa Riccardo 01/10/2021

package museo;

import java.util.concurrent.Semaphore;

public class ThreadGeneratore implements Runnable 
{

	private int tempo=1000;
	private Semaphore mutexEnt, contatore, mutexUsc;

	public ThreadGeneratore(Semaphore mutexE, Semaphore contatore, Semaphore mutexU)
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
			new Thread(new ThreadVisitatore(mutexEnt, contatore, mutexUsc)).start();
			
			try 
			{
				mutexEnt.acquire();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			MainClass.persAttesa++;
			mutexEnt.release();

			try 
			{
				Thread.sleep(tempo+ (int) Math.random()*tempo);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}

		}
	}


}
