const api_url = 
      "http://localhost:8081/api/trains";
  
// Defining async function
async function getapi(url) {
    
    // Storing response
    const response = await fetch(url);
    
    // Storing data in form of JSON
    var data = await response.json();
    console.log(data);
    if (response) {
        hideloader();
    }
    show(data);
}
// Calling that async function
getapi(api_url);
  
// Function to hide the loader
function hideloader() {
    document.getElementById('loading').style.display = 'none';
}


function show(data) {
    let tab = 
        `<tr>
          <th>Train_no</th>
          <th>Train_name</th>
          <th>source</th>
          <th>Destination</th>
          <th>Price</th>
         </tr>`;
    
    // Loop to access all rows 
    for (let r of data.list) {
        tab += `<tr> 
    <td>${r.train_no} </td>
    <td>${r.train_name}</td>
    <td>${r.source}</td> 
    <td>${r.destination}</td> 
    <td>${r.price}</td>          
</tr>`;
    }
    // Setting innerHTML as tab variable
    document.getElementById("employees").innerHTML = tab;
}