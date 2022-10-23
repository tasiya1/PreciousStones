package preciousStones;

class AddToNecklaceCommand implements Command {
	
	NecklaceActions theJewelry;
	
	public AddToNecklaceCommand(NecklaceActions newJewelry) {
		theJewelry = newJewelry;
	}
	
	@Override
	public void execute() {
		theJewelry.addToNecklace();
	}
}
