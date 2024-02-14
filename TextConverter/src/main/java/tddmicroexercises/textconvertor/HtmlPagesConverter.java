package tddmicroexercises.textconvertor;

import java.util.ArrayList;

public class HtmlPagesConverter {
    private final IStringEscapeUtils stringEscapeUtils;
    private final IFileManager fileManager;
    private final IPageBreaksHandler pageBreaksHandler;
    
    public HtmlPagesConverter(IStringEscapeUtils stringEscapeUtils, IFileManager fileManager, IPageBreaksHandler pageBreaksHandler) {
        this.stringEscapeUtils = stringEscapeUtils;
        this.fileManager = fileManager;
        this.pageBreaksHandler = pageBreaksHandler;
    }

    public String getHtmlPage(int page) {
        fileManager.skip(pageBreaksHandler.getBreaks().get(page));
        StringBuffer htmlPage = new StringBuffer();
        String line = fileManager.readLine();
        while (line != null)
        {
            if (line.contains("PAGE_BREAK")) {
                break;
            }
            htmlPage.append(stringEscapeUtils.escapeHtml(line));
            htmlPage.append("<br />");
            
            line = fileManager.readLine();
        }
        fileManager.close();
        return htmlPage.toString();
    }
    
}
