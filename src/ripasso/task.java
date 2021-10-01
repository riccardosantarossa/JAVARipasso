
//Santarossa Riccardo 5BIA 24/09/2021

package ripasso;

public class task implements Runnable 
{
	int n=0;

	@Override
	
	public void run() 
	{
		while(MainClass.stop)
		{
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		n++;
		
		System.out.println("Thread A:" + n);
		}
	}
}

