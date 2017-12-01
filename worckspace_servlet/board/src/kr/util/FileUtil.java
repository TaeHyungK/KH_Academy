package kr.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//���� ���ε� ����� �����ϱ� ���� cos.jar������ �ʼ������� �䱸��
public class FileUtil {
	//���ε� ���(������)	
	public static final String UPLOAD_PATH = "D:\\taehyung\\academy_workspace_java\\worckspace_servlet\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\board\\upload";
	//���ڵ� Ÿ��
	public static final String ENCODING_TYPE="UTF-8";
	//�ִ� ���ε� ������
	public static final int MAX_SIZE = 10*1024*1024;
	
	//������ ���ε� ��ο� ����
	public static MultipartRequest createFile(HttpServletRequest req) throws IOException{
		return new MultipartRequest(req, UPLOAD_PATH, MAX_SIZE, ENCODING_TYPE, new DefaultFileRenamePolicy());
	}
}