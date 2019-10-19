package model;

public class Competitor extends Person{
	private Competitor previous;
	private Competitor next;

	public Competitor(String id, String name, String lastName, String email, String gender, String country,
			String photo, String birthDay) {
		super(id, name, lastName, email, gender, country, photo, birthDay);
	}

	public Competitor getPrevious() {
		return previous;
	}

	public void setPrevious(Competitor previous) {
		this.previous = previous;
	}

	public Competitor getNext() {
		return next;
	}

	public void setNext(Competitor next) {
		this.next = next;
	}
	
	public String findCompetitor(String idP) {
		String msg = "";
		
		if(id.compareToIgnoreCase(idP) == 0) {
			return msg = this.getId();
		}else{
			if(this.next != null) {
			msg = this.next.findCompetitor(idP);
			}
		}
		
		return msg;
	}
}
