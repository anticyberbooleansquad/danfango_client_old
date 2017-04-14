/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieAgency;

import XMLGenerator.ClientXMLGenerator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.net.*;
import java.io.*;
import javax.xml.stream.XMLStreamException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author johnlegutko
 */
public class MovieAgency {

    public void scrape() throws IOException, XMLStreamException {
        Document doc;
        ArrayList<JSONObject> movies;
        String year2016 = "http://www.imdb.com/search/title?year=2016,2016&title_type=feature&sort=moviemeter,asc&view=simple";
        String year2017 = "http://www.imdb.com/search/title?year=2017,2017&title_type=feature&sort=moviemeter,asc&view=simple";
        String year2018 = "http://www.imdb.com/search/title?year=2018,2018&title_type=feature&sort=moviemeter,asc&view=simple";

        doc = Jsoup.connect(year2016).get();
        movies = parseHTML(doc);
        doc = Jsoup.connect(year2017).get(); 
        movies.addAll(parseHTML(doc));
        doc = Jsoup.connect(year2018).get();
        movies.addAll(parseHTML(doc));

        ClientXMLGenerator generator = new ClientXMLGenerator();
        generator.genMovieXMLFile(movies);
        

    }

    public static ArrayList<JSONObject> parseHTML(Document doc) throws IOException, XMLStreamException {
        ArrayList<String> hrefs = new ArrayList();
        ArrayList<String> imdbIds = new ArrayList();
        ArrayList<JSONObject> movies = new ArrayList();
        Elements movieTitles = doc.select("div.col-title > span > span > a");

        for (Element e : movieTitles) {
            hrefs.add(e.attr("href"));
        }

        for (String s : hrefs) {
            String id = s.substring(7, 16);
            imdbIds.add(id);
        }

        System.out.println(Arrays.toString(imdbIds.toArray()));

        for (String id : imdbIds) {
            URL omdb = new URL("http://www.omdbapi.com/?i=" + id);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(omdb.openStream()))) {
                String inputLine =  in.readLine();
                JSONObject jsonObj = null;
                if (inputLine != null) {
                    System.out.println(inputLine);
                    jsonObj = new JSONObject(inputLine);
                    if (!jsonObj.isNull("Title")) {
                        movies.add(jsonObj);
                    }
                }
            }
        }

        return movies;

    }

}
