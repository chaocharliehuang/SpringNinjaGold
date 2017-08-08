<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>NinjaGold</h1>
	
	<h1>Your Gold</h1>
    <h2> <c:out value="${gold}"/></h2>
    <h2> <c:out value="${rand}"/></h2>
    <h1>farm</h1>
	<form class="building" action='/process' method='POST'>
	    <input type="hidden" name="building" value="farm">
	    <input type="submit" name='farm' value="find gold!">
	</form>
	<h1>cave</h1>
	    
	<form class="building" action='/process' method='post'>
	   <input type="hidden" name="building" value="cave">
	    <input type="submit"  value="find gold!">
	</form>
	<h1>house</h1>
	   
	<form class="building" action='/process' method='post'>
	    <input type="hidden" name="building" value="house">
	    <input type="submit"  value="find gold!">
	</form>
	<h1>casino</h1>
	    
	<form class="building" action='/process' method='post'>
	    <input type="hidden" name="building" value="casino">
	    <input type="submit"  value="find gold!">
	   </form>


<h3>Activities</h3>
<table>

<c:forEach items="${activity}"  var="i">

    <tr>      
        <td>${i[0]}  </td>
         <td>${i[1]}  </td>
        
       
    </tr>

</c:forEach>
</table>
	
	
	
</body>
</html>