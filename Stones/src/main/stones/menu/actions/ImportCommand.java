package main.stones.menu.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ImportCommand implements Command{

	NecklaceActions theJewelry;
	
	public ImportCommand(NecklaceActions newJewelry) {
		theJewelry = newJewelry;
	}
	
	@Override
	public void execute() throws FileNotFoundException, IOException, Exception {
		theJewelry.importFromFile();
	}
}
