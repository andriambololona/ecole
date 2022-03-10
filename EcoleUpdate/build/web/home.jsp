<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "services.tableBD"%>
<%@page import = "models.Infoeleve"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Ecole - Liste des etudiants/Ecolage</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
        <link rel="stylesheet" href="assets/css/smoothproducts.css">
    </head>

    <%
            tableBD[] listComplet = (tableBD[]) session.getAttribute("listComplet");
            tableBD[] listAvecCritere = (tableBD[]) session.getAttribute("listCritere");
            String size = (String) session.getAttribute("size");
    %>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col">
                    <header>
                        <nav class="navbar navbar-light navbar-expand-md">
                            <div class="container-fluid">
                                <a class="navbar-brand" href="#">Ecole</a>
                                <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                                <div class="collapse navbar-collapse" id="navcol-1">
                                    <ul class="navbar-nav" style=" margin-left: auto;">
                                        <li class="nav-item"><a class="nav-link active" href="home.jsp">Liste des eleves/ecolage</a></li>
                                        <li class="nav-item"><a class="nav-link" href="bulletin.jsp">Bulletin de note</a></li>
                                        <li class="nav-item"><a class="nav-link" href="enregistrementnote.jsp">Enregistrement des note</a></li>
                                        
                                    </ul>
                                </div>
                            </div>
                        </nav>
                    </header>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-2"><label>Niveau :&nbsp;</label>
                    <div>
                        <div>
                            <form action="EtudiantsControler" method="post">
                                <select class="form-control" name="niveau">
                                    <option value="Seconde">Seconde</option>
                                    <option value="Premiere">Premiere</option>
                                    <option value="Terminale">Terminal</option>
                                </select>
                                <label>Numero matricule :&nbsp;</label>
                                <input class="form-control" type="text" style="resize: 10px;" name="matricule" >
                                <label>Mois:&nbsp;</label>
                                <select class="form-control" name="mois">
                                    <option value="Janvier">Janvier</option>
                                    <option value="Fevrier">Fevrier</option>
                                    <option value="Mars">Mars</option>
                                    <option value="Avril">Avril</option>
                                    <option value="Mai">Mai</option>
                                    <option value="Juin">Juin</option>
                                    <option value="Juillet">Juillet</option>
                                    <option value="Aout">Aout</option>
                                    <option value="Septembre">Septembre</option>
                                    <option value="Octobre">Octobre</option>
                                    <option value="Novembre">Novembre</option>
                                    <option value="Decembre">Decembre</option>
                                </select>
                                <label>Anne Scolaire :&nbsp;</label>
                                <select class="form-control" name="annee"> 
                                    <option value="2019/2020">2019/2020</option>
                                    <option value="2020/2021">2020/2021</option>
                                    <option value="2021/2022">2021/2022</option>
                                </select><br>
                                <button class="btn btn-success" type="submit">Rechercher</button>
                            </form>
                        </div>



                    </div>
                    <div style="margin-top: 4cm">
                        <%if(size != null && listAvecCritere == null){%>
                        <div style="text-align: center;">
                            <p style="color: red; font-size: 22px;">Eleves inexistants</p>
                        </div>
                        <%}else{}%>
                        <form action="LogoutControler">
                            <div>
                                <button type="submit" class="btn btn-secondary">Deconnection</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col">
                    <div style="height: 18cm; background-color: darkgray;">
                        <div class="table-responsive">
                            <table class="table" style="overflow-y: scroll">
                                <thead>
                                    <tr>
                                        <th>Nom</th>
                                        <th>Prenom</th>
                                        <th>Sexe</th>
                                        <th>Classe</th>
                                        <th>Montant Total</th>
                                        <th>Annee scolaire</th>
                                        <th>Mois</th>
                                        <th>Etat</th>
                                        <th>Payer</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%if(listComplet != null && listAvecCritere == null){
                                        for(tableBD list : listComplet){
                                    %>
                                    <tr>
                                        <td><%=((Infoeleve)list).getNom()%></td>
                                        <td><%=((Infoeleve)list).getPrenom()%></td>
                                        <td><%=((Infoeleve)list).getSexe()%></td>
                                        <td><%=((Infoeleve)list).getNiveau()%></td>
                                        <td><%=((Infoeleve)list).getMontant_total()%></td>
                                        <td><%=((Infoeleve)list).getAnnee_scolaire()%></td>
                                        <td><%=((Infoeleve)list).getMois()%></td>
                                        <td><%=((Infoeleve)list).getEtat_paiement()%></td>
                                        <td><a href="PaiementEcolage?nomPaiement=<%=((Infoeleve)list).getPrenom()%>" class="btn btn-success">Payer</a></td>
                                    </tr>
                                    <%}%>
                                </tbody>
                                <%
                                }else
                                {%>
                                <tbody>
                                    <%
                                        for(tableBD listC : listAvecCritere){
                                    %>
                                    <tr>
                                        <td><%=((Infoeleve)listC).getNom()%></td>
                                        <td><%=((Infoeleve)listC).getPrenom()%></td>
                                        <td><%=((Infoeleve)listC).getSexe()%></td>
                                        <td><%=((Infoeleve)listC).getNiveau()%></td>
                                        <td><%=((Infoeleve)listC).getMontant_total()%></td>
                                        <td><%=((Infoeleve)listC).getAnnee_scolaire()%></td>
                                        <td><%=((Infoeleve)listC).getMois()%></td>
                                        <td><%=((Infoeleve)listC).getEtat_paiement()%></td>
                                        <td><a href="PaiementEcolage?nomCPaiement=<%=((Infoeleve)listC).getPrenom()%>" class="btn btn-success">Payer</a></td>
                                    </tr>
                                    <%}%>
                                </tbody>
                                <%
                                }
                                %>
                            </table>
                        </div>
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