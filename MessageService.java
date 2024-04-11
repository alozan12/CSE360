package application;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MessageService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static List<Message> parseMessagesFromText(List<String> lines) {
        if (lines.isEmpty()) {
            // Return an empty list early if there are no lines to parse
            return new ArrayList<>();
        }

        List<Message> messages = new ArrayList<>();
        String sender = null, receiver = null, content = "";
        LocalDateTime timestamp = null;
        boolean inContent = false;

        for (String line : lines) {
            if (line.startsWith("Sender: ")) {
                sender = line.substring("Sender: ".length());
            } else if (line.startsWith("Receiver: ")) {
                receiver = line.substring("Receiver: ".length());
            } else if (line.startsWith("Timestamp: ")) {
                timestamp = LocalDateTime.parse(line.substring("Timestamp: ".length()), formatter);
            } else if (line.startsWith("Content:")) {
                inContent = true;
                content = line.substring("Content: ".length());
            } else if (!line.trim().isEmpty() && inContent) {
                content += "\n" + line;
            } else if (line.trim().isEmpty() && inContent) {
                // Add the message when encountering an empty line signifying the end of a message block
                if (sender != null && receiver != null && timestamp != null && !content.isEmpty()) {
                    messages.add(new Message(sender, receiver, timestamp, content));
                }
                // Reset for the next message
                sender = receiver = content = null;
                timestamp = null;
                inContent = false;
            }
        }

        // Add the last message if the file doesn't end with an empty line
        if (sender != null && receiver != null && timestamp != null && !content.isEmpty()) {
            messages.add(new Message(sender, receiver, timestamp, content));
        }

        return messages;
    }
}
