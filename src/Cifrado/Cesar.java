package Cifrado;

import java.util.Scanner;

public class Cesar {

	static String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    static int tamano = alfabeto.length(); // 27 letras

    public static String cifrar(String texto, int clave) {

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {

            char caracter = texto.charAt(i);
            boolean esMinuscula = Character.isLowerCase(caracter);

            char letra = Character.toUpperCase(caracter);

            int posicion = alfabeto.indexOf(letra);

            if (posicion != -1) {

                int nuevaPos = (posicion + clave) % tamano;
                char cifrada = alfabeto.charAt(nuevaPos);

                if (esMinuscula) {
                    cifrada = Character.toLowerCase(cifrada);
                }

                resultado.append(cifrada);

            } else {
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

    public static String descifrar(String texto, int clave) {
        return cifrar(texto, tamano - (clave % tamano));
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