package br.com.serratec.customannotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Telefone, String>{

	@Override
	public void initialize(Telefone constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		/*String regexFixo = "^[(][1-9]{2}[)][0-9]{4}[-][0-9]{4}$";
		String regexCelular= "^[(][1-9]{2}[)][9][0-9]{4}[-][0-9]{4}$";
		
		if (value == null)
		{
			return false;
		}
		else if( value.matches(regexFixo) )
		{
			return true;
		}
		else if ( value.matches(regexCelular) )
		{
			return true;
		}
		else
		{
			return false;
		}*/
		
		// Combina as duas regex em uma única expressão regular
	    String regex = "^[(][1-9]{2}[)]([0-9]{4}|9[0-9]{4})[-][0-9]{4}$";
	    
	    // Retorna false se o valor for nulo ou não corresponder à regex
	    return value != null && value.matches(regex);
		
	}

}
