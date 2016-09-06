package builders;

import model.Profile;
import model.Type;
import model.TypeOfTransport;

public class ProfileBuilder {
	
	private Type typeOfFilm;
	private Type typeOfMusic;
	private Type typeOfFood;
	private int limitAmount;
	private TypeOfTransport typeOfTransport;
	
	public ProfileBuilder(){
		this.typeOfFilm = Type.NO_FILM;
		this.typeOfMusic = Type.NO_MUSIC;
		this.typeOfFood = Type.NO_FOOD;
		this.limitAmount = 0;
		this.typeOfTransport = TypeOfTransport.NO_TRANSPORT;
    }
    
	public static ProfileBuilder aProfile(){
        return new ProfileBuilder();
    }
	
	 public Profile build(){
		 Profile profile =  new Profile(typeOfFilm, typeOfMusic, typeOfFood, limitAmount, typeOfTransport);
	     return profile;
	 }
	 
	 public ProfileBuilder withTypeOfFilm(Type typeOfFilm){
		 this.typeOfFilm = typeOfFilm;
	     return this;
	 }
	 
	 public ProfileBuilder withTypeOfMusic(Type typeOfMusic){
		 this.typeOfMusic = typeOfMusic;
	     return this;
	 }
	 
	 public ProfileBuilder withTypeOfFood(Type typeOfFood){
		 this.typeOfFood = typeOfFood;
	     return this;
	 }
	 
	 public ProfileBuilder withLimitAmount(int limitAmount){
		 this.limitAmount = limitAmount;
	     return this;
	 }
	 
	 public ProfileBuilder withTypeOfTransport(TypeOfTransport typeOfTransport){
		 this.typeOfTransport = typeOfTransport;
	     return this;
	 }

}