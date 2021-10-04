
//5BIA Santarossa Riccardo 01/10/2021

package museo;

import java.util.concurrent.Semaphore;

public class ThreadVisitatore implements Runnable 
{
	private Semaphore mutex, contatore;
	private int permanenza= (int) Math.random()*1000;

	private int persAttesa, persInterno, persUscite;

	public ThreadVisitatore(Semaphore mutex, Semaphore contatore, int pAtt, int pInt, int pUsc)
	{
		this.mutex=mutex;
		this.contatore=contatore;
		this.persAttesa=pAtt;
		this.persInterno=pInt;
		this.persUscite=pUsc;
	}

	@Override
	public void run() 
	{
		while(true)
		{
			contatore.acquire();

			mutex.acquire();
			persAttesa--;
			persInterno++;
			mutex.release();

			Thread.sleep(permanenza);

			contatore.release();
			
			mutex.acquire();
			persUscite++;
			mutex.release();

		}

	}

}
