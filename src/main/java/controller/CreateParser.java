/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import IOHandler.IOReadWrite;
import controller.PostParser;
import model.PostBean;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ITE
 */

public class CreateParser {

    public CreateParser() {
    }
    
     public void createUserFile() throws SQLException, IOException{
         IOReadWrite ioRW = new IOReadWrite();
         String[] allXmlFileName = ioRW.getAllXmlFileName();
         String userID;
         String initialFileName;
         PostBean post;
         PostParser parser = new PostParser();
         
         for (int i = 0; i < allXmlFileName.length; i++){
             initialFileName = allXmlFileName[i];
             post = parser.parsePost(initialFileName);
             userID = post.getUserID(post.getUser());
              post.setCreated(post.getCreated().substring(11, (post.getCreated().length() - 1)));
             String getText = createContentToWrite(post.getCreated(), post.getContent());
             ioRW.writeToFile(userID, getText);
         }
     }
     
     public String createContentToWrite(String createdDate, String message){
         return createdDate + " " + message;
     }   
}
