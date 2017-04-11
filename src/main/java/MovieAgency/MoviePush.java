/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MovieAgency;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class MoviePush {

        public void push(String Email, String Password) throws MalformedURLException, IOException{
            //set URL and type of request
            URL url = new URL("http://localhost:8080/Danfango/submitCredentials");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            
            //set params on post
            con.setRequestProperty("email", "MovieAgency@gmail.com");
            con.setRequestProperty("password", "MovieAgencyPassword");
            
            //???
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.flush();
            wr.close();

            //get response
            int responseCode = con.getResponseCode();
            System.out.println("nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            
            //read response
            BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
            String output;
            StringBuffer response = new StringBuffer();

            while ((output = in.readLine()) != null) {
             response.append(output);
            }
            in.close();

            //printing result from response
            System.out.println(response.toString());
        }
}


// // HTTP Post request
// private void sendingPostRequest() throws Exception {
//
//  String url = "http://localhost:8080/JAXRSJsonCRUDExample/rest/countries";
//  URL obj = new URL(url);
//  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//        // Setting basic post request
//  con.setRequestMethod("POST");
//  con.setRequestProperty("User-Agent", USER_AGENT);
//  con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//  con.setRequestProperty("Content-Type","application/json");
//
//  String postJsonData = "{"id":5,"countryName":"USA","population":8000}";
//  
//  // Send post request
//  con.setDoOutput(true);
//  DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//  wr.writeBytes(postJsonData);
//  wr.flush();
//  wr.close();
//
//  int responseCode = con.getResponseCode();
//  System.out.println("nSending 'POST' request to URL : " + url);
//  System.out.println("Post Data : " + postJsonData);
//  System.out.println("Response Code : " + responseCode);
//
//  BufferedReader in = new BufferedReader(
//          new InputStreamReader(con.getInputStream()));
//  String output;
//  StringBuffer response = new StringBuffer();
//
//  while ((output = in.readLine()) != null) {
//   response.append(output);
//  }
//  in.close();
//  
//  //printing result from response
//  System.out.println(response.toString());
// }