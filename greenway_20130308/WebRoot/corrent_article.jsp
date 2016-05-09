<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'corrent_article.jsp' starting page</title>
  </head>
  
  <body>
    <h1><s:property value="#session['article'].title"/></h1>
    <s:property value="#session['article'].author"/>
    <s:property value="#session['article'].date"/>
    <s:property value="#session['article'].content"/>
    gro.name<s:property value="#session['article'].gro.name"/>
    
    <h3>gentie</h3>
    <s:if test="#session['gentie_list']!=null">
    <table id="table1">
        <s:iterator value="#session['gentie_list']" id="id">
        <tr> 
             <td width="20%">
                 name: <s:property value="#id.user.name"/>
             </td>
             <td width="20%">
                 addDate: <s:property value="#id.addDate"/>
             <td/>
             <td width="20%">
                 content: <s:property value="#id.content"/>
             </td>
        <tr>
        </s:iterator>
        </table>
        </s:if>
  </body>
</html>
