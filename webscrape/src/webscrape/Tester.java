package webscrape;
import java.io.*;
import java.net.*;
import java.util.*;

public class Tester 
{
	public static void main(String[] args)
	{
		String webpage="https://www.fotmob.com/leagues/47/table/Premier-League";
		
		try
		{
			FileWriter file=new FileWriter("C:/Users/s-zhangte/Documents/csv/Tester.csv");

			readFotMob(webpage, file);
		}
		catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        }
        catch (IOException ie) {
            System.out.println("IOException raised");
        }
	}
	public static void readFotMob(String webpage, FileWriter file)
	{
		try
		{
			URL url = new URL(webpage);
			BufferedReader readr = 
		              new BufferedReader(new InputStreamReader(url.openStream()));            
			BufferedWriter download =
		              new BufferedWriter(file);
			String line="";
			Boolean table=false;
			while((line=readr.readLine())!= null)
			{
				if(line.contains(",\"table\":{\"all\":[{\"name\":\""))
					table=true;
				if(table)
				{
					String toPut="";
					line=line.substring(line.indexOf(",\"table\":{\"all\":[{\"name\":\"")+26);
					line=line.substring(0,line.indexOf("}],\"home\":[{\""));
					System.out.println(line);
					download.write(line.substring(0,line.indexOf("\""))+", ");
					
					line=line.substring(line.indexOf("played\":")+8);
					System.out.println(line);

					download.write(line.substring(0,line.indexOf("\""))+", ");
					line=line.substring(10);
					System.out.println(line);

					download.write(line.substring(0,line.indexOf("\""))+", ");
					
				}
				
			}
		}
		catch (MalformedURLException mue) 
		{
            System.out.println("Malformed URL Exception raised");
        }
        catch (IOException ie) 
		{
            System.out.println("IOException raised");
        }
	}
}
