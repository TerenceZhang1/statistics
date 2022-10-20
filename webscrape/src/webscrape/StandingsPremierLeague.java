package webscrape;
import java.io.*;
import java.net.*;
import java.util.*;

//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

public class StandingsPremierLeague 
{
	private static ArrayList<ArrayList<ArrayList<String>>> full = new ArrayList<ArrayList<ArrayList<String>>>();
	public static void main(String[] args)
	{
		String webpage="";
		for(int i=1992;i<2021;i++)
		{
			//https://en.wikipedia.org/wiki/"+i+"%E2%80%9320_Premier_League
			System.out.print(i+" ");
			if(i<1999)
				webpage="https://en.wikipedia.org/wiki/"+i+"%E2%80%93"+(i-1992+93)+"_Premier_League";
			else if(i<2009&&i>1998)
				webpage="https://en.wikipedia.org/wiki/"+i+"%E2%80%930"+(i-1999)+"_Premier_League";
			else
				webpage="https://en.wikipedia.org/wiki/"+i+"%E2%80%93"+(i-1999)+"_Premier_League";
			try {
	        	String text="";
	        	ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
	            // Create URL object
	            URL url = new URL(webpage);
	            BufferedReader readr = 
	              new BufferedReader(new InputStreamReader(url.openStream()));
	  
	            // Enter filename in which you want to download
	            BufferedWriter writer = 
	              new BufferedWriter(new FileWriter("Download.html"));
	              
	            // read each line from stream till end
	            String line;
	            int num=0;
	            boolean yes=false;
	            int stat=0;
	            while ((line = readr.readLine()) != null&&num<1700) 
	            {
	            	if(line.contains("<h2><span class=\"mw-headline\" id=\"League_table\">League table"))
	            		yes=true;
	            	if(yes)
	            	{
	            		//System.out.println(line);
	            		if(line.contains("<th scope=\"row\" style=\"text-align: left; white-space:nowrap;font-weight: normal;background-color:"))
	            		{
	            			stat=0;
	            			ArrayList<String> news = new ArrayList<String>();
	            			news.add(line.substring(line.indexOf("\">",line.indexOf("\">")+4)+2,line.indexOf("</a>")));
	            			for(int j=0;j<8;j++)
	            			{
	            				writer.write(line);
	                			line=readr.readLine();
	                			writer.write(line);
	                			line=readr.readLine();
	                			news.add(line.substring(line.indexOf(";\">")+3));
	            			}
	            			table.add(news);
	            		}
	            	}	
	            	        	
	                writer.write(line);
	                num++;
	            }
	            System.out.println(table);
	            full.add(table);
	            readr.close();
	            writer.close();
	        }
	        catch (MalformedURLException mue) {
	            System.out.println("Malformed URL Exception raised");
	        }
	        catch (IOException ie) {
	            System.out.println("IOException raised");
	        }
			
			
		} //end of for
		
		
		
		
	} //end of main
	
}

