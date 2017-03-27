import java.util.*;
import java.util.concurrent.*;

public class Supplier implements Callable<Boolean>{
	private final Inventory inventory;
	
	public Supplier(){
	
	}
	
	public Boolean call(){
		//getting ready
		//Thread.sleep(Integer.parseInt(Math.random() + 0.5));
		produceItems();
		
		return true;
	}
	
	private void produceItems(){
		while(true)
		{
			if(Inventory.getInstance().placeSupplies())
			{
				double i = Math.random() * 3;
				
				//not paper
				if(i < 1){
					Inventory.getInstance().produceMatches();
					Inventory.getInstance().produceTobacco();
				}
					
				//not matches
				else if(i > 1 && i < 3){
					Inventory.getInstance().producePaper();
					Inventory.getInstance().produceTobacco();
				}		
				//not tobacco
				else{
					Inventory.getInstance().produceMatches();
					Inventory.getInstance().producePaper();
				}
				Thread.sleep((int)(Math.random() + 0.5) * 1000);
			}
		}

	}
}
