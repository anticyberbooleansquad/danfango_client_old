/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheatreAgency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import javax.xml.stream.XMLStreamException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author johnlegutko
 */
public class TheatreScraper {

    public void getTheatreIds() throws IOException, XMLStreamException {
        ArrayList<JSONObject> theatres = new ArrayList();
        ArrayList<String> theatreids = new ArrayList();

        URL gracenote = new URL("http://data.tmsapi.com/v1.1/theatres?zip=11757&radius=100&units=mi&numTheatres=1000&api_key=7k72q6prdt4z44t764r3jw7t");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(gracenote.openStream()))) {
            String inputLine;
            JSONObject jsonObj = null;
            if ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                jsonObj = new JSONObject(inputLine);

                theatres.add(jsonObj);

            }

        }

        System.out.println(Arrays.toString(theatreids.toArray()));

    }

}
