package webscrape;

import java.io.*;
import java.net.*;
import java.util.*;


public class ScoresPremierLeague
{
	public static void main(String[] args) throws IOException
	{
		String webpage="https://fbref.com/en";
		try 
		{
	        String text="";
	        // Create URL object
	        URL url = new URL(webpage);
	        url.openStream();
//	        BufferedReader readr = 
//	        		new BufferedReader(new InputStreamReader(url.openStream()));
//	        
//	        // Enter filename in which you want to download
//	        FileWriter file = new FileWriter("C:/Users/s-zhangte/Documents/csv/Scores.csv");
//	        BufferedWriter download =
//	                new BufferedWriter(file);
//	        // read each line from stream till end
//	        String line;
//	        int num=0;
//	        
//	        readr.close();
//	        download.close();		
	     }
		 catch (MalformedURLException mue) 
		 {
			 System.out.println("Malformed URL Exception raised");
	     }
	     catch (IOException ie) 
		 {
	    	 System.out.println("IOException raised");
	     }
			

		
	} //end of main
	
}
