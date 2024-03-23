package dev.dheeshik;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
  public static void main(String[] args) {

    File file = new File("./socialmediaposts.csv");
    String csvEntry;
    Document doc;
    try {
      FileWriter outputfile = new FileWriter(file);
      outputfile.append("Reviewer, Content, Date\n");

      doc = Jsoup.connect("https://www.rottentomatoes.com/m/dune_2021/reviews").get();
      System.out.println(doc.title());
      Elements reviewRow = doc.select("div.review-row");
      for (Element review : reviewRow) {
        csvEntry = review.select("a.display-name").first().text() + ',';
        csvEntry = csvEntry
            .concat(
                '\"' + review.select("p[data-qa=\"review-quote\"]").first().text().replace('\"', '\'') + '\"' + ',');
        csvEntry = csvEntry.concat('\"' + review.select("span[data-qa=\"review-date\"]").first().text() + '\"');

        outputfile.append(csvEntry + '\n');

      }

      outputfile.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    ReviewContentParser parser = new ReviewContentParser();
    try {
      parser.GetGoodReviews("./socialmediaposts.csv");
      AdGenerator gen = new AdGenerator();
      gen.generateTargetedAdd(parser.foundWords, "socialmediaposts2.csv");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
