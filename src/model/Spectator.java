package model;

public class Spectator extends Person{
	private Spectator left;
	private Spectator right;
	
	public Spectator(String id, String name, String lastName, String email, String gender, String country,
			String photo, String birthDay) {
		super(id, name, lastName, email, gender, country, photo, birthDay);
	}

	public Spectator getLeft() {
		return left;
	}

	public void setLeft(Spectator left) {
		this.left = left;
	}

	public Spectator getRigth() {
		return right;
	}

	public void setRigth(Spectator right) {
		this.right = right;
	}
	
	public String findSpectator(String idP) {
		String msg = "";
		
		if(id.compareToIgnoreCase(idP) == 0) {
			return this.toString();
		}else  if(id.compareToIgnoreCase(idP) < 0) {
					if(this.right != null) {
						msg = this.right.findSpectator(idP);
					}
			}else if(id.compareToIgnoreCase(idP) > 0) {
					if(this.left != null) {
						msg = this.left.findSpectator(idP);
					}
			}
	
		return msg;
	}
	
	public void insertSpectator(Spectator e) {
		
		if(id.compareToIgnoreCase(e.getId()) < 0) {
			
			if(right == null) {
				setRigth(e);
			}else {
				this.right.insertSpectator(e);
			}	
		}else {
			if(left == null) {
				setLeft(e);
			}else {
				this.left.insertSpectator(e);
			}
		}
	}

	public String showSpectators(String sCountry) {
		String msg = "";
		
		if(country.equalsIgnoreCase(sCountry)) {
			msg += getId() + "\n";
			msg += "|___";
			
			if(left != null && left.country.equalsIgnoreCase(sCountry)) {
				msg += left.getId() + "  \n";
				msg += "|___";
			}
			
			
			if(right != null && right.country.equalsIgnoreCase(sCountry)) {
				msg += right.getId() + "\n";
			}	
		}
		if(left != null) msg += left.showSpectators(sCountry);
		if(right != null) msg += right.showSpectators(sCountry);
		
		return msg;
	}
}
