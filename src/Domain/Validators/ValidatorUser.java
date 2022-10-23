package Domain.Validators;

import Domain.User;

public class ValidatorUser<T> implements Validator<T>{

    @Override
    public void validate(T entity) throws ValidationException {
        User user = (User)entity;
        String ok = "";
        if(user.getID() <0){
            ok+= "Invalid ID!";

        }
        if(user.getName() == ""){
            ok += "Invalid Name";
        }
        if(ok != ""){
            throw new ValidationException(ok);
        }
    }
}
