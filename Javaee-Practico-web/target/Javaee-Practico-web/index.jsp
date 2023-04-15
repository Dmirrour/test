<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu de Opciones</title>
    <style>
        .btn-container {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .btn-container button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn-container input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Agragar Permiso de Circulazion</h1>
<div class="btn-container">
    <button onclick="location.href='AltaPC.jsp'">Alta Permiso</button>
    &nbsp;
    <button onclick="location.href='listar-permisosC'">Listado Permiso</button>
    &nbsp;
    <button onclick="location.href='listar-permisosB'">Borrar Permiso</button>
    &nbsp;
    <button onclick="location.href='buscar.jsp'">Buscar Permiso</button>
</div>
</body>
</html>