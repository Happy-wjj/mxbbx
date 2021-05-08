(function (e) {
    "function" == typeof define && define.amd ? define(["jquery", "moment"], e) : e(jQuery, moment)
})(function (e, t) {
    function a(e, t) {
        var a = e.split("_");
        return 1 === t % 10 && 11 !== t % 100 ? a[0] : t % 10 >= 2 && 4 >= t % 10 && (10 > t % 100 || t % 100 >= 20) ? a[1] : a[2]
    }

    function n(e, t, n) {
        var r = {mm: "хвилина_хвилини_хвилин", hh: "година_години_годин", dd: "день_дні_днів", MM: "місяць_місяці_місяців", yy: "рік_роки_років"};
        return"m" === n ? t ? "хвилина" : "хвилину" : "h" === n ? t ? "година" : "годину" : e + " " + a(r[n], +e)
    }

    function r(e, t) {
        var a = {nominative: "січень_лютий_березень_квітень_травень_червень_липень_серпень_вересень_жовтень_листопад_грудень".split("_"), accusative: "січня_лютого_березня_квітня_травня_червня_липня_серпня_вересня_жовтня_листопада_грудня".split("_")}, n = /D[oD]? *MMMM?/.test(t) ? "accusative" : "nominative";
        return a[n][e.month()]
    }

    function i(e, t) {
        var a = {nominative: "неділя_понеділок_вівторок_середа_четвер_п’ятниця_субота".split("_"), accusative: "неділю_понеділок_вівторок_середу_четвер_п’ятницю_суботу".split("_"), genitive: "неділі_понеділка_вівторка_середи_четверга_п’ятниці_суботи".split("_")}, n = /(\[[ВвУу]\]) ?dddd/.test(t) ? "accusative" : /\[?(?:минулої|наступної)? ?\] ?dddd/.test(t) ? "genitive" : "nominative";
        return a[n][e.day()]
    }

    function o(e) {
        return function () {
            return e + "о" + (11 === this.hours() ? "б" : "") + "] LT"
        }
    }

    t.lang("uk", {months: r, monthsShort: "січ_лют_бер_квіт_трав_черв_лип_серп_вер_жовт_лист_груд".split("_"), weekdays: i, weekdaysShort: "нд_пн_вт_ср_чт_пт_сб".split("_"), weekdaysMin: "нд_пн_вт_ср_чт_пт_сб".split("_"), longDateFormat: {LT: "HH:mm", L: "DD.MM.YYYY", LL: "D MMMM YYYY р.", LLL: "D MMMM YYYY р., LT", LLLL: "dddd, D MMMM YYYY р., LT"}, calendar: {sameDay: o("[Сьогодні "), nextDay: o("[Завтра "), lastDay: o("[Вчора "), nextWeek: o("[У] dddd ["), lastWeek: function () {
        switch (this.day()) {
            case 0:
            case 3:
            case 5:
            case 6:
                return o("[Минулої] dddd [").call(this);
            case 1:
            case 2:
            case 4:
                return o("[Минулого] dddd [").call(this)
        }
    }, sameElse: "L"}, relativeTime: {future: "за %s", past: "%s тому", s: "декілька секунд", m: n, mm: n, h: "годину", hh: n, d: "день", dd: n, M: "місяць", MM: n, y: "рік", yy: n}, meridiem: function (e) {
        return 4 > e ? "ночі" : 12 > e ? "ранку" : 17 > e ? "дня" : "вечора"
    }, ordinal: function (e, t) {
        switch (t) {
            case"M":
            case"d":
            case"DDD":
            case"w":
            case"W":
                return e + "-й";
            case"D":
                return e + "-го";
            default:
                return e
        }
    }, week: {dow: 1, doy: 7}}), e.fullCalendar.datepickerLang("uk", "uk", {closeText: "Закрити", prevText: "&#x3C;", nextText: "&#x3E;", currentText: "Сьогодні", monthNames: ["Січень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень", "Серпень", "Вересень", "Жовтень", "Листопад", "Грудень"], monthNamesShort: ["Січ", "Лют", "Бер", "Кві", "Тра", "Чер", "Лип", "Сер", "Вер", "Жов", "Лис", "Гру"], dayNames: ["неділя", "понеділок", "вівторок", "середа", "четвер", "п’ятниця", "субота"], dayNamesShort: ["нед", "пнд", "вів", "срд", "чтв", "птн", "сбт"], dayNamesMin: ["Нд", "Пн", "Вт", "Ср", "Чт", "Пт", "Сб"], weekHeader: "Тиж", dateFormat: "dd/mm/yy", firstDay: 1, isRTL: !1, showMonthAfterYear: !1, yearSuffix: ""}), e.fullCalendar.lang("uk", {defaultButtonText: {month: "Місяць", week: "Тиждень", day: "День", list: "Порядок денний"}, allDayText: "Увесь день"})
});