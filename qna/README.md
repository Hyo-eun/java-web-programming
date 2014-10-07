- Servlet Context 생성 
ServeletContextLoader에서 SC를 로딩하고 RequestMapping을 초기화하여 컨텍스트 속성으로 지정된다.
또한 QnaContextLoaderListener에서 DB스키마와 정보를 초기화하기 위한 qna.sql 스크립트를 DatabasePopulatorUtil을 이용해 DB를 초기화한다.

- localhost:8080 접속
localhost:8080으로 접속하면 루트 URL이기 때문에 web.xml에 welcome page로 등록된 index.jsp를 호출하게된다.
index.jsp에서 sendRedirect를 호출하여 302 코드로 응답 후 /list.next로 Redirect된다.
리다이렉트된 /list.next 요청은 web.xml에 정의되어 있는데로 FrontController 서블릿이 전달 받는다.
FrontController는 RequestMapping에 정의된 findController 메서드를 이용해 url에 맞는 ListController를 찾게된다.
ListController에서는 QuestionDao를 이용해 질의 목록을 받아오고 request 속성으로 해당 리스트를 저장한뒤 list.jsp를 대상으로 요청을 포워드하게 되어 JSP내부의 JSTL에의해 질의가 적용된 html을 사용자에게 응답한다.
