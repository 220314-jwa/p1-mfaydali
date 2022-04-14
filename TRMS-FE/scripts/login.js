function supportsLocalStorage () {
    try {
        return 'localStorage' in window && window['localStorage'] !== null;
    } catch (e) {
        console.log('You dont have local storage');
        return false;
    }
}


// Dont ask
async function signIn() {
    let employeeId = document.getElementById("employeeId").value;
    let url = `http://localhost:5432/employees?employeeId=${employeeId}}`;

    isLocalStorage = supportsLocalStorage();
    //console.log("Your browser supports local storage?"  + isLocalStorage)


    let httpResponse = await fetch(`http://localhost:5432/employees`);
    

    let employees = await httpResponse.json();
    let status = await httpResponse.status;
    console.log(status);
    
    breakme: if(true) {
        // for each employee in employees
        for (const key in employees) {
            if (Object.hasOwnProperty.call(employees, key)) {
                const employee = employees[key];
                // if there is a match to sign in credentials, add that employee to local storage
                if (employee.employeeId == 0) {
                    //console.log("we have a match! " + employee.name); 
                    localStorage.setItem("employeeId", employee.employeeId);
                    window.location.replace("index.html");

                    //break all the way out
                    break breakme;
                }
            } 
        }
        // otherwise alert there is no match
        alert("No user found with these credentials Please try again.");
    }
}