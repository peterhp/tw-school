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
const KEY_REPORT = "stu-report";

const initStorage = function () {
   initDataInStorage(KEY_CURRENT_SID, "100");
   initDataInStorage(KEY_STUDENT_LIST, "[]");
   initDataInStorage(KEY_REPORT, JSON.stringify({
       items: [
           {
               sid: "S003",
               name: "San",
               math: 75,
               chinese: 95,
               english: 80,
               program: 80,
               total: 330,
               average: 82.5
           },
           {
               sid: "S004",
               name: "Si",
               math: 85,
               chinese: 80,
               english: 70,
               program: 90,
               total: 325,
               average: 81.25
           }
       ],
       average: 327.5,
       median: 327.5
   }));
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
