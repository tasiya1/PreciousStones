package main.stones;

/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.stones.menu.actions.NecklaceActions;
import main.stones.types.Jadeite;
import main.stones.types.Pyrite;
import main.stones.types.Stone;
import main.stones.types.Tourmaline;


public class Necklace implements NecklaceActions{
	
	public List<Stone> particles;
	
	public Necklace() {
		
		particles = new ArrayList<>();
	}
	
	public Stone inputProperties() {
		String name, type;
		double carats, price, hardness, transparency = 0;
		Map <String, Stone> types = new HashMap <String, Stone>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n\tType of stone (Tourmaline, Pyrite, Jadeite) -> ");
		type = sc.nextLine();
			
		System.out.print("\n\tName -> ");
		name = sc.nextLine();
		System.out.print("\tCarats -> ");
		carats = sc.nextDouble();
		System.out.print("\tPrice in $ -> ");
		price = sc.nextDouble();
		System.out.print("\tHardness -> ");
		hardness = sc.nextDouble();
		System.out.print("\tTransparency -> ");
		transparency = sc.nextDouble();
		System.out.println();
		
		types.put("Tourmaline", new Tourmaline(name, carats, price, hardness, transparency));
		types.put("Pyrite", new Pyrite(name, carats, price, hardness, transparency));
		types.put("Jadeite", new Jadeite(name, carats, price, hardness, transparency));				
		Stone st = types.get(type);
		return st;
	}
	
	public Stone findStone(List<Stone> stones) {
		Scanner sc = new Scanner(System.in);
		Stone st;
		System.out.print("\n\tName -> ");
		String name = sc.nextLine();

		for (int i = 0; i <stones.size(); i++) {
			if (stones.get(i).getName().equals(name))
				return stones.get(i);
		}
		return null;
	}
	
	@Override
	public void addToNecklace() {
		Stone st = inputProperties();	
		particles.add(st);
	}
	
	@Override
	public void removeFromNecklace() {
		Stone st = findStone(particles);
		if (st == null) {
			System.out.println("\n\tNo stones found with this name");
			return;
		}
		particles.remove(st);
	}
	
	@Override
	public void printNecklace() {
		if (particles.size() == 0) {
			System.out.println("\n\tThere is no stones in the necklace.");
			return;
		}
			
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).printInfo();
		}
	}

	@Override
	public void editProperties() {
		Stone st = findStone(particles);
		if (st == null) {
			System.out.println("\n\tNo stones found with this name");
			return;
		}
		st.edit();
	}

	@Override
	public void findByTransparency() {
		Scanner sc = new Scanner(System.in);
		double from, to;
		System.out.print("\n\tFinding the stones by given transparency range.\n\tEnter the FROM value -> ");
		from = sc.nextDouble();
		System.out.print("\tEnter the TO value -> ");
		to = sc.nextDouble();
		
		for (int i = 0; i < particles.size(); i++) {
			if (particles.get(i).getTransparency() <= to && particles.get(i).getTransparency() >= from)
				particles.get(i).printInfo();
		}
	}

	@Override
	public void removeAllStones() {
		if (particles.isEmpty())
			System.out.println("\n\tThe necklace is already clear.");
		else {
			particles.clear();
			System.out.println("\n\tDone! The necklace is cleared.");
		}
	}

	@Override
	public void sortNecklace() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\tSort by Price in (asc, desc) -> ");
		String option = sc.nextLine();

		if (option.equals("asc"))
			particles.sort(Comparator.comparing((Stone::getPrice)));
		else 
			particles.sort(Comparator.comparing((Stone::getPrice)).reversed());
	}

	@Override
	public void totalWeightPrice() {
		double sum = 0;
		for (int i = 0; i < particles.size(); i++) {
			sum += particles.get(i).getCarats();
		}
		System.out.println("\n\tThe total carats: " + sum);
		
		sum = 0;
		for (int i = 0; i < particles.size(); i++) {
			sum += particles.get(i).getPrice();
		}		
		System.out.println("\n\tThe total price: $" + sum);
	}

	
	@Override
	public void importFromFile() throws IOException, Exception {

	}
	@Override
	public void exportToFile() {
		
	}
	
	/*@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
	*/
  /*public void HelloNecklace() {
		System.out.println("Hello Necklace!");
	}*/
}
