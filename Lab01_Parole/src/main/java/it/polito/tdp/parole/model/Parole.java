package it.polito.tdp.parole.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Parole{
	
	Map<String, String> mappa;
	List<String> lista;
		
	public Parole() {
		//TODO
		mappa = new TreeMap<String, String>();
		lista = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		//TODO
		mappa.put(p, p);
	}
	
	public List<String> getElenco() {
		//TODO
		lista.clear();
		
		for(String s: mappa.values())
		{
			lista.add(s);
		}
		
		return lista;
	}
	
	public void reset() {
		// TODO
		mappa.clear();
		lista.clear();
	}
	
	public void togliParola(String s)
	{
		mappa.remove(s);
	}

	
	
	

	
	
	

}
