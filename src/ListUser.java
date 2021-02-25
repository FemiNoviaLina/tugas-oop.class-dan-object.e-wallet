import java.util.*;

public class ListUser {
    ArrayList<User> allUser = new ArrayList<User>();

    static User findUserByPhone(ArrayList<User> allUser, String phone) {
        User pickedUser = null;
        for (User user : allUser) {
            if ((user.noTelp).equals(phone)) {
                pickedUser = user;
                break;
            }
        }
        return pickedUser;
    }

}
