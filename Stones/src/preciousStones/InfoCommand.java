package preciousStones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class InfoCommand implements Command {

	public InfoCommand() {}

	@Override
	public void execute() {
	
		File info = new File ("info.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(info));
		} catch (FileNotFoundException e1) { e1.printStackTrace(); }
		String buffer;
		
		try {
			while ((buffer = br.readLine()) != null)
				System.out.println(buffer);
		} catch (IOException e) { e.printStackTrace(); }
		try {
			br.close();
		} catch (IOException e) { e.printStackTrace(); }		
	}

}
