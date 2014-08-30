<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ page import="java.util.*" %>
<%@ page import="org.opennms.twissandra.api.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<tiles:importAttribute name="description" />
<tiles:importAttribute name="title" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!--
 * Copyright 2013, Matt Brozowski and Eric Evans
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
-->
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title><tiles:insertAttribute name="title" /></title>
  <meta name="description" content="${description}" />
  <c:url var="resetCssUrl" value="/css/reset.css" />
  <c:url var="nine60CssUrl" value="/css/960.css" />
  <c:url var="textCssUrl" value="/css/text.css" />
  <c:url var="screenCssUrl" value="/css/screen.css" />
  <link href="${resetCssUrl}" rel="stylesheet" type="text/css" media="screen,projection" />
  <link href="${nine60CssUrl}" rel="stylesheet" type="text/css" media="screen,projection" />
  <link href="${textCssUrl}" rel="stylesheet" type="text/css" media="screen,projection" />
  <link href="${screenCssUrl}" rel="stylesheet" type="text/css" media="screen,projection" />
</head>
<body>
  <c:url var="homeUrl" value="/" />
  <c:url var="publiclineUrl" value="/public" />
  <c:url var="findFriendsUrl" value="/find-friends" />
  <c:url var="loginUrl" value="/login" />
  <c:url var="logoutUrl" value="/j_spring_security_logout" />
  <div class="container_12 clearfix">
    <div id="header">
      <div id="logo" class="grid_7">
        <a href="${homeUrl}">JTwitter</a>
      </div>
      <ul id="nav" class="grid_5">
        <li><a href="${homeUrl}">Home</a></li>
        <li><a href="${publiclineUrl}">Public</a></li>
        <li><a href="${findFriendsUrl}">Find Friends</a></li>

        <sec:authorize access="isAuthenticated()">
        <li><a href="${logoutUrl}">Sign out of ${username}</a></li>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
        <li><a href="${loginUrl}">Login</a></li>
        </sec:authorize>

      </ul>
    </div>
    <div class="clear"></div>
    <tiles:insertAttribute name="content" />
    <div id="sidebar" class="grid_3 omega">
    <p>
      JTwitter is an example project to learn Cassandra using Twitter Concepts.
    </p>
   <tiles:insertAttribute name="sidebar" />
    </div>
  </div>
</body>
</html>

