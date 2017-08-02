/**
 * Created by Shli on 02/08/2017.
 */

$(document).ready(function () {
   $("#main-form").submit(function (event) {
       if (validateTestInfo()) {
           saveTestData();
           window.location.replace("answer-sheet.html");
       } else {
           alert("个人信息错误或不全，请正确填写！");
           event.preventDefault();
       }
   });
});

const saveTestData = function () {
    return sessionStorage.setItem("student",
            JSON.stringify(parseStudentFromFormArray(
                $("#main-form").serializeArray())));
};

const parseStudentFromFormArray = function(form) {
    const student = getStudentTemplate();

    for (let input of form) {
        if (typeof student[input.name] != "undefined") {
            student[input.name] = input.value;
        } else {
            let {t, q} = parseFieldsForName(input.name);
            if (typeof student.answer[t][q] === "string") {
                student.answer[t][q] = input.value;
            } else {
                student.answer[t][q].push(input.value);
            }
        }
    }

    return student;
};

const parseFieldsForName = function (name) {
    const fields = name.split(".");
    return {
        t: fields[0],
        q: "q" + fields[1]
    };
};

const getStudentTemplate = function () {
    return {
        klass: "",
        sid: "",
        name: "",
        email: "",
        pid: "",
        answer: {
            t1: {
                q1: "",
                q2: []
            },
            t2: {
                q1: "",
                q2: ""
            },
            t3: {
                q1: [],
                q2: []
            },
            t4: {
                q1: "",
                q2: ""
            },
            t5: {
                q1: ""
            }
        }
    };
};
