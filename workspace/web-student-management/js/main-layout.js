/**
 * Created by Shli on 03/08/2017.
 */

$(function () {
   retrieveLayoutElements();
   initStorage();
});

const retrieveLayoutElements = function () {
    $("header").load("header.html");
    $("footer").load("footer.html");
};

const KEY_CURRENT_SID = "cur-sid";
const KEY_STUDENT_LIST = "stu-list";

const initStorage = function () {
   initDataInStorage(KEY_CURRENT_SID, "100");
   initDataInStorage(KEY_STUDENT_LIST, "[]");
};

const initDataInStorage = function (key, value) {
    if (!isExistInStorage(key)) {
       saveDataInStorage(key, value);
    }
};

const isExistInStorage = function (key) {
    return (localStorage.getItem(key) != null);
};

const saveDataInStorage = function (key, value) {
    localStorage.setItem(key, value);
};

const getDataInStorage = function (key) {
    return localStorage.getItem(key);
};
