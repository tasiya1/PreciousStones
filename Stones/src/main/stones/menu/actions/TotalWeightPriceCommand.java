package main.stones.menu.actions;

public class TotalWeightPriceCommand implements Command {

	NecklaceActions theJewelry;
	
	public TotalWeightPriceCommand(NecklaceActions necklaceActions) {
		theJewelry = necklaceActions;
	}

	@Override
	public void execute() {
		theJewelry.totalWeightPrice();
	}
}
