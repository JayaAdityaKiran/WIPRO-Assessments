let userName = "Jaya Aditya";
let age = "22";
let isSubscribed = "true";

// For validation

function validateForm(){
    let userNmeType = typeof userName;
    let ageType = typeof age;
    let isSubscribedType = typeof isSubscribed;

    console.log("Username : "+userName + "Data Type : "+userNmeType);
    console.log("Age : "+age + "Data Type : "+ageType);
    console.log("isSubcribed : "+isSubscribed + "Data Type : "+isSubscribedType);

    // conversion

    age = Number(age);
    isSubscribed = isSubscribed === "true"; // output will be true

    console.log("Age : "+age + "After conversion the Data Type is : "+typeof age);
    console.log("isSubcribed : "+isSubscribed + "After conversion the Data Type is : "+ typeof isSubscribed);

}
validateForm(userName , age , isSubscribed);