package model;

import java.util.ArrayList;

public enum Type {
	
	//Type of Film:
	HORROR,
	ADVENTURE,
	FANTASY,
	COMEDY,
	ACTION,
	
	//Type of Music:
	ELECTRONIC,
	POP,
	CLASSIC,
	ROCK,
	REGGAETON,
	
	//Type of Food:
	PASTA,
	FAST_FOOD,
	PIZZA,
	SUSHI,
	GRILL;
	
	public ArrayList<Type> typeOfFilms(){
		ArrayList<Type> typeOfFilms = new ArrayList<Type>();
		typeOfFilms.add(HORROR);
		typeOfFilms.add(ADVENTURE);
		typeOfFilms.add(FANTASY);
		typeOfFilms.add(COMEDY);
		typeOfFilms.add(ACTION);
		return typeOfFilms;
	}
	
	public ArrayList<Type> typeOfMusic(){
		ArrayList<Type> typeOfMusic = new ArrayList<Type>();
		typeOfMusic.add(ELECTRONIC);
		typeOfMusic.add(POP);
		typeOfMusic.add(CLASSIC);
		typeOfMusic.add(ROCK);
		typeOfMusic.add(REGGAETON);
		return typeOfMusic;
	}
	
	public ArrayList<Type> typeOfFood(){
		ArrayList<Type> typeOfFood = new ArrayList<Type>();
		typeOfFood.add(PASTA);
		typeOfFood.add(FAST_FOOD);
		typeOfFood.add(PIZZA);
		typeOfFood.add(SUSHI);
		typeOfFood.add(GRILL);
		return typeOfFood;
	}	
}