
//5BIA Santarossa Riccardo 01/10/2021

package museo;

import java.util.concurrent.Semaphore;

public class ThreadVisitatore implements Runnable 
{
	private Semaphore mutexEnt, contatore, mutexUsc;
	private int permanenza= (int) Math.random()*1000;

	public ThreadVisitatore(Semaphore mutexE, Semaphore contatore, Semaphore mutexU)
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
			try 
			{
				contatore.acquire();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}

			try 
			{
				mutexEnt.acquire();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			MainClass.persAttesa--;
			
			mutexEnt.release();
			
			
			MainClass.persInterno++;

			try 
			{
				Thread.sleep(permanenza);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}

			contatore.release();
			
			try 
			{
				mutexUsc.acquire();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			MainClass.persUscite++;
			mutexUsc.release();

		}

	}

}
