"use strict";
let results = document.getElementById("frameworks");

async function ggy() {
  let x;
  try {
    x = await fetch("http://localhost:8080/api/v1/frameworks", {
      method: "GET",
    }).then((res) => res.json());
  } catch (err) {
    console.log(err);
    this.errors = err;
  }
  console.log(x);

  results.innerHTML = "";
  x.forEach((element) => {
    addDataToDom(element);
  });
}

ggy();

function addDataToDom(element) {
  results.insertAdjacentHTML("beforeend", getCard(element));
}

function getCard(element) {
  return `<div class="container">
    <a href="/edit">
      <h3>${element.name}</h3>
      <h3>${element.type}</h3>
    </a>
    <h4>${element.stars} <i class="fas fa-star"></i></h4>
    <br>
    <i id="delete${element.id}" class="far fa-trash-alt"></i>
    </div>
    `;
}
btn.addEventListener("click", async function () {
  let x;
  let form = document.getElementById("form");
  console.log(
    form.elements["framework"].value,
    form.elements["stars"].value,
    form.elements["type"].value
  );

  try {
    x = await fetch("http://localhost:8080/api/v1/frameworks", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },

      body: JSON.stringify({
        name: form.elements["framework"].value,
        stars: form.elements["stars"].value,
        type: form.elements["type"].value,
      }),
    }).then((res) => init());
  } catch (err) {
    console.log(err);
    this.errors = err;
  }
  console.log(x);
});

function addFramework(e) {
  e.preventDefault();
  console.log("hee");
}
