package kr.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//파일 업로드 기능을 수행하기 위해 cos.jar파일이 필수적으로 요구됨
public class FileUtil {
	//업로드 경로(절대경로)	
	public static final String UPLOAD_PATH = "D:\\taehyung\\academy_workspace_java\\worckspace_servlet\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\board\\upload";
	//인코딩 타입
	public static final String ENCODING_TYPE="UTF-8";
	//최대 업로드 사이즈
	public static final int MAX_SIZE = 10*1024*1024;
	
	//파일을 업로드 경로에 생성
	public static MultipartRequest createFile(HttpServletRequest req) throws IOException{
		return new MultipartRequest(req, UPLOAD_PATH, MAX_SIZE, ENCODING_TYPE, new DefaultFileRenamePolicy());
	}
}