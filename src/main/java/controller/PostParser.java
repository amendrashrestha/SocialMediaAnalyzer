/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXParseException;
import model.PostBean;

/**
 *
 * @author Amendra Shrestha
 */
public class PostParser extends ParserHandler {

    private String parsedValue;
    private PostBean post;
    private boolean isPost = false;

    /**
     * parses the XML document file, prints the parse data of XML document file
     * and adds the parsed data of XML document file to database
     *
     * @param baseDir
     * @param fileDir
     * @param fileName
     */
    public PostBean parsePost(String fileName) throws SQLException {
            post = new PostBean();
        if (parseDocument(fileName)) {
            System.out.println("\tParsed document successfully.");
        } else {
            System.out.println("\tException occured while parsing document.");
        }
        return post;
    }

    /**
     * overriding the default SAX start element method parses each starting XML
     * element tag and sets the required extracted data
     *
     * @param uri
     * @param localName
     * @param elementName
     * @param attributes
     */
    @Override
    public void startElement(String uri,
            String localName,
            String elementName,
            Attributes attributes) throws SAXParseException {

        if (elementName.equalsIgnoreCase("sioct:BoardPost")) {            
            post.setPost(attributes.getValue("rdf:about"));
        }
        if (elementName.equalsIgnoreCase("sioc:User")) {
            post.setUser(attributes.getValue("rdf:about"));
        }
        if (elementName.equalsIgnoreCase("foaf:Person")) {
            post.setMaker(attributes.getValue("rdf:about"));
        }
    }

    /**
     * overriding the default SAX end element method parses each ending XML
     * element tag and sets the required extracted data
     *
     * @param namespaceURI
     * @param localName
     * @param elementName
     */
    @Override
    public void endElement(String namespaceURI,
            String localName,
            String elementName) {
        if (elementName.equalsIgnoreCase("dc:title") && isPost) {
            post.setTitle(parsedValue);
            isPost = false;
        }
        if (elementName.equalsIgnoreCase("dcterms:created")) {
            post.setCreated(parsedValue);
        }
        if (elementName.equalsIgnoreCase("sioc:content")) {
            post.setContent(parsedValue);
        }
    }

    /**
     * holds extracted text data in string object
     *
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char ch[],
            int start,
            int length) {
        parsedValue = new String(ch, start, length);
    }
}
