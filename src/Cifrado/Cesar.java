package Cifrado;

import java.util.Scanner;

public class Cesar {

	public static String cifrar(String texto, int clave) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            if (Character.isLetter(caracter)) {

                char base = Character.isUpperCase(caracter) ? 'A' : 'a';

                char cifrado = (char) ((caracter - base + clave) % 26 + base);

                resultado.append(cifrado);

            } else {
                resultado.append(caracter); 
            }
        }

        return resultado.toString();
    }

    public static String descifrar(String texto, int clave) {
        return cifrar(texto, 26 - (clave % 26));
    }

    public static void main(String[] args) {

    	Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el mensaje: ");
        String mensaje = scanner.nextLine();

        System.out.print("Introduce la clave (desplazamiento): ");
        int clave = scanner.nextInt();

        String cifrado = cifrar(mensaje, clave);
        String descifrado = descifrar(cifrado, clave);

        System.out.println("Mensaje cifrado: " + cifrado);
        System.out.println("Mensaje descifrado: " + descifrado);

        scanner.close();
    }
}