package Day3;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Day3 {
	
	public static void main(String[] args) {
		try {
			
			Scanner s = new Scanner(new File("src/Day3/input.txt"));
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNextLine()){
			    list.add(s.nextLine());
			}
			s.close();

			//day3_1(list);
			day3_2(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void day3_1(ArrayList<String> input) {
		
		Map<String, Integer> grid = new HashMap<String, Integer>();
		//parseinput
		for (String line : input) {
			String split[] = line.split("\\s+");
			String coords[] = split[2].substring(0, split[2].length()-1).split(",");
			String dimensions[] = split[3].split("x");
			
			for (int x = 0; x < Integer.parseInt(dimensions[0]); x++ ) {
				for (int y = 0; y < Integer.parseInt(dimensions[1]); y++) {
					String xAsString = Integer.toString(Integer.parseInt(coords[0]) + x);
					String yAsString = Integer.toString(Integer.parseInt(coords[1]) + y);
					String combined = xAsString + "," + yAsString;
					
					int value = grid.containsKey(combined) ? grid.get(combined) : 0;
					grid.put(combined, value + 1);
				}
			}
		}
		
		int overlap = 0;
		
		for (Map.Entry<String, Integer> pair : grid.entrySet()) {
		    if (pair.getValue() > 1) {
		    	overlap++;
		    }
		}
		
		System.out.println("Part1: " + overlap);
	}
	
	public static void day3_2(ArrayList<String> input) {
		
		Map<String, Integer> grid = new HashMap<String, Integer>();
		//parseinput
		for (String line : input) {
			String split[] = line.split("\\s+");
			String coords[] = split[2].substring(0, split[2].length()-1).split(",");
			String dimensions[] = split[3].split("x");
			
			for (int x = 0; x < Integer.parseInt(dimensions[0]); x++ ) {
				for (int y = 0; y < Integer.parseInt(dimensions[1]); y++) {
					String xAsString = Integer.toString(Integer.parseInt(coords[0]) + x);
					String yAsString = Integer.toString(Integer.parseInt(coords[1]) + y);
					String combined = xAsString + "," + yAsString;
					
					int value = grid.containsKey(combined) ? grid.get(combined) : 0;
					grid.put(combined, value + 1);
				}
			}
		}
		
		String noOverlap = "";
		
		for (String line : input) {
			boolean overlap = false;
			
			String split[] = line.split("\\s+");
			String coords[] = split[2].substring(0, split[2].length()-1).split(",");
			String dimensions[] = split[3].split("x");
			
			for (int x = 0; x < Integer.parseInt(dimensions[0]); x++ ) {
				for (int y = 0; y < Integer.parseInt(dimensions[1]); y++) {
					String xAsString = Integer.toString(Integer.parseInt(coords[0]) + x);
					String yAsString = Integer.toString(Integer.parseInt(coords[1]) + y);
					String combined = xAsString + "," + yAsString;
					
					if (grid.get(combined) > 1) {
						overlap = true;
						break;
					}
				}
				if (overlap) {
					break;
				}
			}
			
			if (!overlap) {
				noOverlap += split[0];
			}
		}
		
		System.out.println("Part2: " + noOverlap);
	}

}
