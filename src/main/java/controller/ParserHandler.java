/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Amendra Shrestha
 */
public class ParserHandler extends DefaultHandler {

    /**
     * This method first decodes the filename because the provided filename contains unusual character. The URL are renamed to new filename by taking last part of
     * filename and these renamed XML files are parsed by respective parser.
     *
     * @param baseDir
     * @param fileDir
     * @param fileName
     * @return boolean
     */
    //public boolean parseDocument(String baseDir, String fileDir, String fileName) {
    public boolean parseDocument(String path){
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser parser;
        
        try {
            // decode file to get rid of unusual characters
            String decodedFileURL = URLDecoder.decode(path, "UTF-8");
            //System.out.println(decodedFileURL);
            // get last part of decoded url which will be the new file name to be renamed
            String newFileName = decodedFileURL.substring(decodedFileURL.lastIndexOf("?") + 1, decodedFileURL.length());
            //System.out.println(newFileName);
            // rename the file and return the same file which needs to be parse
            //File fileToParse = FileDirectoryHandler.renameFile(baseDir, fileDir, fileName, newFileName);
            File fileToParse = FileDirectoryHandler.renameFile(path, newFileName);

            parser = spf.newSAXParser();
            // parse file
            parser.parse(fileToParse, this);
            return true;
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException in ParserHandler: " + e);
            return false;
        } catch (SAXException e) {
            System.out.println("SAXException in ParserHandler: " + e);
            return false;
        } catch (IOException e) {
            System.out.println("IOException in ParserHandler: " + e);
            return false;
        }
    }
}
