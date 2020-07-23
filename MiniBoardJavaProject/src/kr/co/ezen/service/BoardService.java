package kr.co.ezen.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.ezen.beans.ContentBean;
import kr.co.ezen.beans.UserBean;
import kr.co.ezen.dao.BoardDao;

@PropertySource("/WEB-INF/properties/option.properties")
@Service // 어떤 역할을 수행할지를 명시적 표현해준다.
public class BoardService {
	@Value("${path.upload}")
	private String path_upload;
	@Autowired
	private BoardDao boardDao;

	@Resource(name = "loginUserBean") // 로그인 체크
	private UserBean loginUserBean;

	private String saveUploadFile(MultipartFile upload_file) throws IllegalStateException, IOException {

		String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();

		upload_file.transferTo(new File(path_upload + "/" + file_name));

		return file_name;

	}

	public void addContentInfo(ContentBean writeContentBean) throws IllegalStateException, IOException {

		MultipartFile upload_file = writeContentBean.getUpload_File();

		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			writeContentBean.setContent_file(file_name);
			System.out.println(file_name);
		}
		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx()); // 글을 입력할때 어떠한 유저가 작성하는지 알수 있다
		boardDao.addContentInfo(writeContentBean);

	}

	public String getBoardInfoName(int board_info_idx) {

		return boardDao.getBoardInfoName(board_info_idx);
	}

	public List<ContentBean> getContentList(int board_info_idx) {
		List<ContentBean> boardresult = boardDao.getContentList(board_info_idx);
		return boardresult;
	}

	public ContentBean getContentInfoBean(int content_idx) {
		ContentBean contentBean = boardDao.getContentInfoBean(content_idx);

		return contentBean;
	}

	public List<ContentBean> getMainInfo(int board_info_idx) {
		List<ContentBean> MainminiBean = boardDao.getMainInfo(board_info_idx);
		return MainminiBean;
	} 

}
