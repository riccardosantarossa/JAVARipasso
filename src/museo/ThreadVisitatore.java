
//5BIA Santarossa Riccardo 01/10/2021

package museo;

import java.util.concurrent.Semaphore;

public class ThreadVisitatore implements Runnable 
{
	private Semaphore mutexEnt, contatore, mutexUsc;
	private int tPermMin,tPermMax;
	
	//Il thread dovrà usare i semaforo per modificare le variabile quindi lo passo al costruttore, così come i tempi 
	public ThreadVisitatore(Semaphore mutexE, Semaphore contatore, Semaphore mutexU, int tMax, int tMin)
	{
		this.mutexEnt=mutexE;
		this.contatore=contatore;
		this.mutexUsc=mutexU;
		this.tPermMax=tMax;
		this.tPermMin=tMin;
		
	}

	@Override
	public void run() 
	{
		while(true)
		{

			//Acquire sul semaforo di entrata
			try {mutexEnt.acquire();} 
			catch (InterruptedException e) {e.printStackTrace();}

			//Decremento il numero di persone in attesa perchè sono entrato nel museo facendo acquire del contatore
			if(MainClass.persAttesa>0)
				MainClass.persAttesa--;

			//Rilascio il semaforo di entrata perchè ho modificato la variabile
			mutexEnt.release();

			//Faccio acquire sul semaforo a contatore
			try {contatore.acquire();} 
			catch (InterruptedException e){e.printStackTrace();}
			
			//Incremento le persone che sono all'interno del museo
			if(MainClass.persInterno<4)
				MainClass.persInterno++;

			//Tempo di permanenza dentro al museo
			try 
			{
				//Thread.sleep(tPermMin + (int) Math.random()*tPermMax);
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) {e.printStackTrace();}

			//Rilascio uno slot del contatore dato che è passato il tempo di permanenza
			contatore.release();
			
			//Faccio acquire del semaforo di uscita
			try {mutexUsc.acquire();} 
			catch (InterruptedException e) {e.printStackTrace();}
			
			//Modifico la variabile che conta le persone uscite
			MainClass.persUscite++;

			//Rilascio il semaforo di uscita
			mutexUsc.release();

		}

	}

}
