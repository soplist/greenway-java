<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <title>user groups</title>
  </head>
  
  <body>
    <table id="table1">
        <s:iterator value="#session['group_list']" id="id">
        <tr> 
             <td width="50%">
                  <a href="/greenway_20130308/listArticleByGroupId.action?group_id=<s:property value='#id.id'/>">
                     name: <s:property value="#id.name"/>
                  </a>
             </td>
             <!-- -->
         </tr> 
        </s:iterator>
    </table>
    <h3>my group article</h3>
    <table id="table2">
    <s:if test="#session['article_list']!=null">
        <s:iterator value="#session['article_list']" id="id">
        <tr> 
           <td width="20%">
                  <a href="/greenway_20130308/getCorrentArticle.action?article_id=<s:property value="#id.id"/>">
                      title: <s:property value="#id.title"/>
                  </a>
             </td>
             <td width="20%">
                 author: <s:property value="#id.author"/>
             <td/>
             <td width="20%">
                 date: <s:property value="#id.date"/>
             </td>
        </tr> 
        </s:iterator>
        </s:if>
    </table>
  </body>
</html>
