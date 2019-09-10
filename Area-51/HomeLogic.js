
let deadline = new Date("Sep 20, 2019 03:00").getTime();

let x = setInterval(function(){
    let now = new Date().getTime();
    let distance = deadline - now;

    // time calculation
    let days = Math.floor(distance / (1000 *60*60*24));
    let hours = Math.floor((distance % (1000 *60*60*24)) / (1000*60*60));
    let minutes = Math.floor((distance % (1000 *60*60)) / (1000*60));
    let seconds = Math.floor((distance % (1000*60)) / (1000));

    document.getElementById("day").innerHTML =days ; 
    document.getElementById("hour").innerHTML =hours; 
    document.getElementById("minute").innerHTML = minutes;  
    document.getElementById("second").innerHTML =seconds;  
    
    if(distance < 0){
        clearInterval(x);
        document.getElementById("demo").innerHTML = "TIME'S UP RAID IS OVER!"; 
        document.getElementById("day").innerHTML ='00'; 
        document.getElementById("hour").innerHTML ='00'; 
        document.getElementById("minute").innerHTML ='00' ;  
        document.getElementById("second").innerHTML = '00';
    }
},1000);