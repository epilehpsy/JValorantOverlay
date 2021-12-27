package felpud0.valorantAPI;

import java.util.List;

public class TeamBalancerBacktrack {
	
	//Datos entrada.
	private int nParticipantes; //El n de participantes.
	private int pesos[];

	//Datos de trabajo
	private int nivel;
	private int acomuladoPersonas[];

	//Datos salida.
	private int pesoAcomulado[]; //Variables que llevaran el peso de cada equipo
	private int solucion[];
	private int bestSolucion[];
	private int soaA,soaB = 0 ;
	private int nPA,nPB = 0;
	private int voa = Integer.MAX_VALUE;
	
	public TeamBalancerBacktrack(List<Integer> part) {
		nParticipantes=part.size();
		pesos=new int[nParticipantes];
		solucion=new int[nParticipantes];

		for(int i=0;i<nParticipantes;i++) {
			pesos[i]=part.get(i);
			solucion[i]=-1;
		}
		nivel=0;
		pesoAcomulado=new int[2];
		acomuladoPersonas=new int[2];
		for(int i=0;i<2;i++) {
			pesoAcomulado[i]=0;
			acomuladoPersonas[i]=0;
		}
	}
	
	
	private void generar() {
		
	    int s=++solucion[nivel];
	    pesoAcomulado[s]+=pesos[nivel];
	    acomuladoPersonas[s]++;
	}
	
	private boolean isSolucion(){

	    return (nivel==nParticipantes-1 && Math.abs(acomuladoPersonas[0]-acomuladoPersonas[1]) <= 1);
	}

	private boolean criterio(){

	    return (nivel < nParticipantes-1 && acomuladoPersonas[solucion[nivel]] 
	            <= (int)(nParticipantes/2)+1);
	}

	private boolean masHermanos(){

	    return (solucion[nivel]<1);
	}

	private void retroceder(){


	    int s=solucion[nivel];
	    pesoAcomulado[s]-=pesos[nivel];

	    solucion[nivel]=-1;
	    nivel--;
	    acomuladoPersonas[s]--;

	}
	
	private int valor(){

	    return Math.abs(pesoAcomulado[0]-pesoAcomulado[1]);
	}
	
	
	public void backtrack(){


	    boolean fin=false;

	    do{
	        generar();
	        if (isSolucion() && valor() < voa){
	            voa=valor();
	            soaA=pesoAcomulado[0];
	            soaB=pesoAcomulado[1];
	            nPA=acomuladoPersonas[0];
	            nPB=acomuladoPersonas[1];
	            bestSolucion=solucion.clone();
	        }
	        if (criterio())
	            nivel++;

	        else {
	            
	            if (masHermanos()){
	                pesoAcomulado[solucion[nivel]]-=pesos[nivel]; //Quitarle al equipo el peso que le habias metido.
	                acomuladoPersonas[solucion[nivel]]--; //Quitarle al equipo el peso que le habias metido.

	            }

	                
	            while (!masHermanos() && nivel >= 0){
	                
	                retroceder();
	                if (masHermanos()){
	                    acomuladoPersonas[solucion[nivel]]--;
	                    pesoAcomulado[solucion[nivel]]-=pesos[nivel]; //Quitarle al equipo el peso que le habias metido.

	                }
	            }
	            
	        }

	    }while (!fin && nivel > 0);

	}

	public int[] getSolucion(){		
		return bestSolucion;
	}


	public int getSoaA() {
		return soaA;
	}


	public int getSoaB() {
		return soaB;
	}
	
	public int getVoa() {
		return voa;
	}
}
