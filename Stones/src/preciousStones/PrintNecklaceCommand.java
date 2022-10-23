package preciousStones;

class PrintNecklaceCommand implements Command {
	
	NecklaceActions theJewelry;
		
	public PrintNecklaceCommand(NecklaceActions newJewelry) {
		theJewelry = newJewelry;
	}
		
	@Override
	public void execute() {
		theJewelry.printNecklace();
		//System.out.print("This is necklace.");
	}
}
