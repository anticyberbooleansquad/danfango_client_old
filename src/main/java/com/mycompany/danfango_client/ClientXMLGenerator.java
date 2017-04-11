/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.danfango_client;

/**
 *
 * @author johnlegutko
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.json.JSONObject;

public class ClientXMLGenerator {

    public void genMovieXMLFile(ArrayList<JSONObject> movies) throws XMLStreamException, IOException {
        StringWriter stringWriter = new StringWriter();

        XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter xMLStreamWriter = xMLOutputFactory.createXMLStreamWriter(stringWriter);

        xMLStreamWriter.writeStartDocument();
        xMLStreamWriter.writeStartElement("movies"); //start outer movies

        for (JSONObject movie : movies) {

            xMLStreamWriter.writeStartElement("movie");

            xMLStreamWriter.writeStartElement("title");
            xMLStreamWriter.writeCharacters(movie.get("Title").toString());
            xMLStreamWriter.writeEndElement();

            xMLStreamWriter.writeStartElement("year");
            xMLStreamWriter.writeCharacters(movie.get("Year").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeStartElement("rated");
            xMLStreamWriter.writeCharacters(movie.get("Rated").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeStartElement("released");
            xMLStreamWriter.writeCharacters(movie.get("Released").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeStartElement("imdbID");
            xMLStreamWriter.writeCharacters(movie.get("imdbID").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeStartElement("imdbRating");
            xMLStreamWriter.writeCharacters(movie.get("imdbRating").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeStartElement("genre");
            xMLStreamWriter.writeCharacters(movie.get("Genre").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeStartElement("plot");
            xMLStreamWriter.writeCharacters(movie.get("Plot").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeStartElement("poster");
            xMLStreamWriter.writeCharacters(movie.get("Poster").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeStartElement("runtime");
            xMLStreamWriter.writeCharacters(movie.get("Runtime").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeStartElement("actors");
            xMLStreamWriter.writeCharacters(movie.get("Actors").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeStartElement("director");
            xMLStreamWriter.writeCharacters(movie.get("Director").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeStartElement("writer");
            xMLStreamWriter.writeCharacters(movie.get("Writer").toString());
            xMLStreamWriter.writeEndElement();
            
            xMLStreamWriter.writeEndElement();

        }

        xMLStreamWriter.writeEndElement(); //end outer movies

        xMLStreamWriter.writeEndDocument();
        xMLStreamWriter.flush();
        xMLStreamWriter.close();

        String xmlString = stringWriter.getBuffer().toString();
        stringWriter.close();
        System.out.println(xmlString);
        
        FileWriter fw = new FileWriter("movieAgency.xml");
        fw.write(xmlString);
        fw.close();

    }
    
   

}

