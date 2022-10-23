package preciousStones;

class RemoveAllStonesCommand implements Command {

	NecklaceActions theJewelry;
	
	public RemoveAllStonesCommand(NecklaceActions necklaceActions) {
		theJewelry = necklaceActions;
	}

	@Override
	public void execute() {
		theJewelry.removeAllStones();
		
	}

}
