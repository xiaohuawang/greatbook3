<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>NEWSCORE</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

 <form action="Input" method="post" role="form">
Id:<br>
<input type="text" name="Id">
<br>
Classtype:<br>
<input type="text" name="Classtype">
<br>
Classname:<br>
<input type="text" name="Classname">
<br>
Assigntype<br>
<input type="text" name="Assigntype">
<br>
Thedate<br>
<input type="text" name="Thedate">
<br>
Grade<br>
<input type="text" name="Grade">

<br>
<input type="submit" value="submit">

</form>

<p>Note that the form itself is not visible.</p>

<p>Also note that the default width of a text field is 20 characters.</p>

</body>

</html>