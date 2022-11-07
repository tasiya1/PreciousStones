package main.stones.menu.actions;

public class EditPropertiesCommand implements Command {

	NecklaceActions theJewelry;
	
	public EditPropertiesCommand(NecklaceActions necklaceActions) {
		theJewelry = necklaceActions;
	}

	@Override
	public void execute() {
		theJewelry.editProperties();
		
	}

}
