/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.PostHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import model.Posts;
import model.User;

/**
 *
 * @author amendrashrestha
 */
public class FileReaderMain {
    
    public static void main(String args[]) throws FileNotFoundException, IOException{
        
        PostHandler postH = new PostHandler();
        List a = postH.getAllUsersAsObject();
        List testList = postH.divideUser(a);
        System.out.println(testList.size());
        
        for(int i =0; i<testList.size(); i++){
            User u = (User) testList.get(i);
            List postList = u.getUserPost();
            System.out.println("The User id is:" + String.valueOf(u.getId()));
            System.out.println("The size of Post is  :" + postList.size());
            for (int j = 0; j < postList.size(); j++){
                Posts p = (Posts) postList.get(j);
                System.out.println("The " + j + "Post is : " );
                System.out.println("The time is: " + p.getTime());
                System.out.println("The conetent is: " + p.getContent());
            }
        }
        //List testList = postH.getAllUser();
        
    }
}
