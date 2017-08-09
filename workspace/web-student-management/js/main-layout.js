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
               mathScore: 75,
               chineseScore: 95,
               englishScore: 80,
               programScore: 80,
               totalScore: 330,
               averageScore: 82.5
           },
           {
               sid: "S004",
               name: "Si",
               mathScore: 85,
               chineseScore: 80,
               englishScore: 70,
               programScore: 90,
               totalScore: 325,
               averageScore: 81.25
           }
       ],
       averageTotalScore: 327.5,
       medianTotalScore: 327.5
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
