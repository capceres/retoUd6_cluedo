package retoUd6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Jugador {
	
	//atributos
	private String nombre;
	private String arma;
	private String habitacion;
	private LocalDateTime horaPartida;
	
	//constructor
	public Jugador (String nombre, String arma, String habitacion, LocalDateTime horaPartida) {
		this.nombre = nombre;
		this.arma = arma;
		this.habitacion = habitacion;
		this.horaPartida = horaPartida;
		
	}
	
	//metodos
	public void setNombre() {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setArma() {
		this.arma = arma;
	}
	
	public String getArma() {
		return arma;
	}
	
	public void setHabitacion() {
		this.habitacion = habitacion;
	}
	
	public String getHabitacion() {
		return habitacion;
	}
	
	public void setHoraPartida() {
		this.horaPartida = horaPartida;
	}
	
	public LocalDateTime getHoraPartida() {
		return horaPartida;
	}
	
	public String mostrarJugador() {
		return "Nombre: " + nombre + " | " + "Arma: " + arma + " | " + "Habitación: " + habitacion + " | " + "Hora de partida: " + horaPartida;
	}




}
