<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>personal homepage</title>
     <link href='css/personal_homepage.css' type='text/css' rel='stylesheet' />
     <script type="text/javascript" src="js/jQuery.js"></script>
     <script type="text/javascript" src="js/personal_homepage.js"></script>
  </head>
  <body>
    <a href="#"><s:property value="#session['user'].name"/></a>
    <form name="message" action="sendMessage" method="post" >
    <table>
       <tr>
          <td>
          <textarea id="message" name="message.content" rows="3" cols="60" style="resize:none"></textarea>
          <!--<input id="message" name="message.content"/>-->
          </td>
       </tr>
       <tr align="right">
          <td>
          <input id="btn" type="button" value="send" onclick="javascript:clickButton();"></input>
          </td>
       </tr>
       </table>
    </form>
    
    
        
                <div id="result">
                  <a id="post_message" href="#">
                  </a>
                </div>
             
        <s:iterator value="#session['messages']" id="id">
        
                  <div id="message">
                  <a id="msg" href="#">
                  name: <s:property value="#id.user.name"/>
                  date: <s:property value="#id.date"/>
                  content: <s:property value="#id.content"/>
                  </a>
                  </div>
            
        </s:iterator>

    
    <a href="/greenway_20130308/getGroupsByUserId.action?user_id=<%=request.getSession().getAttribute("user_id")%>">groups</a>
    <a href="time_line">timelines</a>
  </body>
</html>
