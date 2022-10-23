package preciousStones;

class FindByTransparencyCommand implements Command {

	NecklaceActions theJewelry;
	
	public FindByTransparencyCommand(NecklaceActions necklaceActions) {
		theJewelry = necklaceActions;
	}

	@Override
	public void execute() {
		theJewelry.findByTransparency();
		
	}

}
