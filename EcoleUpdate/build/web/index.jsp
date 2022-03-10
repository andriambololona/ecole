<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Connection</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
</head>

<body>
    <div class="container">
        <section class="login-clean" style="margin-top: 4cm;">
            <form method="post" style="margin-top: auto; background-color: darkcyan;" action="LoginControler">
                <h2 class="sr-only">Login Form</h2>
                <div class="form-group">
                    <input class="form-control" type="text" name="id" placeholder="Nom utilisateur" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="password" placeholder="Mot de passe" required>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary btn-block" type="submit" style="color: #f1f7fc;background-color: #505e6c;">Connecter</button>
                </div>
            </form>
        </section>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
    <script src="assets/js/smoothproducts.min.js"></script>
    <script src="assets/js/theme.js"></script>
</body>

</html>