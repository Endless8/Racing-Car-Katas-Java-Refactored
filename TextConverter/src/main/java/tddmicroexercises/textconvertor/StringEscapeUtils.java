package tddmicroexercises.textconvertor;

class StringEscapeUtils implements IStringEscapeUtils {

    public String escapeHtml(String input) {
        String output = input;
        output = output.replace("&", "&amp;");
        output = output.replace("<", "&lt;");
        output = output.replace(">", "&gt;");
        output = output.replace("\"", "&quot;");
        output = output.replace("'", "&quot;");
        return output;
    }

}
