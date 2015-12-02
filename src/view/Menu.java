package view;

import java.util.Scanner;
import controller.Controller;

public class Menu {
	
 Controller ctrl = new Controller();


//Menu module	
	public void showMenu00() {
		Scanner scan = new Scanner(System.in);
		while(true) {
				System.out.println();
				System.out.println("F.C What Ever management system: ");
				System.out.println("===================================");
				System.out.println("a: Add Player");
				System.out.println("b: Add Match");
				System.out.println("c: Player list");
				System.out.println("d: Match list");	
				System.out.println("e: Add Player to Match");	
				System.out.println("f: Player stats");
				System.out.println("g: Match stats");
				System.out.println("===================================");
				String menuChoice00 = scan.next();
                
                switch (menuChoice00.toLowerCase()){
                case "a":
                	ctrl.addPlayer();
               	break;
                case "b":
                	ctrl.addMatch();
                break;
                case "c":
                	ctrl.getPlayer();
                break;
                case "d":
                	ctrl.getMatch();
                break;
                case "e":
                	ctrl.addPlayer2Match();
                break;
                }
}
			
	}
	
//------------------------------------------------------

	}
