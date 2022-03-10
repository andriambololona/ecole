<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Ecole - Rang de etudiants</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
</head>

<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col">
                <header>
                    <nav class="navbar navbar-light navbar-expand-md">
                        <div class="container-fluid"><a class="navbar-brand" href="#">Ecole</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                            <div class="collapse navbar-collapse" id="navcol-1">
                                <ul class="navbar-nav" style="/*right: initial;*/margin-left: auto;/*text-align: right;*//*float: right;*/">
                                    <li class="nav-item"><a class="nav-link" href="home.jsp">Liste des eleves/ecolage</a></li>
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
            <div class="col-xl-1"></div>
            <div class="col">
                <div class="row">
                    <div class="col">
                        <div>
                            <p>Rang des etudiants</p>
                        </div>
                        <div>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Moyenne</th>
                                            <th>Rang</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>Cell 1</td>
                                            <td>Cell 1</td>
                                            <td>Cell 1</td>
                                            <td>Cell 2</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-1"></div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>