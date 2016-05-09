<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>regest</title>
  </head>
  <body>
    <s:form name="user" action="regist" method="post" >
          <s:textfield name="name" label="username"></s:textfield>
          <FONT color="red"><s:fielderror key="username.error" /></FONT>
           
          <s:password name="password"  label="password"></s:password>
          <!--  <FONT color="red"><s:fielderror key="password.error" /></FONT>-->
          <s:textfield name="email" label="email"></s:textfield>
          <s:submit></s:submit>
      </s:form>
  </body>
</html>
