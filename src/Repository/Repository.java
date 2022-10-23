package Repository;

import Domain.HasID;
import Domain.Validators.ValidationException;

import java.util.List;

public interface Repository<E,ID> {
    E add(E e) throws ValidationException;
    E remove(ID id);
    E find(ID id);
    List<E> getAll();
}
