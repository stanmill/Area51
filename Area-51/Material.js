function TodaysDate(){
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1;
    var yyyy = today.getFullYear();

    if(dd<10) {
        dd = '0' + dd
    } 

    if(mm<10) {
    mm = '0' + mm
    } 

    date = mm + '/' + dd + '/' + yyyy;
        return date
    }
    
showCookies = () => {
 
 document.cookie = "UserName = Naruto Runner, DateVisited =" + TodaysDate();
 
 alert(document.cookie);
}

var id;

function getData(){
var xmlhttp = new XMLHttpRequest();
 xmlhttp.onreadystatechange = function() {
     if (this.readyState == 4 && this.status == 200) {
        var myObj = JSON.parse(this.responseText);
        id = myObj.length;
         console.log(myObj); 
         LoadTable(myObj);
     }
};
 xmlhttp.open("GET", "http://localhost:8080/api/materials", true);
 xmlhttp.send();
}

function LoadTable(myObj) {
// EXTRACT VALUE FOR HTML HEADER. 
var col = [];
for (var i = 0; i < myObj.length; i++) {
    for (var key in myObj[i]) {
        if (col.indexOf(key) === -1) {
            col.push(key);
        }
    }
}

// CREATE DYNAMIC TABLE.
var table = document.createElement("table");


// CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

var tr = table.insertRow(-1);                   // TABLE ROW.

for (var i = 1; i < col.length; i++) {
    var th = document.createElement("th");      // TABLE HEADER.
    th.innerHTML = col[i];
    tr.appendChild(th);
}
    
// ADD JSON DATA TO THE TABLE AS ROWS.
for (let i = 0; i < myObj.length; i++) {

    tr = table.insertRow(-1);

    for (var j = 1; j < col.length; j++) {
       
        var tabCell = tr.insertCell(-1);
        console.log(myObj[i][col[j]])
        if(col[j] === "picture"){
            var img = new Image();
            img.src = myObj[i][col[j]];
            img.setAttribute("class", "img-fluid rounded");
            tabCell.appendChild(img);
        }
        else
            tabCell.innerHTML = myObj[i][col[j]];
    }
}

// FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
var divContainer = document.getElementById("demo");
divContainer.innerHTML = "";
divContainer.appendChild(table);
}

window.onload = getData();

function addToDatabase() {
    xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8080/api/materials", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");

    let items = document.getElementById("item").value;
    let newitems = parseInt(items);
    let name = document.getElementById("name").value;
    let newname = String(name);
    let picture = document.getElementById("picture").value;
    let newpicture = String(picture);
    let cost = document.getElementById("cost").value;
    let newcost = String(cost);
     id += 1;

    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            var json = JSON.parse(xmlhttp.responseText);
            console.log(json.name + ", "+ json.name);

        }
    }
    let jsonObject = JSON.stringify({"id":id,"numOfItems": newitems,"name": newname, "picture": newpicture,"cost": newcost});
    
    xmlhttp.send(jsonObject);
    
    document.getElementById("item").value = "";
    document.getElementById("name").value = "";
    document.getElementById("picture").value = "";
    document.getElementById("cost").value = "";   
}

function deleteFromDatabase(){
    
    var deleteId = document.getElementById("deletion").value;
    
    xmlhttp = new XMLHttpRequest();
    xmlhttp.open("DELETE", "http://localhost:8080/api/materials/" + deleteId, true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send();

    document.getElementById("deletion").value = "";
}

function updateToDatabase() {

    let items = document.getElementById("item").value;
    let newitems = parseInt(items);
    let name = document.getElementById("name").value;
    let newname = String(name);
    let picture = document.getElementById("picture").value;
    let newpicture = String(picture);
    let cost = document.getElementById("cost").value;
    let newcost = String(cost);
    let newId = document.getElementById("deletion").value;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.open("PUT","http://localhost:8080/api/materials", true);
    xmlhttp.setRequestHeader("Content-Type", "application/json");

    let jsonObject = JSON.stringify({"id":newId,"numOfItems": newitems,"name": newname, "picture": newpicture,"cost": newcost});
    console.log(jsonObject+"updated");
    xmlhttp.send(jsonObject);
    
    document.getElementById("item").value = "";
    document.getElementById("name").value = "";
    document.getElementById("picture").value = "";
    document.getElementById("cost").value = "";  
    document.getElementById("deletion").value = "";
}
        