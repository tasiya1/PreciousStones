package test;

import static org.junit.Assert.assertEquals;

//import static org.mockito.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.stones.Necklace;
import main.stones.types.Jadeite;
import main.stones.types.Pyrite;
import main.stones.types.Stone;
import main.stones.types.Tourmaline;

public class MyTest {
	
	private final PrintStream sOut = System.out;
	private final ByteArrayOutputStream outStreamBuf = new ByteArrayOutputStream();
	
	/* -------ЯКАСЬ НЕПОТРІБНА ШТУКА
	@Before
	void atStart{ //test data
		Necklace necklace = new Necklace();
		
		necklace.particles.add(new Jadeite("a", 0.3, 1000, 7.5, 0.3));
		necklace.particles.add(new Tourmaline("b", 0.1, 800, 6.0, 0.5));
		necklace.particles.add(new Pyrite("c", 0.4, 1200, 0.5, 0.2));
	}
	*/
	@Before
	public void setStreamBuffer() {
		System.setOut(new PrintStream(outStreamBuf)); //зміна стандартного потоку виведення в
	}
	
	@After
	public void setStandardStream() {
		System.setOut(sOut); //встановлення стандартного потоку
	}
	
	@Test
	public void addStoneTest1() { //додання нового камінчика
		Necklace necklace = new Necklace();
		String input = "Jadeite\nCristen\n0.3\n1000\n7.5\n0.3\n"; //тестові дані для камінчика
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		necklace.addToNecklace();
		
		assertEquals("Cristen", necklace.particles.get(0).getName());
		assertEquals(0.3, necklace.particles.get(0).getCarats(), 0.0000001); //для даблів в assertEquals потрібна також похибка
		assertEquals(1000, necklace.particles.get(0).getPrice(), 0.0000001);
		assertEquals(7.5, necklace.particles.get(0).getHardness(), 0.0000001);
		assertEquals(0.3, necklace.particles.get(0).getTransparency(), 0.0000001);
	}
	
	@Test
	public void removeStoneWhichExistsTest2() { //перевірка на видалення камінчика(такий в намисті точно Є)
		Necklace necklace = new Necklace();
		
		Stone a = new Jadeite("a", 0.3, 1000, 7.5, 0.3);
		necklace.particles.add(a);
		
		String input = "a\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		necklace.removeFromNecklace();
		assertEquals(false, necklace.particles.contains(a));
	}
	
