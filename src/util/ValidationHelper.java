package util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationHelper {
	
	private static ValidationHelper instance = null;
	
	public static ValidationHelper getInstance() {
		if(instance == null)
			instance = new ValidationHelper();
		return instance;
	}
	
    Set<ConstraintViolation<Object>> errors = new HashSet<ConstraintViolation<Object>>();
	
    public void setErrors(Object data) {
    	
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    	Validator validator = factory.getValidator();
    	
    	errors = validator.validate(data);    	
    }

    public boolean isValid(Object data) {
        setErrors(data);
        Iterator iter = errors.iterator();
        while(iter.hasNext()) {
        	System.out.println(iter.next());
        }
        
        return errors.isEmpty();
    }

    public java.util.Set<ConstraintViolation<Object>> getErrors() {
        return errors;
    }


}
