<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Ecole - Enregistrement des notes</title>
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
                                    <li class="nav-item"><a class="nav-link active" href="enregistrementnote.jsp">Enregistrement des note</a></li>
                                   
                                </ul>
                            </div>
                        </div>
                    </nav>
                </header>
            </div>
        </div>
        <div class="row">
            <div class="col-xl-3"></div>
            <div class="col">
                <div>
                    <div style="font-size: 34px;margin-top: 2cm;text-align: center;">
                        <p>Enregistrement des notes</p>
                    </div>
                    <div style="font-family: inherit;margin-top: 1.5cm;">
                        <form action="NoteControler" method="post">
                            <label>Numero matricule :&nbsp;</label>
                            <input class="form-control" type="text" name="matricule">
                            <label>Matiere :&nbsp;</label>
                            <select class="form-control" name="matiere">                                
                                    <option value="1">MALAGASY</option>
                                    <option value="2">FRANCAIS</option>
                                    <option value="3">MATHEMATIQUE</option>                               
                                    <option value="4">PHYSIQUE</option>                               
                                    <option value="5">SCIENCE</option>                                    
                            </select>
                            <label>Notes :&nbsp;</label>
                            <input class="form-control" type="number" name="note"><br>
                            <button class="btn btn-success" type="submit">Enregistrer</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-xl-3"></div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>