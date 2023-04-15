<%@ page import="org.example.model.PNCirculacion" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import ="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listado de Permisos de Circulacion</title>
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
<%
        ArrayList<PNCirculacion> per = (ArrayList<PNCirculacion>) request.getAttribute("permiso");
%>
<div class="div-form"> <!-- Contenedor responsive -> ver codigo css en css/mosficarUsuario.css -->
    <div align="center" class="div-dataUser" style="background-color:#33475b"> <!-- Segundo contenedor responsive -> ver codigo css en css/mosficarUsuario.css -->
        <h2 class="font-weight-bold mb-3" style="color:white"> Listado de Permisos de Circulacion</h2>
            <div class="form-row mb-2">
                <!-- ACA PONE LA DATA -->
                <table>
                    <thead>
                    <tr>
                        <th>ID(numero)</th>
                        <th>Patente(asociada)</th>
                        <th>Fecha de expiracion</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if (per != null) {

                            for (PNCirculacion dtp : per) {
                    %>
                    <tr>
                        <td data-label="POSICION"> <%=dtp.getNumero()%></td>
                        <td data-label="NOMBRE"> <%=dtp.getPatente()%></td>
                        <%
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            String fechaV = sdf.format(dtp.getPvalidez());
                        %>
                        <td data-label="DESCRIPCION"> <%=fechaV%></td>
                    </tr>
                    <%
                        }
                    }else{
                    %>
                    <tr>
                        <td data-label="ID(numero)"> <li>Vacio</li> </td>
                        <td data-label="Patente(asociada)"> <li>Vacio</li> </td>
                        <td data-label="Fecha de expiracion"> <li>Vacio</li> </td>

                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>

            </div>
        <div class="btn-container">
            <button onclick="location.href='AltaPC.jsp'">Alta Permiso</button>
            &nbsp;
            <button onclick="location.href='listar-permisosC'">Listado Permiso</button>
            &nbsp;
            <button onclick="location.href='listar-permisosB'">Borrar Permiso</button>
            &nbsp;
            <button onclick="location.href='buscar.jsp'">Buscar Permiso</button>
        </div>
    </div> <!-- cierrre de div-dataUser -->
</div> <!-- cierrre de div-form -->
</body>
</html>
