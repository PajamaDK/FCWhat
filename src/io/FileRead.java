package io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import main.Player;
import main.PlayerPosition;
import main.Match;

public class FileRead {
		
	//------------------------------------------------------ 
	  
	  public ArrayList<Match> fetchMatchArray() {

			Long date;
			BufferedReader br = null;
			String line;
			
			ArrayList<Match> fetchedMatchList = new ArrayList<>();
			
			try {

				br = new BufferedReader(new FileReader("matchdb.csv"));
				while ((line = br.readLine()) != null) {

					String[] content = line.split(",");

					date =  Long.parseLong(content[1]);
					
					fetchedMatchList.add(new Match(content[0],date,content[2]));	
				}
				
				Collections.sort(fetchedMatchList, (o1, o2) -> o1.getDate().compareTo(o2.getDate()));

			} catch (IOException e) {e.printStackTrace();
			} finally 	{
						if (br != null) {
						try { br.close();
						} catch (IOException e) {e.printStackTrace();
						}
						}
						}
			
			return fetchedMatchList;
		  }
	//------------------------------------------------------ 


	  public ArrayList<Player> fetchPlayerArray() {

	  	double salaryValue;
	  	BufferedReader br = null;
	  	String line;
	  		
	  	ArrayList<Player> fetchedPlayerList = new ArrayList<>();
	  		
	  	try {

	  			br = new BufferedReader(new FileReader("playerdb.csv"));
	  			while ((line = br.readLine()) != null) {

	  				String[] content = line.split(",");
	  				
	  				salaryValue = Double.parseDouble(content[2]);
	  				
	  				fetchedPlayerList.add(new Player(content[0],content[1],salaryValue));	
	  				
	  			}
	  			
	  			Collections.sort(fetchedPlayerList, (o1, o2) -> o1.getName().compareTo(o2.getName()));

	  		} catch (IOException e) {e.printStackTrace();
	  		} finally 	{
	  					if (br != null) {
	  					try { br.close();
	  					} catch (IOException e) {e.printStackTrace();
	  					}
	  					}
	  					}
	  		
	  		return fetchedPlayerList;
	  		
	  	  }

	//------------------------------------------------------ 


	  public ArrayList<PlayerPosition> fetchPlayerPosision(String matchID) {

	  	int position;
	  	BufferedReader br = null;
	  	String line;
	  		
	  	ArrayList<PlayerPosition> fetchedPlayerPosList = new ArrayList<>();
	  		
	  	try {
	  			br = new BufferedReader(new FileReader("playerpositiondb.csv"));
	  			while ((line = br.readLine()) != null) {

	  				String[] content = line.split(",");
	  				
	  				position = Integer.parseInt(content[2]);
	  				
	  				if(content[0].equals(matchID)){
	  				fetchedPlayerPosList.add(new PlayerPosition(content[0],content[1],position));	
	  				}
	  			}
	  			
	  			Collections.sort(fetchedPlayerPosList, (o1, o2) -> o1.getPositionInString().compareTo(o2.getPositionInString()));

	  		} catch (IOException e) {e.printStackTrace();
	  		} finally 	{
	  					if (br != null) {
	  					try { br.close();
	  					} catch (IOException e) {e.printStackTrace();
	  					}
	  					}
	  					}
	  		
	  		return fetchedPlayerPosList;
	  	  }

	  //------------------------------------------------------ 

	  
}