package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Message {
    private String sender;
    private String receiver;
    private LocalDateTime timestamp;
    private String content;

    // DateTime format to be used for serialization/deserialization
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public Message(String sender, String receiver, LocalDateTime timestamp, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
        this.content = content;
    }

    // Getters
    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    // Setters
    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Serialize this Message to a String
    public String toString() {
        return String.format("\nMessage: \nSender: %s\nReceiver: %s\nTimestamp: %s\nContent: %s\n",
                sender, receiver, timestamp.format(formatter), content);
    }
}
