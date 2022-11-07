package main.stones.menu.actions;

public class SortNecklaceCommand implements Command {

	NecklaceActions theJewelry;
	
	public SortNecklaceCommand(NecklaceActions necklaceActions) {
		theJewelry = necklaceActions;
	}

	@Override
	public void execute() {
		theJewelry.sortNecklace();
		
	}

}
