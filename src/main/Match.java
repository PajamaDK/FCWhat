package main;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Match {
	
	private String id,versus;
	private Long date;
	
	public Match(String id, Long date, String versus){
		this.id = id;
		this.date = date;
		this.versus = versus;
	}
	public String getId(){
		return this.id;
	}
	public Long getDate(){
		return this.date;
	}
	//------------------------------------------------------ 
	public String getDateInHuman(){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime dateTime = LocalDateTime.ofEpochSecond(this.date, 0,ZoneOffset.UTC);
		String formattedDateTime = dateTime.format(formatter);
		
		return formattedDateTime;
	}
	//------------------------------------------------------ 
	public String getVersus(){
		return this.versus;
	}
	
	//------------------------------------------------------ 
	
	
}
