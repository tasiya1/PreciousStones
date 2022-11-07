package main.stones.menu.actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import main.stones.*;

public interface NecklaceActions {
	
	public void addToNecklace();
	
	public void removeFromNecklace();
	
	public void editProperties();
	
	public void printNecklace();
	
	public void findByTransparency();
	
	public void removeAllStones();
	
	public void sortNecklace();
	
	public void totalWeightPrice();

	public void importFromFile() throws FileNotFoundException, IOException, Exception;
	
	public void exportToFile();


}
