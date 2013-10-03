package view;

import IOHandler.IOProperties;
import IOHandler.IOReadWrite;
import java.io.IOException;
import java.sql.SQLException;

/**
 * This is the main file of Social Media Analyzer.
 * This project is responsible to parser XML data and store it into text files according to 
 * user ID. 
 * A user must create a folder named UserPost in desktop or can create anywhere but need to
 * change the path in IOProperties.java file.
 * @author ITE
 *
 */

public class App 
{
    public static void main( String[] args ) throws IOException, SQLException
    {
        IOReadWrite ioRW = new IOReadWrite();
        CreateParser init = new CreateParser();

        init.createUserFile();
        ioRW.getAllDirectories(IOProperties.INDIVIDUAL_USER_FILE_PATH);
    }
}
