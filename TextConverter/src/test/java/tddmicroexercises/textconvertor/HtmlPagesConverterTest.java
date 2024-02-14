package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class HtmlPagesConverterTest {

    private HtmlPagesConverter pagesConverter;
    private IStringEscapeUtils stringEscapeUtils;
    private IFileManager fileManager;
    private IPageBreaksHandler pageBreaksHandler;

    @BeforeEach
    public void init() {
        stringEscapeUtils = mock(IStringEscapeUtils.class);
        fileManager = mock(IFileManager.class);
        pageBreaksHandler = mock(IPageBreaksHandler.class);
        pagesConverter = new HtmlPagesConverter(stringEscapeUtils, fileManager, pageBreaksHandler);
    }

    @Test
    public void getHtmlPageTest() {
        triggerMocks();
        String htmlPage = pagesConverter.getHtmlPage(0);
        assertEquals("&lt;body&gt;<br />123<br />", htmlPage);
    }

    private void triggerMocks() {
        when(pageBreaksHandler.getBreaks()).thenReturn(Collections.singletonList(0));
        when(fileManager.readLine()).thenReturn("<body>","123", "PAGE_BREAK</body>", null);
        when(stringEscapeUtils.escapeHtml("<body>")).thenReturn("&lt;body&gt;");
        when(stringEscapeUtils.escapeHtml("123")).thenReturn("123");
        when(stringEscapeUtils.escapeHtml("PAGE_BREAK</body>")).thenReturn("PAGE_BREAK&lt;/body&gt;");
    }

}
