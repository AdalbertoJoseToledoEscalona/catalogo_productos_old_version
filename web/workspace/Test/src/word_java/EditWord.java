/**
 * 
 */
package word_java;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * @author adalberto
 *
 */
public class EditWord {

	/**
	 * 
	 */
	public EditWord() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File doc = new File("FBolo.doc");
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(doc);
			
			
			BufferedInputStream buffInputStream = new BufferedInputStream(fileInputStream);

			HWPFDocument word = new HWPFDocument(new POIFSFileSystem(buffInputStream)); 

			Range range = word.getRange();  
			range.replaceText("<@activitat>", "Activitat Alex"); 
			range.replaceText("<@compañia>", "Compañia Alex");

			OutputStream output = new FileOutputStream("resultado.doc"); 
			output.flush(); 
			word.write(output); 
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
