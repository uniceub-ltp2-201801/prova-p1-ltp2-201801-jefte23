<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.sun.xml.internal.ws.api.ha.StickyFeature"%>
<%@page import="java.util.*"%>
<%@page import="java.time.LocalDate"%>
<%@page import="dao.*"%>
<%@page import="control.*"%>
<%@page import="model.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Home</title>

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="estilo.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  
    <!-- Barra navega��o -->
    <nav class="navbar navbar-default navbar-transparente ">
      <div class="container">
        
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" 
                  data-toggle="collapse" data-target="#barra-navegacao">
            <span class="sr-only">Alternar Menu</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="index.html" class="navbar-brand">
          	<span class="img-logo"></span>
          </a>
        </div>

        <div class="collapse navbar-collapse" id="barra-navegacao">

          <ul class="nav navbar-nav navbar-right">
            <li> <a href="listarProfessores">Listar Professores</a> </li>
            <li> <a href="consultarPorTitulacao">Consultar por titula��o</a> </li>
            <li> <a href="#">Diciplina</a> </li>
         </ul>
        </div>
      </div>
    </nav>


	<!-- Conte�do da pagina  -->

     <div class="container">
		<div class="row">
            <div class="col-xs-6  marcador">
        		 <table class="table table-striped table-bordered table-hover">
      <thead>
        <tr>
          <th>IdProfessor</th>
          <th>Nome Professores</th>
        </tr>
      </thead>
      <tbody>
        <tr>
	
	<%
		List<Professor> professores = (List<Professor>) request.getAttribute("professores");
		for (int i = 0; i< professores.size();i++)
		{
			
	%>
	
	<tr>
          <td>
          	<a href="exibirProfessor?idProfessor=<%=professores.get(i).getIdProfessor()%>">
          		<%=professores.get(i).getIdProfessor() %>
          	</a>
          </td>
          
          <td>
            <a href="exibirProfessor?idProfessor=<%=professores.get(i).getIdProfessor()%>">
            	<%=professores.get(i).getNomeProfessor() %>
            </a>
           </td>
	</tr>
	         
       <%
			}
       %>   

        </tbody>
    </table>
            </div>
            <div class="col-xs-6  marcador">
              	      <thead>
        <tr>
          <th>IdProfessor</th>
          <th>Nome Professores</th>
          <th>M�e professor</th>
          <th>Titula��o</th>
        </tr>
      </thead>
      <tbody>
        <tr>
	
	<%
		Professor p = (Professor) request.getAttribute("professor");
				
	%>
	
	<tr>
          <td><%= p.getIdProfessor() %></td>
          <td><%= p.getNomeProfessor() %></td>
          <td><%= p.getNomeMae() %></td>          
          <td><%= p.getTitula��o() %></td>          
   
	</tr>
	         
          </div>
        </div> 
      <!-- Fim row 1 -->
        
	 	<div class="row">
	       	<div class="col-xs-6  marcador">
	              <h1 align="center"></h1>
	            </div>
	            <div class="col-xs-6  marcador">
	              <h1 align="center"></h1>
	            </div> <!-- Fim row 2 -->
	     </div>
     </div>
    
       <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>

