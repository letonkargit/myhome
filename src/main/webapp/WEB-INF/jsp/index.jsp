<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
        .initialhide {
            display: none;
        }
        
        .hover-highlight:hover {
            color: blue; 
        }
    </style>
    <script>
        function checklogon(){
            var user = "<%=session.getAttribute("user")%>";
            if(user !== "null" && user !== ""){
                takemeuserhome();
            }
            document.getElementById('username').focus();
        }
        
        function verifyandregister(){
            showAndClose('youaregoodmessage', 5000);
        }
        
        function showAndClose(id, time){
            document.getElementById(id).style.display = 'block';
            setTimeout(function(){
                hideId(id);
            },time);
        }
        
        function registerandlogin(){
            document.registrationform.action = "<%=request.getContextPath()%>/registeruser";
            document.registrationform.submit();
        }
        
        function closeregisterdiv(){
            hideId('registeruser');
            hideId('registeruserbackend');
        }
        
        function blurmemberdiv(checkboxid, showdivid, disbalecheckboxid){
            if(document.getElementById(checkboxid).checked === true){
                document.getElementById(disbalecheckboxid).disabled = true;
                document.getElementById(showdivid).disabled = true;
            } else {
                document.getElementById(disbalecheckboxid).disabled = false;
            }
        }
    </script>
</head>
<body onload="checklogon()">
    <jsp:include page="common/nologinheader.jsp"/>
    <div style="z-index: 200; float: top;left: 0%;top: 0; position: fixed;background: white;height: 100%;width: 100%;opacity: 0.8"  id="registeruserbackend" class="initialhide"></div>
        <div style="z-index: 300; float: top;left: 15%;right: 15%; top:5px; position: fixed;background: burlywood;color: black;border-radius: 10px;border:1px solid black;padding: 1%;height: 60%;" id="registeruser" class="initialhide">
            <form name="registrationform" method="POST">
            <div style="z-index: 301;top: 2px;float: top;position: relative;">
                <div style="top: 2px;right: 1px;float: left;width: 45%;" id="member1">   
                    <div class="container mt-3">  
<!--                        <div class="form-check" style="top: 1px;width: 100%;align-content: center;z-index: 600;height: 90%">
                            <input class="form-check-input" type="checkbox" value="" id="adddetailslatermemeber1" onclick="blurmemberdiv('adddetailslatermemeber1','member1','adddetailslatermemeber2')">
                            <label class="form-check-label" for="flexCheckDefault">
                              Enter details of my other better half later
                            </label>
                        </div>-->
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="member1_fn" name="member1_fn" placeholder="First Name">
                            &nbsp;
                            <div style="width: 20%"><input type="text" maxlength="1" class="form-control" id="member1_mn" name="member1_mn" placeholder="MI"></div>
                            &nbsp;
                            <input type="text" class="form-control" id="member1_ln" name="member1_ln" placeholder="Last Name">
                        </div>

                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="member1_email" name="member1_email" placeholder="Email">
                        </div>

                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="member1_phone" name="member1_phone" placeholder="Phone">
                        </div>

                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="member1_dob_mm" name="member1_dob_mm" placeholder="MM">
                            &nbsp;
                            <input type="text" class="form-control" id="member1_dob_dd" name="member1_dob_dd" placeholder="DD">
                            &nbsp;
                            <input type="text" class="form-control" id="member1_dob_yyyy" name="member1_dob_yyyy" placeholder="YYYY">
                        </div>

                        <div class="input-group mb-3">
                            <select class="custom-select" id="member1_gender" name="member1_gender">
                              <option selected>Select Gender</option>
                              <option value="Male">Male</option>
                              <option value="Female">Female</option>
                              <option value="Rather not say">Rather not say</option>
                            </select>
                            &nbsp;&nbsp;
                            <select class="custom-select" id="member1_betterhalf" name="member1_betterhalf">
                              <option selected>Which better half are you?</option>
                              <option value="Husband">Husband</option>
                              <option value="Boyfriend">Boyfriend</option>
                              <option value="Spouse 1">Spouse 1</option>
                              <option value="Partner 1">Partner 1</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div style="top: 2px;right: 1px;float: right;width: 45%;" id="member2">
                    <div class="container mt-3">                    
