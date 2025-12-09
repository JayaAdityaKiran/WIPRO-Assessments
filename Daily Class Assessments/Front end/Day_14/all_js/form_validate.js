// add event listner will capture the form details from html form after we hit the submit button
document.getElementById("registrationForm").addEventListener("submit",function(event){
    event.preventDefault(); // will not reload the page automatically
    let userName = document.getElementById("username").value;
    let userAge = document.getElementById("age").value;
    let subscribed = document.getElementById("isSubscribed").value;

    console.log(userName);
    console.log(userAge);
    console.log(subscribed);
    alert("Form Submitted!!")

});