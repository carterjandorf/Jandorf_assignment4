package jandorf_problem1;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class DuplicateRemover {

	// Arraylist will be used to store the duplicate Strings
	ArrayList<String> uniqueWords = new ArrayList<String>();

	// Scanner instance
	Scanner input;

	// Two variables being used to compare the String objects
	String current;
	String[] list;

	void remove(String dataFile) {

		// Create the Try Catch to throw an exception if something goes wrong
		try {

			// Create Scanner to read the file
			input = new Scanner(new File(dataFile));

			// Read each line and split the words apart in each line to be able to compare them
			while(input.hasNextLine()) {
				current = input.nextLine();
				list = current.split("[^\\w]+"); // Remove excess character

				// Iterate through the array and make all words uppercase and put them into the dups array
				for(int i = 0; i < list.length; i++) {
					String upper = list[i].toUpperCase();
					uniqueWords.add(upper);
				}
			}
			
			// Remove duplicates in the array
			for(int x = 0; x < uniqueWords.size(); x++) {
				// Remove the duplicates now that all the words have been added
				for(int i = 0; i < uniqueWords.size()-1; i++) {
					for(int j = 0; j < uniqueWords.size(); j++) {
						if((uniqueWords.get(i).compareTo(uniqueWords.get(j)) == 0) && i != j) {
							uniqueWords.remove(i);
						}
					}
				}

			}


		} catch(Exception e) {
			System.out.println("Sorry, there was an error while handling your request.");
		}

	}

	void write(String outputFile) {

		try {
			FileWriter out = new FileWriter(outputFile);

			for(int i = 0; i < uniqueWords.size(); i++) {
				out.write(uniqueWords.get(i) + "\n");
			}

			out.close();

		} catch(Exception e) {
			System.out.println("Sorry, there was an error while handling your request.");
		}
	}

}