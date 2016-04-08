package seila;

public class Main {

	public static void main(String[] args) {
		
		double pesos[] = {-1,-1,-1,-1};
//		int entradas[][] = {{1,0,0}, {1,0,1}, {1,1,0}, {1,1,1}};
		int entradas[][] = {{1,-1,-1,1}, {1,1,-1,1}, {1,-1,-1,-1}, {1,1,1,-1}, {1,-1,1,1}, {1,1,-1,-1}};
//		int saidas[] = {0,0,0,1};
		int saidas[] = {0,1,0,1,0,1};
		
		int ordem[][] = {{0,1,2,3,4,5}, {2,5,4,1,0,3}, {1,0,2,5,4,3}, {5,3,0,4,1,2},{1,0,3,4,5,2}};

		int ciclosDesejados = 2;
		int ciclo = 0;
		
		boolean semOrdem = false;
		
		double alpha = 1;
		Neuronio n = new Neuronio();
		
		n.setPesos(pesos);
		n.setEntradas(entradas);
		n.setAlpha(alpha);
		n.setSaidas(saidas);
		
		while(ciclo < ciclosDesejados) {
			if(semOrdem) {
				for(int i = 0; i < saidas.length; i++) {
					int saida = n.getNet(i);
					if(saida != saidas[i]) {
						n.setNewPesos(i,saida, entradas[i]);
					}
					for(int j = 0; j < pesos.length ; j++) {
						System.out.print(n.getPesos()[j] + " ");;
					}
					System.out.println();
				}
			} else {
				for(int i = 0; i < saidas.length; i++) {
					int saida = n.getNetComOrdem(ordem[ciclo][i]);
					if(saida != saidas[i]) {
						n.setNewPesos(i,saida, entradas[i]);
					}
				}
			}
			
			System.out.print("ciclo[" + ciclo + "]: ");
			
			for(int i = 0; i < saidas.length; i++) {
				int saida = n.getNet(i);
				System.out.print(saida + " ");
			}
			System.out.println();
			System.out.print("pesos: ");
			for(int i = 0; i < pesos.length ; i++) {
				System.out.print(n.getPesos()[i] + " ");;
			}
			System.out.println();
			ciclo++;
		}
		
		int entradasTeste[][] = {{1,1,1}, {-1,1-1}};
		n.setEntradas(entradasTeste);
		for(int i = 0; i < entradasTeste.length; i++) {
			System.out.print(n.getNet(i) + " ");
		}
	}

}
