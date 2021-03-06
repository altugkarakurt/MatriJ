package deltaj;

/* by Altuğ Karakurt in February 2014
 * 
 * This class is intended to do the basic matrix operations and offer a solution
 * for handling matrices.
 * 
 * - The basic operation methods, such as addition, multiplication, etc. are 
 * designed to return the result as a new MatriJ to maintain their re-usability
 * by other methods. Depending on the needs, they may be modified to void methods
 * and manipulate the calling MatriJ instead. 
 */

public class MatriJ {

	//VARIABLES
	//The matrices are kept as A[i][j], where i is row index and j is column index  
	private double[][] matrix;
	private int rows;
	private int cols;
		
	//CONSTRUCTOR
	public MatriJ(double[][] matrix){
		if (MatriJ.isMatrix(matrix)){
			rows = matrix.length;
			cols = matrix[0].length;
			this.matrix = matrix;
		}
	}
	
	public static boolean isMatrix(double[][] matrix){
	//Checks for the rectangularity of the given matrix
		int size = matrix[0].length;
		for (double[] i : matrix){
			if (i.length != size){
				return false;
			}
		}
		return true;
	}
	
	//GETTERS - SETTERS
	public void set(double n, int i, int j){
		this.matrix[i][j] = n;
	}
	
	public int getRowNum(){
		return this.rows;
	}
	
	public int getColNum(){
		return this.cols;
	}
	
	public double[][] getMatrix(){
		return this.matrix;
	}
	
	public boolean isSquare(){
		return this.rows == this.cols;
	}

	
	//METHOD	
	public double get(int rowIndex, int colIndex){
		return (rowIndex <= this.getRowNum() && colIndex <= this.getColNum()) ? this.get(rowIndex, colIndex) : null;		
	}
	
	public static MatriJ identity(int n){
		double[][] res = new double[n][n];
		for (int i = 0; i < n; i++){
			res[i][i] = 1;
		}
		return new MatriJ(res);
	}
	
	public int countRecurrence(double n){
	//Searches the entire MatriJ for the input value n and returns the number of
	//it's appearances
		int count = 0;
		for (int i = 0; i < this.getRowNum(); i++){
			for (int j = 0; j < this.getColNum(); j++){
				if (n == this.get(i, j)){
					count++;
				}
			}
		}
		return count;
	}
	
	public boolean equals(MatriJ mat){
	//if the size of two MatriJs are not equal, returns false. If they are equal,
	//checks for every element in their 2D arrays for equality
		if(this.getRowNum() == mat.getRowNum() && this.getColNum() == mat.getColNum()){
			for (int i = 0; i < this.getRowNum(); i++){
				for (int j = 0; j < this.getColNum(); j++){
					if (this.get(i, j) != mat.get(i, j)){
						return false;
					}
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isSymmetric(){
	//checks for the condition A^T ?= A
		return this.equals(this.transpose());
	}
	
	public boolean isSkewSymmetric(){
		//checks for the condition A^T ?= -A	
		return (this.scalarMulti(-1)).equals(this.transpose());
	}
	
	public MatriJ transpose(){
	//returns the transpose of the calling MatriJ
		double[][] res = new double[this.getColNum()][this.getRowNum()];
		for (int i = 0; i < this.getRowNum(); i++){
			for (int j = 0; j < this.getColNum(); j++){
				res[j][i] = this.get(i, j);
			}
		}
		return new MatriJ(res);
	}
	
	public MatriJ add(MatriJ mat){
	//adds two given matrices and returns the result as a MatriJ
		if (this.getColNum() == mat.getColNum() && this.getRowNum() == mat.getRowNum()){
			double[][] res = new double[this.getRowNum()][this.getColNum()];
			for (int i = 0; i < this.getRowNum(); i++){
				for (int j = 0; j < this.getColNum(); j++){
					res[i][j] = this.get(i, j) + mat.get(i, j);
				}
			}
			return new MatriJ(res);
		}
		else{
			return null;
		}
	}
	
	public MatriJ scalarMulti(double n){
	//multiplies all indices of the calling MatriJ with the constant n and returns the result
	//as a MatriJ		 
		double[][] res = new double[this.getRowNum()][this.getColNum()];
		for (int i = 0; i < this.getRowNum(); i++){
			for (int j = 0; j < this.getColNum(); j++){
				res[i][j] = (this.get(i, j) * n);
			}
		}
		return new MatriJ(res);
	}
	
	public MatriJ sub(MatriJ mat){
	//subtracts the parameter matrix from calling matrix and returns the result
	//as a MatriJ		
		return this.add(mat.scalarMulti(-1));
	}
	
	public MatriJ multi(MatriJ mat){
	//multiplies two matrices. m1.multi(m2) gives m1 x m2. if the matrices are 
	//not multipliable returns null 
		if (this.getColNum() != mat.getRowNum()){
			return null;
		}
		else{
			double[][] res = new double[this.getRowNum()][mat.getColNum()];
			for (int i = 0; i < this.getRowNum(); i++){
				for (int j = 0; j < mat.getColNum(); j++){
					for (int k = 0; k < this.getColNum(); k++){
						res[i][j] += this.get(i,k) * mat.get(k,j);
					}
				}
			}
			return new MatriJ(res);
		}
	}
	
	public String toString(){
		String res = "";
		for (int i = 0; i < this.getRowNum(); i++){
			for (int j = 0; j < this.getColNum(); j++){
				res += "" + this.get(i, j) + ", \t";
			}
			res += "\n";
		}
		return res;
	}
}