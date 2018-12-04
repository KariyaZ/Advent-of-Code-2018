package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("src/Day1/input.txt"));
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNextLine()){
			    list.add(s.nextLine());
			}
			s.close();
			day1_1(list);
			day1_2(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void day1_1(ArrayList<String> input) {
		int frequency = 0;
		for (String line : input) {
			frequency += Integer.parseInt(line);
		}
		System.out.println(frequency);
	}
	
	public static void day1_2(ArrayList<String> input) {
		ArrayList<Integer> frequencies = new ArrayList<Integer>();
		int frequency = 0;
		frequencies.add(0);
		boolean found = false;
		while (!found) {
			for (String line : input) {
				frequency += Integer.parseInt(line);
				if (frequencies.contains(frequency)) { 
					System.out.println(frequency); 
					found = true;
					break;
				}
				frequencies.add(frequency);
			}
		}
		System.out.println("Done");
	}
}
