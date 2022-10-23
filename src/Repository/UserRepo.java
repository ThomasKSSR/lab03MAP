package Repository;

import Domain.User;
import Domain.Validators.ValidationException;
import Domain.Validators.Validator;
import Domain.Validators.ValidatorUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserRepo<E extends  User,ID extends Integer> implements Repository<E,ID>{

    private Map<Integer,E> users;
    private Validator<E> validUser;

    public UserRepo( Validator<E> validUser) {
        this.users = new HashMap<Integer,E>();
        this.validUser = validUser;
    }


    @Override
    public E add(E e) throws ValidationException {
        if(e == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }
        if(users.containsKey(e.getID())){
            return null;
        }
        validUser.validate(e);

        users.put(e.getID(),e);

        return e;
    }

    @Override
    public E remove(ID id) {
        /*if(id<0){
            throw new IllegalArgumentException("ID can't be negative");
        }*/
        if(users.containsKey(id)){
            E user = users.remove(id);
            return user;
        }
        else{
            return null;
        }



    }

    @Override
    public E find(ID id) {
        /*if(id<0){
            throw new IllegalArgumentException("ID can't be negative");
        }*/

        if(users.containsKey(id)){
            return users.get(id);
        }
        else{
            return null;
        }



    }

    @Override
    public List<E> getAll() {
        if(!users.isEmpty())
            return users.values().stream().toList();

        return null;


    }
}
