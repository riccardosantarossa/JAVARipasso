
//Santarossa Riccardo 5BIA 30/09/2021

package campane;
import java.util.concurrent.*;


public class Don implements Runnable
{
    Semaphore s2, s3;

    public Don(Semaphore s2, Semaphore s3)
    {
        this.s2=s2;
        this.s3=s3;
    }

    public void run()
    {
        while(true)
        {
            try 
            {
				s2.acquire();
			} 
            catch (InterruptedException e) 
            {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("DON");
            try 
            {
				Thread.sleep(1000);
			} 
            catch (InterruptedException e) 
            {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            s3.release();
        }
    }

}