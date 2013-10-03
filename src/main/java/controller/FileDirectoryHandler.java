/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amendra Shrestha
 */
public class FileDirectoryHandler {

    public static List<String> list = new ArrayList<String>();

    /**
     * checks directory name and finds lists of files
     * @param dirName
     * @return list of files
     */
    
    // so from other class you can call, Directory.getList() method which will return all the list of file path
    public void rootlist(String fname) {
        File filenames = new File(fname);
        //System.out.println(filenames);
        
        try{
            if (!filenames.isDirectory()) {
            getList().add(fname); // add all the file path to array list
            return;
        }
        String filelists[] = filenames.list();
        for (int i = 0; i < filelists.length; i++) {
            rootlist(fname + File.separator + filelists[i]);
        }
        }catch (Exception e){
            System.err.println(e);
        }
    }

    /**
     * @return the list
     */
    public static List<String> getList() {
        return list;
    }

    /**
     * @param aList the list to set
     */
    public static void setList(List<String> aList) {
        list = aList;
    }

    /**
     * rename the file and return it
     *
     * @param baseDir
     * @param fileDir
     * @param fileName
     * @param newFileName
     * @return file
     */
    //public static File renameFile(String baseDir, String fileDir, String fileName, String newFileName) {
    public static File renameFile(String fileName, String newFileName) {
        File oldFile = new File(fileName);
        File newFile;
        //System.out.println("Old file: " + oldFile);
        if(fileName.startsWith("http")){
            String dirName = fileName.substring(1, fileName.indexOf("http"));
         newFile = new File("/" + dirName + newFileName);
        System.out.println("New file: " + newFile);
        if (oldFile.renameTo(newFile)) {
            return newFile;
        } else {
            return null;
        }
    }
        else {
            return oldFile;
        }
    }
}
