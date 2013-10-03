/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import IOHandler.IOReadWrite;
import controller.PostParser;
import model.PostBean;
import java.io.IOException;
import java.sql.SQLException;

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
             String getText = createContentToWrite(post.getCreated(), post.getContent());
             ioRW.writeToFile(userID, getText);
         }
     }
     
     public String createContentToWrite(String createdDate, String message){
         return createdDate + " " + message;
     }   
}
