package webscrape;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class NewStandingsPrem
{
	public static void main(String[] args)
	{
		try
		{
			FileWriter file=new FileWriter("C:/Users/s-zhangte/Documents/csv/PremStandings.csv");
			String webpage="";
			for(int i=1992;i<2022;i++)
	        {
	           	if(i<1999)
					webpage="https://en.wikipedia.org/wiki/"+i+"%E2%80%93"+(i-1992+93)+"_Premier_League";
				else if(i<2009&&i>1998)
					webpage="https://en.wikipedia.org/wiki/"+i+"%E2%80%930"+(i-1999)+"_Premier_League";
				else
					webpage="https://en.wikipedia.org/wiki/"+i+"%E2%80%93"+(i-1999)+"_Premier_League";  
	           	readWiki(webpage, file);
	        }
			webpage="https://www.fotmob.com/leagues/47/table/Premier-League";
			//readFotMob(webpage,file);
		}
		catch (IOException ie) 
		{
            System.out.println("IOException raised");
        }
		
		
            
		
	}
	
	public static void readWiki(String webpage, FileWriter file)
	{
		try
		{
			URL url = new URL(webpage);
            BufferedReader readr = 
              new BufferedReader(new InputStreamReader(url.openStream()));            
            BufferedWriter download =
              new BufferedWriter(file);
           
            
            String line;
            boolean isTable=false;
            while((line = readr.readLine()) != null)
            {
            	if(line.contains("<h2><span class=\"mw-headline\" id=\"League_table\">League table"))
            		isTable=true;
            	if(isTable)
            		if(line.contains("<th scope=\"row\" style=\"text-align: left; white-space:nowrap;font-weight: normal;background-color:"))
            		{
            			String name=line.substring(line.indexOf("\">",line.indexOf("\">")+4)+2,line.indexOf("</a>"))+", ";
            			if(name.contains("&amp;"))
            				name=name.substring(0,name.indexOf("&amp;"))+"and"+name.substring(name.indexOf("&amp;")+5);
            			download.write(name);
            			for(int j=0;j<8;j++)
            			{
            				line=readr.readLine();
            				line=readr.readLine();
            				String toPut=line.substring(line.indexOf(";\">")+3);
            				if(toPut.contains("&#8722;"))
            					toPut="-"+toPut.substring(7);
            				if(j==7&&toPut.length()!=2)
            					if(toPut.length()!=3)
            						toPut=toPut.substring(0,2);
            				
            				download.write(toPut);
            				if(j!=8)
            					download.write(", ");
            				
            			}
            			download.flush();
            			download.newLine();
            		}
            	
            }
            download.flush();
            download.newLine();
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
