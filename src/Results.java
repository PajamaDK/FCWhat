Enter file contents hereimport java.util.ArrayList;
import java.time.LocalDate;
public class Results{

//opretter et Match-objekt indeholdende følgende variable
//(MatchID,Modstander,Dato,StartTid,
   
   public class Match{
   
   private double matchID;
   
   private String modstander;

   private LocalDate dato;
 
   private LocalDate startTid;
   
   public Match(double matchID,String modstander,LocalDate dato,LocalDate startTid){
      this.matchID = matchID;
      this.modstander = modstander;
      this.dato = dato;
      this.startTid = startTid;
   }
   public double getMatchID(){
         return matchID;
   }
   public void setMatchID(double matchID){
         this.matchID = matchID;
   }

   public String getModstander(){
         return modstander;
   }
   public void setModstander(String Modstander){
         this.modstander = modstander;
   }
   
   public LocalDate getDato(){
         return dato;
   }
      public void setDato(LocalDate Dato){
         this.dato = dato;
   }

   public LocalDate getStartTid(){
         return startTid;
   }
   public void setStartTid(LocalDate StartTid){
         this.startTid = startTid;
   }
      ArrayList<Match> matchliste = new ArrayList<>();
   
//opr1etter et Score-objekt indeholdende følgende variable
//Sa1mlet resultat,Scoringer(Tid & Navn))
   
   public class Score{
  
   private double matchID;
   
   private String endScore;

   private double goalTime;
 
   private String goalName;
   
   public Score(double matchID,String endScore,double goalTime,String goalName){
      this.matchID = matchID;
      this.endScore = endScore;
      this.goalTime = goalTime;
      this.goalName = goalName;
   }
   public double getMatchID(){
         return matchID;
   }
   public void setMatchID(double matchID){
         this.matchID = matchID;
   }

   public String getEndScore(){
         return endScore;
   }
   public void setEndScore(String Endscore){
         this.endScore = endScore;
   }
   
   public double getGoalTime(){
         return goalTime;
   }
   public void setGoalTime(double GoalTime){
         this.goalTime = goalTime;
   }

   public String getGoalName(){
         return goalName;
   }
   public void setGoalName(String GoalName){
         this.goalName = goalName;
   }
  
   ArrayList<Score> scoreliste = new ArrayList<>();
   
      
      
   }

   
   //enter kamp(match)ID
   
   //enter Dato og tidspunkt for kampen
   
   //enter kampens resultat
   
   //enter kampens mål (tidspunkt og navn)
   
   //Udprint kampens data (ID,Modstander,Dato,StartTid,
   //Samlet resultat,Scoringer(Tid & Navn))
}}
