/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import MovieAgency.MovieScraper;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author johnlegutko
 */
public class AgencyController {
    
    public static void main(String[] args) throws IOException, XMLStreamException {
        MovieScraper ms = new MovieScraper();
        ms.scrape();
    }
    
}