<!--                        <div class="form-check" style="top: 1px;width: 100%;align-content: center;">
                            <input class="form-check-input" type="checkbox" value="" id="adddetailslatermemeber2" onclick="blurmemberdiv('adddetailslatermemeber2','member2','adddetailslatermemeber1')">
                            <label class="form-check-label" for="flexCheckDefault">
                              Enter details of my other better half later
                            </label>
                        </div>-->
                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="member2_fn" name="member2_fn" placeholder="First Name">
                            &nbsp;
                            <div style="width: 20%"><input type="text" maxlength="1" id="member2_mn" name="member2_mn" class="form-control" placeholder="MI"></div>
                            &nbsp;
                            <input type="text" class="form-control" id="member2_ln" name="member2_ln" placeholder="Last Name">
                        </div>

                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="member2_email" name="member2_email" placeholder="Email">
                        </div>

                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="member2_phone" name="member2_phone" placeholder="Phone">
                        </div>

                        <div class="input-group mb-3">
                            <input type="text" class="form-control" id="member2_dob_mm" name="member2_dob_mm" placeholder="MM">
                            &nbsp;
                            <input type="text" class="form-control" id="member2_dob_dd" name="member2_dob_dd" placeholder="DD">
                            &nbsp;
                            <input type="text" class="form-control" id="member2_dob_yyyy" name="member2_dob_yyyy" placeholder="YYYY">
                        </div>

                        <div class="input-group mb-3">
                            <select class="custom-select" id="member2_gender" name="member2_gender">
                              <option selected>Select Gender</option>
                              <option value="Male">Male</option>
                              <option value="Female">Female</option>
                              <option value="Rather not say">Rather not say</option>
                            </select>
                            &nbsp;&nbsp;
                            <select class="custom-select" id="member2_betterhalf" name="member2_betterhalf">
                              <option selected>Which better half are you?</option>
                              <option value="Wife">Wife</option>
                              <option value="Girlfriend">Girlfriend</option>
                              <option value="Spouse 2">Spouse 2</option>
                              <option value="Partner 2">Partner 2</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
            <div style="z-index: 300 ; float: top;position: relative;width:100%;align-content: center;">
                <center>
                <div style="width: 50%">
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" id="couple_uid" name="couple_uid" placeholder="Username">
                        <button type="button" class="btn btn-secondary" onclick="checkuseridavailability();">
                            Check userid for availability
                        </button>
                    </div>
                    <div class="input-group mb-3">
                        <input type="password" class="form-control" id="memebers_pwd" name="memebers_pwd" placeholder="Password">
                    </div>
                </div>
                    </center>
            </div>
        </form>
            <div style="float: top;position: relative;width:100%;align-content: center">
                <center>
                    <button type="button" class="btn btn-primary" onclick="verifyandregister();">
                        Verify and register
                    </button>
                    &nbsp;&nbsp;
                    <button type="button" class="btn btn-primary" onclick="registerandlogin();">
                        Register and login
                    </button>
                </center>
            </div>
            <div style="float: top;right: 1%;top: 0%;position: absolute;font-family: monospace;" onclick="closeregisterdiv()">
                X
            </div>
        </div>
    <div class="container p-3 my-3 border" style="float:top;position: relative">
        <div class="row">
            <div class="col">
                Dashboard - where you would see update from other couples! - WITH NO LOGIN
            </div>            
        </div>
    </div>
    <div style="z-index: 400; float: bottom;bottom:12%;left:5px;position: fixed; ;background: gray;color: black;border-radius: 10px;padding:5px;border: 1px solid brown" class="initialhide" id="youaregoodmessage">
        No need to verify now, you are good!<br> please register and login
    </div>
    <jsp:include page="common/footer.jsp"/>
</body>
</html>