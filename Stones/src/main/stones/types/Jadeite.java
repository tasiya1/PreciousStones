package main.stones.types;

import main.stones.*;

public class Jadeite extends Stone{

	public Jadeite(String name, double carats, double price, double hardness, double transparency) {
		super (name, carats, price, hardness, transparency);
	}
	
	@Override
	public String type() {
		return "Jadeite";
	}
	
	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public double getCarats() {
		return super.getCarats();
	}

	@Override
	public double getPrice() {
		return super.getPrice();
	}

	@Override
	public double getHardness() {
		return super.getHardness();
	}

	@Override
	public double getTransparency() {
		return super.getTransparency();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public void setCarats(double carats) {
		super.setCarats(carats);
	}

	@Override
	public void setPrice(double price) {
		super.setPrice(price);
	}

	@Override
	public void setHardness(double hardness) {
		super.setHardness(hardness);
	}

	@Override
	public void setTransparency(double transparency) {
		super.setTransparency(transparency);
	}

	@Override
	public void printInfo() {
		super.printInfo();
	}

	@Override
	public void edit() {
		super.edit();
	}

}