package main.stones.menu.actions;

public class RemoveFromNecklaceCommand implements Command {
	
	NecklaceActions theJewelry;
	
	public RemoveFromNecklaceCommand(NecklaceActions newJewelry) {
		theJewelry = newJewelry;
	}
	
	@Override
	public void execute() {
		theJewelry.removeFromNecklace();
	}
}
