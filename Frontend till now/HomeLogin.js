let cName= "Jake";
let cId= 123;
let cPass= 456;

let eName= "Mary";
let eId= 789;
let ePass= 890;
function customer()
{
    if((document.getElementById("c_user").value=="Jake"&& document.getElementById("c_pass").value==456)||(document.getElementById("c_user").value==123&& document.getElementById("c_pass").value==456))
        location.href="ordercustomer.html";
    else
        alert("Validation Failed");
  
    /* if( document.getElementById("tab-1") == true )
   window.location.href="login.html"
    else if(document.getElementById("tab-2") == true)
    window.location.href = "signup.html"
    else
    alert("invalid")*/
    
}

function employee(){
    if((document.getElementById("e_user").value=="Mary"&& document.getElementById("e_pass").value==890)||(document.getElementById("e_user").value==789&& document.getElementById("e_pass").value==890)){
        window.location.href="Emp_ListOfOrder.html";
    }
    
    else
        alert("Validation Failed");
    
    
}

