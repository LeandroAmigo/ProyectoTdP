package grafica;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logica.CONSTANTES;

public class ParedGrafica {
	protected JLabel grafico;
	protected JLabel graficoBomba;
	protected Icon [] misImagenes;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected int fila;
	protected int columna;
	protected GUI gui;
	protected int MiImagen;
	protected int explociones;
	
	public ParedGrafica(int x, int y,GUI gui)
	{	
		this.gui=gui;
		this.fila=y*ancho;
		this.columna=x*alto;
		explociones=0;
		misImagenes=new Icon [4];
		misImagenes[0]=new ImageIcon(this.getClass().getResource("/Imagenes/Indestructible.png"));
		misImagenes[1]=new ImageIcon(this.getClass().getResource("/Imagenes/Destructible.png"));
		misImagenes[2]=new ImageIcon(this.getClass().getResource("/Imagenes/Transitable.png"));
		misImagenes[3]=new ImageIcon(this.getClass().getResource("/Imagenes/Explosion.png"));
		
				
	}
	public void setGrafico(int Imagen)
	{	if(Imagen!=CONSTANTES.B_Explosion)
			MiImagen=Imagen;
		switch(Imagen)
		{
		case CONSTANTES.P_Indestructible:
				gui.removePanelEscenario(getGrafico());
				this.grafico =new JLabel(misImagenes[CONSTANTES.P_Indestructible]);
				this.grafico.setBounds(this.fila, this.columna, this.ancho, this.alto);
				gui.addPanelEscenario(getGrafico(), 0);
				break;
		case CONSTANTES.P_Destructible:
				gui.removePanelEscenario(getGrafico());
				this.grafico =new JLabel(misImagenes[CONSTANTES.P_Destructible]);
				this.grafico.setBounds(this.fila, this.columna, this.ancho, this.alto);
				gui.addPanelEscenario(getGrafico(), 0);
				break;
		case CONSTANTES.P_Transitable:
			gui.removePanelEscenario(getGrafico());
			this.grafico =new JLabel(misImagenes[CONSTANTES.P_Transitable]);
			this.grafico.setBounds(this.fila, this.columna, this.ancho, this.alto);
			gui.addPanelEscenario(getGrafico(), 0);
				break;
		case CONSTANTES.B_Explosion:
			explociones++;
			this.graficoBomba =new JLabel(misImagenes[CONSTANTES.B_Explosion]);
			this.graficoBomba.setBounds(this.fila, this.columna, this.ancho, this.alto);
			gui.addPanelEscenario(graficoBomba, 1);
				break;
		}
		
		
	}	
	
	public JLabel getGrafico() {
		if(grafico==null)
			grafico=new JLabel(misImagenes[CONSTANTES.P_Transitable]);
		return this.grafico;
	}
	
	public void Restaurar()
	{
		while(explociones!=0)
		{	gui.removePanelEscenario(graficoBomba);
			explociones--;
		}
		if(MiImagen==CONSTANTES.P_Destructible)
		{	System.out.println("Entre a destruir una destructible");
			gui.removePanelEscenario(grafico);
			 			
			setGrafico(CONSTANTES.P_Transitable);
			
		}
		
	}

}
