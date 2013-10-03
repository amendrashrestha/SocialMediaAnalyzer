package view;

import IOHandler.IOProperties;
import IOHandler.IOReadWrite;
import java.io.IOException;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws IOException, SQLException
    {
        IOReadWrite ioRW = new IOReadWrite();
        CreateParser init = new CreateParser();

        init.createUserFile();
        ioRW.getAllDirectories(IOProperties.INDIVIDUAL_USER_FILE_PATH);
        /*
        CreateParser init = new CreateParser();
        try {
            init.createUserFile();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
    }
}
