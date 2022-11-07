package main.stones.menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import main.stones.menu.actions.*;


public class Menu {

	Map <String, Command> options;

	public Menu(NecklaceActions necklaceActions) {
		options = new HashMap<>();

		//ключі команд
		options.put("Add", new AddToNecklaceCommand(necklaceActions));
		options.put("Remove", new RemoveFromNecklaceCommand(necklaceActions));
		options.put("Edit", new EditPropertiesCommand(necklaceActions));
		options.put("Find by transparency", new FindByTransparencyCommand(necklaceActions));
		options.put("Print", new PrintNecklaceCommand(necklaceActions));
		options.put("Remove all", new RemoveAllStonesCommand(necklaceActions));
		options.put("Sort", new SortNecklaceCommand(necklaceActions));
		options.put("Total", new TotalWeightPriceCommand(necklaceActions));
		options.put("Import", new ImportCommand(necklaceActions));
		options.put("Export", new ExportCommand(necklaceActions));
	}

	public void goMenu(NecklaceActions necklaceActions) throws FileNotFoundException, IOException, Exception {

		Scanner sc = new Scanner(System.in);
		String choice;
		Command option;

		//if (options == null)
		//	options = new HashMap<String, Command>();

		while (true) { //виконання меню
			System.out.print("\n\t-> ");
			choice = sc.nextLine();
			if (choice.equals("Exit")) {
				System.out.print("\n\tEnd of program.");
				break;
			}

			option = options.get(choice);
			if (option != null)
				option.execute();
			else System.out.println("\tWrong command entered. Try again.");
		}
		sc.close();
	}
}
