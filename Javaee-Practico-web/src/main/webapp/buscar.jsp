<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.example.model.PNCirculacion" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
  <title>Buscar</title>
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
<h1>Buscar Permiso</h1>

<form action="buscar-permisosC" method="post">
  <label for="seleccion">Seleccionar Atributo:</label>
  <select id="seleccion" name="tipo">
    <option value="ID">ID</option>
    <option value="Patente">Patente</option>
    <option value="Fecha">Fecha</option>
  </select>
  <br><br>
  <label for="buscar">Buscar:</label>
  <input type="text" id="buscar" name="buscar">
  <button type="submit">Enviar</button>
</form>
  <%
      if(request.getAttribute("muestrolistado")!=null){
      ArrayList<PNCirculacion> per = (ArrayList<PNCirculacion>) request.getAttribute("permiso");
  %>
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
    <%
      }
    %>


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