	@Test
	public void removeStoneWhichDoNotExistTest3() { //перевірка на видалення камінчика(такого в намисті точно НЕМАЄ)
		Necklace necklace = new Necklace();
		
		Stone a = new Jadeite("a", 0.3, 1000, 7.5, 0.3);
		necklace.particles.add(a);
		
		String input = "b\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		necklace.removeFromNecklace();
		
		assertEquals("\n\tName -> \n\tNo stones found with this name\r\n", outStreamBuf.toString()); //очікуваний вивід
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------
	
	@Test
	public void removeAllInNotEmptyTest4() { //перевірка на видалення всіх каменів(намисто НЕ ПУСТЕ)
		Necklace necklace = new Necklace();
		
		Stone a = new Jadeite("a", 0.3, 1000, 7.5, 0.3);
		necklace.particles.add(a);
		
		String input = "b\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		necklace.removeFromNecklace();
		
		assertEquals("\n\tName -> \n\tNo stones found with this name\r\n", outStreamBuf.toString()); //очікуваний вивід
	}
	
	@Test
	public void removeAllInEmptyTest5() { //перевірка на видалення всіх каменів(намисто ПУСТЕ)
		Necklace necklace = new Necklace();
		
		Stone a = new Jadeite("a", 0.3, 1000, 7.5, 0.3);
		necklace.particles.add(a);
		
		String input = "b\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		necklace.removeFromNecklace();
		
		assertEquals("\n\tName -> \n\tNo stones found with this name\r\n", outStreamBuf.toString()); //очікуваний вивід
	}
	
	@Test
	public void printNecklaceWhichIsEmptyTest5() {
		Necklace necklace = new Necklace();
		
		necklace.printNecklace();
		assertEquals("\n\tThere is no stones in the necklace.\r\n", outStreamBuf.toString());
	}
	
	@Test
	public void printNecklaceWhichIsNotEmptyTest6() {
		Necklace necklace = new Necklace();
		
		necklace.particles.add(new Jadeite("a", 0.3, 1000, 7.5, 0.3));
		necklace.particles.add(new Tourmaline("b", 0.1, 800, 6.0, 0.5));
		
		necklace.printNecklace();
		
		assertEquals("\n\tName: a\n\tCarats: 0.3\n\tPrice: $1000.0\n\tHardness: 7.5\n\tTransparency: 0.3\r\n"
					+ "\n\tName: b\n\tCarats: 0.1\n\tPrice: $800.0\n\tHardness: 6.0\n\tTransparency: 0.5\r\n", outStreamBuf.toString());		
	}
	
	@Test
	public void editPropertiesOfStoneWhichExistsTest7() {
		Necklace necklace = new Necklace();
		necklace.particles.add(new Jadeite("a", 0.3, 1000, 7.5, 0.3));
		
		String input = "#\n0.4\n2000.0\n8.5\n0.4\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		necklace.particles.get(0).edit();
		
		assertEquals("a", necklace.particles.get(0).getName());
		assertEquals(0.4, necklace.particles.get(0).getCarats(), 0.0000001);
		assertEquals(2000, necklace.particles.get(0).getPrice(), 0.0000001);
		assertEquals(8.5, necklace.particles.get(0).getHardness(), 0.0000001);
		assertEquals(0.4, necklace.particles.get(0).getTransparency(), 0.0000001);
	}
	
	@Test
	public void editPropertiesOfStoneWhichDoesNotExitTest8() {
		Necklace necklace = new Necklace();
		necklace.particles.add(new Jadeite("a", 0.3, 1000, 7.5, 0.3));
		
		String input = "b\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		necklace.editProperties();
		
		assertEquals("\n\tName -> \n\tNo stones found with this name\r\n", outStreamBuf.toString()); //очікуваний вивід
	}
	
	@Test
	public void findByTransparencyFrom01To05Test10() {
		Necklace necklace = new Necklace();
		
		necklace.particles.add(new Jadeite		("a", 0.3, 1000, 7.5, 0.3));
		necklace.particles.add(new Tourmaline	("b", 0.1, 800, 6.0, 0.5));
		necklace.particles.add(new Pyrite		("c", 0.4, 1400, 5.5, 0.2));
		necklace.particles.add(new Tourmaline	("d", 1, 1000, 5.0, 0.8));
		necklace.particles.add(new Pyrite		("e", 1, 5000, 5, 0.1));
		
		String input = "0.2\n0.5\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		necklace.findByTransparency();
		
		assertEquals("\n\tFinding the stones by given transparency range.\n\tEnter the FROM value -> \tEnter the TO value -> "
					+ "\n\tName: a\n\tCarats: 0.3\n\tPrice: $1000.0\n\tHardness: 7.5\n\tTransparency: 0.3\r\n"
					+ "\n\tName: b\n\tCarats: 0.1\n\tPrice: $800.0\n\tHardness: 6.0\n\tTransparency: 0.5\r\n"
					+ "\n\tName: c\n\tCarats: 0.4\n\tPrice: $1400.0\n\tHardness: 5.5\n\tTransparency: 0.2\r\n", outStreamBuf.toString()); //очікуваний вивід
	}
	
	@Test
	public void sortByPriceDescTest11() {
		Necklace necklace = new Necklace();
		
		Stone a = new Jadeite		("a", 0.3, 1000, 7.5, 0.3);
		Stone b = new Tourmaline	("b", 0.1, 800, 6.0, 0.5);
		Stone c = new Pyrite		("c", 0.4, 1400, 5.5, 0.2);
		
		necklace.particles.add(a);
		necklace.particles.add(b);
		necklace.particles.add(c);
		
		String input = "desc\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		necklace.sortNecklace();
		
		assertEquals(c, necklace.particles.get(0));
		assertEquals(a, necklace.particles.get(1));
		assertEquals(b, necklace.particles.get(2));
	}
	
	@Test
	public void sortByPriceAscTest12() {
		Necklace necklace = new Necklace();
		Stone a = new Jadeite		("a", 0.3, 1000, 7.5, 0.3);
		Stone b = new Tourmaline	("b", 0.1, 800, 6.0, 0.5);
		Stone c = new Pyrite		("c", 0.4, 1400, 5.5, 0.2);
		
		necklace.particles.add(a);
		necklace.particles.add(b);
		necklace.particles.add(c);
		
		String input = "asc\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		necklace.sortNecklace();
		//перевірка чи всі камінці правильно посортовані
		assertEquals(b, necklace.particles.get(0));
		assertEquals(a, necklace.particles.get(1));
		assertEquals(c, necklace.particles.get(2));
	}
	
	@Test
	public void totalWeightPriceTest13() {
		Necklace necklace = new Necklace();
		
		necklace.particles.add(new Jadeite		("a", 0.3, 1000, 7.5, 0.3));
		necklace.particles.add(new Tourmaline	("b", 0.1, 800, 6.0, 0.5));
		necklace.particles.add(new Pyrite		("c", 0.4, 1400, 5.5, 0.2));
		
		necklace.totalWeightPrice();
		
		assertEquals("\n\tThe total carats: 0.8\r\n\n\tThe total price: $3200.0\r\n", outStreamBuf.toString()); //очікуваний вивід
	}
	
	
	
	
	
	
}
