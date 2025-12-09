alert("Calling app.js file content")

let age = 15; // Number // cannot be redifeined
const myName = "Aditya"; // String // use const when the value of the variable is going to be constant
var isTrue = true; // Boolean // use var when the variable is being used as a local variable inside a funtion and can be redifined as well

console.log(typeof(age)); // Output --- Number
console.log(typeof(myName)); // Output --- String
console.log(typeof(isTrue)); // Output --- Boolean

// Conversion

let score = "100";
let toIntScore = Number(score)

let sum = 5+4; // 5-4 , 5*4 , 5/4 , 5%4
console.log("The Value of sum is : "+sum);