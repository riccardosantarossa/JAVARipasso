//Santarossa Riccardo 5BIA 30/09/2021

package campane;
import java.util.concurrent.*;


public class Din implements Runnable
{
    Semaphore s1, s2;

    public Din(Semaphore s1, Semaphore s2)
    {
        this.s1=s1;
        this.s2=s2;
    }

    public void run()
    {
        while(true)
        {
            try 
            {
				s1.acquire();
			} 
            catch (InterruptedException e) 
            {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("DIN");
            try {
				Thread.sleep(1000);
			} 
            catch (InterruptedException e) 
            {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            s2.release();
        }
    }

}