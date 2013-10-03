/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Amendra Shrestha
 */
public class PostBean {

    private int PostID;
    private String post;
    private String type;
    private String title;
    private String user;
    private String seeAlso;
    private String maker;
    private String makerSeeAlso;
    private String created;
    private String content;
    private String replyOfPost;
    private String replyOfseeAlso;

    public PostBean() {
    }

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int PostID) {
        this.PostID = PostID;
    }

    public String getReplyOfseeAlso() {
        return replyOfseeAlso;
    }

    public void setReplyOfseeAlso(String replyOfseeAlso) {
        this.replyOfseeAlso = replyOfseeAlso;
    }

    public String getReplyOfPost() {
        return replyOfPost;
    }

    public void setReplyOfPost(String replyOfPost) {
        this.replyOfPost = replyOfPost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getMakerSeeAlso() {
        return makerSeeAlso;
    }

    public void setMakerSeeAlso(String makerSeeAlso) {
        this.makerSeeAlso = makerSeeAlso;
    }

    public String getPost() {
        return post;

    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSeeAlso() {
        return seeAlso;
    }

    public void setSeeAlso(String seeAlso) {
        this.seeAlso = seeAlso;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String getUserID(String rawData){
    	int noUserID = 0;
    	if(rawData != null){
    		 return (rawData.substring(40, rawData.length())).split("#")[0];
    	}
       return String.valueOf(noUserID);
    }
}
