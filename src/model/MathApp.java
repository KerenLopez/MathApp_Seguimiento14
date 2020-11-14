package model;
import java.util.*;

public class MathApp{

	//Atribute
	private int amount;

	//Relationship
	private ArrayList <IntegerSet> sets;

	public MathApp(){
		sets = new ArrayList<IntegerSet>();
		amount = 0;
	}

	public boolean verifySet(String name){
		boolean find = false;
		for(int k=0;k<amount && !find;k++){
			if(sets.get(k).getName().equalsIgnoreCase(name)){
				find = true;
			}
		} return find;
	}

	public IntegerSet findSet(String name){
		IntegerSet objSet = null;
		boolean find = false;
		for(int k=0;k<amount && !find;k++){
			if(sets.get(k).getName().equalsIgnoreCase(name)){
				find = true;
				objSet = sets.get(k);
			}
		} return objSet;
	}

	public void addSet(String name){
		IntegerSet objSet = new IntegerSet(name);
		sets.add(objSet);
		amount=sets.size();
	}

	public void removeSet(String name){
		boolean find = false;
		for(int k=0;k<amount && !find;k++){
			if(sets.get(k).getName().equalsIgnoreCase(name)){
				find=true;
				sets.remove(k);
				amount = sets.size();
			}
		} 
	}

	public String addElementMessage(String setName, int element){
		String message;
		IntegerSet objSet = findSet(setName);
		boolean add = objSet.verifyElement(element);
		if(!add){
			addElementToSet(setName, element);
			message = "\nEl elemento fue agregado exitosamente";
		} else{
			message = "\nEl elemento ya existe, intentelo nuevamente";
		} return message;
	} 

	public void addElementToSet(String setName, int element){
		IntegerSet objSet = findSet(setName);
		objSet.addElement(element);
	}

	public String removeElementMessage(String setName, int element){
		String message;
		IntegerSet objSet = findSet(setName);
		boolean find = objSet.verifyElement(element);
		if(find){
			removeElementFromSet(setName, element);
			message = "\nEl elemento fue eliminado exitosamente";
		} else{
			message = "\nEl elemento no existe, intentelo nuevamente";
		} return message;
	}

	public void removeElementFromSet(String setName, int element){
		IntegerSet objSet = findSet(setName);
		objSet.removeElement(element);	
	}

	public String showUnionOperation(String name1, String name2, String newName){
		union(name1, name2, newName);
		String set = showInfoSet(newName);
		String message = "\nLa union de los dos conjuntos es: "+set;
		return message;
	}

	public void union(String name1, String name2, String newName){
		IntegerSet objSet1 = findSet(name1);
		IntegerSet objSet2 = findSet(name2);
		IntegerSet newObj = objSet1.union(objSet2, newName);
		sets.add(newObj);
		amount = sets.size();
	}

	public String showDifferenceOperation(String name1, String name2, String newName){
		difference(name1, name2, newName);
		String set = showInfoSet(newName);
		String message = "\nLa diferencia entre los dos conjuntos es: "+set;
		return message;
	}

	public void difference(String name1, String name2, String newName){
		IntegerSet objSet1 = findSet(name1);
		IntegerSet objSet2 = findSet(name2);
		IntegerSet newObj = objSet1.difference(objSet2, newName);
		sets.add(newObj);
		amount = sets.size();
	}

	public String showIntersection(String name1, String name2, String newName){
		intersection(name1, name2, newName);
		String set = showInfoSet(newName);
		String message = "\nLa interseccion entre los dos conjuntos es: "+set;
		return message;
	}

	public void intersection(String name1, String name2, String newName){
		IntegerSet objSet1 = findSet(name1);
		IntegerSet objSet2 = findSet(name2);
		IntegerSet newObj = objSet1.intersection(objSet2, newName);
		sets.add(newObj);
		amount = sets.size();
	}

	public String showSymmetricDifferenceOperation(String name1, String name2, String newName){
		symmetricDifference(name1, name2, newName);
		String set = showInfoSet(newName);
		String message = "\nLa diferencia simetrica entre los dos conjuntos es: "+set;
		return message;
	}

	public void symmetricDifference(String name1, String name2, String newName){
		IntegerSet objSet1 = findSet(name1);
		IntegerSet objSet2 = findSet(name2);
		IntegerSet newObj = objSet1.symmetricDifference(objSet2, newName);
		sets.add(newObj);
		amount = sets.size();
	}

	public String showInfoSet(String name){
		IntegerSet newObjSet = findSet(name);
		String message = newObjSet.toString();
		return message;
	}

	public String showInfoSets(){
		String message = "";
		for(int k=0;k<amount;k++){
			message += sets.get(k).toString();
		}
		return message;
	}
}