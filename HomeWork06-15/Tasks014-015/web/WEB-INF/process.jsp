<%--
  Created by IntelliJ IDEA.
  User: Дамир
  Date: 25.03.2016
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
 <form action="process" method="post">
      <p><textarea  name="text"></textarea></p>
   <select type = "text" name = "operation" >
      <option value = "character">number of characters</option>\
      <option value = "words">number of words</option>
      <option value = "sentences">number of sentences</option>
      <option value =  "paragraph">number of paragraphs</option></select>
      <p><input type="submit" value="Process"></p>
    </form>
</body>
</html>
