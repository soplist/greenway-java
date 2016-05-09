  $(document).ready(function() {
          $("#btn").click(function() {
               var message = $("#message").val();
               var params = $("form").serialize();
               if(message=="")
                  return;
               //$.post('sendMessage.action',{'message.content':message},function(data){alert(data);})
               $.ajax({
                   url : "sendMessage.action",
                   type : "post",
                   dataType : "json",
                   data : params,
                   success : update_page,
                   error: function(){
                     alert('error\n');
                   }
               });
               $("#message").attr("value","");
          });
     });
    function update_page(result) {
        //alert("hehe");
        var objs = eval(result);
        /*
        for(j in objs){
            alert(objs[j].content);
        }*/
        //alert(objs[0].content);
        //$("#post_message").append(objs[0].content);
        //document.getElementById('post_message').id='aaa';
        document.getElementById("post_message").innerHTML=objs[0].content;
        document.getElementById("result").outerHTML = "<div id='result'><a id='post_message' href='#'></a></div>"
        	+document.getElementById("result").outerHTML;
        
    } 