package com.lm2a.examen.service;

public class Horoscopo {
	
	static String[] vaticinio = {
			"Mal dia para salir de casa, quedate durmiendo",
			"La persona que se sentara a tu lado en el metro tendra COVID, ve caminando.",
			"Hoy te hubiera tocado la loteria, pero el numero ganador ya esta agotado.",
			"Hoy volvera a subir el Bitcoin que no te decidiste a comprar dos años atras.",
			"No se ocurra jugar a nada, no es tu dia",
			"Esa respuesta que estas pensando era buena para otra pregunta",
			"Lo siento, te copiaste de la persona equivocada",
			"Haber estudiado",
			"No desees que tus deseos se hagan realidad, te quedaras sin deseos",
			"Nada que decirte, los astros hoy pasan de ti"
	};
	
	public static String signo(int dia, int mes) {
	    String signo = "";
	    switch (mes) {
	        case 1:
	            if (dia > 21) {
	                signo = "ACUARIO";
	            } else {
	                signo = "CAPRICORNIO";
	            }
	            break;
	        case 2:
	                if (dia > 19) {
	                    signo = "PISCIS";
	                } else {
	                    signo = "ACUARIO";
	                }
	                break;
	        case 3:
	                if (dia > 20) {
	                    signo = "ARIES";
	                } else {
	                    signo = "PISCIS";
	                }
	                break;
	        case 4:
	                if (dia > 20) {
	                    signo = "TAURO";
	                } else {
	                    signo = "ARIES";
	                }
	                break;
	        case 5:
	                if (dia > 21) {
	                    signo = "GEMINIS";
	                } else {
	                    signo = "TAURO";
	                }
	                break;
	        case 6:
	                if (dia > 20) {
	                    signo = "CANCER";
	                } else {
	                    signo = "GEMINIS";
	                }
	                break;
	        case 7:
	                if (dia > 22) {
	                    signo = "LEO";
	                } else {
	                    signo = "CANCER";
	                }
	                break;
	        case 8:
	                if (dia > 21) {
	                    signo = "VIRGO";
	                } else {
	                    signo = "LEO";
	                }
	                break;
	        case 9:
	                if (dia > 22) {
	                    signo = "LIBRA";
	                } else {
	                    signo = "VIRGO";
	                }
	                break;
	        case 10:
	                if (dia > 22) {
	                    signo = "ESCORPION";
	                } else {
	                    signo = "LIBRA";
	                }
	                break;
	        case 11:
	                if (dia > 21) {
	                    signo = "SAGITARIO";
	                } else {
	                    signo = "ESCORPION";
	                }
	                break;
	        case 12:
	                if (dia > 21) {
	                    signo = "CAPRICORNIO";
	                } else {
	                    signo = "SAGITARIO";
	                }
	        break;
	    }
	    return signo;
	}
	
	public static String getPresagio() {
		int x = (int) (Math.random()*12);
		return vaticinio[x];
	}
}

