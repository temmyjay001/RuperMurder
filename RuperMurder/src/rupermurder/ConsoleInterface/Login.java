/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rupermurder.ConsoleInterface;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rupermurder.UserDao.LoginBean;

/**
 *
 * @author VitaKing
 */
public class Login {
    String userName;
    String password;
    Matcher matcher;
    Pattern pattern;
    Scanner scanner = new Scanner(System.in);
    static int count = 0;
    
    public void requestInfo() throws InterruptedException{
        System.out.println("Enter a valid Username and password");
        
        System.out.println("Username");
        String userLoginResponse = scanner.next();
        userName = userLoginResponse;
        System.out.println("Password: ");
        String userLoginPasswordResponse = scanner.next();
        password = userLoginPasswordResponse;
        LoginBean userBean = new LoginBean();
        userBean.setUserName(userName);
        userBean.setPassword(password);
        
        validateAccess(userBean);
    }
    
    
    public void validateAccess(LoginBean bean) throws InterruptedException{
        if((!"".equals(bean.getUserName()) && !"".equals(bean.getPassword()) && !"WEAK".equals(bean.getPassword()))){
                System.out.println(bean.getPassword());
                System.out.println("You have successfully logged in");
        }else{
            System.out.println("Username and password incorrect");
            count++;
            if(count > 3){
                System.out.println("You have entered the wrong access details 3 times\nYou have to wait for 3mins before retrying");
                Thread.sleep(30000);
                requestInfo();
            } else{
                requestInfo();
            }
        }

    }
}
