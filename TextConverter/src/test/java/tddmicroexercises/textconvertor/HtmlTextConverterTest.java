package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HtmlTextConverterTest {

    HtmlTextConverter textConverter;
    IStringEscapeUtils stringEscapeUtils;
    IFileManager fileManager;

    @BeforeEach
    public void init() {
        stringEscapeUtils = mock(IStringEscapeUtils.class);
        fileManager = mock(IFileManager.class);
        textConverter = new HtmlTextConverter(stringEscapeUtils, fileManager);
    }

    @Test
    public void convertToHtmlTest() {
        when(fileManager.readLine()).thenReturn("<body>","123", "</body>", null);
        when(stringEscapeUtils.escapeHtml("<body>")).thenReturn("&lt;body&gt;");
        when(stringEscapeUtils.escapeHtml("123")).thenReturn("123");
        when(stringEscapeUtils.escapeHtml("</body>")).thenReturn("&lt;/body&gt;");
        String result = textConverter.convertToHtml();
        assertEquals("&lt;body&gt;<br />123<br />&lt;/body&gt;<br />", result);
    }

}
