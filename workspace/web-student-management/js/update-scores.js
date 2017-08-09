/**
 * Created by Shli on 09/08/2017.
 */
$(document).ready(function () {
    $("#sid").text("S001");
    $("#name").text("yi");

    $("form").validate({
        rules: {
            mathScore: {
                required: true,
                range: [0, 100]
            },
            chineseScore: {
                required: true,
                range: [0, 100]
            },
            englishScore: {
                required: true,
                range: [0, 100]
            },
            programScore: {
                required: true,
                range: [0, 100]
            }
        },

        messages: {
            mathScore: {
                required: "Please input your math score",
                range: "Please input valid math score"
            },
            chineseScore: {
                required: "Please input your chinese score",
                range: "Please input valid chinese score"
            },
            englishScore: {
                required: "Please input your english score",
                range: "Please input valid english score"
            },
            programScore: {
                required: "Please input your program score",
                range: "Please input valid program score"
            }
        },

        errorLabelContainer: $("#err"),

        submitHandler: function (form) {

            form.reset();
        }
    });
});
