package CalculoIMC;

import java.util.LinkedHashMap;

public class TabelaIMC {

	LinkedHashMap<String, String> table;

	public static String calcularIMC(Double peso, Double altura) {

		Double aux = peso / (altura * altura);

		if (aux == 18.5)
			return "IMC=" + aux + "Você está abaixo do peso ideal ";
		if (aux > 18.5 && aux < 24.9)
			return "IMC=" + aux + "\nvocê está em seu peso normal! ";
		if (aux > 25.0 && aux < 29.9)
			return "IMC=" + aux + "\nVocê está acima de seu peso (sobrepeso)";
		if (aux > 30.0 && aux < 34.9)
			return "IMC=" + aux + "\nObesidade grau I";
		if (aux > 35.0 && aux < 39.9)
			return "IMC=" + aux + "\nObesidade grau II";
		if (aux > 40.0)
			return "IMC=" + aux + "\nObesidade grau III";
		return null;

	}

}
