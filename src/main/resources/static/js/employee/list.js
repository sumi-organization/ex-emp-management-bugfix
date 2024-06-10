"use strict";

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
