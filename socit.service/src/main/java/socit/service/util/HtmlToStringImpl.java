package socit.service.util;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
@Log4j
public class HtmlToStringImpl implements HtmlToString {
    private static final InputStream resourcesHtml = HtmlToStringImpl.class.getClassLoader().
            getResourceAsStream("emailHtml.html");

    @Override
    public String getEmailStringHtml() {
        String stringHtml = null;
        String string;
        StringBuffer stringBuffer;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(resourcesHtml))) {
            stringBuffer = new StringBuffer();
            while ((string = in.readLine()) != null) {
                stringBuffer.append(string).append("\n");
            }
            stringHtml = stringBuffer.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        log.debug("html parse success");
        return stringHtml;
    }
}
