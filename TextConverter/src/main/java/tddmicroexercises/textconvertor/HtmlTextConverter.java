package tddmicroexercises.textconvertor;

public class HtmlTextConverter
{

	private final IStringEscapeUtils stringEscapeUtils;
	private final IFileManager fileManager;

    public HtmlTextConverter(IStringEscapeUtils stringEscapeUtils, IFileManager fileManager)
    {
		this.stringEscapeUtils = stringEscapeUtils;
        this.fileManager = fileManager;
    }

    public String convertToHtml() {
	    String line = fileManager.readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += stringEscapeUtils.escapeHtml(line);
	        html += "<br />";
	        line = fileManager.readLine();
	    }
	    return html;

    }

}
