package deltaj;

/* by Altuğ Karakurt in March 2014
 * 
 * 
*/

public class VectorJ {
	
	//VARIABLES
	private double[] vector;
	private int dim;
	
	//CONSTRUCTOR
	public VectorJ(double[] vector){
		this.vector = vector;
		dim = vector.length;
	}
	
	//GETTERS - SETTERS
	public void set(int index, double n){
		if (index < this.dim){
			vector[index] = n;
		}
	}
	
	public double get(int index){
		return (index <= this.getDim()) ? this.get(index) : null;
	}
	
	public int getDim(){
		return this.dim;
	}
	
	//METHODS
	public int countReccurence(double n){
		int res = 0;
		for (int i = 0; i < this.dim; i++){
			if (this.get(i) == n){
				res++;
			}
		}
		return res;
	}
	
	public boolean equals(VectorJ vec){
		if (this.getDim() != vec.getDim()){
			return false;
		}
		for (int i = 0; i < this.dim; i++){
			if (this.get(i) != vec.get(i)){
				return false;
			}
		}
		return true;
	}
	
	public VectorJ add(VectorJ vec){
		if (this.getDim() == vec.getDim()){
			double[] res = new double[this.getDim()];
			for (int i = 0; i < this.getDim(); i++){
				res[i] = this.get(i) + vec.get(i);
			}
			return new VectorJ(res);
		}
		return null;
	}
	
	public VectorJ scalarMulit(double n){
		double[] res = new double[this.getDim()];
		for (int i = 0; i < this.getDim(); i++){
			res[i] = this.get(i) * n;
		}
		return new VectorJ(res);
	}
	
	public VectorJ sub(VectorJ vec){
		if (this.getDim() == vec.getDim()){
			return this.add(vec.scalarMulit(-1));
		}
		return null;
	}
	
	public double dotProduct(VectorJ vec){
		if (this.getDim() == vec.getDim()){
			double res = 0;
			for (int i = 0; i < this.getDim(); i++){
				res += vec.get(i) * this.get(i);
			}
			return res;
		}
		return 0;			//find an alternative
	}
	
	public String toString(){
		String res = "";
		for (int i = 0; i < this.getDim(); i++){
			res += "" + this.get(i) + "\n";
		}
		return res;
	}
}
