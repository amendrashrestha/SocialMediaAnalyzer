/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IOHandler;

import controller.FileDirectoryHandler;
import model.Posts;
import model.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Batman
 */
public class IOReadWrite {
    
    public IOReadWrite(){
    	
    }

    public void writeToFile(String fileName, String content) throws IOException{
         String getUserFolderName = getFolderName(fileName);
         checkAndCreateDirectory(IOProperties.INDIVIDUAL_USER_FILE_PATH, getUserFolderName);
         String fileLocation = IOProperties.INDIVIDUAL_USER_FILE_PATH + getUserFolderName;
         String tempfileName = fileName + IOProperties.USER_FILE_EXTENSION;
         String completeFileNameNPath =  fileLocation + "/" + tempfileName;      
         //System.out.print(completeFileNameNPath);
         File file = new File(completeFileNameNPath);
         if(!file.exists()) {
            file.createNewFile();
         }
          PrintWriter out = new PrintWriter(new FileWriter(completeFileNameNPath, true));
          out.append(content+IOProperties.DATA_SEPERATOR);
          out.close();
     }
    /*
     * It returns the name of the xml file in a folder
     */
     public String[] getAllXmlFileName(){
        FileDirectoryHandler handle = new FileDirectoryHandler();
        handle.rootlist(IOProperties.XML_DATA_FILE_PATH);
        String[] filesList = new String[FileDirectoryHandler.getList().size()];
        FileDirectoryHandler.list.toArray(filesList);
        return filesList;
    }
     
     public String getFolderName(String userId){
         String folderName = "";
         int userID = Integer.valueOf(userId);
         if (userID > 0 && userID <= 50000){
           folderName = "50K";
         } else if(userID > 50000 && userID <= 100000){
             folderName = "100K";
         }else if (userID > 100000 && userID <= 150000){
             folderName = "150K";
         }else if (userID > 150000 && userID <= 200000){
             folderName = "200K";
         }else if(userID > 200000 && userID <= 250000){
             folderName = "250K";
         }else if(userID > 300000 && userID <= 350000){
             folderName = "300K";
         }else if(userID > 350000 && userID <= 400000){
             folderName = "350K";
         }else if(userID > 400000 && userID <=450000){
             folderName = "400K";
         }else if(userID > 450000 && userID <=500000){
             folderName = "450K";
         }
         return folderName;
     }
     
     public void checkAndCreateDirectory(String path, String folderName){
         File directory = new File(path + "/" + folderName); //for mac use / and for windows use "\\"
         if(!directory.exists()){
             directory.mkdirs();
         }
     }
     
     public List getAllDirectories(String basePath){
        File file = new File(basePath);
        String[] directories = file.list(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
                }
            });
          System.out.print(Arrays.toString(directories));
          return Arrays.asList(directories);
     }
     
     public String readTxtFileAsString(String basePath, String directoryName, String fileName, String extension) throws FileNotFoundException, IOException{
     
         
         StringBuilder  stringBuilder = new StringBuilder();
         try{
//         File file = new File(basePath + directoryName + "\\" + fileName + "." + extension);
         File file = new File(basePath + directoryName + "/" + fileName + extension);
         BufferedReader reader = new BufferedReader( new FileReader (file));
         String line = null;
         if(file.exists()){
             while((line = reader.readLine() ) != null ) {
                stringBuilder.append(line);
                }
         }
         }catch(FileNotFoundException ex){
             throw ex;
         } catch (IOException ex) {
            throw ex;
        }
         String a = stringBuilder.substring(0, (stringBuilder.length() - (IOProperties.DATA_SEPERATOR).length())).toString();
         return a;
     }
     
     public User convertTxtFileToUserObj(String basePath, String directoryName, String fileName, String extension) throws FileNotFoundException, IOException{
         String userPostAsString = readTxtFileAsString(basePath, directoryName, fileName, extension);
         //String userPostAsString = readTxtFileAsString(basePath, fileName, extension);
         String temp[] = null;
         User user = new User();
         List postList = new ArrayList();
         user.setId(Integer.valueOf(fileName));
         if (userPostAsString.contains(IOProperties.DATA_SEPERATOR)){
             temp = userPostAsString.split(IOProperties.DATA_SEPERATOR);
         } else{
             temp= new String[1];
             temp[0] = userPostAsString;
            
         }
         
         for (int i = 0; i < temp.length; i++){
             if (temp[i].toString().matches("[0-9]{2}:[0-9]{2}:[0-9]{2}") || 
                     temp[i].toString().length() == 8)  
             {
                 temp[i] = temp[i].toString() + "  ";
             }
             Posts posts = new Posts();
             String date = temp[i].substring(0, 8);
             if (date.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}")){
                 posts.setTime(date);
                 posts.setContent(temp[i].substring(9, temp[i].length()));
                 postList.add(posts);
             }else{
                 continue;
             
         }
     }
         user.setUserPost(postList);
         return user;
     } 
             
             
     public List getAllFilesInADirectory(String directoryName){
         List returnList = new ArrayList();
         File folder = new File(directoryName);
         File[] listOfFiles = folder.listFiles();
         for (int i=0; i<listOfFiles.length; i++){
            String a = listOfFiles[i].getName();
             returnList.add(a.substring(0, a.length() -4));
         }
         return returnList;
     }
}
