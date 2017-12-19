package persistence;

import domain.User;
import java.util.ArrayList;

public class UserDAO {
    
    private static UserDAO instance;
    private static ArrayList<User> users;
    
    public static UserDAO getInstance() {
        if(instance == null){
            instance = new UserDAO();
        }
        return instance;
    }
    
    private UserDAO() {
        users = new ArrayList<>();
        users.add(new User("admin", "admin", true));
        users.add(new User("bruno", "1234", false));
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
    
    public void addUser(String username, String password, boolean admin) {
        users.add(new User(username, password, admin));
    }
    
    public User getUserWithUsername(String username) {
        for(User user: users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
    
}
