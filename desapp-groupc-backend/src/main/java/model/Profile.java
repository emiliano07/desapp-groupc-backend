package model;

public class Profile {
	
	public Type typeOfFilm;
	public Type typeOfMusic;
	public Type typeOfFood;
	public int limitAmount;
	
	public Profile(Type typeOfFilm, Type typeOfMusic, Type typeOfFood, int limitAmount){
		this.typeOfFilm = typeOfFilm;
		this.typeOfMusic = typeOfMusic;
		this.typeOfFood = typeOfFood;
		this.limitAmount = limitAmount;
	}

	public Type getTypeOfFilm() {
		return typeOfFilm;
	}

	public Type getTypeOfMusic() {
		return typeOfMusic;
	}

	public Type getTypeOfFood() {
		return typeOfFood;
	}
}