package deltaj;

public class MatriJTester {

	public static void main(String[] args) {
		System.out.println("Testing class for MatriJ...");
		final int R1 = 3;
		final int C1 = 2;
		final int R2 = 3;
		final int C2 = 2;
		
		double[][] arr1 = new double[R1][C1];
		double[][] arr2 = new double[R2][C2];
		arr1[0][0] = 94;
		arr1[0][1] = 4;
		arr1[1][0] = 0;
		arr1[1][1] = 24;
		arr1[2][0] = 9;
		arr1[2][1] = 3;
		
		arr2[0][0] = 4;
		arr2[0][1] = 3;
		arr2[1][0] = 74;
		arr2[1][1] = 26;
		arr2[2][0] = 1;
		arr2[2][1] = 9;

		
		try{
			MatriJ mat1 = new MatriJ(arr1);
			MatriJ mat2 = new MatriJ(arr2);
			System.out.println("MAT1" + "\n" + mat1);
			System.out.println("MAT2" + "\n" + mat2);
			System.out.println("C1: " + mat1.getColNum() + " R1: " + mat1.getRowNum());
			System.out.println("C2: " + mat2.getColNum() + " R2: " + mat2.getRowNum());
			System.out.println("The addition: ");
			System.out.println(mat1.add(mat2));
			System.out.println("Multiply by 2: ");
			System.out.println(mat1.scalarMulti(2));
			System.out.println("Subtraction: ");
			System.out.println(mat1.sub(mat2));
			System.out.println("The 0,0th element of mat1");
			System.out.println(mat1.get(0,0));
			System.out.println("The 0,1 element is replaced by 9");
			mat1.set(9, 0, 1);
			System.out.println(mat1);
			System.out.println("Multiplication of both matrices: ");
			System.out.println(mat1.multi(mat2));
		}
		catch(Exception e){
			System.out.print("Failed to create the MatriJs");
		}
		
		
		
		

	}

}
