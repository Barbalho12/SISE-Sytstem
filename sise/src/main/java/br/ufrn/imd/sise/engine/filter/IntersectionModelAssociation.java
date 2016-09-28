package br.ufrn.imd.sise.engine.filter;

import br.ufrn.imd.sise.engine.filter.model.UserPreferences;

public class IntersectionModelAssociation implements ModelAssociation{

	private static IntersectionModelAssociation intersectionModelAssociation = new IntersectionModelAssociation();
	
	public IntersectionModelAssociation(){
		
	}
	
	/* Comparation method.
	 * return:
	 * 10 - if the two terms are equals.
	 * value - if they are differents. 
	 * Obs.: value means the number of letters are equals.
	 * */
	@Override
	public double calculate(UserPreferences termPreferences, String termsInformation) {
		
		try {
			// TODO
			String userTerm = termPreferences.getTermo(); 
			if(userTerm.equals(termsInformation)) {
				return 10.0;
			} else {
				double value = 0, intersec = 0;
				int size = 0;	
				if(userTerm.length() > termsInformation.length()) {
					size = userTerm.length(); 
				} else {
					size = termsInformation.length();
				} 
				
				for(int i=0; i<size;i++) {
					if(userTerm.charAt(i) == termsInformation.charAt(i)) {
						intersec += 1;
					} else {
						value = ((intersec/userTerm.length()) * 10);
						return value;
					}
				}
				
				return value;
			}	
			
		} catch (Exception e){
			e.getStackTrace();
		}
		
		return 0;
	}	
	
	public static IntersectionModelAssociation getInstance() {
		return intersectionModelAssociation;
	}

}
