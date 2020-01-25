
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="itStep.DiskCD" %>
<html>
<head>
    <title>Add CD disk</title>
    <style>
        form {

            width: 300px;
            height: 80px;
        }

        fieldset {
            border-radius: 5px;
            background-color: #ccc;
        }

        button {
            color: green;
            border-radius: 5px;
            background-color: antiquewhite;
            border: none;
            margin-left: 130px;
            padding: 5px 15px;
        }

        input {
            border-radius: 4px;
            border: none;
            outline: none;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>New disk</legend>
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
    <button type="submit">Add</button>
    </fieldset>

</form>
<%
    if(session.isNew() || session.getAttribute("disk") == null){
        session.setAttribute("disk",new ArrayList<DiskCD>());
    }
    if("POST".equals(request.getMethod())){
        List<DiskCD> disks = (List<DiskCD>) session.getAttribute("disk");
        DiskCD diskCd = new DiskCD(disks.size() + 1,request.getParameter("name"),Integer.parseInt(request.getParameter("cost")));
        disks.add(diskCd);
        System.out.println(disks.size());
    }



%>
</body>
</html>
