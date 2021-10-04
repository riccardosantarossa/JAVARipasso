
//5BIA Santarossa Riccardo 01/10/2021

package museo;

import java.util.concurrent.Semaphore;

public class ThreadGeneratore implements Runnable 
{

	private int tempo=1000;
	private Semaphore mutex, contatore;
	private int persAttesa;

	public ThreadGeneratore(Semaphore mutex, Semaphore contatore, int pAtt)
	{
		this.mutex=mutex;
		this.contatore=contatore;
		this.persAttesa=pAtt;
	}

	@Override
	public void run() 
	{

		while(true)
		{
			ThreadVisitatore t = new ThreadVisitatore();
			
			mutex.acquire();
			persAttesa++;
			mutex.release();

			Thread.sleep(tempo+ (int) Math.random()*tempo);

		}
	}


}
