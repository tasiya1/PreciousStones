package main.stones.types;

import java.util.Scanner;

public class Stone {
	
	private String name;
	private double carats;
	private double price;
	private double hardness;
	private double transparency;
	
	public Stone(String name, double carats, double price, double hardness, double transparency) {
		this.name = name;
		this.carats = carats;
		this.price = price;
		this.hardness = hardness;
		this.transparency = transparency;
	}

	public String getName() {return name;}
	public double getCarats() {return carats;}
	public double getPrice() {return price;}	
	public double getHardness() {return hardness;}	
	public double getTransparency() {return transparency;}	
	
	public void setName(String name) {this.name = name;}
	public void setCarats(double carats) {this.carats = carats;}
	public void setPrice(double price) {this.price = price;}
	public void setHardness(double hardness) {this.hardness = hardness;}
	public void setTransparency(double transparency) {this.transparency = transparency;}
	
	public String type() {return null;}
	
	public void printInfo() {
		System.out.print("\n\tName: " + this.name);
		System.out.print("\n\tCarats: " + this.carats);
		System.out.print("\n\tPrice: $" + this.price);
		System.out.print("\n\tHardness: " + this.hardness);
		System.out.println("\n\tTransparency: " + this.transparency);
	}
	
	public void edit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t# - ім'я залишиться таким самим.");
		String buffer;
		double numBuffer;
		
		System.out.print("\n\tName\t\t(Old): " + this.name + "   \t(New) -> ");
		buffer = sc.nextLine();
		if (!buffer.substring(0).equals("#")) {
			this.name = buffer;
		}
		System.out.print("\n\tCarats\t\t(Old): " + this.carats + "   \t(New) -> ");
		numBuffer = sc.nextDouble();
		this.carats = numBuffer;
		System.out.print("\n\tPrice\t\t(Old): $" + this.price + "   \t(New) -> ");
		numBuffer = sc.nextDouble();
		this.price = numBuffer;
		System.out.print("\n\tHardness\t(Old): " + this.hardness + "   \t(New) -> ");
		numBuffer = sc.nextDouble();
		this.hardness = numBuffer;
		System.out.print("\n\tTransparency\t(Old): " + this.transparency + "   \t(New) -> ");
		numBuffer = sc.nextDouble();
		this.transparency = numBuffer;
	}
	
}
