<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="itStep.DiskCD" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="java.util.Collections" %>
<html>
<head>
    <title>All disk</title>
    <style>
        table{
            border-collapse: collapse;
            border-radius: 10px;
            background-color: #e2e5e5;
        }
        tr{
            border-radius: 10px;
        }
        td{
            padding: 10px 15px;
            border-radius: 10px;
        }

    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Cost</th>
    </tr>
    </thead>
    <tbody>
    <%
        if(session.getAttribute("disk")!=null) {
            List<DiskCD> disks = (List<DiskCD>)session.getAttribute("disk");

            Collections.sort(disks, new Comparator<DiskCD>() {
                public int compare(DiskCD o1, DiskCD o2) {
                    return String.valueOf(o1.getId()).compareTo(String.valueOf(o2.getId()));
                }
            });

            for (DiskCD disk: disks) {
                out.write("<tr>");
                out.write("<td>" + disk.getId() + "</td>");
                out.write("<td>" + disk.getName() + "</td>");
                out.write("<td>" + disk.getCost() + "</td>");
                out.write("</tr>");
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
