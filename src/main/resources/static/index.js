window.onload = function () {
    function changeImage() {
        var BackgroundImg = ["36630.jpg", "42079.jpg", "808516.jpg", "842599.jpg"];
        var i = Math.floor((Math.random() * 4));
        document.body.style.backgroundImage = 'url("' + BackgroundImg[i] + '")';
    }
    window.setInterval(changeImage, 5000);
}
function fadeOutEffect() {
    document.getElementById("div1").classList.add('hide');
    document.getElementById("div1").style.display = "none";
    fadeInEffect();
}
function fadeInEffect() {
    document.getElementById("nav2").classList.remove('hide');
    document.getElementById('nav2').classList.add('show');
}
function random() {
    var data = "qwert";
    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;
    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
            let response = this.responseText;
            let anime = JSON.parse(response);
            for (index in anime) {
                console.log(anime[index]);
                document.getElementById('modal_img').src = '' + anime[index];
                document.getElementById('anime_name').innerHTML=index;
            }

        }
    });
    xhr.open("POST", "https://anime-recommend.herokuapp.com/send/random");
    xhr.withCredentials = false;
    xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(data);
}
function animeList() {
    document.getElementById('btn1').classList.remove('hide');
    document.getElementById('btn2').classList.remove('hide');
    var gen = document.getElementById("inputGroupSelect01");
    var genre = gen.options[gen.selectedIndex].value;
    var exp = document.getElementById("inputGroupSelect02");
    var experience = exp.options[exp.selectedIndex].value;
    var subgen = document.getElementById("inputGroupSelect03");
    var subGenre = subgen.options[subgen.selectedIndex].value;
    var cardList = [];
    console.log(genre + " " + experience + " " + subGenre);                       /*For testing whether data is being selected from page or not*/
    var data = JSON.stringify({ "genre": genre, "exp": experience, "stream": subGenre });
    var xhr = new XMLHttpRequest();
    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
            let response = this.responseText;
            let anime = JSON.parse(response);
            Object.keys(anime).forEach(function (key) {
                console.log(key + " : " + anime[key]);
                var content =
                    `<div class="col-lg-4">
                        <div class="card shadow p-1 ">
                            <img class="card-img-top"
                                src=${anime[key]}
                                alt="anime_img">
                                <div class="card-body">
                                    <h5 class="card-title text-dark">${key}</h5>
                                </div>
                        </div>
                    </div>
                    `;
                cardList.push(content);
            });
            console.log(cardList);
            var j = 1;
            var i = 0;
            var flag = true;
            var carousel = document.getElementById('carousel_inner_item');
            carousel.innerHTML = '';
            while (i < cardList.length) {
                k = 0;
                var innerItem = document.createElement('div');
                innerItem.classList.add('carousel-item');
                if (j == 1) {
                    innerItem.classList.add('active');
                }
                var container = document.createElement('div');
                container.classList.add('container');
                container.id = j;
                container.style.marginTop = '40px';
                container.style.padding = '0px';
                container.style.textAlign = 'center';
                carousel.appendChild(innerItem);
                innerItem.appendChild(container);
                var slide = document.createElement('div');
                slide.classList.add('row');
                while (k < 3) {
                    if (cardList[i] === undefined) {
                        break;
                    }
                    slide.innerHTML += cardList[i];
                    i++;
                    k++;
                }
                document.getElementById(j).appendChild(slide);
                j++;
            }

        }
    });
    xhr.open("POST", "https://anime-recommend.herokuapp.com/send");
    xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(data);
}