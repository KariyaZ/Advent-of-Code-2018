package Day4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day4 {
	
	public static void main(String[] args) {
		try {
			
			Scanner s = new Scanner(new File("src/Day4/input.txt"));
			ArrayList<String> list = new ArrayList<String>();
			while (s.hasNextLine()){
			    list.add(s.nextLine());
			}
			s.close();

			day4_1(list);
			//day3_2(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static void day4_1(ArrayList<String> input) {
		
		Collections.sort(input);
		
		Map<String, Map<Integer, Integer>> sleepTimes = new HashMap<>();
		
		int startSleep = 0;
		String currentGuard = "";
		
		for (String line : input) {
			int minute = Integer.parseInt(line.substring(15, 17));
			
			if (line.contains("begins")) {
				currentGuard = line.split(" ")[3];
				if (!sleepTimes.containsKey(currentGuard)) {
					Map<Integer, Integer> sleepSchedule = new HashMap<Integer, Integer>();
					for (int i = 0; i < 60; i++) {
						sleepSchedule.put(i, 0);
					}
					sleepTimes.put(currentGuard, sleepSchedule);
				}
			}
			
			if (line.contains("sleep")) {
				startSleep = minute;
			}
			
			if (line.contains("wake")) {
				for (int i = startSleep; i < minute; i++) {
					int value = sleepTimes.get(currentGuard).get(i);
					sleepTimes.get(currentGuard).put(i, value + 1);
				}
			}
		}
		
		int sleepiestGuard = 0;
		int totalSleep = 0;
		int sleepiestMinute = 0;
		
		int part2Guard = 0;
		int part2Minute = 0;
		int part2Frequency = 0;
		
		for (Map.Entry<String, Map<Integer, Integer>> pair : sleepTimes.entrySet()) {
		    int sleepAmount = 0;
		    int guard = Integer.parseInt(pair.getKey().substring(1));
		    int maxMinute = Collections.max(pair.getValue().entrySet(), Map.Entry.comparingByValue()).getKey();
		    int maxMinuteValue = Collections.max(pair.getValue().entrySet(), Map.Entry.comparingByValue()).getValue();
		    for (Map.Entry<Integer, Integer> pair2 : pair.getValue().entrySet()) {
		    	sleepAmount += pair2.getValue();
		    }
		    
		    if (sleepAmount > totalSleep) {
		    	totalSleep = sleepAmount;
		    	sleepiestGuard = guard;
		    	sleepiestMinute = maxMinute;
		    }
		    
		    if (maxMinuteValue > part2Frequency) {
		    	part2Frequency = maxMinuteValue;
		    	part2Minute = maxMinute;
		    	part2Guard = guard;
		    }
		}
		
		System.out.println("Sleepiest Guard: " + sleepiestGuard);
		System.out.println("Sleepiest Minute: " + sleepiestMinute);
		System.out.println("Part 1 Answer: " + sleepiestGuard*sleepiestMinute);
		
		System.out.println("Part 2 Guard: " + part2Guard);
		System.out.println("Part 2 Minute: " + part2Minute);
		System.out.println("Part 2 Answer: " + part2Guard*part2Minute);
	}

}
