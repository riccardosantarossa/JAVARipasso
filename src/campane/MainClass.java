
//Santarossa Riccardo 5BIA 30/09/2021

package campane;

import java.util.concurrent.*;


public class MainClass extends Thread
{

    public static void main(String[] args)
    {
	  Semaphore s1 = new Semaphore(1);
	  Semaphore s2 = new Semaphore(0);
	  Semaphore s3 = new Semaphore(0);

	  Din campana1 = new Din(s1,s2);
	  Don campana2 = new Don(s2,s3);
      Dan campana3 = new Dan(s1,s3);
      
      Thread t1 = new Thread(campana1);
      Thread t2 = new Thread(campana2);
      Thread t3 = new Thread(campana3);
        
	    t1.start();
	    t2.start();
	    t3.start();
    }

}