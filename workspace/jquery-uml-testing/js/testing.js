/**
 * Created by Shli on 02/08/2017.
 */

$(document).ready(function () {
    $("#submit").click(function () {
        saveTestData(getStudentAndItsAnswers());
    });
});

const saveTestData = function (student) {
    sessionStorage.setItem("student", JSON.stringify(student));
}

const getStudentAndItsAnswers = function () {
    const student = getStudentInfo();

    student.answer.t1 = getAnswerForTestItem1();
    student.answer.t2 = getAnswerForTestItem2();
    student.answer.t3 = getAnswerForTestItem3();
    student.answer.t4 = getAnswerForTestItem4();
    student.answer.t5 = getAnswerForTestItem5();

    return student;
};

const getStudentInfo = function () {
    return {
        sid: $("#stu-id").val(),
        name: $("#stu-name").val(),
        klass: $("#stu-class").val(),
        answer: {}
    };
};

const getAnswerForTestItem1 = function () {
    return {
        q1: $("input[name='t1.1']").val(),
        q2: $("input[name='t1.2']").map(function () {return $(this).val();}).get()
    };
};

const getAnswerForTestItem2 = function () {
    return {
        q1: $("input[name='t2.1']:checked").val(),
        q2: $("input[name='t2.2']:checked").val()
    };
};

const getAnswerForTestItem3 = function () {
    return {
        q1: $("input[name='t3.1']:checked").map(function () {return $(this).val();}).get(),
        q2: $("input[name='t3.2']:checked").map(function () {return $(this).val();}).get()
    };
};

const getAnswerForTestItem4 = function () {
    return {
        q1: $("input[name='t4.1']:checked").val(),
        q2: $("input[name='t4.2']:checked").val()
    };
};

const getAnswerForTestItem5 = function () {
    return {
        q1: $("textarea[name='t5.1']").text()
    };
};
