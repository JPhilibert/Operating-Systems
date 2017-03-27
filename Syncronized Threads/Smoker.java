import java.util.*;
import java.util.concurrent.*;

public class Smoker implements Callable<Boolean>{
	static String[] ITEMS = {"matches", "papers", "tobacco"};
	
	private String item;
	
	public Smoker(int index){
		item = Smoker.ITEMS[index];
	}
	
	public Boolean call(){

		 while(true)
		 {
		 	tryTake();
		 }
		 
		 return true;//unreachable. when do they stop smoking?
	}
	
	public void tryTake()
	{
		//each smoker tries to take a different supply first, this might be faster, or it might break stuff
		//trys to take both items you need. if you succeed both times, smoke, else return anything you took
		if(item.equals("matches"))
		{
			if(Inventory.getInstance().consumePaper()){
				if(Inventory.getInstance().consumeTobacco()){
					Inventory.getInstance().smoke();
				}else{
					Inventory.getInstance().producePaper();
				}
			}
		}else if(item.equals("paper"))
		{
			if(Inventory.getInstance().consumeTobacco()){
				if(Inventory.getInstance().consumeMatches()){
					Inventory.getInstance().smoke();
				}else{
					Inventory.getInstance().produceTobacco();
				}
			}
		}else if(item.equals("matches"))
		{
			if(Inventory.getInstance().consumePaper()){
				if(Inventory.getInstance().consumeTobacco()){
					Inventory.getInstance().smoke();
				}else{
					Inventory.getInstance().producePaper();
				}
			}
		}else{
			System.out.println("smoker id error");
		}
	}
}
