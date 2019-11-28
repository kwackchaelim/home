package skwyverns;

//서블릿 패키지 import
import java.io.*;
//import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

import javax.servlet.annotation.WebServlet;

//자바 클래스 import
import java.util.ArrayList;
import java.util.List;


//어너테이션 서블릿과 URL 정의
@WebServlet(description = "skwyverns Controller 서블릿", urlPatterns = { "/skwyverns/SkwyvernsController" })
public class SkwyvernsController extends HttpServlet {

	// 객체 직렬화(Serializable), 이클립스에서 자동 생성은 클래스 이름에서 Ctrl + 1
	private static final long serialVersionUID = 1L;

	// _jspxFactory 생성
	private static final javax.servlet.jsp.JspFactory _jspxFactory = javax.servlet.jsp.JspFactory.getDefaultFactory();
	
	
	/******************************************************************************************/
	// GET 요청을 처리하기 위한 메서드
	/******************************************************************************************/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// doPost()로 포워딩.
		doPost(request, response);
	}

	
	/******************************************************************************************/
	// POST 요청을 처리하기 위한 메서드
	/******************************************************************************************/
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // pageContext 참조변수 선언
		// javax.servlet.jsp.PageContext pageContext = null;
		PageContext pageContext = null;
		
		try {

		   // pageContext 참조변수 객체 생성
			pageContext = _jspxFactory.getPageContext(this, request, response, null, true, 8192, true);
		
			
			// 한글 인코딩
			request.setCharacterEncoding("UTF-8");
			
			// 클라이언트 응답시 전달될 컨텐트에 대한 타잎 설정과 캐릿터셋 지정
			response.setContentType("text/html; charset=UTF-8");
	
			// action구분 등 파라메터
			String action = request.getParameter("action");
			System.out.println("Controller action = " + action);


			//클라이언트 응답을 위한 출력 스트림 확보(alert 메세지용)
			PrintWriter out = response.getWriter();
			
			// skwyvernsDTO 변수 정의
			SkwyvernsDTO skwyvernsDTO = new SkwyvernsDTO();

			/* action에 따라 동작            */			
			if((action.equals("insert")) || (action.equals("update")) || (action.equals("delete")) ) {
			
				// setProperty skwyvernsDTO에 해당하는 java 코드
				skwyvernsDTO.setTitle(request.getParameter("title"));
				skwyvernsDTO.setName(request.getParameter("name"));
				skwyvernsDTO.setMemo(request.getParameter("memo"));
			}

			/* action에 따라 동작            */			
			if( (action.equals("update")) || (action.equals("delete")) ) {
			
				// setProperty skwyvernsDTO에 해당하는 java 코드
				skwyvernsDTO.setId(Integer.parseInt(request.getParameter("id")));
			}

			
			/* 조회조건 값 설정            */			
			String searchName = request.getParameter("searchName");
				
			if(searchName == null) {
				searchName = "";
			}
			
			skwyvernsDTO.setSearchName(searchName);


			// skwyvernsDAO 변수 정의
			SkwyvernsDAO skwyvernsDAO = new SkwyvernsDAO();
			
			/*                      */
			/* action에 따라 모델 호출            */			
			/*                      */
			if(action.equals("add")) {
			
				//입력화면 오픈
				request.setAttribute("action", action);
				
				pageContext.forward("skwyverns_view.jsp");
			
			} else if(action.equals("insert")) {
				
				//입력
				if(skwyvernsDAO.insertDB(skwyvernsDTO)) {

					//조회결과
					List<SkwyvernsDTO> skwyvernsList = skwyvernsDAO.getDBList();
					
					// List를 setAttribute
					request.setAttribute("skwyvernsList", skwyvernsList);
					
					out.println("<script>alert('action 파라미터를 확인해 주세요!!!')</script>");
					
					// 결과 조회를 위하여 조회화면 호출
					pageContext.forward("skwyverns_list.jsp");
					
					
				} else {
					throw new Exception("DB 입력오류");
				}
				
			} else if(action.equals("list")) {

				
				//조회결과
				List<SkwyvernsDTO> skwyvernsList = skwyvernsDAO.getDBList();

				
				// List를 setAttribute
				request.setAttribute("skwyvernsList", skwyvernsList);

				pageContext.forward("skwyverns_list.jsp");

			} else if(action.equals("edit")) {
				
				// edit용 1건을 select
				skwyvernsDTO = skwyvernsDAO.getDB(Integer.parseInt((String)request.getParameter("id")));
				
				// edit를 setAttribute
				request.setAttribute("action", action);
				
				request.setAttribute("skwyvernsDTO", skwyvernsDTO);
				pageContext.forward("skwyverns_view.jsp");
				
				
			} else if(action.equals("update")) {

				//수정
				if(skwyvernsDAO.updateDB(Integer.parseInt((String)request.getParameter("id")),skwyvernsDTO)) {

					//조회결과
					ArrayList<SkwyvernsDTO> skwyvernsList = skwyvernsDAO.getDBList();
					
					// List를 setAttribute
					request.setAttribute("skwyvernsList", skwyvernsList);

					// 결과 조회를 위하여 조회화면 호출
					pageContext.forward("skwyverns_list.jsp");
				} else {
					throw new Exception("DB 수정오류");
				}
				
			} else if(action.equals("delete")) {

				// 삭제
				if(skwyvernsDAO.deleteDB(Integer.parseInt((String)request.getParameter("id")))) {

					//조회결과
					ArrayList<SkwyvernsDTO> skwyvernsList = skwyvernsDAO.getDBList();
					
					// List를 setAttribute
					request.setAttribute("skwyvernsList", skwyvernsList);

					// 결과 조회를 위하여 조회화면 호출
					pageContext.forward("skwyverns_list.jsp");
				} else {
					throw new Exception("DB 삭제오류");
				}
				
			} else {
				
				out.println("<script>alert('action 파라미터를 확인해 주세요!!!')</script>");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}

