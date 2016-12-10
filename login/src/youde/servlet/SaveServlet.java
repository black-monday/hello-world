package youde.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

public class SaveServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SaveServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			// ��ʼ���ϴ����
			SmartUpload mySmartUpload = new SmartUpload();
			mySmartUpload.initialize(this.getServletConfig(), request, response);
			mySmartUpload.upload();
			String DocID = "";
			String DocTitle = "";
			String DocType = "";
			String Docdata = "";
			String ID = "";
			String shangpath = "";
			// ��ȡ�����?��¼
			
			ID = mySmartUpload.getRequest().getParameter("id");
			DocID = mySmartUpload.getRequest().getParameter("DocID");
			DocTitle = mySmartUpload.getRequest().getParameter("DocTitle");
			shangpath = mySmartUpload.getRequest().getParameter("DocType");
			String FilePath;
			com.jspsmart.upload.File myFile = null;
			myFile = mySmartUpload.getFiles().getFile(0);
			FilePath = myFile.getFileName();
			if (!myFile.isMissing()) {
				myFile.saveAs(FilePath, mySmartUpload.SAVE_PHYSICAL); // �����ϴ��ļ����ڴ�
				File tfile = new File(FilePath);
				if ((ID == null) || (ID.equals("0"))) { // ������¼�¼	 

					out.write("succeed");//���ؿؼ�HttpPost()����ֵ��
				} else { // ���¼�¼

					SaveFileToServer(tfile,shangpath);
					out.write("succeed");//���ؿؼ�HttpPost()����ֵ��

				}

				if (tfile.exists()) {
					tfile.delete();
				}
			}
		} catch (Exception e) {
			out.write("failed");//���ؿؼ�HttpPost()����ֵ��
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	private void SaveFileToServer(File file,String path) {
		try {
			InputStream inStream = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
            
			inStream.read(bytes);
			inStream.close();

			FileOutputStream fos = new FileOutputStream(path);
			fos.write(bytes);
			fos.flush();
			fos.close();

		} catch (Exception e) {
			System.out.println("save:" + e.toString());
		}
	}

}
