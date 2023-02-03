package rtf;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.rtf.RTFEditorKit;

public class ConvertRTFToHtml2 {

	public static String convertTextRTF2HTML(String text) {
		if (text == null) {
			return "";
		}
		StringReader reader = new StringReader(text);
		StringWriter writer = new StringWriter();
		RTFEditorKit rtfEditorKit = new RTFEditorKit();
		HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
		Document doc = rtfEditorKit.createDefaultDocument();

		try {
			rtfEditorKit.read(reader, doc, 0);
			htmlEditorKit.write(writer, doc, 0, doc.getLength());
		} catch (IOException ex) {
			// logger.error("Erro na convers�o de RTF2HTML.", ex);
		} catch (BadLocationException ex) {
			// logger.error("Erro na convers�o de RTF2HTML.", ex);
		}
		return writer.toString();
	}

	public static String convertTextRTF(String text) {
        
		String g = "";
        String convert = ConvertRTFToHtml2.convertTextRTF2HTML(text);
		String n = convert.replaceAll("<[^>]*>", "").replaceAll("\r\n|\n|\t", "");
      
		boolean validar = false;
		for (int i = 0; i < n.length(); i++) {

			if (n.charAt(i) == ' ') {
				if (validar == true) {
					g = g + n.charAt(i);
					validar = false;
				}
			} else {
				g = g + n.charAt(i);
				validar = true;
			}
		}
		   
		return g;
	}

	public static String convertTextRTF2(String text) {
		String convert = ConvertRTFToHtml2.convertTextRTF2HTML(text);
        String n = convert.replaceAll("<[^>]*>|\t", "");
        String g = "";

		boolean validar = false;
		for (int i = 0; i < n.length(); i++) {

			if (n.charAt(i) == ' ') {
				if (validar == true) {
					g = g + n.charAt(i);
					validar = false;
				}
			} else {
				g = g + n.charAt(i);
				validar = true;
			}
		}

		String x[] = g.split("\r\n|\n");

		String novo = "";

		for (String string : x) {
			if (string.length() > 1) {
				novo = novo + string.toString() + "\r\n";
			}
		}

		return novo;
	}

}
