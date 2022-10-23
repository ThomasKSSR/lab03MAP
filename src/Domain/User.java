package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements HasID<Integer>{
    private int ID;
    private String name;
    private List<User> friends;

    public User(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.friends = new ArrayList<User>();


    }

    @Override
    public String toString() {
        return "User: {ID:" + ID+ " , Name: " + name + " }" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ID == user.ID && Objects.equals(name, user.name) && Objects.equals(friends,user.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name,friends);
    }


    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void addFriend(User user){
        friends.add(user);
    }

    public void removeFriend(User user){
        friends.remove(user);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
