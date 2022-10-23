package Business;

import Domain.Friendship;
import Domain.User;
import Domain.Validators.ValidationException;
import Repository.FriendshipRepo;
import Repository.UserRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Network {
    private UserRepo<User,Integer> userRepo;
    private FriendshipRepo<Friendship, HashSet<Integer>> friendshipRepo;

    public Network(UserRepo<User, Integer> userRepo, FriendshipRepo<Friendship, HashSet<Integer>> friendshipRepo) {
        this.userRepo = userRepo;
        this.friendshipRepo = friendshipRepo;
    }

    public boolean add_User(Integer ID,String Name) throws ValidationException {
        User user = new User(ID,Name);
        if(userRepo.add(user) == null){
            return false;
        }
        return true;

    }
    public boolean remove_user(Integer ID){
        if(userRepo.remove(ID) == null){
            return false;
        }
        return true;
    }

    public List<User> getAllUsers(){
        return userRepo.getAll();
    }

    public boolean add_Friendship(int id_user1,int id_user2) throws IllegalArgumentException{
        User user1 = userRepo.find(id_user1);
        User user2 = userRepo.find(id_user2);
        if(user1 != null && user2 != null){
            Friendship fr = new Friendship(user1,user2);
            friendshipRepo.add(fr);
            user1.addFriend((user2));
            user2.addFriend((user1));
            return true;
        }
        return false;

    }
    public boolean remove_Friendship(int id_user1,int id_user2) throws IllegalArgumentException{
        User user1 = userRepo.find(id_user1);
        User user2 = userRepo.find(id_user2);
        if(user1 != null && user2 != null) {
            Friendship fr = new Friendship(user1, user2);
            HashSet<Integer> ids = new HashSet<Integer>();
            ids.add(id_user1);
            ids.add(id_user2);
            friendshipRepo.remove(ids);
            user1.removeFriend(user2);
            user2.removeFriend((user1));
            return true;
        }
        return false;
    }

    public List<Friendship> get_all_friends(){
        return friendshipRepo.getAll();
    }
}
