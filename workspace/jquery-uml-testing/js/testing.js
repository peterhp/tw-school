/**
 * Created by Shli on 02/08/2017.
 */

$(document).ready(function () {
    const student = getStudentInfo();
    student.answer.push(getAnswerForTestItem1());

    console.log(student);
});

const getStudentInfo = function () {
    return {
        id: $("#stu-id").val(),
        name: $("#stu-name").val(),
        klass: $("#stu-class").val(),
        answer: []
    };
};

const getAnswerForTestItem1 = function () {
    const answers = [];
    for (let elem of $(".t1")) {
        answers.push(elem.value);
    }
    return answers;
};
