import java.util.*;

public class ListUser {
    ArrayList<User> allUser = new ArrayList<User>();

    User findUserByPhone(ArrayList<User> allUser, String phone) {
        User pickedUser = null;
        for (User user : allUser) {
            if ((user.noTelp).equals(phone)) {
                pickedUser = user;
                break;
            }
        }
        return pickedUser;
    }

    User register(String nama, String email, String noTelp, String password, ArrayList<User> allUser) {
        User curUser = new User(nama, email, noTelp, password);
        allUser.add(curUser);
        return curUser;
    }

    User login(ArrayList<User> allUser, String noTelp, String pass) {
        User curUser = findUserByPhone(allUser, noTelp);
        if(curUser.password.equals(pass)) {
            return curUser;
        }
        else return null;
    }

}
