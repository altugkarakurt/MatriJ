package deltaj;

public class MatriJTester {

	public static void main(String[] args) {
		System.out.println("Testing class for MatriJ...");
		final int R1 = 3;
		final int C1 = 2;
		final int R2 = 2;
		final int C2 = 3;
		
		double[][] arr1 = new double[R1][C1];
		double[][] arr2 = new double[R2][C2];
		arr1[0][0] = 4;
		arr1[0][1] = 3;
		arr1[1][0] = 1;
		arr1[1][1] = 2;
		arr1[2][0] = 5;
		arr1[2][1] = 7;
		
		arr2[0][0] = 4;
		arr2[0][1] = 5;
		arr2[0][2] = 6;
		arr2[1][0] = 7;
		arr2[1][1] = 2;
		arr2[1][2] = 8;

		
		try{
			MatriJ mat1 = new MatriJ(arr1);
			MatriJ mat2 = new MatriJ(arr2);
			System.out.println("MAT1" + "\n" + mat1);
			System.out.println("MAT2" + "\n" + mat2);
			System.out.println("The addition: ");
			System.out.println(mat1.add(mat2));
			System.out.println("Multiply by 2: ");
			System.out.println(mat1.scalarMulti(2));
			System.out.println("Subtraction: ");
			System.out.println(mat1.sub(mat2));
			System.out.println("Multiplication of both matrices: ");
			System.out.println(mat2.multi(mat1));
		}
		catch(Exception e){
			System.out.println("Failed to create the MatriJs");
			e.printStackTrace();
		}
		
		
		
		

	}

}
