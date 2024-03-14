package dev.dheeshik;

import org.apache.commons.io.FileUtils;

public class AdGenerator {
  void generateTargetedAdd(ArrayList<String> foundWords, String newMovieReviews) {
    File reviews = new File(newMovieReviews);
    System.out.println("Here is a movie you might enjoy based on what you liked previosly:");
    try {
      for (String word : foundWords) {
        if (FileUtils.readFileToString(reviews).contains(word)) {
          foundWords.add(word);
        }
      }
      br.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
