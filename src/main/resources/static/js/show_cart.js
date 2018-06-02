$(document).ready(function(){

    $.ajax({url: "http://localhost:8080/get_all_cart", success: function(result) {
            var cart_contents = [];
            var cart_requests = [];
            for (var res in result){
                if (result[res]['contents']){
                    cart_contents.push(result[res]['contents'])
                    console.log(result[res]['contents'])
                    var item = result[res]['contents'].replace("=", " ");

                    $("p").append(item + "</b>")
                }
                if (result[res]['user_request']){
                    console.log("user requests" + result[res]['user_request'])
                    cart_requests.append(result[res]['contents']);
                    $("#special_requests").append(result[res]['user_request'] + "<span class=\"label label-info\">In progress </span>");
                }

            }
        }});


});