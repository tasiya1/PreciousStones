package main.stones.menu.actions;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
	
	public abstract void execute() throws FileNotFoundException, IOException, Exception;	
}
