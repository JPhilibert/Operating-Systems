import java.util.*;
import java.util.concurrent.*;

public class Main{
	
	public static void main(String[] args){
		
		List<Callable<Boolean>> threads = new ArrayList<Callable<Boolean>>();
		threads.add(new Smoker(0));
		threads.add(new Smoker(1));
		threads.add(new Smoker(2));
		threads.add(new Supplier());
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.invokeAll(threads);//the threads will never end right?
	}

}
