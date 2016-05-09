

function ShowNo()
    {
        document.getElementById("doing").style.display = "none";
        document.getElementById("divLogin").style.display = "none";
    }
    function showFloat()
    {
    	var range = getRange();
        
        $("doing").width(range.width + "px");
        $("doing").width(range.height + "px");
        document.getElementById("doing").style.display = "block";
        document.getElementById("divLogin").style.display = "";
    }
    function getRange()
    {
        var top = document.body.scrollTop;
        var left = document.body.scrollLeft;
        var height = document.body.clientHeight;
        var width = document.body.clientWidth;

        if (top == 0 && left == 0 && height == 0 && width == 0) {
            top = document.documentElement.scrollTop;
            left = document.documentElement.scrollLeft;
            height = document.documentElement.clientHeight;
            width = document.documentElement.clientWidth;
        }
        return { top: top, left: left, height: height, width: width };
    } 

 function Login() {
        var username = document.getElementById("txtUserName").value;
        var pwd = document.getElementById("txtPwd").value;
        if (username == "" || pwd == "") {
            alert("please input username and password");
            return;
        }
        var div = document.getElementById("userinfo");
        alert("haha");
        var params = $("form").serialize();
        
        //$.post('sendMessage.action',{'message.content':message},function(data){alert(data);})
        $.ajax({
            url : "login.action",
            type : "post",
            dataType : "text",
            cache: false,
            async: true,
            data : params,
            success : update_page,
            error: function(error){
              alert(error);
            }
        });
 }
 function update_page(result) {
	 if(result=="0")
		alert("user does not exit");
	 else{
		 window.location.href="login_index.jsp";
	 }
 } 

