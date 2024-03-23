package dev.dheeshik;

import org.apache.commons.io.FileUtils;
import java.util.ArrayList;
import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.commons.io.FileUtils;

public class AdGenerator {
  void generateTargetedAdd(ArrayList<String> foundWords, String newMovieReviews) throws IOException {
    File reviews = new File(newMovieReviews);
    System.out.println("Here are some reviews for a movie you might like based on what you've said before: \n");
    try {
      BufferedReader reader = new BufferedReader(new FileReader(newMovieReviews));
      String line = reader.readLine();
      ArrayList<String> printedReviews = new ArrayList<String>();

      while (line != null) {
        for (String word : foundWords) {
          if (line.contains(word)) {
            if (!printedReviews.contains(line)) {
              printedReviews.add(line);
            }
          }
        }

        // read next line
        line = reader.readLine();
      }

      reader.close();

      for (String review : printedReviews) {
        System.out.println(review);
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
