package webscrape;

import java.io.*;
import java.net.*;
import java.util.*;


public class ScoresPremierLeague
{
	public static void main(String[] args) throws IOException
	{
		String webpage="https://fbref.com/en/";
		try 
		{
	        String text="";
	        // Create URL object
	        URL url = new URL(webpage);
	        
	        BufferedReader readr = 
	        		new BufferedReader(new InputStreamReader(url.openStream()));
	        // Enter filename in which you want to download
	        FileWriter writer = new FileWriter("/C:/Users/s-zhangte/OneDrive - Bellevue School District/csv");
	              
	        // read each line from stream till end
	        String line;
	        int num=0;
	        while ((line = readr.readLine()) != null&&num<5) 
	        {
	            System.out.println(line);
	        	text+=line;
	            
	            writer.write(line);
	            
	            num++;
	        } 
	        
	        readr.close();
	        writer.close();		
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
