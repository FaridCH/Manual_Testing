<jsp:useBean id="someClass" class="fr.uha.ensisa.gl.manualtesting.SomeClass"/>
<%@page import="fr.uha.ensisa.gl.manualtesting.Model.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="fr.uha.ensisa.gl.manualtesting.DataBase.*"%>
<%@page import="fr.uha.ensisa.gl.manualtesting.Controller.*" %>
<%
Integer test = (request.getParameter("t")!=null) ? Integer.parseInt(request.getParameter("t")) : 0;
ManualTest Mtest= DataBase.get(test);

//adding a step to a test
if(request.getParameter("newStep")!=null && request.getParameter("newStepDescr")!=null && test!=null)
	Mtest.getStep().add(new Step(request.getParameter("newStepDescr"),("new assertion").equals(request.getParameter("newStep"))));
if(request.getParameter("step")!=null && test!=null){
	//Changing a step's description
	if(("change").equals(request.getParameter("action")))
		Mtest.getStep().get(Integer.parseInt(request.getParameter("step"))).setDesc(request.getParameter("newDescription"));
	if(("up").equals(request.getParameter("action")))
		StepBouton.up(Integer.parseInt(request.getParameter("step")),Mtest);
	if(("down").equals(request.getParameter("action")))
		StepBouton.down(Integer.parseInt(request.getParameter("step")),Mtest);

	//deleting a step
	if(("delete").equals(request.getParameter("action")))
		Mtest.getStep().remove(Integer.parseInt(request.getParameter("step")));
}
%>
<html>
<body>
<a href="index.jsp">Home</a>
<h1 id="titre"><%= (!Mtest.getDone())? "Test Case" : "Test Suite" %></h1>
<h2><%= Mtest.getName() %></h2>
<p><a href="testrun.jsp?t=<%= test %>">run</a></p>

<form method="get" action="testcase.jsp">
	<input type="text" name="name" >
	<input type="submit" name="name-button" value="change name">
	<input type="hidden" name="t" value="<%= test %>">
</form>

<form action="testcase.jsp">
	<textarea name="newStepDescr"></textarea>
	<input type="submit" name="newStep" value="new manual step">
	<input type="submit" name="newStep" id="AssertId" value="new assertion">
	<input type="hidden" name="t" value="<%= test %>">
</form>

<% if(!Mtest.getDone()){ %>
<h2>Defined Steps</h2>
<table id="testcasetable">
	<tr>
		<th>Name</th>
		<th>Type</th>
		<th>Action</th>
	</tr>
	
<% Iterator<Step> it = Mtest.getStep().iterator();
int stepNumber=0;
while (it.hasNext()){ 
	Step theStep=Mtest.getStep().get(stepNumber);
	%>	
	<tr id="<%= stepNumber %>Details">
		<td><form action="testcase.jsp">
				<input type="hidden" name="step" value="<%= stepNumber %>">
				<textarea name="newDescription"><%= theStep.getDesc() %></textarea>
				<input type="submit" name="action" value="change">
			</form></td>
		<td id="<%= stepNumber %>Class"><%= (theStep.getType())? "Assertion" :"Manual Step" %></td>
		<td><form action="testcase.jsp">
				<input type="hidden" name="step" value="<%= stepNumber %>"> <input
					type="submit" name="action" id="<%= stepNumber %>Up" value="up"> <input
					type="submit" name="action" id="<%= stepNumber %>Down" value="down"> <input
					type="submit" name="action" id="<%= stepNumber %>Delete" value="delete">
					<input type="hidden" name="t" value="<%= test %>">
			</form></td>
	</tr>
<% 
	it.next(); stepNumber++;}
 %>	
	
</table>
<% } %>



</body>
</html>