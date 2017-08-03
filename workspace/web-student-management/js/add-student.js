/**
 * Created by Shli on 03/08/2017.
 */

$(document).ready(function () {
   $("form").validate({
       rules: {
           name: "required",
           gender: "required",
           class: "required"
       },

       messages: {
           name: "Please input your name.",
           gender: "Please select your gender.",
           class: "Please input your class."
       },

       errorLabelContainer: $("#msg"),

       submitHandler: function (form) {
           form.submit();
       }
   });
});
