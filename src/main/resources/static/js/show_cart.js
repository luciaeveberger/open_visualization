$(document).ready(function(){
    var count = 0;
    $.ajax({url: "/get_all_cart", success: function(result) {
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
                    cart_requests.push(result[res]['contents']);
                    var request = result[res]['contents'].replace("+", " ");
                    $("#special_requests").append("Request" + count + "</b>");
                    count = count + 1;

                }

            }
        }});


});