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
    <script>
        function saveValue(currentid,nextid){
            if(document.getElementById(currentid).value !== null && document.getElementById(currentid).value !== ""){
                showId(nextid);
                document.getElementById(currentid+"_value").innerHTML = document.getElementById(currentid).value;
                document.getElementById(currentid+"_hidden").value = document.getElementById(currentid).value;
                hideId(currentid+"_div");
            }
        }
        
        function saveItem(){
            document.itemsform.action="<%=request.getContextPath()%>/saveitem";
            document.itemsform.submit();
        }
        
        //Edit item
        var canedit = true;
        function editthisitem(id){
            if(canedit){
                //For item type
                hideId("itemtype"+id);
                hideId("showsaveitems"+id);
                showId("itemtypeedit"+id)
                showId("saveediteditemid"+id);
                
                canedit = false;
            } else {
                alert("Please save edited item first! This should be a toast!");
            }
        }
        
        function saveEditedItem(id){
            var typeVal = document.getElementById("itemtypeval"+id).value;
            alert("Saving - "+typeVal);
        }
    </script>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>
    <!-- common required properties-->
    <!--<input type="hidden" id="success" name="success" value="${success}">-->
    <!-- common required properties-->
    <div class="container p-3 my-3 border" style="float:top;position: relative">
        <div class="row">
            <div class="col">
                <div class="input-group mb-3">
                    <div id="additemid">
                        <button type="button" class="btn btn-dark" onclick="showId('detailsrow');showId('itemsid');showId('itemsdemo');showId('item_type_div');hideId('showitemsdiv');">Add Item</button>                    
                    </div>
                    <div id="showallitems">
                        <button type="button" class="btn btn-dark" onclick="showId('detailsrow');showId('showitemsdiv');hideId('itemsid');hideId('itemsdemo');">Show Items</button>                    
                    </div>
                </div>
            </div>     
        </div>
    </div>
    <div id="detailsrow">
        <div class="container p-3 my-3 border" style="float:top;position: relative">
            <div class="row">
                <div id="itemsid" class="initialhide">
                    <div class="col">
                        <div>
                            <div id="item_type_div" class="initialhide">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text">Enter item type :</span>
                                    </div>
                                    <br>
                                    <input type="text" name="item_type" id="item_type"/>
                                    <br>
                                    <button type="button" class="btn btn-primary" onclick="saveValue('item_type','item_name_div');">
                                        Next : Enter name
                                    </button>
                                </div>
                            </div>
                            <div id="item_name_div" class="initialhide">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text">Enter item name:</span>
                                    </div>
                                    <input type="text" name="item_name" id="item_name" />
                                    <button type="button" class="btn btn-primary" onclick="saveValue('item_name','item_desc_div');">
                                        Next : Enter Description
                                    </button>
                                </div>
                            </div>
                            <div id="item_desc_div" class="initialhide">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text">Enter item description</span>
                                    </div>
                                    <input type="text" name="item_desc" id="item_desc" />
                                    <button type="button" class="btn btn-primary" onclick="saveValue('item_desc','item_eattime_div');">
                                        Next : Good time to eat
                                    </button>
                                </div>
                            </div>
                            <div id="item_eattime_div" class="initialhide">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text">Good time to eat?</span>
                                    </div>
                                    <input type="text" name="item_eattime" id="item_eattime" />
                                    <button type="button" class="btn btn-primary" onclick="saveValue('item_eattime','item_exp_div');">
                                        Next : Expiration date
                                    </button>
                                </div>
                            </div>
                            <div id="item_exp_div" class="initialhide">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text">When is it expiring?</span>
                                    </div>
                                    <input type="text" name="item_exp" id="item_exp" />
                                    <button type="button" class="btn btn-primary" onclick="saveValue('item_exp','item_location_div');">
                                        Next : Where have you kept it?
                                    </button>
                                </div>
                            </div>
                            <div id="item_location_div" class="initialhide">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text">Where have you kept it?</span>
                                    </div>
                                    <input type="text" name="item_location" id="item_location" />
                                    <button type="button" class="btn btn-primary" onclick="saveValue('item_location','item_opened_div');">
                                        Next : Is it opened yet?
                                    </button>
                                </div>
                            </div>
                            <div id="item_opened_div" class="initialhide">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                      <span class="input-group-text">Is it opened yet?</span>
                                    </div>
                                    <input type="text" name="item_opened" id="item_opened" />
                                    <button type="button" class="btn btn-primary" onclick="saveValue('item_opened','item_save_button');hideId('itemsid');">
                                        Next : Review items :)
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div id="showitemsdiv">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th style="width: 150px">Item type</th>
                                    <th>Item name</th>
                                    <th>Item description</th>
                                    <th>Good time to eat</th>
                                    <th>Item expiration</th>
                                    <th>Kept here</th>
                                    <th>Item opened ever</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${items}" var="item">
                                    <tr>
                                        <td style="width: 150px">
                                            <div id="itemtype${item.item_id}">${item.item_type}</div>
                                            <div id="itemtypeedit${item.item_id}" class="initialhide">
                                                <input type="text" name="itemtypeval${item.item_id}" id="itemtypeval${item.item_id}" value="${item.item_type}" />
                                            </div>
                                        </td>
                                        <td>${item.item_name}</td>
                                        <td>${item.item_desc}</td>
                                        <td>${item.item_eat_time}</td>
                                        <td>${item.item_exp_date}</td>
                                        <td>${item.item_location}</td>
                                        <td>${item.is_opened}</td>
                                        <td>
                                            <div id="showsaveitems${item.item_id}">
                                                <i class='fa fa-edit' style='font-size:24px' onclick="editthisitem(${item.item_id});" ></i>
                                            </div>
                                            <div id="saveediteditemid${item.item_id}" class="initialhide">
                                                <button type="button" class="btn btn-primary" onclick="saveEditedItem(${item.item_id})"> Save </button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="container p-3 my-3 " style="float:top;position: relative">
            <div class="row" style="align-content: center">
                <div id="itemsdemo" class="initialhide" style="width: 210px;border: 1px solid black;background: yellowgreen;float: right;top:5px;position: absolute;border-radius: 10px">
                            <div style="height: 20px;width: 208px;border-bottom: 1px outset red;float: top;border-radius: 10px 10px 0px 0px;position: relative;margin-bottom: 1px">
                                <i>Type : </i> <label id="item_type_value" name="item_type_value"/>
                            </div>
                            <div style="height: 20px;width: 208px;border-bottom: 1px outset red;float: top;position: relative;margin-bottom: 1px">
                                <i>Name : </i> <label id="item_name_value"/>
                            </div>
                            <div style="height: 40px;width: 208px;border-bottom: 1px outset red;float: top;position: relative;margin-bottom: 1px">
                                <i>Description : </i> <label id="item_desc_value"/>
                            </div>
                            <div style="height: 40px;width: 208px;border-bottom: 1px outset red;float: top;position: relative;margin-bottom: 1px">
                                <i>Good time to eat : </i> <label id="item_eattime_value"/>
                            </div>
                            <div style="height: 40px;width: 208px;border-bottom: 1px outset red;float: top;position: relative;margin-bottom: 1px">
                                <i>Expiring on : </i> <label id="item_exp_value"/>
                            </div>
                            <div style="height: 40px;width: 208px;border-bottom: 1px outset red;float: top;position: relative;margin-bottom: 1px">
                                <i>Kept in: </i><label id="item_location_value"/>
                            </div>
                            <div style="height: 20px;width: 208px;border-bottom: 1px outset red;float: top;position: relative;margin-bottom: 1px">
                                <i>Item is  </i> <label id="item_opened_value"/>
                            </div>
                    <center>
                            <div style="width: 208px;border-bottom: float: top;position: relative;margin-bottom: 1px" id="item_save_button">
                                <button type="button" class="btn btn-primary" onclick="saveItem();">
                                    Save item
                                </button>
                            </div>
                        </center>
                </div>
                <form name="itemsform" method="POST">
                            <input type="hidden" id="item_type_hidden" name="item_type_hidden">
                            <input type="hidden" id="item_name_hidden" name="item_name_hidden">
                            <input type="hidden" id="item_desc_hidden" name="item_desc_hidden">
                            <input type="hidden" id="item_eattime_hidden" name="item_eattime_hidden">
                            <input type="hidden" id="item_exp_hidden" name="item_exp_hidden">
                            <input type="hidden" id="item_location_hidden" name="item_location_hidden">
                            <input type="hidden" id="item_opened_hidden" name="item_opened_hidden">
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"/>
</body>
</html>