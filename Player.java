package assigment2;

public class Player implements Comparable<Player> {
	String type;
	int payoff;
	int move;
	int gamesPlayed;
	
	public Player(String type){
		this.type = type;
		this.payoff = 0;
		this.move = 0;
		this.gamesPlayed = 0;
	}
	
	void addPayoff(int p) {
		this.payoff +=p;
	}

	@Override
	public int compareTo(Player o) {
		int compareQuantity = ((Player) o).payoff;
		return compareQuantity - this.payoff;
	}
}
