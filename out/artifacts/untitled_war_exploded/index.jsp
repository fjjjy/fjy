
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ page import="com.bean.StudnetBean"%>
           <%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>学生管理系统</title>
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

 <style type="text/css">
 .text-center{
	 font-size: 40px;
	 margin-bottom: 30px;
 }
 body{
	 background: url(img_1.png);
	 /*background-size: 100% 120%;*/
 }
 </style>
 <script> 
 //增加
  function submitit1(){ 
    document.form1.action = "AddStudentServlet" 
    //document.form1.submit();
  }
  //更改
  function submitit3() { 
   document.form1.action = "ChangeStudentServlet" 
   //document.form1.submit(); 
 } 

 
 //删除
  function submitit2() { 
    document.form2.action = "DelStudentServlet" 
   // document.form2.submit(); 
  } 

 //查找
    function submitit4() { 
    document.form2.action = "ShowStudentServlet" 
    //document.form2.submit(); 
  } 
</script> 

</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-center">
				水库管理系统
			</h3>
		</div>
	</div>

	<div class="row clearfix">
		<div class="col-md-12 column">
			<form class="form-horizontal" role="form" name="form1" METHOD="POST">
				<div class="form-group">
					 <label for="inputEmail31" class="col-sm-2 control-label">编号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail31" name="A" />
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword32" class="col-sm-2 control-label">名字</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword32" name="B" />
					</div>
				</div>

					<div class="form-group">
					 <label for="inputPassword33" class="col-sm-2 control-label">面积</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword33" name="C"/>
					</div>
				</div>

				<div class="form-group">
					 <label for="inputPassword34" class="col-sm-2 control-label">深度</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword34" name="D"/>
					</div>
				</div>

				<div class="form-group">
					 <label for="inputPassword35" class="col-sm-2 control-label">位置</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword35" name="E" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default" onClick=submitit1();>添加水库信息</button>
						  <button type="submit" class="btn btn-default" onClick=submitit3();>更改水库信息</button>

				<%
				String state = (String) session.getAttribute("B1");
							 session.removeAttribute("B1");
				if(state!=null){
					out.print(state);
				}

				%>
					</div>
				</div>
			</form>

			<form class="form-horizontal" role="form" name="form2" METHOD="POST">
				<div class="form-group">
					 <label for="inputEmail36" class="col-sm-2 control-label">编号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail36" name="A"/>
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default" onClick=submitit2();>删除水库信息</button>
						 <button type="submit" class="btn btn-default" onClick=submitit4();>查找水库信息</button>
						 <%
				state = (String) session.getAttribute("B2");
							 session.removeAttribute("B2");
				if(state!=null){
					out.print(state);
				}

				%>
					</div>
				</div>

			</form>
	<div class="row clearfix">
				<div class="col-md-1 column">
				</div>
				<div class="col-md-11 column">
					<table class="table">
						<thead>
							<tr>
								<th>
									编号
								</th>
								<th>
									名字
								</th>
								<th>
									面积
								</th>
								<th>
									深度
								</th>
								<th>
									位置
								</th>
							</tr>
						</thead>
						<tbody>

						<%
						//获取对象
						ArrayList stumess = (ArrayList) session.getAttribute("stumessage");
						 session.removeAttribute("stumessage");
						if(stumess!=null){
							//下面执行成功的地方 有数据
							for(int i=0;i<stumess.size();i++){
								StudnetBean a=(StudnetBean)	stumess.get(i);


							%>


								<tr class="info">
								<td>
									<%=a.getSid() %>
								</td>
								<td>
									<%=a.getSname() %>
								</td>
								<td>
									<%=a.getScls() %>
								</td>
								<td>
									<%=a.getSold() %>
								</td>
									<td>
									<%=a.getSroom() %>
								</td>
							</tr>





							<%
							}
						}


						%>



						</tbody>
					</table>
				</div>
			</div>
		</div>

		</div>

	</div>
</div>

</body>
</html>