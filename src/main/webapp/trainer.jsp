<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 06.07.16
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trainer</title>
    <script type="text/javascript" src="../resources/templates/key.js"></script>
    <link href="../resources/templates/style.css" rel="stylesheet">
</head>


<body>

<div id="logo">
    <h1>Trainer</h1>
</div>
<div id="typing">
    <div id="info">
        <div id="typed"></div>
        <div id="timer">Время: 00:00</div>
        <div id="errors"></div>
    </div>
    <div id="text_type">
        <span id="next">text from bd</span><br>
        <!--<span class="current">letter will input green color</span><br>
        <span class="letter_ok">letter true=grey </span><br>
        <span class="letter_bad">letter false=red </span><br>-->
    </div>
    <div>
        <form name="input_form" id="input_form" action="">
            <!--<input name="input_text" id="input_text"  > </input> -->
            <textarea name="input_text" id="input_text"  spellcheck="false" onkeydown="if(event.keyCode == 13){ if (event.shiftKey==1) { return true;} else { return false;}}" ></textarea>
        </form>
    </div>
</div>
</body>
</html>





