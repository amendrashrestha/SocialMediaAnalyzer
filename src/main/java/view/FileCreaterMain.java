/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CreateParser;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author amendrashrestha
 */
public class FileCreaterMain {
    
    public static void main(String args[]) throws SQLException, IOException{
        CreateParser init = new CreateParser();
        init.createUserFile();
    }
}
