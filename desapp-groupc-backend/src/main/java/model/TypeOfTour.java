package model;

public enum TypeOfTour{

	GASOLERA,
	WITH_FRIENDS,
	SATURDAY_NIGHT_FEVER,
	HALF_ORANGE,
	SURPRISE;
	
	public void generate(Sistem sistem, Tour tour){
		switch (tour.getTipe()) {
        	case GASOLERA:
        		sistem.generateGASOLERA(tour);
        		break;
        	case WITH_FRIENDS:
        		sistem.generateWITH_FRIENDS(tour); 
        		break;
        	case SATURDAY_NIGHT_FEVER:
        		sistem.generateSATURDAY_NIGHT_FEVER(tour); 
        		break;
        	case HALF_ORANGE:
        		sistem.generateHALF_ORANGE(tour); 
        		break;
        	case SURPRISE:
        		sistem.generateSURPRISE(tour); 
        		break;
        	default: 
        		sistem.generateSURPRISE(tour); 
        		break;
		}
	}
}