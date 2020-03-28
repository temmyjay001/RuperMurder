/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rupermurder.UserDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author VitaKing
 */
public class LoginBean {
       String userName;
       String Password;

    public LoginBean() {
    }
       
    public LoginBean(String userName, String Password) {
        this.userName = userName;
        this.Password = Password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(userName.equals(userName)){
            this.userName = userName;
        } else{
            this.userName = userName;
        }
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{16,20})";
        Pattern p = Pattern.compile(PASSWORD_PATTERN);
        Matcher m = p.matcher(Password);
        hasConsecutiveCharacters(Password);
//        if(Password.equals(Password))
            System.out.println(m.matches());
        if(m.matches()){
            this.Password = Password;
        } else{
            System.out.println(m.matches());
            this.Password = "WEAK";
        }
    }
    
    public boolean hasConsecutiveCharacters(String pwd){
        String[] letter = pwd.split(""); // here you get each letter in to a string array

        for(int i=0; i<letter.length-2; i++){
            if(letter[i].equals(letter[i+1]) && letter[i+1].equals(letter[i+2])){
                return true; //return true as it has 3 consecutive same character
            }
        }
        return false; //If you reach here that means there are no 3 consecutive characters therefore return false.
    }
       
}
