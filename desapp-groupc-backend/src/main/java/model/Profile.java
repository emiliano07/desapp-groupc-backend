package model;

public class Profile {
	
	public Type typeOfFilm;
	public Type typeOfMusic;
	public Type typeOfFood;
	public int limitAmount;
	public TypeOfTransport typeOfTransport;
	
	public Profile(Type typeOfFilm, Type typeOfMusic, Type typeOfFood, int limitAmount, TypeOfTransport typeOfTransport){
		this.typeOfFilm = typeOfFilm;
		this.typeOfMusic = typeOfMusic;
		this.typeOfFood = typeOfFood;
		this.limitAmount = limitAmount;
		this.typeOfTransport = typeOfTransport;
	}
	
	//DEBERIAMOS PONER TODOS LOS TYPES JUNTOS Y NO DIFERENCIARLOS???
}