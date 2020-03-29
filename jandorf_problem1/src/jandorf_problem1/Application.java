package jandorf_problem1;

public class Application {
	
	public static void main(String[] args) {
		DuplicateRemover dup = new DuplicateRemover();
		dup.remove("problem1.txt");
		dup.write("unique_words.txt");
	}

}
