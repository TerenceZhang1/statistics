package webscrape;
import java.io.*;
import java.net.*;
import java.util.*;

public class Tester 
{
	public static void main(String[] args)
	{
		String webpage="";
		try {
        	String text="";
            // Create URL object
            URL url = new URL("https://google.com");
            BufferedReader readr = 
              new BufferedReader(new InputStreamReader(url.openStream()));
  
            // Enter filename in which you want to download
            BufferedWriter writer = 
              new BufferedWriter(new FileWriter("Download.html"));
            
            BufferedWriter download =
              new BufferedWriter(new FileWriter("C:/Users/s-zhangte/Documents/csv/Tester.csv"));
            download.write("5");
            download.flush();
            download.write(",");
            download.write(" 6");
            download.flush();
		}
		catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        }
        catch (IOException ie) {
            System.out.println("IOException raised");
        }
	}
}
