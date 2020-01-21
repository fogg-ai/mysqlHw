<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cookie</title>
    <style>
        body {
            background: #c8cccb;
        }

        main {
            padding: 50px;
            background: #ccc;
            position: fixed;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);

        }

        input {
            border: none;
            border-radius: 4px;
            margin-top: 5px;
            margin-left: 10px;
        }

        button {
            padding: 5px 15px;
            border: none;
            border-radius: 4px;
            margin-top: 10px;
            margin-left: 90px;
        }

        label {
            float: left;
        }

        .inp {
            padding-left: 25px;
        }

    </style>
</head>
<body>
<main>
    <h2>Add cookie</h2>
    <form method="post" action="add">
        <table>
            <tr>
                <td><label for="keyAdd">Key:</label></td>
                <td><input id="keyAdd" name="key"/></td>
            </tr>
            <tr>
                <td><label for="valueAdd">Value:</label></td>
                <td><input id="valueAdd" name="value"/></td>
            </tr>
            <tr>
                <td><label for="timeAdd">Time life:</label></td>
                <td><input id="timeAdd" name="time life"/></td>
            </tr>
            <tr>
                <td><label for="domainAdd">Domain:</label></td>
                <td><input id="domainAdd" name="domain"/></td>
            </tr>
            <tr>
                <td><label for="httpHttpsAdd">HTTPS:</label></td>
                <td><input type="radio" id="httpHttpsAdd" name="httpHttps" value="HTTPS"/></td>
            </tr>
            <tr>
                <td><label for="httpHttpAdd">HTTP:</label></td>
                <td><input type="radio" id="httpHttpAdd" name="httpHttps" value="HTTP"/></td>
            </tr>
        </table>
        <button type="submit">Add</button>
    </form>
    <h2>Replace attribute cookie</h2>
    <form method="post" action="replace">
        <table>
            <tr>
                <td><label for="keyReplace">Key:</label></td>
                <td><input id="keyReplace" name="key"/></td>
            </tr>
            <tr>
                <td><label for="valueReplace">Value:</label></td>
                <td><input id="valueReplace" name="value"/></td>
            </tr>
            <tr>
                <td><label for="timeReplace">Time life:</label></td>
                <td><input id="timeReplace" name="time life"/></td>
            </tr>
            <tr>
                <td><label for="domainReplace">Domain:</label></td>
                <td><input id="domainReplace" name="domain"/></td>
            </tr>
        </table>
        <button type="submit">Replace</button>
    </form>
    <h2>Delete cookie</h2>
    <form method="post" action="delete">
        <table>
            <tr>
                <td><label for="keyDelete">Key:</label></td>
                <td class="inp"><input id="keyDelete" name="key"/></td>
            </tr>
        </table>
        <button type="submit">Delete</button>
    </form>
</main>
</body>
</html>