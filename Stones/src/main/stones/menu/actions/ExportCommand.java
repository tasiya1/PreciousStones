package main.stones.menu.actions;

public class ExportCommand implements Command{

	NecklaceActions theJewelry;
	
	public ExportCommand(NecklaceActions newJewelry) {
		theJewelry = newJewelry;
	}
	
	@Override
	public void execute() {
		theJewelry.exportToFile();
	}

}
