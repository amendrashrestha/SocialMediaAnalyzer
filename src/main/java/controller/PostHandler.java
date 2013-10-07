/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package controller;

import IOHandler.IOProperties;
import IOHandler.IOReadWrite;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Posts;
import model.User;

/**
 *
 * @author amendrashrestha
 */
public class PostHandler {
    public List<User> getAllUsersAsObject() throws FileNotFoundException, IOException{
        IOReadWrite ioRW = new IOReadWrite();
        List directoryList = ioRW.getAllDirectories(IOProperties.INDIVIDUAL_USER_FILE_PATH);
        List allFiles = new ArrayList();
        List allFilesSize = new ArrayList();
        for (int i = 0; i<directoryList.size(); i++){
            allFilesSize = ioRW.getAllFilesInADirectory(IOProperties.INDIVIDUAL_USER_FILE_PATH + directoryList.get(i));
            for(int j = 0; j < allFilesSize.size(); j++){
                String fileName = allFilesSize.get(j).toString();
                   User user = ioRW.convertTxtFileToUserObj(IOProperties.INDIVIDUAL_USER_FILE_PATH, directoryList.get(i).toString(), allFilesSize.get(j).toString(), IOProperties.USER_FILE_EXTENSION);
                   //User user = ioRW.convertTxtFileToUserObj(IOProperties.INDIVIDUAL_USER_FILE_PATH, directoryList.get(i).toString(), IOProperties.USER_FILE_EXTENSION);
                   if (user.getUserPost().size() > 1) 
                       allFiles.add(user);
            }
        }
        return allFiles;
    }

    public List<User> divideUser(List<User> userList){
        List finalList = new ArrayList();
        boolean flag = true;
        for (int i = 0; i<userList.size(); i++){
           User user = (User) userList.get(i);
           List firstUserList = null;
           if (i == 0) firstUserList = new ArrayList();
           List postList = user.getUserPost();
          
           List toAddPostList = new ArrayList();
            for (int j=0; j<postList.size(); j++ ){
                if (j % 2 == 0 && i == 0){
                    firstUserList.add((Posts) postList.get(j));
                } else if (j % 2 != 0){
                    toAddPostList.add((Posts) postList.get(j));
                }
            }
              if (i == 0){
                  User firstUser = new User();
                  firstUser.setId(user.getId());
                  firstUser.setUserPost(firstUserList);
                  finalList.add(0, firstUser);
              }
              User users = new User();
              users.setId(user.getId());
              users.setUserPost(toAddPostList);
              finalList.add(users);
        }
       return finalList;
    }
    
    public List<User> getAllUser() throws FileNotFoundException, IOException{
        List userObjs = getAllUsersAsObject();
        return divideUser(userObjs);
        
    }
    
}

