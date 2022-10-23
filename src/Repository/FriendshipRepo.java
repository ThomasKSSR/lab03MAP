package Repository;

import Domain.Friendship;
import Domain.User;
import Domain.Validators.ValidationException;
import Domain.Validators.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FriendshipRepo<E extends Friendship,ID> implements Repository<E,ID>{
    private List<E> friends;



    public FriendshipRepo() {
        this.friends = new ArrayList<E>();

    }

    @Override
    public E add(E e)  {
        if(e.getUser1() == null || e.getUser2() == null){
            throw new IllegalArgumentException("Entity cannot be null");
        }

        friends.add(e);
        return e;


    }

    @Override
    public E remove(ID id) {
        E fr1 = null;
       for(E fr :friends){
           if(Objects.equals(fr.getID(),id)){
               fr1 = fr;

           }

       }
       if(fr1 != null) {
           friends.remove(fr1);
           return fr1;
       }

       return null;
    }

    @Override
    public E find(ID id) {
        for(E fr : friends){
            if(fr.getID() == id){
                return fr;
            }
        }
        return null;
    }

    @Override
    public List<E> getAll() {
        return friends;
    }
}
