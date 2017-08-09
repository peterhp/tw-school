/**
 * Created by Shli on 09/08/2017.
 */

$.urlParam = function (key) {
    const regex = new RegExp(`[\?&]${key}=([^&]*)`);
    const result = regex.exec(window.location.href);
    return (result ? decodeURIComponent(result[1]) : "");
};

const sid = $.urlParam("sid");
const name = $.urlParam("name");

$(document).ready(function () {
    initScoresPage();

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
            updateStudentScores(
                `http://localhost:8080/students/${sid}/scores`,
                getScoresFromForm());
        }
    });

    $("form").on("reset", function (event) {
        event.preventDefault();

        $("#err").html("");
        initScoresPage();
    });
});

const initScoresPage = function () {
    $("#sid").text(sid);
    $("#name").text(name);
    obtainAndDisplayStudentScores(
        `http://localhost:8080/students/${sid}/scores`);
};

const obtainAndDisplayStudentScores = function (url) {
    $.ajax({
        url: url,
        method: "GET",
        dataType: "json",
        success: function (data) {
            displayStudentScores(data);
        }
    });
};

const updateStudentScores = function (url, scores) {
    $.ajax({
        url: url,
        method: "PUT",
        contentType: "application/json",
        data: JSON.stringify(scores),
        dataType: "json",
        statusCode: {
            200: function () {
                $("#msg").text(`Succeed to update course scores for student ${name}.`);
            },
            404: function () {
                $("#msg").text(`Fail to update course scores for student ${name}.`);
            }
        }
    });
};

const displayStudentScores = function (scores) {
    $("input[name='mathScore']").val(scores.mathScore);
    $("input[name='chineseScore']").val(scores.chineseScore);
    $("input[name='englishScore']").val(scores.englishScore);
    $("input[name='programScore']").val(scores.programScore);
};

const getScoresFromForm = function () {
    const inputs = $("form").serializeArray();

    const scores = {};
    for (let kv of inputs) {
        scores[kv.name] = kv.value;
    }
    return scores;
};
