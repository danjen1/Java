/*
madlibs.java
Author: Gabe B-W
HW16: Mad Libs program (in Java)
Parses ARGV[0] as a Mad Libs template file and asks user for words to fill in
the blanks.
Format of the template file:
((...)) = placeholder, e.g.
>> Our favorite language is ((a gemstone)).
Then this program asks for "a gemstone". Please use a/an in the query.
To reuse an answer, use ((label:query)) the first time, then later ((label)) to
reuse the results of query. labels must match \w, i.e. [0-9A-Za-z_].
>> Our favorite language is ((gem:a gemstone)). We think ((gem)) is better than
((a gemstone))
In this case, the "gem" label is set to the result of the first query, then
reused at "((gem))"
*/

import java.util.*;
import java.util.regex.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

class Mad_Libs
{
    // Store value of a label like ((label:query))
    private HashMap<String, String> labels;
    private Pattern splitterRegex;
    private String template; // the madlibs template string

    public static void main(String[] args)
    {
       OpenPanel op = new OpenPanel();

    }


    public Mad_Libs(File file)
    {

        try {
            this.template = readFileToString(file);
        } catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null,"File not found!");
            System.exit(1);
        }
        // label => answer
        this.labels = new HashMap<String,String>();
        // Use (?s) to get Pattern.DOTALL. Embed in the regex itself so that
        // matcher.pattern.toString() [below] keeps the options.
        this.splitterRegex = Pattern.compile("(?s)\\({2}(?:(\\w+?):)?(.+?)\\){2}");
    }

    public void textOutput(String longMessage, Frame frame) {
        JTextArea textArea = new JTextArea(20, 90);
        textArea.setText(longMessage);
        textArea.setEditable(false);
        //JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(frame, textArea);
    }

    public String parse(){
        Matcher matcher = splitterRegex.matcher(this.template);
        String replacedTemplate = this.template;

        while( matcher.find() ){
            String label = matcher.group(1); // may be null
            String query = matcher.group(2);
            String answer = "";
            // if no label, check if query IS a label
            if( label == null && this.labels.containsKey(query) ){
                answer = this.labels.get(query);
            } else {
                // When asking for input, use spaces for newlines
                answer = JOptionPane.showInputDialog("Please give me " + query.replaceAll("\n", " ") + ": ");
                // associate label with answer if label given
                if( label != null ){
                    this.labels.put(label, answer);
                }
            }
            replacedTemplate = replacedTemplate.replaceFirst(matcher.pattern().toString(), answer);
        }
        return replacedTemplate;
    }

    // Return contents of this.file as a String. Not particularly memory-efficient.
    public String readFileToString(File file) throws FileNotFoundException {
        String NL = System.getProperty("line.separator");
        Scanner scanner = new Scanner(file);
        String text = "";

        try {
            while (scanner.hasNextLine()){
                text += scanner.nextLine() + NL;
            }
        }
        finally{
            scanner.close();
        }
        return text;
    }


}
