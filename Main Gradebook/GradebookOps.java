public class GradebookOps
{
	public static int findStudent(String studentName, String[] allStudentNames, boolean alphabetical)
	{
		for(int i=0;i<allStudentNames.length; i++){
			if (allStudentNames[i].equals(studentName))
				return i;
		}
		
		return -1;
	}

	public static double computeGrade(int studentIndex, int[][] scoreTable, int[] itemPointValues)
	{
	
	double gradeforstudent= 0.0;
	double totalforstudent= 0.0;
	int numexc= 0;
		for(int gradecount= 0; gradecount< itemPointValues.length; gradecount++){
			if(scoreTable[studentIndex][gradecount] >= 0){
			totalforstudent= totalforstudent+ scoreTable[studentIndex][gradecount];	
			}
			else{
			numexc++;
			}
			}
			
	double totalgrade= 0.0;		
		for(int totalgradecount= 0; totalgradecount< itemPointValues.length; totalgradecount++){
			if(scoreTable[studentIndex][totalgradecount] != -1){
			totalgrade= totalgrade+ itemPointValues[totalgradecount];
			}
			else{
			}
		}
			
	gradeforstudent= (totalforstudent/totalgrade)* 100;
		
		if(numexc == itemPointValues.length){
		return -1;
		}
		else{
		return gradeforstudent; 
		}
	}
		
	
	public static double[] computeAllGrades(int[][] scoreTable, int[] itemPointValues)
	{
	int maxpoints= 0;
	int totalpoints= 0;
	double[] studentgrades= new double[scoreTable.length];
	
	for(int row= 0; row< scoreTable.length; row++){
		maxpoints= 0;
		totalpoints= 0;
		for(int col= 0; col< scoreTable[row].length; col++){
			if(scoreTable[row][col] >= 0){
				
				totalpoints += scoreTable[row][col];
				maxpoints += itemPointValues[col];
				}
			}
			studentgrades[row]= (double)totalpoints/maxpoints*100;
		}
		
		if(maxpoints == 0){
		return null; 
	}
	else{
		return studentgrades;
		}
	}

	public static double computeClassAverage(int item, int[][] scoreTable)
	{
	int gradeditemcount;
	double sumgradeditem= 0.0;
	int numofstudents= 0;
	int numexc= 0;
	
	
		for(gradeditemcount= 0; gradeditemcount< scoreTable.length; gradeditemcount++){
			if(scoreTable[gradeditemcount][item] >= 0){
			sumgradeditem= sumgradeditem + scoreTable[gradeditemcount][item];
			}
			else{
			numexc ++;
			}
		}	
		numofstudents= scoreTable.length - numexc;
		
		if(scoreTable.length == numexc){
			return -1;
			}
		else{	
		return sumgradeditem/numofstudents; 
		}
	}
	
	

}
