console.log("Welcome to jQuery");

// $("p.class_p2").hide(); // p2 class of paragraph 2
// $("#id_p1").hide(); // p1 id of paragraph 1

$("#btn_hide").click(function(){

    // $(".class_p2").hide();

    // $(".class_p2").text("Done by jQuery ")

    // document.write($(".second").text());

    // with this you will get only text 
    // console.log($(".second").text());

    // with this you will html elements and text both
    // console.log($(".second").html());
})

$("body").keydown(function(){

    // console.log(event.which); // which is the number when we press any key on keyboard when on site...in console it gives number

})

$("body").keydown(function(event){

    if(event.which == 65){
        $(".class_p2").hide(2000,function(){
            console.log("task complete");
        })
    }
    if(event.which == 68){
        $(".class_p2").show(2000,function(){
            console.log("task complete");
        })
    console.log(event.which);
    }

})

// The best practice is when you write you JS or jQuery code then 
// use document ready function which will ensure that our full content is loaded

$(document).ready(function(){
$("#btn_hide").click(function(){
    // for hide and show all together you can use toggle
    $(".class_p2").toggle(2000, function()
{
 console.log("Toggle done");   
});
});
});

$(document).ready(function(){
$("#fading_effect").click(function(){
    // $(".p3").fadeOut();
   $(".p3").fadeTo("slow", 0.1);
});
});

// for slide toggle
$(document).ready(function(){
$("#btn_hide").click(function(){
    // for hide and show all together you can use toggle
    $(".class_p2").slideDown();
});
});


//Box effects

// for slide toggle
$(document).ready(function(){
$("#Box").click(function(){
    // for hide and show all together you can use toggle
    $(".box").animate({
        width: "+=200px",
        height: "200px",
        fontSize:"20px"
    },"slow");
});
});

// in fadeTo we may pass the speed as slow with opacity in between 0 and 1
$("body").keydown(function(event){
    if(event.which === 65)
    {
        $(".second").hide(2000 ,function(){
            console.log("task completed");
        });
    }

     if(event.which === 68)
    {
        $(".second").show(2000 ,function(){
            console.log("task completed");
    });
    console.log(event.which);
}
});