package application;

public class CurrentUser {
	  private static String currentUserRole = "Patient"; // Default value

	  
	    public static String getCurrentPatient() {
	    	System.out.println("Current Role" + currentUserRole );
	        return currentUserRole;
	    }

	    public static void setUser(String currentUser) {
	        CurrentUser.currentUserRole = currentUser;
	    }
}
