<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario JSP</title>
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
        .input-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .input-container input[type="submit"] {
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
<form action="agregar-permisoC" method="post">
    <label for="numero">Número:</label>
    <input type="number" id="numero" name="numero" required><br><br>

    <label for="texto">Texto:</label>
    <input type="text" id="texto" name="texto" required><br><br>

    <label for="fecha">Fecha:</label>
    <input type="date" id="fecha" name="fecha" required><br><br>

    <input type="submit" value="Enviar">
</form>
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



