<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "services.tableBD"%>
<%@page import = "models.Noteeleve"%>
<%@page import = "models.Infoeleve"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Ecole - Bulletin de note</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
        <link rel="stylesheet" href="assets/css/smoothproducts.css">
    </head>

    <%
        tableBD[] listNote = (tableBD[]) session.getAttribute("listNote");
        tableBD[] infoEleve = (tableBD[]) session.getAttribute("InfoEleve");
        String moyenne = (String) session.getAttribute("moyenne");
        String mention = (String) session.getAttribute("mention");
        tableBD[] premiere= (tableBD[]) session.getAttribute("premiere");
        tableBD[] deuxieme= (tableBD[]) session.getAttribute("deuxieme");
        tableBD[] troisieme= (tableBD[]) session.getAttribute("troisieme");
    %>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col">
                    <header>
                        <nav class="navbar navbar-light navbar-expand-md">
                            <div class="container-fluid"><a class="navbar-brand" href="#">Ecole</a>
                                <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navcol-1">
                                    <ul class="navbar-nav" style="/*right: initial;*/margin-left: auto;/*text-align: right;*//*float: right;*/">
                                        <li class="nav-item"><a class="nav-link" href="home.jsp">Liste des eleves/ecolage</a></li>
                                        <li class="nav-item"><a class="nav-link active" href="bulletin.jsp">Bulletin de note</a></li>
                                        <li class="nav-item"><a class="nav-link" href="enregistrementnote.jsp">Enregistrement des note</a></li>
                                        
                                    </ul>
                                </div>
                            </div>
                        </nav>
                    </header>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div class="row">
                        <div class="col-xl-1"></div>
                        <div class="col">
                            <div>
                                <div class="row">
                                    <div class="col-xl-8">
                                        <%
                                        if(infoEleve != null){
                                        %>
                                        <label>Nom :&nbsp;</label><label><%=((Infoeleve) infoEleve[0]).getNom()%></label><br>
                                        <label>Prenom :&nbsp;</label><label><%=((Infoeleve) infoEleve[0]).getPrenom()%></label><br>
                                        <label>Niveau :&nbsp;</label><label><%=((Infoeleve) infoEleve[0]).getNiveau()%></label><br>
                                        <label>Anne Scolaire :&nbsp;</label><%=((Infoeleve) infoEleve[0]).getAnnee_scolaire()%><label></label><br>
                                        <%
                                        }else{%>
                                        <label>Nom :&nbsp;</label><label></label><br>
                                        <label>Prenom :&nbsp;</label><label></label><br>
                                        <label>Niveau :&nbsp;</label><label></label><br>
                                        <label>Anne Scolaire :&nbsp;</label><label></label><br>
                                        <%}%>
                                    </div>
                                    <div class="col" style="float: right">
                                        <form action="BulletinControler" method="post">
                                            <div>
                                                <label>Numero Matricule : </label>&nbsp;&nbsp;<input type="text" name="matricule">                                                
                                            </div>
                                            <div>
                                                <label>Classe :</label>&nbsp;&nbsp;
                                                <select name="niveau" style="width: 3cm">
                                                    <option value="null"></option>
                                                    <option value="2">Seconde</option>
                                                    <option value="1">Premiere</option>
                                                    <option value="0">Terminal</option>
                                                </select>                                                
                                            </div>
                                            <div>
                                                <label>Trimestre :</label>&nbsp;&nbsp;
                                                <select name="trimestre" style="width: 3cm">
                                                    <option value="null" selected="">---</option>
                                                    <option value="premier">Premiere</option>
                                                    <option value="deuxieme">Deuxieme</option>
                                                    <option value="troisieme">Troisieme</option>
                                                </select> 
                                            </div>
                                            <div>
                                                <button type="submit" class="btn btn-dark">Afficher</button>
                                            </div>
                                        </form>
                                    </div> 
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-1"></div>
                        <div class="col">
                            <div class="row" style="height: 16cm;">
                                <div class="col">
                                    <div>
                                        <div class="table-responsive">
                                            <table class="table" style="background-color: darkgray;">
                                                <thead>
                                                    <tr>
                                                        <th>Matiere</th>
                                                        <th>Notes</th>
                                                        <th>Coefficient</th>
                                                        <th>Enseignant</th>
                                                    </tr>
                                                </thead>
                                                <%
                                                    if(listNote != null){
                                                        for(int i = 0; i<listNote.length; i++){
                                                %>
                                                <tbody>
                                                    <tr>
                                                        <td><%=((Noteeleve) listNote[i]).getNom_matiere()%></td>
                                                        <td><%=((Noteeleve) listNote[i]).getNoteeleve()%></td>
                                                        <td><%=((Noteeleve) listNote[i]).getCoefficient()%></td>
                                                        <td><%=((Noteeleve) listNote[i]).getNom()%></td>
                                                    </tr>
                                                    <% }
                                                    %>
                                                </tbody>
                                                <%}
                                                else if(premiere != null && deuxieme == null && troisieme == null && listNote == null){
                                                        for(int i = 0; i<premiere.length; i++){
                                                %>
                                                <tbody>
                                                    <tr>
                                                        <td><%=((Noteeleve) premiere[i]).getNom_matiere()%></td>
                                                        <td><%=((Noteeleve) premiere[i]).getNoteeleve()%></td>
                                                        <td><%=((Noteeleve) premiere[i]).getCoefficient()%></td>
                                                        <td><%=((Noteeleve) premiere[i]).getNom()%></td>
                                                    </tr>
                                                    <% }
                                                    %>
                                                </tbody>
                                                <%}
                                                else if(premiere == null && deuxieme != null && troisieme == null && listNote == null){
                                                        for(int i = 0; i<deuxieme.length; i++){
                                                %>
                                                <tbody>
                                                    <tr>
                                                        <td><%=((Noteeleve) deuxieme[i]).getNom_matiere()%></td>
                                                        <td><%=((Noteeleve) deuxieme[i]).getNoteeleve()%></td>
                                                        <td><%=((Noteeleve) deuxieme[i]).getCoefficient()%></td>
                                                        <td><%=((Noteeleve) deuxieme[i]).getNom()%></td>
                                                    </tr>
                                                    <% }
                                                    %>
                                                </tbody>
                                                <%}
                                                    else if(premiere == null && deuxieme == null && troisieme != null && listNote == null){
                                                        for(int i = 0; i<troisieme.length; i++){
                                                %>
                                                <tbody>
                                                    <tr>
                                                        <td><%=((Noteeleve) troisieme[i]).getNom_matiere()%></td>
                                                        <td><%=((Noteeleve) troisieme[i]).getNoteeleve()%></td>
                                                        <td><%=((Noteeleve) troisieme[i]).getCoefficient()%></td>
                                                        <td><%=((Noteeleve) troisieme[i]).getNom()%></td>
                                                    </tr>
                                                    <% }
                                                    %>
                                                </tbody>
                                                <%}
                                                %>
                                            </table>
                                        </div>
                                    </div>
                                    <div>
                                        <div>
                                            <label>Moyenne :&nbsp;</label><label><%if(moyenne != null) out.println(moyenne);%></label><br>
                                            <label>Moyenne de classe :&nbsp;</label><label></label><br>
                                            <label>Mention :&nbsp;</label><label><%if(mention != null) out.println(mention);%></label><br>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-1"></div>
                    </div>
                </div>
            </div>
        </div>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
        <script src="assets/js/smoothproducts.min.js"></script>
        <script src="assets/js/theme.js"></script>
    </body>

</html>