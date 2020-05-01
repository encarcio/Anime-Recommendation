window.onload = function () {
    function fadeOutEffect() {
        var div = document.getElementById('div1');
        var i = Math.floor((Math.random() * 4));
        document.body.style.backgroundImage = 'url("' + BackgroundImg[i] + '")';
    }
    window.setInterval(changeImage, 5000);
}