package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Day2 {
	
	public static void main(String[] args) {
		try {
			
			Scanner s = new Scanner(new File("src/Day2/input.txt"));
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNextLine()){
			    list.add(s.nextLine());
			}
			s.close();

			day2_1(list);
			day2_2(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void day2_1(ArrayList<String> input) {
		
		int twice = 0;
		int thrice = 0;
		
		for (String line : input) {
			
			boolean inc2 = false;
			boolean inc3 = false;
			
			Set<Character> characters = new HashSet<>();

			for (char character : line.toCharArray()) {
				characters.add(character);
			}
			
			for (char c : characters) {
				int count = (int) line.chars().filter(letter -> letter == c).count();
				if (count == 2) { if(!inc2) {twice++; inc2=true; }}
				if (count == 3) { if(!inc3) {thrice++; inc3=true; }}
			}
			
		}
		
		System.out.println("Twice: " + twice);
		System.out.println("Thrice: " + thrice);
		System.out.println("Sum: " + twice*thrice);
	}
	
	public static void day2_2(ArrayList<String> input) {
		
		List<String> matching = new ArrayList<>();
		
		for (int i = 0; i < input.size(); i++) {
			String a = input.get(i);
		    for (int j = i + 1; j < input.size(); j++) {
		        String b = input.get(j);
		        StringBuilder matchletters = new StringBuilder();
		        for (int k = 0; k < a.length(); k++) {
		            if (a.charAt(k) == b.charAt(k)) {
		            	matchletters.append(a.charAt(k));
		            }
		        }
		        matching.add(matchletters.toString());
		    }
		}
		
		int longest = 0;
		int index = 0;
		for(int i=1; i< matching.size(); i++) {
		    if(matching.get(i).length() > longest) {
		    	longest = matching.get(i).length();
		        index = i;
		    }
		}
		
		System.out.println("Part 2: " + matching.get(index));	
	}
}
