package model;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String user;
    private String content;

    public Message() {
        user = "";
        content = "";
    }

    public Message(String user, String content) {
        this.user = user;
        this.content = content;
    }

    @XmlElement
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @XmlElement
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
