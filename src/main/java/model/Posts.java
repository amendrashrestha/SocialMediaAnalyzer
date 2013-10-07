/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Batman
 */
public class Posts {
    private String time;
    private String content;

    /**
     * @return the date
     */
    public String getTime() {
        return time;
    }

    /**
     * @param date the date to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
}
