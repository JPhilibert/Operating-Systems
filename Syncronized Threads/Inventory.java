import java.util.*;
import java.util.concurrent.*;

public class Inventory{
	
	private static Inventory instance;
	
	private final Semaphore paper = new Semaphore(0, true);
	private final Semaphore matches = new Semaphore(0, true);
	private final Semaphore tobacco = new Semaphore(0, true);
	//token in supply indicates the table is clear
	private final Semaphore supply = new Semaphore(1, true);
	
	public static Inventory getInstance()
	{
		if(instance == null)
		{
			instance = new Inventory();
		}
		return instance;
	}
	private Inventory(){};
	
	public void producePaper(){
		paper.release();
	}
	
	public void produceMatches(){
		matches.release();
	}
	
	public void produceTobacco(){
		tobacco.release();
	}
	
	public void smoke(){
		Thread.sleep(1000);//InteruptedException?
		supply.release();
	}	
	
	public synchronized boolean consumePaper(){
		return paper.tryAcquire();
	}
	
	public synchronized boolean consumeMatches(){
		return matches.tryAcquire();
	}
	
	public synchronized boolean consumeTobacco(){
		return tobacco.tryAcquire();
	}
	
	public boolean placeSupplies(){
		return supply.tryAcquire();
	}

}
