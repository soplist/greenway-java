<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//CN">
<html>
  <head>
      <title>index</title>
  </head>
  <body>
      <s:form name="user" action="user" method="post" >
          <s:textfield name="name" label="username"></s:textfield>
          <FONT color="red"><s:fielderror key="username.error" /></FONT>
           
          <s:password name="password"  label="password"></s:password>
          <!--  <FONT color="red"><s:fielderror key="password.error" /></FONT>-->
          <s:a href="rgst">regest</s:a>
          <s:submit></s:submit>
      </s:form>
      <s:a href="json">json</s:a>
      <s:a href="search_grid">search_grid</s:a>
      <s:a href="test">get_ip</s:a>
  </body>
</html>
