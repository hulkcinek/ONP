package com.company;

import java.util.Scanner;

public class Main {
    // 2 7 + 3 / 14 3 - 4 * + 2 /
    public static void main(String[] args) {
        double[] stos = new double[200];
        int wskaznikStosu = 0;
        Scanner s = new Scanner(System.in);
        String wyrazenie = s.nextLine();

        String[] elementy = wyrazenie.split(" ");

        for (int i = 0; i < elementy.length; i++) {
            // jak sprawdzic czy rzecz na stosie jest liczba czy znakiem?
            try {
                int liczba = Integer.parseInt(elementy[i]);
                stos[wskaznikStosu++] = liczba;
            } catch (NumberFormatException e) {
                // napotkalismy znak a nie liczbe
                double liczba1;
                double liczba2;
                // odczytanie i zmniejszenie wskaznikaStosu
                liczba1 = stos[wskaznikStosu-2];
                liczba2 = stos[wskaznikStosu-1];
                wskaznikStosu -= 1;

                switch(elementy[i]) {
                    case "+":
                        stos[wskaznikStosu-1] = liczba1+liczba2;
                        stos[wskaznikStosu] = 0.0;
                        break;
                    case "-":
                        stos[wskaznikStosu-1] = liczba1-liczba2;
                        stos[wskaznikStosu] = 0.0;
                        break;
                    case "*":
                        stos[wskaznikStosu-1] = liczba1*liczba2;
                        stos[wskaznikStosu] = 0.0;
                        break;
                    case "/":
                        stos[wskaznikStosu-1] = liczba1/liczba2;
                        stos[wskaznikStosu] = 0.0;
                        break;
                }
            }
        }

        // jaka wartosc chcemy na koniec wydrukowac? gdzie sie ona bedzie znajdowac?
        System.out.println(stos[0]);
    }
}
