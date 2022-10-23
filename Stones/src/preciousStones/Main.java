package preciousStones;

class Main {
	//public static Stone [] stones;
	
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		InfoCommand print = new InfoCommand(); //вивід довідки про команди
		print.execute();
		
		NecklaceActions newJewelry = new Necklace(); 

		Menu menu = new Menu(newJewelry);
		menu.goMenu(newJewelry);
	}
}
