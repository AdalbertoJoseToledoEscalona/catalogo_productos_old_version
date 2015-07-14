package controlador.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 50 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		filePath = "data";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession sesion = request.getSession();


			System.out.println("Hello<br/>");

			boolean isMultipartContent = ServletFileUpload
					.isMultipartContent(request);
			if (!isMultipartContent) {
				// System.out.println("You are not trying to upload<br/>");
				return;
			}
			System.out.println("You are trying to upload<br/>");

			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			// try {
			List<FileItem> fields;
			
				fields = upload.parseRequest(request);
			
			System.out.println("Number of fields: " + fields.size()
					+ "<br/><br/>");
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				System.out.println("No fields found");
				return;
			}
			System.out.println("<table border=\"1\">");
			while (it.hasNext()) {
				System.out.println("<tr>");
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					System.out
							.println("<td>regular form field</td><td>FIELD NAME: "
									+ fileItem.getFieldName()
									+ "<br/>STRING: "
									+ fileItem.getString());
					System.out.println("</td>");


				} else {
					System.out
							.println("<td>file form field</td><td>FIELD NAME: "
									+ fileItem.getFieldName() + "<br/>STRING: "
									+ fileItem.getString() + "<br/>NAME: "
									+ fileItem.getName()
									+ "<br/>CONTENT TYPE: "
									+ fileItem.getContentType()
									+ "<br/>SIZE (BYTES): "
									+ fileItem.getSize() + "<br/>TO STRING: "
									+ fileItem.toString());
					System.out.println("</td>");

					System.out.println();

					String fileName = fileItem.getName();
					
					if(fileName.isEmpty() && fileItem.getSize() == 0){
						System.out.println("EL CAMPO FILE ESTA VACIO");
					}else{
					
						 System.out.println("Nos han subido el fichero" +
						 fileName);
	
						// construimos un objeto file para recuperar el trayecto
						// completo
						File fichero = new File(fileName);
						// depura("El nombre del fichero es " + fichero.getName());
	
						MessageDigest md = MessageDigest.getInstance("MD5");
						// FileInputStream fis = new
						// FileInputStream("c:\\loging.log");
						InputStream fis = fileItem.getInputStream();
	
						byte[] dataBytes = new byte[1024];
	
						int nread = 0;
						while ((nread = fis.read(dataBytes)) != -1) {
							md.update(dataBytes, 0, nread);
						}
						;
						byte[] mdbytes = md.digest();
	
						// convert the byte to hex format method 1
						StringBuffer sb = new StringBuffer();
						for (int i = 0; i < mdbytes.length; i++) {
							sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100,
									16).substring(1));
						}
	
						String md5 = sb.toString();
	
	
							
	
							//  descartamos el path 
							fichero = new File(request.getServletContext().getRealPath(filePath
									  + File.separator +fileName));
							  
							  System.out.println(fichero.getAbsolutePath());
							  
		
							  // escribimos el fichero colgando del nuevo path
							  fileItem.write(fichero);
						 

					}	
				}
				System.out.println("</tr>");
			}
			System.out.println("</table>");
			// } catch (FileUploadException e) {
			// e.printStackTrace();
			// } catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// }


		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
