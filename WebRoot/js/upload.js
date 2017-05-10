function additem(){
  var tr=document.createElement("tr");
  var td=document.createElement("td");
  var file=document.createElement("input");
  var but=document.createElement("input");
  file.setAttribute("type", "file");
  file.setAttribute("name", "img");
  but.type="button";
  but.setAttribute("value", "删除");
  but.setAttribute("onclick", "delitem(this)");
  td.appendChild(file);
  td.appendChild(but);
  tr.appendChild(td);
  var tbody=document.getElementsByTagName("tbody")[1];
    tbody.appendChild(tr);
} 
function delitem(del){
  var tr=del.parentNode.parentNode;
  var tbody=document.getElementsByTagName("tbody")[1];
  tbody.removeChild(tr);
}
function check(){
  var list=document.getElementsByName("img");
  for(var i=0;i<list.length;i++){
    if(list[i].value==null||list[i].value==""){
       alert("第"+(i+1)+"号位置没有选择文件");
       return false;
     }     
  }
   return true;  
}