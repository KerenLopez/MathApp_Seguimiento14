package model;
import java.util.*;

public class IntegerSet{

	//Atributes
	private String name;
	private int cardinality;
	private ArrayList <Integer> elements;

	public IntegerSet(String name){
		this.name = name;
		cardinality = 0;
		elements = new ArrayList<Integer>();
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getCardinality(){
		return cardinality;
	}

	public void setCardinality(int cardinality){
		this.cardinality = cardinality;
	}

	public ArrayList<Integer> getElements(){
		return elements;
	}

	public void setElements(ArrayList<Integer> elements){
		this.elements = elements;
	}

	public boolean verifyElement(Integer element){
		boolean find = false;
		for(int k=0;k<cardinality && !find;k++){
			if(elements.get(k)==element){
				find=true;
			}
		} return find;
	}

	public void addElement(Integer element){
		elements.add(element);
		cardinality = elements.size();	
	}

	public void removeElement(Integer element){
		boolean stop = false;
		for(int k=0;k<cardinality && !stop;k++){
			if(elements.get(k)==element){
				stop=true;
				elements.remove(k);
				cardinality = elements.size();	
			}
		}
	}

	public IntegerSet union(IntegerSet set, String newName){
		IntegerSet newSet = new IntegerSet(newName);
		for(int k=0;k<cardinality;k++){
			newSet.getElements().add(getElements().get(k));
			newSet.setCardinality(getElements().size());	
		}	
		for(int i=0;i<set.getCardinality();i++){
			boolean find = newSet.verifyElement(set.getElements().get(i));
			if(find==false){
				newSet.getElements().add(set.getElements().get(i));
				newSet.setCardinality((newSet.getCardinality())+1);
			}
		}	
		return newSet;
	}

	public IntegerSet difference(IntegerSet set, String newName){
		IntegerSet newSet = new IntegerSet(newName);
		for(int k=0;k<cardinality;k++){
			boolean find = set.verifyElement(getElements().get(k));
			if(find==false){
				newSet.getElements().add(getElements().get(k));
				newSet.setCardinality((newSet.getCardinality())+1);
			}
		}
		return newSet;
	}

	public IntegerSet intersection(IntegerSet set, String newName){
		IntegerSet newSet = new IntegerSet(newName);
		for(int k=0;k<cardinality;k++){
			boolean find = set.verifyElement(getElements().get(k));
			if(find==true){
				newSet.getElements().add(getElements().get(k));
				newSet.setCardinality((newSet.getCardinality())+1);
			}
		}
		return newSet;
	}

	public IntegerSet symmetricDifference(IntegerSet set, String newName){
		IntegerSet newSet = new IntegerSet(newName);
		for(int k=0;k<cardinality;k++){
			boolean find = set.verifyElement(getElements().get(k));
			if(find==false){
				newSet.getElements().add(getElements().get(k));
				newSet.setCardinality((newSet.getCardinality())+1);
			}
		}
		for(int i=0;i<set.getCardinality();i++){
			boolean find = verifyElement(set.getElements().get(i));
			if(find==false){
				newSet.getElements().add(set.getElements().get(i));
				newSet.setCardinality((newSet.getCardinality())+1);
			}
		}
		return newSet;
	}

	public String toString(){
		String message = "\n                                          "+name+"=";
		boolean full = getElements().isEmpty();
		if(full==true){
			message+="El conjunto esta vacio";
		} else{
			for(int k=0;k<cardinality;k++){
				message+= "["+getElements().get(k)+"]";
			}
		}return message;
	}
}