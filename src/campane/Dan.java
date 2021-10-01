//Santarossa Riccardo 5BIA 30/09/2021

package campane;
import java.util.concurrent.*;

public class Dan implements Runnable
{
    Semaphore s1, s3;

    public Dan(Semaphore s1, Semaphore s3)
    {
        this.s1=s1;
        this.s3=s3;
    }

    public void run()
    {
        while(true)
        {
            try 
            {
				s3.acquire();
			} 
            catch (InterruptedException e) 
            {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("DAN");
            try 
            {
				Thread.sleep(1000);
			} 
            catch (InterruptedException e) 
            {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            s1.release();
        }
    }

}
