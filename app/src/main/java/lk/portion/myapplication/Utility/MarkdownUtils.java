package lk.portion.myapplication.Utility;

public class MarkdownUtils {
    public static String markdownToHtml(String markdown) {
        // Replace **text** with <b>text</b>
        String html = markdown.replaceAll("\\*\\*(.*?)\\*\\*", "<b>$1</b>");
        // Replace *text* with <i>text</i>
        html = html.replaceAll("\\*(.*?)\\*", "<i>$1</i>");
        // Replace line breaks
        html = html.replaceAll("\n", "<br>");
        // Replace bullet points
        html = html.replaceAll("\\* (.*?)\\n", "<ul><li>$1</li></ul>");
        return html;
    }
}
