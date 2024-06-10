"use strict";

// ページング

const records = document.querySelectorAll("#employees-table tbody > tr");
const NUM_PER_PAGE = 10;
const PAGE_COUNT = Math.floor((records.length - 1) / NUM_PER_PAGE) + 1;

let page = 0;

const executePaging = () => {
  records.forEach((record, i) => {
    record.style.display =
      i >= page * 10 && i < (page + 1) * 10 ? "table-row" : "none";
  });
};

executePaging();

const pagingDom = document.getElementById("paging");
for (let i = 0; i < PAGE_COUNT; i++) {
  const pagingButtonDom = document.createElement("div");
  pagingButtonDom.innerHTML = i + 1;
  pagingButtonDom.className = "paging-button";
  pagingButtonDom.addEventListener("click", () => {
    page = i;
    executePaging();
  });
  pagingDom.appendChild(pagingButtonDom);
}

// オートコンプリート

const employeeSearchInput = document.getElementById("employee-search-input");
const autoCompleteSuggestionDom = document.getElementById(
  "auto-complete-suggestion"
);
const autoCompleteSuggestionDomReset = () => {
  while (autoCompleteSuggestionDom.firstChild) {
    autoCompleteSuggestionDom.removeChild(autoCompleteSuggestionDom.firstChild);
  }
};
employeeSearchInput.addEventListener("input", (v) => {
  axios({
    method: "get",
    url: "http://localhost:8080/api/employee/findByName",
    params: { name: employeeSearchInput.value },
  }).then((v) => {
    autoCompleteSuggestionDomReset();
    v.data.forEach((v) => {
      const autoCompleteSuggestionItemDom = document.createElement("div");
      autoCompleteSuggestionItemDom.innerHTML = v.name;
      autoCompleteSuggestionItemDom.className = "auto-complete-suggestion-item";
      autoCompleteSuggestionItemDom.addEventListener("click", () => {
        employeeSearchInput.value = v.name;
        autoCompleteSuggestionDomReset();
      });
      autoCompleteSuggestionDom.appendChild(autoCompleteSuggestionItemDom);
    });
  });
});
