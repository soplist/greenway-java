
  $(document).ready(function() {
      $.ajax({
          url : "drawTimeLine.action",
          type : "post",
          dataType : "json",
          success : drawLine,
          error: function(){
               alert('error\n');
          }
      });
  });
  function drawLine(result)
  {
  	var objs = eval(result);
  	document.write("<div id='layer' style='position:absolute; width:300px; height:500px; z-index:1; left: 890px; top: 77px;filter:alpha(opacity=50);-moz-opacity:0.5;opacity:0.5;background-color:blue'></div>");
  	document.write("<div id='event_1' style='position:absolute; width:260px; z-index:1; left: 900px; top: 80px;filter:alpha(opacity=50);-moz-opacity:0.5;opacity:0.5;background-color:red'>test</div>");
  	for(j in objs){
  		//alert(parseFloat(j)+1);
  		//var i = j+1;
  		//alert("x="+objs[j].x+",y="+objs[j].y+"x+1="+objs[i].x+",y+1="+objs[i].y);
  		drawDot(objs[j].x,objs[j].y,"#0000cc",2);
  		drawLine_1(objs[j].x,objs[j].y,objs[parseFloat(j)+1].x,objs[parseFloat(j)+1].y,"#0000cc",2,0);
  	}
}
function drawDot(x,y,color,size)
{
  document.write("<table border='0' cellspacing=0 cellpadding=0><tr><td style='position: absolute; left: "+(x)+"; top: "+(y)+";background-color: "+color+"' width="+size+" height="+size+"></td></tr></table>");
  //$("#event").append("<div id='Layer1' style='position:absolute; width:260px; z-index:1; left: 50px; top: 77px;filter:alpha(opacity=50);-moz-opacity:0.5;opacity:0.5;background-color:blue'>testtesttest</div>");
  //time_line+="<table border='0' cellspacing=0 cellpadding=0><tr><td style='position: absolute; left: "+(x)+"; top: "+(y)+";background-color: "+color+"' width="+size+" height="+size+"></td></tr></table>";
}

function drawLine_1(x1,y1,x2,y2,color,size,style)
{
  var i;
  var r=Math.floor(Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
  var theta=Math.atan((x2-x1)/(y2-y1));
  if(((y2-y1)<0&&(x2-x1)>0)||((y2-y1)<0&&(x2-x1)<0))
  {
   theta = Math.PI + theta;
  }
  var dx=Math.sin(theta);
  var dy=Math.cos(theta);
  for(i=0;i<r;i++){
    switch(style){
      case 0:
        drawDot(x1+i*dx,y1+i*dy,color,size);
        break;
      case 1:
        i+=size*2;
        drawDot(x1+i*dx,y1+i*dy,color,size);
        break;
      case 2:
        if(Math.floor(i/4/size)%2==0){
          drawDot(x1+i*dx,y1+i*dy,color,size);
        }
        else{
            i+=size*2;
            drawDot(x1+i*dx,y1+i*dy,color,size);
        }
        break;
      default:
        drawDot(x1+i*dx,y1+i*dy,color,size);
        break;
    }
  }
}

