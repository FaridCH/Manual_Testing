<jsp:useBean id="someClass" class="fr.uha.ensisa.gl.manualtesting.SomeClass"/>
<%@page import="fr.uha.ensisa.gl.manualtesting.Model.ManualTest"%>
<jsp:useBean id="ManualTest" class="fr.uha.ensisa.gl.manualtesting.Model.ManualTest"/>
<%@page import="java.util.Iterator"%>
<jsp:useBean id="Controller" class="fr.uha.ensisa.gl.manualtesting.Controller.Controller"/>
<%@page import="fr.uha.ensisa.gl.manualtesting.DataBase.*"%>
<jsp:useBean id="DataBase" class="fr.uha.ensisa.gl.manualtesting.DataBase.DataBase"/>

<%
if(("new test case").equals(request.getParameter("action"))&&request.getParameter("name")!=null)
	DataBase.add(new ManualTest(request.getParameter("name"),false));
else if (("new suite test").equals(request.getParameter("action"))&&request.getParameter("name")!=null)
	DataBase.add(new ManualTest(request.getParameter("name"),true));
else if(("delete").equals(request.getParameter("action"))&&request.getParameter("idtest")!=null)
	DataBase.delete(Integer.parseInt(request.getParameter("idtest")));
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manual Testing Web</title>
</head>

<body>
<a href="index.jsp">Home</a>
<h1>Manual Testing</h1>
<p>
<h2>Defined Tests</h2>
<table id="testcasestable">
<tr>
<th>Name</th>
<th>Type</th>
<th>Action</th>
</tr>

<% Iterator<ManualTest> it = DataBase.getAll().iterator();
int n=0;
while(it.hasNext()){%>
	<tr id="<%=DataBase.get(n).getName() %>Details">
	<td><a id="<%= DataBase.get(n).getName()  %>Edit"
	href="testcase.jsp?t=<%= n %>"><%= DataBase.get(n).getName() %></a></td>
	<td id="<%=DataBase.get(n).getName() %>Class"><% if(!DataBase.get(n).getDone()) {out.println("TestCase");} else { out.println("SuiteTest");} %></td>
	<td><table><tr><td><form action="index.jsp">
	<input type="hidden" name="t" value="<%= n %>">
	<input id="<%= DataBase.get(n).getName() %>Delete" type="submit" name="action" value="delete">
	<input type="hidden" name="idtest" value="<%=n %>">
	</form></td><td>
	</td></tr></table></td>
	</tr>
<%it.next();n++;} %>

<p>New test:
<form action="index.jsp">
	<input type="text" name="name"> 
	<input type="submit" name="action" value="new test case" id="newtestcase"> 
	<input type="submit" name="action" value="new suite test" id="newsuitetest">
</form>
</p>

<p>
<h2>Test runs</h2>
<table id="testruns">
	<tr>
		<th>Date</th>
		<th>Test</th>
		<th>Failed</th>
	</tr>
<% Iterator<Timer> it2 = DataBase.getHistorique().iterator();
int number2=0;
Timer testtimed = null;
while (it2.hasNext()){
testtimed = it2.next();%>	
	<tr <% if(!testtimed.isStatus()) {%>style="background:#F00"<% } %>>
		<td><a href="testrun.jsp?idRun=<%=number2%>"><%=testtimed.getDate() %></a></td>
		<td><%=testtimed.getTest() %></td>
		<td><% if(testtimed.isStatus()) out.print("Success"); else out.print("Failed"); %></td>
	</tr>
<% number2++;}%>

</table>
</p>


</body>
</html>