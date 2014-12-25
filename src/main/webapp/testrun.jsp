<%@page import="fr.uha.ensisa.gl.manualtesting.DataBase.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="fr.uha.ensisa.gl.manualtesting.Controller.*" %>
<%@page import="fr.uha.ensisa.gl.manualtesting.Model.*" %>
<% 
Integer test = (request.getParameter("t")!=null) ? Integer.parseInt(request.getParameter("t")) : 0; 
Integer stepNumber = (request.getParameter("step")!=null) ? Integer.parseInt(request.getParameter("step")) : 0;
boolean isFailed = (request.getParameter("failed")!=null) ? true : false;
Integer idRun = (request.getParameter("idRun")!=null) ? Integer.parseInt(request.getParameter("idRun")) : (DataBase.getHistorique().size());
ManualTest MTest = DataBase.get(test);
Timer timer;


%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Management System</title>
</head>
<body>
<a href="index.jsp">Home</a>

<% if(idRun>(DataBase.getHistorique().size()-1)){ 
	timer = new Timer(MTest.getName(),test);
	DataBase.getHistorique().add(timer);
	idRun = DataBase.getHistorique().size()-1;
 }else{
	timer = DataBase.getHistorique().get(idRun);
} %>
	
	<% 
	if(DataBase.getHistorique().get(idRun).getTimefin()==0) { %>
	
		<% if (isFailed){
			Date aujourdhui = new Date();
			Long longTime = new Long(aujourdhui.getTime()/1000);
			timer.setTimefin(longTime);
			timer.setReportfailure(MTest.getName()+" : "+request.getParameter("failure")+" while performing step "+(stepNumber+1));
			timer.setStatus(false);
			
		 }else if(MTest.getStep().size()>stepNumber){ %>
		<h1><%= (!MTest.getDone())? "Test Case" : "Test Suite" %> <%= MTest.getName() %></h1>
		<h2>Action</h2> <%= MTest.getStep().get(stepNumber).getDesc() %>
			<p><nobr>
				<form action="testrun.jsp">
					<textarea name="failure"></textarea>
					<input type="hidden" name="t" value="<%= (test) %>">
					<input type="hidden" name="idRun" value="<%= (idRun) %>">
					<input type="hidden" name="step" value="<%= (stepNumber) %>">
					<input type="submit" name="failed" value="failure">
			</form> - <a href="testrun.jsp?t=<%= (test) %>&step=<%= (stepNumber+1) %>&idRun=<%= (idRun) %>">done</a></nobr>
			</p>
		<% }else{
				Date aujourdhui = new Date();
				Long longTime = new Long(aujourdhui.getTime()/1000);
				timer.setTimefin(longTime);
				timer.setStatus(true);
			%>
		<% } %>
		
	<% 
	}
	if(DataBase.getHistorique().get(idRun).getTimefin()!=0) 
	{
		%>
		<h1>Test run for <%= MTest.getName() %> completed <%= (timer.isStatus())? "successfully":"in error" %></h1>
		<p>
			Test ran from <%= timer.getDate() %> to <%= timer.getEndDate() %> in (<%= (timer.getTimefin()-timer.getTimedebut()) %> seconds)
			<br />
			<ul>
				<li><%=timer.getReportfailure() %></li>
			</ul>
		</p>
		<%
	}
	
	%>

</body>
</html>