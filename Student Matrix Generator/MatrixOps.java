public class MatrixOps
{
	public static double[][] multiply(double[][] matrix1, double[][] matrix2)
	{
	double [][] product= new double [matrix1.length][matrix2[0].length];
	if(matrix1[0].length == matrix2.length){
		for(int row= 0; row< matrix1.length; row++){
			for(int col= 0; col< matrix2[0].length; col++){
				for(int k= 0; k< matrix1[0].length; k++){
				product[row][col] += matrix1[row][k] * matrix2[k][col];
				}
			}
		}
		return product;
		}
		
	else{
		return null; 
	}
	}
}
