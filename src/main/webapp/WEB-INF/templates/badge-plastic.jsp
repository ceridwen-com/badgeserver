<?xml version="1.0" encoding="UTF-8"?>
<%--
Copyright 2016 Matthew J. Dovey (www.ceridwen.com).

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
--%>
<%-- 
  Derived from sheilds.io plastic-template.svg (https://github.com/badges/shields)
--%>
<%@page contentType="image/svg+xml" pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="com.ceridwen.badgeserver.BadgeData"%>
<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="${data.totalWidth}" height="18">
  <linearGradient id="smooth" x2="0" y2="100%">
    <stop offset="0"  stop-color="#fff" stop-opacity=".7"/>
    <stop offset=".1" stop-color="#aaa" stop-opacity=".1"/>
    <stop offset=".9" stop-color="#000" stop-opacity=".3"/>
    <stop offset="1"  stop-color="#000" stop-opacity=".5"/>
  </linearGradient>

  <mask id="round">
    <rect width="${data.totalWidth}" height="18" rx="4" fill="#fff"/>
  </mask>

  <g mask="url(#round)">
    <rect width="${data.captionWidth}" height="18" fill="${data.captionColour}"/>
    <rect x="${data.captionWidth}" width="${data.messageWidth}" height="18" fill="${data.messageColour}"/>
    <rect width="${data.totalWidth}" height="18" fill="url(#smooth)"/>
  </g>

  <g fill="#fff" text-anchor="middle" font-family="DejaVu Sans,Verdana,Geneva,sans-serif" font-size="11">
    <% if (!StringUtils.isBlank(((BadgeData)request.getAttribute("data")).getLink())) { %>
    <a xlink:href="${data.link}">
    <% } %>
      <text x="${data.captionMidPoint}" y="14" fill="#010101" fill-opacity=".3">${data.caption}</text>
      <text x="${data.captionMidPoint}" y="13">${data.caption}</text>
      <text x="${data.messageMidPoint}" y="14" fill="#010101" fill-opacity=".3">${data.message}</text>
      <text x="${data.messageMidPoint}" y="13">${data.message}</text>
    <% if (!StringUtils.isBlank(((BadgeData)request.getAttribute("data")).getLink())) { %>
    </a>
    <% } %>
  </g>
</svg>