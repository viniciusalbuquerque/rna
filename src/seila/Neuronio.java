package seila;

public class Neuronio {
	
	private double pesos[];
	private int entradas[][];
	private double alpha;
	private int saidas[];
	
	public void setPesos(double[] pesos) {
		this.pesos = pesos;
	}
	
	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}
	
	public void setEntradas(int[][] entradas) {
		this.entradas = entradas;
	}
	
	public void setSaidas(int[] saidas) {
		this.saidas = saidas;
	}
	
	public int getNet(int index) {
		int saida = 0;
		double net = 0;
		for (int j = 0; j < entradas[index].length; j++) {
			double p = pesos[j];
			int e = entradas[index][j];
			net += p*e;
		}
		
		if(net >= 0) {
			saida = 1;
		} else {
			saida = 0;
		}
		return saida;
	}
	
	public int getNetComOrdem(int ordem) {
		int saida = 0;
		
		double net = 0;
		for (int j = 0; j < entradas[0].length; j++) {
			net += pesos[j]*entradas[ordem][j];
		}
		
		if(net >= 0) {
			saida = 1;
		} else {
			saida = 0;
		}
		
		return saida;
	}
	
	public void setNewPesos(int index, int saida, int entradas[]) {
		for(int i = 0; i < pesos.length; i++) {
			pesos[i] = pesos[i] + alpha*(saidas[index] - saida) * entradas[i];
		}
	}
	
	public double[] getPesos() {
		return pesos;
	}
}
