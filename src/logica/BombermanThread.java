package logica;

import personajes.Bomberman;
import personajes.Enemigo;



public class BombermanThread extends Thread {
	
	// Logica que implementa al malo.
	private Bomberman bomberman;
	
	// Flag que indica cuando debe detenerse la ejecuci�n del hilo.
	// Es volatile porque es accedida desde concurrentemente desde diferentes threads.
	private volatile boolean mDetener;
	
	public BombermanThread(Bomberman b) {
		this.bomberman  = b;
		this.mDetener = false;
	}
	
	@Override
	public void run() {
		// Ejecuto indefinidamente hasta que el flag sea verdadero.
		while(!this.mDetener){
			// Duermo el hilo 1 segundo.
			// De esta manera cada turno se ejecuta cada 1 segundo.
			try {
				// Realizo el movimiento
				//this.enemigo.mover();
				Thread.sleep(00);
				
			} catch (InterruptedException e) { }
		}
	}
	
	public void detener() {
		// Interrumpo el hilo para que no continue con su ejecuci�n.
		this.interrupt(); 
		
		// Seteamos el flag para detener su ejecuci�n.
		this.mDetener = true;
	}
	
	public void destruir() {
		// Detengo la ejecucion del hilo.
		this.detener();
		
		// Notificamos a la logica que este hilo se destruyo.
		this.bomberman.morir();
	}
}