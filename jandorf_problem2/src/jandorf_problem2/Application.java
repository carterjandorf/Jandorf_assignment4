package jandorf_problem2;

public class Application {
	
	public static void main(String[] args) {
		DuplicateCounter dup = new DuplicateCounter();
		dup.count("problem2.txt");
		dup.write("unique_word_counts.txt");
	}
	
}
