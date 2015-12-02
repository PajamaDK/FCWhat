package controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Scanner;

import io.FileRead;
import io.FileWrite;
import main.Match;
import main.Player;
import main.PlayerPosition;
import view.Sound;

public class Controller {

//Sound module object created
	Sound sCast = new Sound();
	
    public void addPlayer(){
        
    ArrayList<Player> addplist = new ArrayList<>();

    String name; double salary; char quit = 'Y';
        while (quit == 'Y'){
        	Scanner scan = new Scanner(System.in);
            String id = Long.toHexString(Double.doubleToLongBits(Math.random()));
            
    		sCast.playSound("/sound/PleaseEnterPlayersName.wav");
        	System.out.print("\nPlease enter players name: ");
            name = scan.nextLine();
    		sCast.playSound("/sound/PleaseEnterPlayersSalary.wav");
            System.out.print("Please enter players Salary: ");
            salary = scan.nextDouble();
            addplist.add (new Player(id,name,salary));
    		sCast.playSound("/sound/DoYouWantToAddAnotherPlayer.wav");
            System.out.print("Do you want to add another player? (Y/N)");
            String choice = scan.next();
            choice = choice.toUpperCase();
            quit= choice.charAt(0);
        }
		sCast.playSound("/sound/AllPlayersHaveBeenSavedToDatabase.wav");
  		FileWrite io2f = new FileWrite();
		io2f.wplayer2f("playerdb.csv", addplist);
    }
    
//------------------------------------------------------
    
    public void getPlayer(){
		FileRead fRead = new FileRead();
		printPlayers(fRead.fetchPlayerArray(),0);   	
    }

//------------------------------------------------------ 
    
    public void getMatch(){
		FileRead fRead = new FileRead();
		printMatches(fRead.fetchMatchArray(),0);
		
    }

//------------------------------------------------------  
    
    public void addPlayer2Match(){
		FileRead fRead = new FileRead();
		char quit = 'Y';
		while(quit == 'Y'){
		printMatches(fRead.fetchMatchArray(),1);
		String matchID,playerID;
		int position;
		Scanner scan = new Scanner(System.in);	
        
		sCast.playSound("/sound/PleaseSelectAMatchID.wav");
        System.out.print("Please select a MatchID: ");
        
        matchID = scan.next();
		printPlayers(fRead.fetchPlayerArray(),1);
		sCast.playSound("/sound/MatchSelectedPleaseSelectAPlayerID.wav");
        System.out.print("Match selected. Please select a PlayerID: ");	
        playerID = scan.next();
        
        String fPPValue = ""; 
        for(PlayerPosition fPP : fRead.fetchPlayerPosision(matchID)){
       	fPPValue += fPP.getPositionInString()+" ";
        }
        String fPPVal = "";
        for(int i =1; i <11; i++){        	
        	String ii = Integer.toString(i);
        	if(!fPPValue.contains(ii)){
        		fPPVal += ii+"-";
        	}
        }
		sCast.playSound("/sound/PleaseSelectAnAvalablePosition.wav");
        System.out.println("Available positions -> {-"+fPPVal+"}");
        System.out.print("Please select an available position: ");
		position = scan.nextInt();
        
		sCast.playSound("/sound/DoYouWantToAddAnotherPlayer.wav");
        System.out.print("Do you want to add another player? (Y/N)");
        String choice = scan.next();
        choice = choice.toUpperCase();
        quit= choice.charAt(0);
        

  		FileWrite io2f = new FileWrite();
		io2f.wplayerpos2f("playerpositiondb.csv",matchID, playerID, position);
		}
		sCast.playSound("/sound/AllPlayersHaveBeenSavedToDatabase.wav");
    }

//------------------------------------------------------  
    public void addMatch(){
        
    ArrayList<Match> addMatchList = new ArrayList<>();

    String versus; 
    char quit = 'Y';
  
        while (quit == 'Y'){
        	Scanner scan0 = new Scanner(System.in);
        	Scanner scan1 = new Scanner(System.in);
            String id = Long.toHexString(Double.doubleToLongBits(Math.random()));
            
    		sCast.playSound("/sound/PleaseEnterMatchDateAndTime.wav");
        	System.out.print("\nPlease enter match date and time (DD/MM/YYYY HH:MM): ");

            String dateAndTime = scan0.nextLine();
            String strDate = dateAndTime+" UTC";
            TemporalAccessor t  = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm zzz").parse(strDate);
            LocalDateTime  ldt = LocalDateTime.from(t);
            Long dateSet = ldt.toEpochSecond(ZoneOffset.UTC);
            
    		sCast.playSound("/sound/PleaseEnterOpponentsName.wav");
            System.out.print("Please enter opponents name: ");
            versus = scan0.nextLine();
            addMatchList.add(new Match(id,dateSet,versus));
    		sCast.playSound("/sound/DoYouWantToAddAnotherMatch.wav");
            System.out.print("Do you want to add another match? (Y/N)");
            String choice = scan1.next();
            choice = choice.toUpperCase();
            quit= choice.charAt(0);
        }
		sCast.playSound("/sound/AllMatchesHaveBeenSavedToDatabase.wav");
  		FileWrite io2f = new FileWrite();
		io2f.wmatch2f("matchdb.csv", addMatchList);
    }

//------------------------------------------------------
    
	public void printPlayers(ArrayList<Player> fplist, int option){
		
		for (Player pl: fplist) {
			if(option == 1){
		System.out.println("PlayerID: "+pl.getId()+"\tName: "+pl.getName()+"\t Salary: "+pl.getSalary());
			} else {
		System.out.println("Name: "+pl.getName()+" Salary: "+pl.getSalary());				
			}

		//sCast.playSound("/sound/Printing.wav");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
	
	public void printMatches(ArrayList<Match> fmlist, int option){
		
		for (Match ma: fmlist) {
			if(option  == 1){
			System.out.println("MatchID: "+ma.getId()+"\t"+ma.getDateInHuman()+"\tOpponent: "+ma.getVersus());	
			} else {
			System.out.println(ma.getDateInHuman()+"\tOpponent: "+ma.getVersus());				
			}

		//sCast.playSound("/sound/Printing.wav");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}

	
}
