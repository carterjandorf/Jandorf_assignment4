package jandorf_problem2;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {

	// Create the Map 
	Map<String, Integer> wordCounter = new HashMap<String, Integer>();
	Scanner input;

	// Create variable to hold stream values
	String current;
	String[] list;

	void count(String dataFile) {

		try {

			// Implement Scanner object
			input = new Scanner(new File(dataFile));

			// Iterate through each line of the file
			while(input.hasNextLine()) {
				current = input.nextLine();
				
				// Get rid of all excess symbols using shortcut
				list = current.split("[^\\w]+");

				// Iterate through each word
				for(int i = 0; i < list.length; i++) {
					String upper = list[i].toUpperCase();
					Integer count = wordCounter.get(upper);
					
					// Check whether to add to existing count variable or make a new one
					if(count == null) {
						count = 1;
					} else {
						count += 1;
					}
					
					// Add the words and counter to the map
					wordCounter.put(upper,count);
					
				}
			}

		} catch (Exception e) {
				System.out.println("Sorry there was an error while processing your request.");
		}

	}

	void write(String outputFile) {
		
		try {
			
			// Create FileWriter to write to outputFile
			FileWriter out = new FileWriter(outputFile);
			
			// use foreach loop to access each value in the map
			for(String s: wordCounter.keySet()) {
				out.write(s + " " + wordCounter.get(s) + "\n");
			}
			
			out.close();
			
		} catch(Exception e) {
			System.out.println("Sorry there was an error while processing your request.");
		}

	}

}

