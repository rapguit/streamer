package com.nscorp;

public class AppTester {

    public static void main(String[] args) {
	    char c = Streamer.firstChar(StreamImpl.newStream("aAbBABacafe"));
        System.out.println("Esperado caracter 'e'. Valor obtido: " + c);

        c = Streamer.firstChar(StreamImpl.newStream("abaciipu"));
        System.out.println("Esperado caracter 'u'. Valor obtido: " + c);

        c = Streamer.firstChar(StreamImpl.newStream("AEIOU"));
        System.out.println("Esperado caracter '!'. Valor obtido: " + c);

    }
}
