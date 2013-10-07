/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Batman
 */
public class User {
    private int id;
    private List<Posts> userPost; 
    
    
    private int nrOfFeatures;
    private List<Float> featureVector;
    private ArrayList<ArrayList<Float>> featureVectorPostList;
        //setNrOfFeatures(293 + 2);
        
    /**
     * @return the userPost
     */
    public List<Posts> getUserPost() {
        return userPost;
    }

    /**
     * @param userPost the userPost to set
     */
    public void setUserPost(List<Posts> userPost) {
        this.userPost = userPost;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    public ArrayList<ArrayList<Float>> initializeFeatureVectorPostList(List userList) {
        ArrayList<ArrayList<Float>> list = new ArrayList<ArrayList<Float>>();
        for (int i = 0; i<userList.size(); i ++){
            User user = (User) userList.get(i);
        for (int j = 0; j < user.getUserPost().size(); j++) {
            ArrayList<Float> featList = new ArrayList<Float>();
            for (int k = 0; k < UserProperties.setNrOfFeatures; k++) {
                featList.add(0.0f);
            }
            list.add(featList);
        }
        }  
        return list;
    }
    
    public void addToFeatureVectorPostList(ArrayList<Float> freqDist, int index) {
        for (int i = 0; i < freqDist.size(); i++) {
            featureVectorPostList.get(index).set(i, freqDist.get(i));
        }
    }

    /**
     * @return the nrOfFeatures
     */
    public int getNrOfFeatures() {
        return nrOfFeatures;
    }

    /**
     * @param nrOfFeatures the nrOfFeatures to set
     */
    public void setNrOfFeatures(int nrOfFeatures) {
        this.nrOfFeatures = nrOfFeatures;
    }

    /**
     * @return the featureVector
     */
    public List<Float> getFeatureVector() {
        return featureVector;
    }

    /**
     * @param featureVector the featureVector to set
     */
    public void setFeatureVector(List<Float> featureVector) {
        this.featureVector = featureVector;
    }

    /**
     * @return the featureVectorPostList
     */
    public ArrayList<ArrayList<Float>> getFeatureVectorPostList() {
        return featureVectorPostList;
    }

    /**
     * @param featureVectorPostList the featureVectorPostList to set
     */

    public void setFeatureVectorPosList(ArrayList<ArrayList<Float>> tempFetList) {
        this.featureVectorPostList = tempFetList;
    }
    
    public double[] getTimeVectorArray(List postTime) throws SQLException {

        double[] rr = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Iterator itr = postTime.iterator();

        while (itr.hasNext()) {
            Timestamp key = (Timestamp) itr.next();
            int hr = key.getHours();
            rr[hr]++;
        }
        return rr;
    }
    
   
}
