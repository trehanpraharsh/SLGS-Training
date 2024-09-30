package mavenapp.com.mavenapp;

public class StudentScoreCard {
	
	public IDatabase database;
	
	public StudentScoreCard(IDatabase database) {
		super();
		this.database = database;
	}
	
	public void calculateAndStore(String sid, int[] scores) {
		int total = 0;
		for(int score : scores) {
			total += score;
		}
		database.updateStudentScore(sid, total);
		
	}

}
