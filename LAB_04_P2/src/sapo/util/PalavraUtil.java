package sapo.util;

public class PalavraUtil {

	
	public static boolean verificaVogal(char letra) {
		
		char vogais[] = {'a','e','i','o','u'};
		
		boolean result = false;
		for (int i = 0; i < vogais.length; i++) {
			if(vogais[i] == letra) {
				result = true;
				break;
			}
		}
		
		return result;
		
	}
}
