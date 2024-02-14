package tddmicroexercises.textconvertor;

import java.util.ArrayList;
import java.util.List;

public class PageBreaksHandler implements IPageBreaksHandler{

    private final List<Integer> breaks;
    private final IFileManager fileManager;

    public PageBreaksHandler(IFileManager fileManager) {
        this.breaks = new ArrayList<>();
        this.fileManager = fileManager;
    }

    public int calculatePageBreaks() {
        breaks.add(0);
        int cumulativeCharCount = 0;
        String line = fileManager.readLine();
        while (line != null)
        {
            cumulativeCharCount += line.length() + 1; // add one for the newline
            if (line.contains("PAGE_BREAK")) {
                int page_break_position = cumulativeCharCount;
                breaks.add(page_break_position);
            }
            line = fileManager.readLine();
        }
        fileManager.close();
        return breaks.size();
    }

    public List<Integer> getBreaks() {
        return breaks;
    }

}
