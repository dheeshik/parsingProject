package dev.dheeshik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.util.ArrayList;

public class ReviewContentParser {
  public ArrayList<String> foundWords = new ArrayList<String>();

  void GetGoodReviews(String reviewPath) throws IOException {
    BufferedReader br;
    File reviews = new File(reviewPath);
    String line = null;
    try {
      br = new BufferedReader(new FileReader("./adjectives.txt"));

      while ((line = br.readLine()) != null) {
        if (FileUtils.readFileToString(reviews).contains(line)) {
          foundWords.add(line);
        }
      }
      br.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
