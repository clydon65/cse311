package assigment2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class simulation {
	

	public static void main(String args[]){  
	     System.out.println("Please input the amount of players: ");  
	     Scanner input = new Scanner(System.in);
	     int n = input.nextInt();
	     System.out.println("Please input the amount of games: ");
	     int m = input.nextInt();
	     System.out.println("What is your p? ");
	     int p = input.nextInt();
	     float percent = (float) (p/100.0);
	     int pItems = Math.round(percent*n);
	     System.out.println("How many generations?");
	     int k = input.nextInt();
	     

	     ArrayList<Player> players = new ArrayList<Player>();
	     //Question 1
	     for(int i = 0; i<n; i++) {
	    	 if(i%4 == 0) {
	    		 players.add(new Player("T4T"));
	    	 }
	    	 else if (i%4 == 1) {
	    		 players.add(new Player("G"));
	    	 }
	    	 else if (i%4 == 2) {
	    		 players.add(new Player("AC"));
	    	 }
	    	 else {
	    		 players.add(new Player("AD"));
	    	 }
	     }
	     //Question 2 - Distribution 1
//	     players.add(new Player("G"));
//	     players.add(new Player("AC"));
//	     for(int i = 2; i<n; i++) {
//	    	 players.add(new Player("T4T"));
//	     }
	     //Distribution 2
//	     for(int i = 1; i<50; i++) {
//	    	 players.add(new Player("G"));
//	     }
//	     players.add(new Player("T4T"));
//	     for(int i = 50; i<n; i++) {
//	    	 players.add(new Player("AD"));
//	     }
//	     //Distribution 3
//	     for(int i = 1; i<50; i++) {
//	    	 players.add(new Player("AC"));
//	     }
//	     players.add(new Player("G"));
//	     for(int i = 50; i<n; i++) {
//	    	 players.add(new Player("AD"));
//	     }
	     //NEW GENERATION
	     for(int g = 1; g<=k; g++) {
		     int t4tPlayers = 0;
		     int gPlayers = 0;
		     int acPlayers = 0; 
		     int adPlayers = 0; 
		     for(int i = 0; i<players.size(); i++) {
		    	 if(players.get(i).type=="T4T") {
		    		 t4tPlayers++;
		    	 }
		    	 if(players.get(i).type=="G") {
		    		 gPlayers++;
		    	 }
		    	 if(players.get(i).type=="AC") {
		    		 acPlayers++;
		    	 }
		    	 if(players.get(i).type=="AD") {
		    		 adPlayers++;
		    	 }
		     }
		     System.out.println("Gen "+g+":	T4T: "+(double)t4tPlayers/n*100+"%	G: "+(double)gPlayers/n*100+"%	AC: "+(double)acPlayers/n*100+"%	AD: "+(double)adPlayers/n*100+"%");
		     for(int j = 0; j<players.size()-1; j++) {
		    	 for(int i = j+1; i < players.size(); i++) {
			    	 Player p1 = players.get(j);
			    	 Player p2 = players.get(i);
			    	 boolean p1Grudge = false;
			    	 boolean p2Grudge = false;
			    	 p1.move = 0;
			    	 p2.move = 0;
			    	 for(int game = 0; game<m; game++) {
			    		 //Tit for Tat
			    		 //P1
			    		 if(p1.type == "T4T") {
			    			if(p1.move==0) {
			    				p1.move = 1;
			    			}
			    			else {
			    				p1.move = p2.move;
			    			}
			    		 }
			    		 //P2
			    		 if(p2.type == "T4T") {
				    			if(p2.move==0) {
				    				p2.move = 1;
				    			}
				    			else {
				    				p2.move = p1.move;
				    			}
				    		 }
			    		 //Grudger
			    		 //P1
			    		 if(p1.type == "G") {
			    			 if(p2.move==2 || p1Grudge) {
			    				 p1Grudge = true;
			    				 p1.move = 2;
			    			 }
			    			 else {
			    				 p1.move = 1;
			    			 }
	
			    		 }
			    		 //P2
			    		 if(p2.type == "G") {
			    			 if(p1.move==2 || p2Grudge) {
			    				 p2Grudge = true;
			    				 p2.move = 2;
			    			 }
			    			 else {
			    				 p2.move = 1;
			    			 }
			    		 }
			    		 //Always Cooperate
			    		 //P1
			    		 if(p1.type == "AC") {
			    			 p1.move = 1;
			    		 }
			    		 //P2
			    		 if(p2.type == "AC") {
			    			 p2.move = 1;
			    		 }
			    		 //Always Defect
			    		 //P1
			    		 if(p1.type == "AD") {
			    			 p1.move = 2; 
			    		 }
			    		 //P2
			    		 if(p2.type == "AD") {
			    			 p2.move = 2; 
			    		 }
			    		 //Payoffs
			    		 if(p1.move == 1 && p2.move == 1) {
			    			 p1.addPayoff(3);
			    			 p2.addPayoff(3);
			    		 }
			    		 if(p1.move == 1 && p2.move == 2) {
			    			 p2.addPayoff(5);
			    		 }
			    		 if(p1.move == 2 && p2.move == 1) {
			    			 p1.addPayoff(5);
			    		 }
			    		 if(p1.move == 2 && p2.move == 2) {
			    			 p1.addPayoff(1);
			    			 p2.addPayoff(1);
			    		 }
			    		 p1.gamesPlayed++;
			    		 p2.gamesPlayed++;
			    	 }
			     }
		     }
//		     for(Player pl: players) {
//		    	 System.out.println(pl.payoff);
//		     }
		     //Results
		     //Payoffs
		     int payoffSum = 0;
		     int t4tSum = 0;
		     int gSum = 0;
		     int acSum = 0; 
		     int adSum = 0; 
		     int t4tGames = 0;
		     int gGames = 0;
		     int acGames = 0; 
		     int adGames = 0;
		     for(int i = 0; i<players.size();i++) {
		    	 if(players.get(i).type=="T4T") {
		    		 t4tSum+=players.get(i).payoff;
		    		 t4tGames += players.get(i).gamesPlayed;
		    	 }
		    	 if(players.get(i).type=="G") {
		    		 gSum+=players.get(i).payoff;
		    		 gGames += players.get(i).gamesPlayed;
		    	 }
		    	 if(players.get(i).type=="AC") {
		    		 acSum+=players.get(i).payoff;
		    		 acGames += players.get(i).gamesPlayed;
		    	 }
		    	 if(players.get(i).type=="AD") {
		    		 adSum+=players.get(i).payoff;
		    		 adGames += players.get(i).gamesPlayed;
		    	 }
		    	 payoffSum += players.get(i).payoff;
		     }
		     
		     System.out.println("Gen "+g+":	T4T: "+t4tSum+"	G: "+gSum+"	AC: "+acSum+"	AD: "+adSum+"	Total: "+payoffSum);
		     System.out.println("Gen "+g+":	T4T: "+(double)t4tSum/t4tGames+"	G: "+(double)gSum/gGames+"	AC: "+(double)acSum/acGames+"	AD: "+(double)adSum/adGames);
		     //Rank
		     Collections.sort(players);
		     //Remove
		     for (int i = 0; i<pItems; i++){
//		    	 System.out.println("REMOVED "+ players.get(players.size()-1-i).payoff);
		    	 players.remove(players.size()-1-i);
		     }
		     //Replicate
		     for (int i = 0; i<pItems; i++){
//		    	 System.out.println("COPY "+ players.get(i).payoff);
		    	 players.add(new Player(players.get(i).type));
		     }
		     
		   
		     //Reset
		     for(int i = 0; i<players.size(); i++) {
		    	 players.get(i).payoff = 0;
		    	 players.get(i).gamesPlayed = 0;
		     }
	     }
	     
	     
	     
	     
	}  
}
