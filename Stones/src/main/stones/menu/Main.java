package main.stones.menu;


import java.io.FileNotFoundException;
import java.io.IOException;

import main.stones.Necklace;
import main.stones.menu.actions.InfoCommand;
import main.stones.menu.actions.NecklaceActions;

public class Main {
	//public static Stone [] stones;
	
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {

		InfoCommand print = new InfoCommand(); //вивід довідки про команди
		print.execute();
		
		NecklaceActions newJewelry = new Necklace(); 

		Menu menu = new Menu(newJewelry);
		menu.goMenu(newJewelry);
	}
}
