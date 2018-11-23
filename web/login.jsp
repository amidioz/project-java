<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Medicale Site</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="robots" content="all,follow">
  <!-- Bootstrap CSS-->
  <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome CSS-->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
  <!-- Google fonts - Popppins for copy-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,800">
  <!-- orion icons-->
  <link rel="stylesheet" href="css/orionicons.css">
  <!-- theme stylesheet-->
  <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
  <!-- Custom stylesheet - for your changes-->
  <link rel="stylesheet" href="css/custom.css">
  <style type="text/css">
  #hover:hover{
    cursor: pointer;
    background-color: #eee;
  }
</style>
</head>
<body>
  <div class="page-holder d-flex align-items-center">
    <div class="container">
      <div class="row align-items-center py-5">
        <div class="col-5 col-lg-7 mx-auto mb-5 mb-lg-0">
            <div class="pr-lg-5"><center><h1 style="font-size: 100px; color: #007bff">Hospital</h1></center></div>
        </div>
        <div class="col-lg-5 px-lg-4">
          <h1 class="text-base text-primary text-uppercase mb-4">Medicale Site</h1>
          <h2 class="mb-4">Welcome back!</h2>
          <form id="loginForm" method="post" action="Login" class="mt-4">
              <% if(session.getAttribute("fun_login") == "-1"){
                    out.write("<div class='form-group mb-4'>"+
                                 "<p style='color: red;'>"+ "UserName or Password worn </p>"+
                              "</div>"
                    );
                    session.setAttribute("fun_login", "0");
               } %>
            <div class="form-group mb-4">
              <input type="text" name="username" placeholder="Username or Email address" class="form-control border-0 shadow form-control-lg">
            </div>
            <div class="form-group mb-4">
              <input type="password" name="passowrd" placeholder="Password" class="form-control border-0 shadow form-control-lg text-violet">
            </div>
            <div class="form-group mb-4">
              <div class="custom-control custom-checkbox">
                <input id="customCheck1" type="checkbox" checked class="custom-control-input">
                <label for="customCheck1" id="hover" class="custom-control-label" >Remember Me</label>
                <label id="hover" style="margin-left: 35px" onclick="alert()">Forrget Password</label>
              </div>
            </div>
            <button type="submit" class="btn btn-primary shadow px-5">Log in</button>
            <a href="#need" style="color: #000"><label id="hover" style="margin-left: 30px" onclick="myFunction1()">Sign Up</label></a>
          </form>
        </div>
      </div>
    </div>
  </div>


  <!-- Form Elements -->
  <div id="need" style="display: none; padding-top: 20px">
    <div class="container" style="align-content: center;" margin-left: 20px; margin-right: 5px"">
      <div class="col-lg-12 mb-5">
        <div class="card">
          <div class="card-header">
            <h3 class="h6 text-uppercase mb-0">SINGING UP ON OUR SITE</h3>
          </div>
          <div class="card-body">
            <form method="post" action="#" class="form-horizontal">
              <div class="form-group row">
                <label class="col-md-3 form-control-label">First Name</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" >
                </div>
              </div>
              <div class="line"></div>
              <div class="form-group row">
                <label class="col-md-3 form-control-label">Last Name</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" >
                </div>
              </div>
              <div class="line"></div>
              <div class="form-group row">
                <label class="col-md-3 form-control-label">Sex</label>
                <div class="custom-control custom-radio custom-control-inline">
                  <input id="customRadioInline1" type="radio" name="customRadioInline1" class="custom-control-input">
                  <label for="customRadioInline1" class="custom-control-label">Male</label>
                </div>
                <div class="custom-control custom-radio custom-control-inline">
                  <input id="customRadioInline2" type="radio" name="customRadioInline1" class="custom-control-input">
                  <label for="customRadioInline2" class="custom-control-label">Female</label>
                </div>
              </div>
              <div class="line"></div>
              <div class="form-group row">
                <label class="col-md-3 form-control-label">Address</label>
                <div class="col-md-9">
                  <input type="address" class="form-control" >
                </div>
              </div>
              <div class="line"></div>
              <div class="form-group row">
                <label class="col-md-3 form-control-label">DDN</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" >
                </div>
              </div>
              <div class="line"></div>
              <div class="form-group row">
                <label class="col-md-3 form-control-label">LDN</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" >
                </div>
              </div>
              <div class="line"></div>
              <div class="form-group row">
                <label class="col-md-3 form-control-label">Email</label>
                <div class="col-md-9">
                  <input type="text" class="form-control"><small class="form-text text-muted ml-3">We'll never share your email with anyone else.</small>
                </div>
              </div>
              <div class="line"></div>
              <div class="form-group row">
                <label class="col-md-3 form-control-label">Phone</label>
                <div class="col-md-9">
                  <input placeholder="+213" type="Phone" class="form-control">
                </div>
              </div>
              <div class="line"></div>
              <div class="form-group row">
                <label class="col-md-3 form-control-label">User Name</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" >
                </div>
              </div>
              <div class="line"></div>
              <div class="form-group row">
                <label class="col-md-3 form-control-label">Password</label>
                <div class="col-md-9">
                  <input type="password" name="password" class="form-control">
                </div>
              </div>
              <div class="line"></div>
              <div class="form-group row">
                <label class="col-md-3 form-control-label">Confirm Password</label>
                <div class="col-md-9">
                  <input type="password" name="password" class="form-control">
                </div>
              </div>
              <div class="line"></div>
              <div class="form-group row">
                <div class="col-md-9 ml-auto">
                  <button class="btn btn-secondary" onclick="myFunction2()" type="button">Cancel</button>
                  <button type="submit" class="btn btn-primary" style="margin-left: 10px">Register</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- JavaScript files-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/popper.js/umd/popper.min.js"> </script>
  <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
  <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
  <script src="vendor/chart.js/Chart.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
  <script src="js/front.js"></script>
  <script>
    function myFunction1() {
      var x = document.getElementById("need");
      if (x.style.display === "none") {
        x.style.display = "block";
      }
    }

    function myFunction2() {
      var x = document.getElementById("need");
      if (x.st
      yle.display === "block") {
        x.style.display = "none";
      }
    }
  </script>
</body>
</html>