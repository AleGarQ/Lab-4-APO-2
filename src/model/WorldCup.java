package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import exceptions.*;

public class WorldCup {
	private String file;
	private Competitor first;
	private Spectator root;
	
	public WorldCup(String files) {
		this.file = files;
		loadSpectatorsAndCompetitors();
	}

	public String findSpectator(String id) {
		Spectator aux = root;
		if(id.compareToIgnoreCase(aux.getId()) == 0) {
			return root.toString();
		}else {
			return aux.findSpectator(id);
		}
	}
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Competitor getFirst() {
		return first;
	}

	public void setFirst(Competitor first) {
		this.first = first;
	}

	public Spectator getRoot() {
		return root;
	}

	public void setRoot(Spectator root) {
		this.root = root;
	}

	public void loadSpectatorsAndCompetitors() {
		File fl = new File(file);
		
		try {
		FileReader fr = new FileReader(fl);
		BufferedReader br = new BufferedReader(fr);
		String msg = br.readLine();
		int i = 0;
		while(msg != null) {
			if(i % 2 == 0) {
				String[] b = msg.split(",");
				String id = b[0];
				String name = b[1];
				String lastName = b[2];
				String email = b[3];
				String gender = b[4];
				String country = b[5];
				String photo = b[6];
				String birthDay = b[7];
				
				Spectator e = new Spectator(id, name, lastName, email, gender, country, photo, birthDay);
				addSpectator(e);
				msg = br.readLine();
			}else if(i % 2 != 0){
				String[] b = msg.split(",");
				String id = b[0];
				String name = b[1];
				String lastName = b[2];
				String email = b[3];
				String gender = b[4];
				String country = b[5];
				String photo = b[6];
				String birthDay = b[7];
				
				Competitor e = new Competitor(id, name, lastName, email, gender, country, photo, birthDay);
				addCompetitorSorted(e);
				msg = br.readLine();
			}
			
			i++;
		}
		
		br.close();
		fr.close();
		
		}catch(IOException e) {
			e.getCause();
		}
	}
	
	public void addSpectator(Spectator e) {
		Spectator aux = root;
		
		if(root == null) {
			root = e;
		}else {
			aux.insertSpectator(e);
		}	
	}
	
	public void addCompetitorSorted(Competitor e) {
		Competitor aux = first;
		Competitor prev = null;
		if(first == null) {
			first = e;
		}else if(e.getId().compareToIgnoreCase(first.getId()) < 0){
			e.setNext(aux);
			aux.setPrevious(e);
			first = e;
		}else {		
			while(aux != null && aux.getId().compareToIgnoreCase(e.getId()) < 0) {
				prev = aux;
				aux = aux.getNext();
			}
			
			if(aux != null) {
				e.setNext(aux);
				aux.setPrevious(e);
				prev.setNext(e);
				e.setPrevious(prev);
			}else {
				e.setNext(aux);
				prev.setNext(e);
				e.setPrevious(prev);
			}
		}
	}
	
	public String findCompetitor(String idP) throws CompetitorNotFound {
		String msg = "";
		Competitor aux = first;
		boolean found = false;
		
		while(aux != null && !found) {
			if(aux.getId().compareToIgnoreCase(idP) == 0) {
				msg = aux.toString();
				found = true;
			}else {
				aux = aux.getNext();
			}
		}
		
		if(found == false) {
			throw new CompetitorNotFound("EL ID NO COINCIDE CON NINGUN COMPETIDOR");
		}
		
		return msg;
	}
	
	public String showCompetitorsOfACountry(String country) {
		String msg = "Los id de los competidores de "+ country +" son:\n";
		Competitor aux = first;
		boolean found = false;
		
		while(aux != null && !found) {
			if(aux.getCountry().compareToIgnoreCase(country) == 0) {
				msg += "||" + aux.getId();
			}
			aux = aux.getNext();
			
			if(aux.getNext() == null) {
					found = true;
			}
		}
		return msg;
	}

	public String showSpectatorsOfACountry(String country) {
		return root.showSpectators(country);
	}
	

}
