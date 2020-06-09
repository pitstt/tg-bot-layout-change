import com.home.server.MessageConverter;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageConverterTest {

    MessageConverter messageConverter = new MessageConverter();

    @Test
    public void cyrillicToLatin() {
        String actual = messageConverter.layoutChange("Руддщ Цщкдв!");
        assertEquals("Hello World!", actual);
    }

    @Test
    public void latinToCyrillic() {
        String actual = messageConverter.layoutChange("Ghbdtn vbh!");
        assertEquals("Привет мир!", actual);
    }
}