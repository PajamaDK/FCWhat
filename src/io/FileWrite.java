package io;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import main.Player;
import main.Match;

public class FileWrite {
   
   public void wplayer2f(String sFileName,ArrayList<Player> plist){
	try
	{
	    FileWriter writer = new FileWriter(sFileName, true);
	    
	    for(Player pl : plist){
		writer.append(pl.getId());
		writer.append(',');
	    writer.append(pl.getName());
	    writer.append(',');
	    writer.append(Double.toString(pl.getSalary()));
        writer.append('\n');
	    }
	    //generate whatever data you want
			
	    writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
	     e.printStackTrace();
	} 
   }
   
   public void wplayerpos2f(String sFileName,String playerID, String matchID, int position){
	try
	{
	    FileWriter writer = new FileWriter(sFileName, true);
	    
		writer.append(playerID);
		writer.append(',');
	    writer.append(matchID);
	    writer.append(',');
	    writer.append(Integer.toString(position));
        writer.append('\n');
	
	    writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
	     e.printStackTrace();
	} 
   } 
   
   public void wmatch2f(String sFileName,ArrayList<Match> addMatchList){
	try
	{
	    FileWriter writer = new FileWriter(sFileName, true);
	    
	    for(Match ma : addMatchList){
		writer.append(ma.getId());
		writer.append(',');
	    writer.append(Long.toString(ma.getDate()));
	    writer.append(',');
	    writer.append(ma.getVersus());
        writer.append('\n');
	    }
	    //generate whatever data you want
			
	    writer.flush();
	    writer.close();
	}
	catch(IOException e)
	{
	     e.printStackTrace();
	} 
   }
   
   
}