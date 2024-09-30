package mavenapp.com.mavenapp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class StudentMockApp {
	
	@Mock
	public IDatabase database;
	public StudentScoreCard studentScoreCard;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@org.junit.jupiter.api.Test
	public void testStudent() {
		StudentScoreCard sc = new StudentScoreCard(database);
		int[] scores = {60,50,90};
		sc.calculateAndStore("student-1", scores);
		Mockito.verify(database, Mockito.times(1)).updateStudentScore("student-1", 200);
		
	}
	
	

}
