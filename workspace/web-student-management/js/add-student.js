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

       errorLabelContainer: $("#err"),

       submitHandler: function (form) {
           const student = getStudentInformation();
           saveStudentInLocalStorage(student);

           $("#msg").text(`Succeed to append student ${student.name}.`);

           //form.submit();
           form.reset();
       }
   });
});

const saveStudentInLocalStorage = function (newStudent) {
    const students = JSON.parse(getDataInStorage(KEY_STUDENT_LIST));

    students.push(newStudent);
    saveDataInStorage(KEY_STUDENT_LIST, JSON.stringify(students));
};

const getStudentInformation = function () {
    const inputs = $("form").serializeArray();

    const student = {sid: generateSidForNewStudent()};
    for (let kv of inputs) {
        student[kv.name] = kv.value;
    }

    return student;
};

const generateSidForNewStudent = function () {
    const sid = parseInt(getDataInStorage(KEY_CURRENT_SID)) + 1;
    saveDataInStorage(KEY_CURRENT_SID, sid.toString());
    return `S${sid}`;
};
