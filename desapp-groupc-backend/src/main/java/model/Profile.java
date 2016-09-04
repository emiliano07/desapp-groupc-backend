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

	public Type getTypeOfFilm() {
		return typeOfFilm;
	}

	public void setTypeOfFilm(Type typeOfFilm) {
		this.typeOfFilm = typeOfFilm;
	}

	public Type getTypeOfMusic() {
		return typeOfMusic;
	}

	public void setTypeOfMusic(Type typeOfMusic) {
		this.typeOfMusic = typeOfMusic;
	}

	public Type getTypeOfFood() {
		return typeOfFood;
	}

	public void setTypeOfFood(Type typeOfFood) {
		this.typeOfFood = typeOfFood;
	}

	public int getLimitAmount() {
		return limitAmount;
	}

	public void setLimitAmount(int limitAmount) {
		this.limitAmount = limitAmount;
	}

	public TypeOfTransport getTypeOfTransport() {
		return typeOfTransport;
	}

	public void setTypeOfTransport(TypeOfTransport typeOfTransport) {
		this.typeOfTransport = typeOfTransport;
	}
}