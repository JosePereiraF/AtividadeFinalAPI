package br.com.serratec.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target (ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TelefoneValidator.class)
public @interface Telefone {
	
	
	String message() default "Número de telefone em formato inválido";
	
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
