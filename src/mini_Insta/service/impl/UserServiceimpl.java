package mini_Insta.service.impl;

import mini_Insta.enums.Gender;
import mini_Insta.generic_ID.GenericId;
import mini_Insta.model.User;
import mini_Insta.service.UserService;

import java.awt.desktop.PreferencesEvent;
import java.util.List;
import java.util.Scanner;
import static mini_Insta.db.Database.users;

public class UserServiceimpl implements UserService {
Scanner scanner = new Scanner(System.in);

    @Override
    public String register() {
        for (User user : users) {
                user.setId(GenericId.genericUserId());
                System.out.println("  REGISTER: ");
                System.out.println("Enter Full Name: ");
                String name = scanner.next();
                user.setFulName(name);
                System.out.println("Enter E-mail: ");
                String email = scanner.next();
                user.setEmail(email);
                System.out.println("Enter password: ");
                String ps = scanner.next();
                user.setPassword(ps);
                System.out.println("Enter Gender:(Male/Female)");
                Gender gender = Gender.valueOf(scanner.next());
                user.setGender(gender);
                users.add(user);
            return "Success Register!✅";
        }
        return null;
    }

    @Override
    public String login(String email, String password) {
        for (User user:users){
            if (user.getEmail().equals(email)&&user.getPassword().equals(password)){
                return "Success Logined!";
            }else
                return "E-mail or password not correct!!!❌";
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : users) {
           if (user.getEmail().equals(email)){
               return user;
           }else System.out.println("E-mail not correct!!!");

        }return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}