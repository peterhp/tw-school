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
               digits: true,
               rangelength: [18, 18]
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
               digits: "Please input valid personal id.",
               rangelength: "Please input valid personal id."
           }
       },

       errorLabelContainer: $("#err"),

       submitHandler: function (form) {
           const student = getStudentInformation();
           saveStudentInStorage(student);

           $("#msg").text(`Succeed to append student [${student.sid}: ${student.name}].`);

           //form.submit();
           form.reset();
       }
   });
});

const saveStudentInStorage = function (newStudent) {
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
