<%--
  Created by IntelliJ IDEA.
  User: nick2
  Date: 1/25/2020
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="itStep.DiskCD" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Edit</title>
    <style>
        form{

            width: 300px;
            height: 80px;
        }
        fieldset{
            border-radius: 5px;
            background-color: #ccc;
        }
        button{
            color: green;
            border-radius: 5px;
            background-color: antiquewhite;
            border: none;
            margin-left: 130px;
            padding: 5px 15px;
        }
        input{
            border-radius:4px;
            border: none;
            outline:none;
            margin-top: 5px;
        }

    </style>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Edit disk</legend>
        <table>
            <tr>
                <td>NameDisk:</td>
                <td><input name="name" required/></td>
            </tr>
            <tr>
                <td>Cost:</td>
                <td><input name="cost" min="0" max="1000" required/></td>
            </tr>
        </table>
    </fieldset>
    <button type="submit">Edit</button>
</form>

<%
    if("POST".equals(request.getMethod())){
        List<DiskCD> disks = (List<DiskCD>) session.getAttribute("disk");
        for (DiskCD disk: disks) {
            if(request.getParameter("name").equals(disk.getName())){
                disks.remove(disk);
                DiskCD diskCd = new DiskCD(disk.getId(), request.getParameter("name"),Integer.parseInt(request.getParameter("cost")));
                disks.add(diskCd);
                break;
            }

        }
    }

    if(session.isNew() || session.getAttribute("disk") == null){
        session.setAttribute("disk",new ArrayList<DiskCD>());
    }

%>
</body>
</html>
