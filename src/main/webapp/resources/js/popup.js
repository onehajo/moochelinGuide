function setCookie(name, value, expiredays) {
    var date = new Date();
    date.setDate(date.getDate() + expiredays);
    document.cookie = escape(name) + "=" + escape(value) + "; expires=" + date.toUTCString();
}

function closePopup() {
    if (document.getElementById("check").value) {
        setCookie("popupYN", "N", 1);
        self.close();
    }
}