
Jquery --- It is a fast, lightweight and very popular JS Library for adding animations, interactions, Ajax functionality and Cross-browser Compatibility to your web application

ex: 

in JS,

const element = document.getElementbyId("btn);
element.addEventListener("click", function(){

    document.getElementbyId("output").innerHTML = "sdfsdf";

})

in Jquery,

$("#btn").click(function(){

    $("output").html("fslfjl")

})

Two ways to use Jquery // even for bootstrap in our projects --

1) download a jquery/bootstrap locally -- src = "jQuery.js"
2) use CDN Links -- for this we need a constant internet connection -- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

3) syntax : 

$(selector).action()

ex --

$("p").hide()

$ is a symbol to access jquery
selector -- define the elements ( tag , class, id , attributes , attributes values)
action() -- what we want to perform 


manipulation Dom in jquery

.text() -- to set or get the text
.html() -- set or get the content with html of selected elements
.val() -- set or get the value of a form

Just use some optimized tips:

1) Dom access: cache selectors instaed of repeatedly calling document.getElementbyId()
2) Loops: use for or map instead of foreach
3) Network: use async/await with error handling
4) Images: lazy load large images (only when we click otherwise not loaded)
5) Code: JS/CSS --- cdn link bundle

If we are creating a site without optimization, there will be -

1. repeated dom calls 
2. no caching
3. mutiple parallel ajax requests

for optimization -

1. use promise.all() to fetch all data in parallel 
2. update DOM omce using a DocumentFragement
3. use async and await for readibility
