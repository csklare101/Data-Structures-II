package hw5;

public class Price implements Comparable<Price>{
	private int dollars;
	private int cents;
	
	public Price(int dollars, int cents) {
		if (dollars < 0 || cents < 0 || cents > 99)
			throw new IllegalArgumentException();
		this.dollars = dollars;
		this.cents = cents;
	}
	
	public String toString() {
		String answer = "$" + dollars + ".";
		if (cents < 10)
			answer = answer + "0" + cents;
		else
			answer = answer + cents;
		return answer;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		if (cents != other.cents)
			return false;
		if (dollars != other.dollars)
			return false;
		return true;
	}

	@Override
	public int compareTo(Price o) {
		int thi = (this.dollars*100) + this.cents;
		int oth = (o.dollars*100) + o.cents;
		
		if(thi > oth) {
			return 1;
		}
		else if(oth > thi) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
