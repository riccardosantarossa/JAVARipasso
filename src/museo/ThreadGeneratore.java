
//5BIA Santarossa Riccardo 01/10/2021

package museo;

public class ThreadGeneratore implements Runnable 
{

	@Override
	public void run() 
	{
		while(true)
		{
			ThreadVisitatore t = new ThreadVisitatore();
		}
	}


}
