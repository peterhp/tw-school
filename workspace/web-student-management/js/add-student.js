/**
 * Created by Shli on 03/08/2017.
 */

$(document).ready(function () {
   $("form").validate({
       rules: {
           name: "required",
           gender: "required",
           class: "required",
           native: "required",
           phone: {
               required: true,
               digits: true
           },
           email: {
               required: true,
               email: true
           },
           pid: {
               required: true,
               digits: true
           },
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
           name: "Please input your name.",
           gender: "Please select your gender.",
           class: "Please input your class.",
           native: "Please select your native place.",
           phone: {
               required: "Please input your phone number.",
               digits: "Please input valid phone number."
           },
           email: {
               required: "Please input your email.",
               email: "Please input valid email."
           },
           pid: {
               required: "Please input your personal id.",
               digits: "Please input valid personal id."
           },
           mathScore: {
               required: "Please input your score",
               range: "Please input valid score"
           },
           chineseScore: {
               required: "Please input your score",
               range: "Please input valid score"
           },
           englishScore: {
               required: "Please input your score",
               range: "Please input valid score"
           },
           programScore: {
               required: "Please input your score",
               range: "Please input valid score"
           }
       },

       errorLabelContainer: $("#err"),

       submitHandler: function (form) {
           submitToRemote("http://localhost:8080/students", generateStudentFromForm());

           form.reset();
       }
   });
});

const submitToRemote = function (url, student) {
    $.ajax({
        url: url,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(student),
        dataType: "json",
        statusCode: {
            200: function (){
                $("#msg").text(`Succeed to append student [${student.name}].`);
            },
            406: function () {
                $("#msg").text(`Fail to append student [${student.name}].`);
            }
        }
    });
};

const submitToStorage = function () {
    const student = generateStudentForStorage();
    saveStudentInStorage(student);
    $("#msg").text(`Succeed to append student [${student.name}].`);
};

const saveStudentInStorage = function (newStudent) {
    const students = JSON.parse(getDataInStorage(KEY_STUDENT_LIST));

    students.push(newStudent);
    saveDataInStorage(KEY_STUDENT_LIST, JSON.stringify(students));
};

const generateStudentForStorage = function () {
    const student = generateStudentFromForm();
    student.sid = generateSidFromStorage();
    return student;
};

const generateSidFromStorage = function () {
    const sid = parseInt(getDataInStorage(KEY_CURRENT_SID)) + 1;
    saveDataInStorage(KEY_CURRENT_SID, sid.toString());
    return `S${sid}`;
};

const generateStudentFromForm = function () {
    const inputs = $("form").serializeArray();
    const student = {};
    for (let kv of inputs) {
        student[kv.name] = kv.value;
    }
    return student;
};
