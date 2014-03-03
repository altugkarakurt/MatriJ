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
	public MatriJ(double[][] matrix) throws NotAMatrixException {
		if (MatriJ.isMatrix(matrix)){
			rows = matrix.length;
			cols = matrix[0].length;
			this.matrix = matrix;
		}
		else{
			throw new NotAMatrixException("This is not a proper rectangular 2D Matrix");
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
	
	public static MatriJ arrayToMatriJ(double[] list, int row, int col){
	//For flexibility, this method gets the matrix as a 1D list and converts into
	//a 2D one and generates a MatriJ from it.
		if (((row*col) != list.length) || list == null || row*col == 0){
			return null;
		}
		else{
			double[][] matrix = new double[row][col];
			for(int i = 0; i < list.length; i++){
				matrix[((int)i / row)][((int)i % row)] = list[i];	//CHECK
			}
			try{
				return new MatriJ(matrix);
			}
			catch(NotAMatrixException e){
				return null;
			}
		}
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
	
	public double[][] getMatriJArray(){
		return this.matrix;
	}
	
	public boolean isSquare(){
		return this.rows == this.cols;
	}

	
	//METHOD	
	public double get(int rowIndex, int colIndex){
		return (rowIndex <= this.rows && colIndex <= this.cols) ? this.matrix[rowIndex][colIndex] : null;		
	}
	
	public int countRecurrence(double n){
	//Searches the entire MatriJ for the input value n and returns the number of
	//it's appearances
		int count = 0;
		for (int i = 0; i < this.rows; i++){
			for (int j = 0; j < this.cols; j++){
				if (n == this.get(i, j)){
					count++;
				}
			}
		}
		return count;
	}
	
	public MatriJ add(MatriJ mat){
	//adds two given matrices and returns the result as a MatriJ
		if (this.getColNum() == mat.getColNum() && this.getRowNum() == mat.getRowNum()){
			double[][] res = new double[this.getRowNum()][this.getColNum()];
			for (int i = 0; i < this.rows; i++){
				for (int j = 0; j < this.cols; j++){
					res[i][j] = this.get(i, j) + mat.get(i, j);
				}
			}
			try{
				return new MatriJ(res);
			}
			catch(Exception e){return null;} //Unexpected to happen
		}
		else{
			return null;
		}
	}
	
	public MatriJ scalarMulti(double n){
	//multiplies all indices of the calling MatriJ with the constant n and returns the result
	//as a MatriJ		 
		double[][] res = new double[this.getRowNum()][this.getColNum()];
		for (int i = 0; i < this.rows; i++){
			for (int j = 0; j < this.cols; j++){
				res[i][j] = (this.get(i, j) * n);
			}
		}
		try{
			return new MatriJ(res);
		}
		catch(Exception e){return null;}	//Unexpected to happen
	}
	
	public MatriJ sub(MatriJ mat){
	//subtracts the parameter matrix from calling matrix and returns the result
	//as a MatriJ		
		return this.add(mat.scalarMulti(-1));
	}
	
	public MatriJ multi(MatriJ mat){
		if (this.cols == mat.rows){
			return null;
		}
		else{
			double[][] res = new double[this.rows][mat.cols];
			for (int i = 0; i < this.rows; i++){
				for (int j = 0; j < this.cols; j++){
					res[i][j] += this.get(j,i) + mat.get(i,j);
				}
			}
			try{
				return new MatriJ(res);
			}
			catch(Exception e){return null;	}	//Unexpected to happen
		}
	}
	
	public String toString(){
		String res = "";
		for (int i = 0; i < this.rows; i++){
			for (int j = 0; j < this.cols; j++){
				res += "" + this.get(i, j) + ", \t";
			}
			res += "\n";
		}
		return res;
	}
}