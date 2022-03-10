<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Ecole - Paiement Ecolage</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
        <link rel="stylesheet" href="assets/css/smoothproducts.css">
    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-3"></div>
                <div class="col">
                    <div>
                        <div style="font-family: cursive;font-size: 38px;text-align: center;margin-top: 2cm;">
                            <p>Paiement Ecolage</p>
                        </div>
                        <div style="margin-top: 3cm;">
                            <form action="PaiementEcolage" method="post">
                                <label>Mois :&nbsp;</label>
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
                                <label>Montant:&nbsp;</label>
                                <input class="form-control" type="number" name="montant" required="required"><br>
                                <button class="btn btn-success" type="submit">Payer</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-xl-4"></div>
            </div>
        </div>
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
        <script src="assets/js/smoothproducts.min.js"></script>
        <script src="assets/js/theme.js"></script>
    </body>

</html>