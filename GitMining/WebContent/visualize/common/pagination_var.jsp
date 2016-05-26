<!-- 定义了分页标签jsp文件与引用该文件的jsp文件之间共享的变量 -->
<%!
	int pageNum;				//要显示的页数
	int currentPage;			//当前显示的页号，从0开始
	String handleServlet;		//处理跳转的servlet路径
%>